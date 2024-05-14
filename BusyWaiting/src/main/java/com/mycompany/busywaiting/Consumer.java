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
public class Consumer implements Runnable {
    
    private List<Integer> buffer;
    
    public Consumer(List<Integer> buffer){
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        while(true) { 
            // El consumidor consume 10 elementos
            while (buffer.size() == 0) { // Espera activa: mientras el buffer esté vacío
                // No hace nada, solo verifica continuamente si hay elementos en el buffer
            }

            // Cuando hay elementos disponibles, consume el siguiente elemento del buffer
            buffer.remove(0);
            try {
                Thread.sleep(1500);
                System.out.println("Se ha consumido un elemento");
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
        }
    }
}