public class Mensagem {
    
    private String remetente;
    private String destinatario;
    private String conteudo;

    public Mensagem(String remetente, String destinatario, String conteudo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.conteudo = conteudo;
    }

    public String getRemente() {
        return remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getConteudo() {
        return conteudo;
    }
    
}
