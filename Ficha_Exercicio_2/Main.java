public class Main {

    public static void main (String[] args) {

        Estoque estoque = new Estoque(10);
        Thread[] clientes = new Thread[15];

        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Thread(new Cliente (i + 1, estoque));
            clientes[i].start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread t : clientes) {
            
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        System.out.println("Estoque final: " + estoque.getQuantidade());
    }
}


