/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semaphoreexample2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillermo
 */
public class SemaphoreExample2 {

    public static void main(String[] args) {
        
        boolean[] theatre = {false, false, false, false, false};
        int maxUsers = theatre.length;
        
        Thread[] users = new Thread[20];
        Random random = new Random();
        Semaphore semaphore = new Semaphore(maxUsers);
        
        for (int i = 0; i < users.length; i++){
            int seat = random.nextInt(theatre.length);
            users[i] = new User(theatre, semaphore, seat);
            users[i].start();
        }
        
        
        for (int i = 0; i < users.length; i++){   
            try {
                users[i].join();
            } catch (InterruptedException ex) {
                System.out.println("interrupt");
            }
        }
               
        
        
    }
}
