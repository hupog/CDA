import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MyThread> threads = new ArrayList<>();

        // Crear e iniciar los hilos
        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread("Thread-" + i);
            threads.add(thread);
            thread.start();
        }

        // Esperar a que todos los hilos terminen
        for (MyThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar a los hilos.");
            }
        }

        // Mensaje desde el hilo principal cuando todos los hilos han terminado
        System.out.println("Todos los hilos han terminado.");
    }
}