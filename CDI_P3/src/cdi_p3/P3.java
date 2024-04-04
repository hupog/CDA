/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cdi_p3;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 *
 * @author hugo
 */
public class P3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name_img = args[0];
        BufferedImage originImg = null;
        
        try{
            originImg = ImageIO.read(new File(name_img));
        }catch(Exception ex){
            
        }
        
        BufferedImage resultingImg = new BufferedImage(originImg.getWidth(),originImg.getHeight(),originImg.getType());
        
        Biworker worker0 = new Biworker(0, originImg, resultingImg);
        Biworker worker1 = new Biworker(1, originImg, resultingImg);
        
        worker0.start();
        worker1.start();
        
        try{
            worker0.join();
            worker1.join();
        }catch(Exception ex){
            
        }
    }
    
}
