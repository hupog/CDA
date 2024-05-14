/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica7;

/**
 *
 * @author Santi
 */
class Chef extends Thread {
    private String nombre;
    private Barra barra;

    public Chef(String nombre, Barra barra) {
        this.nombre = nombre;
        this.barra = barra;
    }

    public void run() {
        while (barra.platosHechos.get() < 40) {
            try {
                // Cocinar
                Thread.sleep(2000); // Simula el tiempo que tarda el chef en cocinar un plato

                // Poner el plato en la barra
                synchronized (barra) {
                    barra.colocarPlato();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}