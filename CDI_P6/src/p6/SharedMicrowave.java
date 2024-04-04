/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author hugo
 */
public class SharedMicrowave {
    int microwaveCont = 0;
    Lock lock = new ReentrantLock();
    public void CookAndWait(){
        lock.lock();
        try {
        System.out.println("Comenzando la cocción de la receta");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
        microwaveCont++;
        System.out.println("Cocción terminada");
        } finally {
            lock.unlock();
        }
    }

    public int getMicrowaveCont() {
        return microwaveCont;
    }
    
}
