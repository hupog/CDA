/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semaphoreexample;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Guillermo
 */
public class SemaphoreExample {

   public static void main(String[] args) {
        
        int maxUsers = 5;
        int numberUser = 20;
        Semaphore semaphore = new Semaphore(maxUsers);
        
        Thread[] users = new Thread[numberUser];
        
        // Crear varios hilos que simulan el acceso a la web
        for (int i = 0; i < users.length; i++) {
            users[i] = new WebUser(semaphore, i);
            users[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread user : users) {
            try {
                user.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}