public class Cliente implements Runnable {
    private int id;
    private Estoque estoque;
    
    public Cliente (int id, Estoque estoque) {
        this.id = id;
        this.estoque = estoque;
    }
    
    @Override
    
    public void run() {
        boolean sucesso = estoque.comprarProduto();
        
        if (sucesso) {
            System.out.println("Cliente " + id + " comprou o produto com sucesso.");
        } else {
            System.out.println("Cliente " + id + " nao consegui comprar. Produto esgotado.");
        }
    }
}
