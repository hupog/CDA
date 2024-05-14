/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatserver;

/**
 * javac -d out src\main\java\com\mycompany\countingsort\*.java
 * java com.mycompany.countingsort.CountingSort
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ChatServer {
    private static final int PORT = 8888;
    private static final Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) {
        int maxConnections = 2;
        final Semaphore maxConnectionsSemaphore = new Semaphore(maxConnections, true);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor de Chat iniciado en el puerto " + PORT);
            while (true) {

                //Esperamos durante 3 segundos, si es posible acceder a la region delimitada entramos.
                // Si no, no se establece la conexion
                if (maxConnectionsSemaphore.tryAcquire(3, TimeUnit.SECONDS)) {
                    //ATENCION: una vez recivida una peticion de comunicacion al puerto, el servidor establece un subconducto con cada cliente
                    //no confundir ServerSocket con Socket
                    Socket clientSocket = serverSocket.accept();

                    System.out.println("Nuevo cliente conectado: " + clientSocket);
                    // Crea un hilo para manejar la comunicación con el cliente
                    Thread clientThread = new Thread(new ClientHandler(clientSocket, maxConnectionsSemaphore));
                    clientThread.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final Semaphore maxConnectionsSemaphore;
        private PrintWriter writer;

        public ClientHandler(Socket clientSocket, Semaphore maxConnectionsSemaphore) {
            this.clientSocket = clientSocket;
            this.maxConnectionsSemaphore = maxConnectionsSemaphore;
        }

        @Override
        public void run() {

            //Todo lo finalizado en reader, hace mencion al canal "stream" de lectura "reader". Es decir el canal por donde vamos a recivir los mensajes
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 //Todo lo finalizado en writer, hace mencion al canal "stream" de escruitura "writer". Es decir el canal por donde podemos escribir
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);) {
                this.writer = writer;
                clientWriters.add(writer);
                String inputLine;
                //Cuando leemos una linea de alguno de los clientes conectados la reenviamos por todos los canales almacenados de los clientes
                //es decir cada ClientHandler debe tener una referencia a todos los usuarios conectados para reenviarles el mensaje
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println("Mensaje recibido de cliente: " + inputLine);
                    broadcast(inputLine);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //ATENCION!! Cuando finaliza una conexion y el socket se cierra, se deben hacer siempre dos cosas.
                //Eliminar el cliente de la lista y volver a dejar un hueco vacio en el semáforo.
                try {
                    if (writer != null) {
                        clientWriters.remove(writer);
                    }
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                maxConnectionsSemaphore.release();
            }

        }
        private void broadcast(String message) {
            for (PrintWriter clientWriter : clientWriters) {
                //Escribimos un mensaje a cada cliente
                clientWriter.println(message);
            }
        }
    }
}