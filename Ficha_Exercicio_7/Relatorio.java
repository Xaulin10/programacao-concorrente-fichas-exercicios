package Ficha_Exercicio_7;

public class Relatorio {

    private int userId;
    private long timestamp;
    private String conteudo;

    public Relatorio(int userId, String conteudo) {
        this.userId = userId;
        this.timestamp = System.currentTimeMillis();
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Relatorio [UserID: " + userId +
                ", Timestamp: " + timestamp + 
                ", Conteudo: " + conteudo + "]";
    }
}
