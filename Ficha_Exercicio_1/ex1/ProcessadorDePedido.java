public class ProcessadorDePedido implements Runnable {
    
    private Pedido pedido;

    public ProcessadorDePedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void run() {
        try{
            while (true) {
                System.out.println(Thread.currentThread().getName() + 
                                " esta Processado ->  " + pedido);

                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + 
                    " foi interronpida e parou o processamrnto do pedido " + pedido.getId());
        }
    }
}
