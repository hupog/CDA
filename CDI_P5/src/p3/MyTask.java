/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author hugo
 */
public class MyTask implements Runnable{
    private final Counter contador;
    private final Lock lock;
    
    public MyTask(Counter contador, Lock lock){
        this.contador = contador;
        this.lock = lock;
    }
    
    @Override
    public void run() {
        System.out.println("Hello world, I’m the java thread number " + Thread.currentThread().getName());
        try {
            Thread.sleep(((int) (Math.random() * 100) + 1));
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
        lock.lock();
        try{
            contador.increment();
        }finally{
            lock.unlock();
        }
        System.out.println("Bye from thread number " + Thread.currentThread().getName());
    }
    
}
