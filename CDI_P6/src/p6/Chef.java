/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p6;

/**
 *
 * @author hugo
 */
public class Chef implements Runnable{
    SharedMicrowave microondas;
    int chefCont = 0;
    public Chef(SharedMicrowave microondas){
        this.microondas = microondas;
    }
    @Override
    public void run() {
        microondas.CookAndWait();
        chefCont++;
    }

    public int getChefCont() {
        return chefCont;
    }
    
    
}
