/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase6;

/**
 *
 * @author Santi
 */
public class CLASE6 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
    

         
        SharedMicrowave microwave = new SharedMicrowave();
        Chef chef1 = new Chef(microwave);
        Chef chef2 = new Chef(microwave);
        Chef chef3 = new Chef(microwave);

        Thread thread1 = new Thread(chef1, "Chef 1");
        Thread thread2 = new Thread(chef2, "Chef 2");
        Thread thread3 = new Thread(chef3, "Chef 3");

        thread1.start();
        thread2.start();
        thread3.start();
        
         try{
             thread1.join();
             thread2.join();
             thread3.join();
         }catch(InterruptedException e){
             e.printStackTrace();
         }
        
         System.out.println(chef1.getChefCount());
         
         System.out.println(chef2.getChefCount());
         
         System.out.println(chef3.getChefCount());
         
         System.out.println(microwave.getMicrowaveCount());
    }
}
