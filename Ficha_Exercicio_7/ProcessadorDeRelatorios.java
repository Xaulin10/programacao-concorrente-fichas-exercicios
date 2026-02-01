package Ficha_Exercicio_7;

public class ProcessadorDeRelatorios implements Runnable {

    private static ThreadLocal<Integer> userId = new ThreadLocal<>();
    private int id;
    private String conteudo;

    public ProcessadorDeRelatorios(int id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    @Override
    public void run() {
        
        userId.set(id);

        Integer atual = userId.get();
        if (atual == null) {
            throw new RuntimeException("UserID nao configurado para o thread atual.");
        }

        Relatorio r = new Relatorio(id, conteudo);
        System.out.println("Relatorio processado: " + r);
    }
}