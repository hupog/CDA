/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hugo
 */
public class Restaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SharedMicrowave sharedMicrowave = new SharedMicrowave();
         Chef[] chefs = new Chef[5];
         
         for (int i = 0; i < chefs.length; i++) {
            chefs[i] = new Chef(sharedMicrowave);
            Thread thread = new Thread(chefs[i]);
            thread.start();
            
             try {
                 thread.join();
             } catch (InterruptedException ex) {
                 Logger.getLogger(Restaurant.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         for (int i = 0; i < chefs.length; i++) {
            System.out.println(chefs[i].getChefCont());
            
        }
         
         System.out.println(sharedMicrowave.getMicrowaveCont());
         
    }
    
}
