/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santi
 */

public class Practica7 {
     public static void main(String[] args) {
        // Creamos una instancia de la clase Barra
        Barra barra = new Barra();

        // Creamos 3 chefs y 3 camareros
        Chef[] chefs = new Chef[]{
                new Chef("Chef Mario", barra),
                new Chef("Chef Luigi", barra),
                new Chef("Chef Peach", barra)
        };

        Camarero[] camareros = new Camarero[]{
                new Camarero("Camarero Juan", barra),
                new Camarero("Camarero Maria", barra),
                new Camarero("Camarero Pedro", barra)
        };

        // Iniciamos los hilos
        for (Chef chef : chefs) {
            chef.start();
        }

        for (Camarero camarero : camareros) {
            camarero.start();
        }
    }

}