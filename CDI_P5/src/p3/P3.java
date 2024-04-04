/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author hugo
 */
public class P3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numThreads = 500; // Número de hilos a crear
        Lock lock = new ReentrantLock();

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new MyTask(counter, lock));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }

        System.out.println("Valor actual del contador: " + counter.getContador());
    }
}
    

