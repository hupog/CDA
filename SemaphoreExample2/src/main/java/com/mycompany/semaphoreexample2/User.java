/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semaphoreexample2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillermo
 */
public class User extends Thread{
    
    private boolean[] theatre;
    private int seat;
    private Semaphore semaphore;
    
    public User(boolean[] theatre, Semaphore semaphore, int seat){
        this.theatre = theatre;
        this.seat = seat;
        this.semaphore = semaphore;
    }
    
    @Override
    public void run(){
        
        try {
            semaphore.acquire();
            synchronized(theatre){
                if (theatre[seat] == false){
                    theatre[seat] = true;
                    System.out.println("Entrada conseguida! posición: "+seat);
                }else{
                    System.out.println("Entrada no conseguida posición" + seat);
                }
            }
            semaphore.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
}
