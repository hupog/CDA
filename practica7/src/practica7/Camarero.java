/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica7;

/**
 *
 * @author Santi
 */
class Camarero extends Thread {
    private String nombre;
    private Barra barra;

    public Camarero(String nombre, Barra barra) {
        this.nombre = nombre;
        this.barra = barra;
    }

    public void run() {
        while (barra.platosHechos.get()<40) {
            try {
                // Tomar un plato de la barra
                synchronized (barra) {
                    barra.tomarPlato();
                }
                // Servir el plato
                Thread.sleep(1000); // Simula el tiempo que tarda el camarero en servir un plato
                System.out.println("Camarero: Plato servido.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}