class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println("Ejecutando hilo: " + this.getName());
    }
}

