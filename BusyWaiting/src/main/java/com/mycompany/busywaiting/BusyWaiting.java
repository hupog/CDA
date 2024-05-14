/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.busywaiting;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guillermo
 */
public class BusyWaiting {

    private static final int bufferSize = 5;
    private static List<Integer> buffer = new ArrayList();
    
    public static void main(String[] args) {
        
        Producer producer = new Producer(bufferSize, buffer);
        Consumer consumer = new Consumer(buffer);

        Thread productorThread = new Thread(producer);
        Thread consumidorThread = new Thread(consumer);

        productorThread.start();
        consumidorThread.start();
               
        
    }
}
