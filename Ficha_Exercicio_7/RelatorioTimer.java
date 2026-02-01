package Ficha_Exercicio_7;

public class RelatorioTimer extends java.util.TimerTask {

    private int contador = 1;

    @Override
    public void run() {
        Thread t = new Thread(new ProcessadorDeRelatorios(
            contador, "Conteudo do relatorio do utilizador " + contador)
        );
        t.start();
        contador++;
    }

}
