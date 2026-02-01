import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
       List<Pedido> pedidos = new ArrayList<>();
       pedidos.add(new Pedido(1, "Paulo", 50));
       pedidos.add(new Pedido(2,"Maria",40));
       pedidos.add(new Pedido(3, "Jose",80));

       Thread t1 = new Thread(new ProcessadorDePedido(pedidos.get(0)), "Thread-01");
       Thread t2 = new Thread(new ProcessadorDePedido(pedidos.get(1)), "Thread-02");
       Thread t3 = new Thread(new ProcessadorDePedido(pedidos.get(2)), "Thread-03");

       t1.start();
       t2.start();
       t3.start();

       try {
            Thread.sleep(10000);
       }catch(InterruptedException e) {
            e.printStackTrace();
       }
       
       System.out.println("\n== Sistema vai parrar, interrompendo as thread. ==\n");

       t1.interrupt();
       t2.interrupt();
       t3.interrupt();

    }
}