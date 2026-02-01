public class Pedido {
    private int id;
    private String cliente;
    private double valor;

    public Pedido (int id, String cleinte, double valor) {
        this.id = id;
        this.cliente = cleinte;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }
    
    @Override
    public String toString() {
        return "Pedido ID: " + id + " | Cliente: " + cliente + " | Valor: " + valor;
    }

}