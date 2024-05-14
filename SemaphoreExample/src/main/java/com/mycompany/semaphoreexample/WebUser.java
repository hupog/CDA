/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semaphoreexample;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillermo
 */
public class WebUser extends Thread{
    private final int numAccess = 10; // Número de usuarios
    private int id;
    private final Semaphore semaphore;
    
    public WebUser(Semaphore semaphore, int id){
        this.id = id;
        this.semaphore = semaphore;
    }
        

    @Override
    public void run() {
        
        try {
            System.out.println("Usuario " +id+ " intenando acceder a la web");
            semaphore.acquire();
            System.out.println("Usuario " +id+ " dentro de la web");
            Thread.sleep(5000); // simulamos que navega por la web
            System.out.println("Usuario " +id+ " sale de la web");
            semaphore.release();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(WebUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
}
