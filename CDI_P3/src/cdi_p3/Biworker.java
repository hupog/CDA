/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cdi_p3;

import java.awt.image.*;

/**
 *
 * @author hugo
 */
public class Biworker extends Thread{
    int idThread;
    BufferedImage originImg;
    BufferedImage resultingImg;
    
    public Biworker(int idThead, BufferedImage originImg, BufferedImage resultingImg){
        
    }
    
    @Override
    public void run(){
        for (int row = idThread; row < originImg.getHeight(); row+=2) {
            for (int col = 0; col < originImg.getWidth(); col+=2) {
                int originRGB = originImg.getRGB(col, row);
                
                int alpha = (originRGB >> 24) & 0xFF;
                int red = (originRGB >> 16) & 0xFF;
                int green = (originRGB >> 8) & 0xFF;
                int blue = originRGB & 0xFF;
                
                int average = (red + green + blue)/3;
                
                int newColor = (alpha << 24) | (average << 16) | (average << 8) | average;
                resultingImg.setRGB(col, row, newColor);
            }
        }
    }
    
}

