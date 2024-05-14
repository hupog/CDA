/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica8;

/**
 *
 * @author Santi
 */
public class Practica8 {

    /**
     * @param args the command line arguments
     */
         public static void main(String[] args) {
        BuildingProject project = new BuildingProject();
        Thread equipo1 = new Thread(new Equipo(project, 1, 1000));
        Thread equipo2 = new Thread(new Equipo(project, 2, 2000));
        Thread equipo3 = new Thread(new Equipo(project, 3, 3000));

        equipo1.start();
        equipo2.start();
        equipo3.start();
    }
}
