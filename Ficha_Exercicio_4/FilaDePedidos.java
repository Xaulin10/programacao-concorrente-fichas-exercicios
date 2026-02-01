public class FilaDePedidos {
    public volatile String[] pedidos;

    public FilaDePedidos (String[] pedidos) {
        this.pedidos = pedidos;
    }

    public synchronized void adicionarPedido(String pedido) throws InterruptedException {

        if (this.isfULL()) {
            wait();
        }

        for (int i = 0; i < pedidos.length; i++) {
            if (pedidos[i] == null){
                pedidos[i] = pedido;
                this.notify();
                return;
            }
        }
    }

    public synchronized String retirarPedido() throws InterruptedException {

        if (this.isEmpty()) {
            wait();
        }

        String pedido = pedidos[0];
        for (int i = this.pedidos.length - 1; i > 0; i--) {
            if (pedidos[i] != null) {
                pedido = pedidos[i];
                pedidos[i] = null;
            }
        }
        this.notify();
        return pedido;
    }


    private boolean isfULL() {
        if (pedidos[pedidos.length - 1] != null) {
            return true;
        }
        return false;
    }
    private boolean isEmpty() {
        return pedidos[pedidos.length - 1] == null;
    }
}
