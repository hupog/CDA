/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.busywaiting;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillermo
 */
public class Producer implements Runnable {
    
    private int bufferSize;
    private List<Integer> buffer;
    
    public Producer(int bufferSize, List<Integer> buffer){
        this.bufferSize = bufferSize;
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        while(true) { 
            while (buffer.size() == bufferSize) { // Espera activa: mientras el buffer esté lleno
                // No hace nada, solo verifica continuamente si hay espacio en el buffer
            }
            // Cuando hay espacio disponible, produce un elemento y lo agrega al buffer
            buffer.add(1);
            try {
                Thread.sleep(1500);
                System.out.println("Se ha producido un elemento");
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
    }
}