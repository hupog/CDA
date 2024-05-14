/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Santi
 */

class BuildingProject {
    private final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable(){
    public void run(){System.out.println("Fin de la etapa");}}); // 3 equipos, 3 awaits, se puede hacer t1 = new Thread()->

    public void excavate(int sleepMs) throws InterruptedException, BrokenBarrierException {
        System.out.println("Somos el equipo 1, estamos excavando...");
        Thread.sleep(sleepMs);
        System.out.println("Somos el equipo 1, hemos acabado y vamos a esperar por los demás equipos.");
        barrier.await(); // Esperar a que todos los equipos terminen
    }

    public void layFoundation(int sleepMs) throws InterruptedException, BrokenBarrierException {
        System.out.println("Somos el equipo 2, estamos construyendo la cimentación...");
        Thread.sleep(sleepMs);
        System.out.println("Somos el equipo 2, hemos acabado y vamos a esperar por los demás equipos.");
        barrier.await(); // Esperar a que todos los equipos terminen
    }

    public void buildStructure(int sleepMs) throws InterruptedException, BrokenBarrierException {
        System.out.println("Somos el equipo 3, estamos levantando la estructura del edificio...");
        Thread.sleep(sleepMs);
        System.out.println("Somos el equipo 3, hemos acabado y vamos a esperar por los demás equipos.");
        barrier.await(); // Esperar a que todos los equipos terminen
    }
}