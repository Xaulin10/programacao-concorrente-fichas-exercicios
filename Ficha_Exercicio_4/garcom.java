public class garcom implements Runnable {

    private FilaDePedidos fila;

    public garcom(FilaDePedidos fila){
        this.fila = fila;
    }

    public void run() {
        String prato;
        synchronized (fila) {
            try {
                prato = fila.retirarPedido();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Prato " + prato + " entregue");
    }

}
