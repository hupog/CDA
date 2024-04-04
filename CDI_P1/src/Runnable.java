public class Runnable implements java.lang.Runnable {
    private String nombre;
    private int timeSleep;

    public Runnable(String nombre, int timeSleep){
        this.nombre = nombre;
        this.timeSleep = timeSleep;
    }
    @Override
    public void run() {
        System.out.println("Hello world, I’m the java thread number " + this.nombre);

        try {
            Thread.sleep(this.timeSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Bye from thread number X");
    }
}
