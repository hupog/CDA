/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Santi
 */
class Barra {
    static final int MAX_PLATOS = 5;
    int platosEnBarra = 0;
    AtomicInteger platosHechos = new AtomicInteger(0);

    synchronized void colocarPlato() throws InterruptedException {
       
        while (platosEnBarra == MAX_PLATOS) {
            // Esperar si la barra está llena
            wait();
        }
        platosEnBarra++;
        platosHechos.incrementAndGet();
        System.out.println("Chef: Hay " + platosEnBarra + " platos en la barra.");
        System.out.println("Chef: Se han hecho " + platosHechos + " platos en total.");
        // Notificar a todos los camareros que hay un nuevo plato disponible
        notifyAll();
    }

    synchronized void tomarPlato() throws InterruptedException {
        while (platosEnBarra == 0) {
            // Esperar si no hay platos en la barra
            wait();
        }
        platosEnBarra--;
        System.out.println("Camarero: He tomado un plato. Quedan " + platosEnBarra + " platos en la barra.");
        // Notificar a todos los chefs que se ha tomado un plato
        notifyAll();
    }
}