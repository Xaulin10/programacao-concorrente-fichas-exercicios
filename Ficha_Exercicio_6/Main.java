public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        Computador[] computadores = {
            new Computador(1),
            new Computador(2),
            new Computador(3)
        };
    
        Thread[] threads =new Thread[3];

        for (int i = 0; i < computadores.length; i++) {
            threads[i] = new Thread(computadores[i], "Thread-" + (i + 1));
            threads[i].start();
        }

        GestorCentroEstagio gestor = new GestorCentroEstagio(computadores);

        for (int i = 0; i < threads.length; i++) {
            System.out.println("Estado de computador " + threads[i].getName() +
                    ": " + threads[i].getState());
        }

        Thread.sleep(5000);
        gestor.liberarComputadores();

        Thread.sleep(5000);
        gestor.liberarComputadores();

        Thread.sleep(5000);
        gestor.encerrarCentro();

        Thread.sleep(1000);
        for (Thread t : threads) {
            System.out.println("Estado de computador " + t.getName() +
                    ": " + t.getState());
        }
    }
}
