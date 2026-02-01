package Ficha_Exercicio_1.ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LeitorDeLog implements Runnable {
    private String caminhoDoFicheiro;
    private List<String> listaPartilhada;

    public LeitorDeLog(String caminhoDoFicheiro, List<String> listaPartilhada) {
        this.caminhoDoFicheiro = caminhoDoFicheiro;
        this.listaPartilhada = listaPartilhada;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoFicheiro))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                listaPartilhada.add(linha);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrompida durante a leitura.");                
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + caminhoDoFicheiro);
        }
    }
}
