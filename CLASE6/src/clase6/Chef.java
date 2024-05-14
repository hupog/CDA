/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Santi
 */

public class Chef implements Runnable {
    private SharedMicrowave microwave;
    private int chefCount = 0;
    private static Lock lock = new ReentrantLock(); // Definir el lock estático aquí

    public Chef(SharedMicrowave microwave) {
        this.microwave = microwave;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            microwave.CookAndWait();
            chefCount++;
        } finally {
            lock.unlock();
        }
    }

    public int getChefCount() {
        return chefCount;
    }
}