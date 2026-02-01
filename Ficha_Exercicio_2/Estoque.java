public class Estoque {
    private volatile int quantidade;

    public Estoque(int quantidadeInicial) {
        this.quantidade = quantidadeInicial;
    }

    public synchronized boolean comprarProduto() {
        if (quantidade > 0) {
            quantidade--;
            return true;
        } else {
            return false;
        }
    }
    
    public int getQuantidade() {
        return quantidade;
    }
}
