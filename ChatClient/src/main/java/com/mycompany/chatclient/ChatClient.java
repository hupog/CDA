/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatclient;

/**
 * javac -d out src\main\java\com\mycompany\countingsort\*.java
 * java com.mycompany.countingsort.CountingSort
 */

import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        final AtomicBoolean isConnected = new AtomicBoolean(false);

        while (!isConnected.get()) {
            try (
                    Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            ) {
//                socket.setSoTimeout(1);

                //Todo lo finalizado en READER, hace mencion al canal "stream" de lectura "reader". Es decir el canal por donde vamos a recivir los mensajes
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //Todo lo finalizado en WRITER, hace mencion al canal "stream" de escruitura "writer". Es decir el canal por donde podemos escribir
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                isConnected.set(true);

                System.out.println("Conectado al servidor de chat. Escribe tu mensaje:");
                Thread receiverThread  = new Thread(() -> {
                    try {
                        String serverMessage;
                        while ((serverMessage = reader.readLine()) != null) {
                            System.out.println(serverMessage);
                        }
                    } catch (IOException e) {
                        isConnected.set(false);
                    }
                });
                Thread sendThread = new Thread(() -> {
                    try {
                        String userInputLine;
                        //VERSION 1: No se interrumpe hasta que el usuario pulsa intro
//                        while (isConnected.get()) {
//                            if ((userInputLine = userInput.readLine()) != null) {
//                                writer.println(userInputLine);
//                            }
//                        }

                        //VERSION 1: Se interrumpe tan pronto se cierra la conexion
                        while (isConnected.get()) {
                            if (System.in.available() > 0) {
                                userInputLine = userInput.readLine();
                                if (userInputLine != null) {
                                    writer.println(userInputLine);
                                }
                            }
                            // Pequeña pausa para evitar consumo excesivo de CPU
                            Thread.sleep(100);
                        }

                    } catch (Exception e) {
                        isConnected.set(false);
                    }
                });
                receiverThread.start(); //Lanzamos el hilo que va a recivir datos y escribir los mensajes por pantalla
                sendThread.start();//Lanzamos el hilo que va leer por teclado y enviar por la conexion

                System.out.println("Servidor Conectado");
                while (isConnected.get())
                {
                    Thread.sleep(100);
                }
                System.out.println("Servidor desconectado");
                //si la conexion se cierra cerramos el socket interumpimos los hilos
                socket.close();
                receiverThread.interrupt();
                sendThread.interrupt();

                sendThread.join();
                receiverThread.join();
            } catch (Exception e) {

                e.printStackTrace();
                int sleepTime = 2000;
                System.out.println("Servidor desconectado...Reintentando conexion en " + sleepTime / 1000 + "s");
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}

