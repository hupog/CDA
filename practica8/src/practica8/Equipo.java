/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica8;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santi
 */
class Equipo implements Runnable {
    private final BuildingProject project;
    private final int equipoNumero;
    private final int sleepMs;

    public Equipo(BuildingProject project, int equipoNumero, int sleepMs) {
        this.project = project;
        this.equipoNumero = equipoNumero;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                if (equipoNumero == 1) {
                    project.excavate(sleepMs);
                } else if (equipoNumero == 2) {
                    project.layFoundation(sleepMs);
                } else if (equipoNumero == 3) {
                    project.buildStructure(sleepMs);
                }
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}