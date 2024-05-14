/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase6;


public class SharedMicrowave {
     
    private int microwaveCount = 0;
    private int preparationCount = 5;

    public void CookAndWait() {
       
            System.out.println(Thread.currentThread().getName() + " está comenzando la cocción de la receta.");
            try {
                Thread.sleep(2000); // Pausa de 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ha terminado de cocinar la receta.");
            microwaveCount++;
       
    }
    
     public synchronized boolean CookWaitAndDecrement() {
        if (preparationCount > 0) {
            preparationCount--;
            return true;
        } else {
            return false;
        }
    }


    public int getMicrowaveCount() {
        return microwaveCount;
    }
}

