import java.util.Random;

public class Cozinheiro implements Runnable{
    private FilaDePedidos fila;
    public Cozinheiro( FilaDePedidos fila){
        this.fila = fila;
    }


    public void run() {
        String prato = "prato" + Integer.valueOf(new Random().nextInt());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return;
        }
        synchronized (fila) {
            try {
                fila.adicionarPedido(prato);
                System.out.println("Prato " + prato + " adicionado na fila");
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
