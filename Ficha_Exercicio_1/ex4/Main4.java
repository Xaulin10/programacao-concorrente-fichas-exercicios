import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        List<String> linhas = Collections.synchronizedList(new ArrayList<>());

        Thread leitor1 = new Thread(new LeitorDeLog("Ficha_Exercicio_1/ex4/log1.txt", linhas));
        Thread leitor2 = new Thread(new LeitorDeLog("Ficha_Exercicio_1/ex4/log2.txt", linhas));
        Thread leitor3 = new Thread(new LeitorDeLog("Ficha_Exercicio_1/ex4/log3.txt", linhas));

        leitor1.start();
        leitor2.start();
        leitor3.start();

        try {
            leitor1.join();
            leitor2.join();
            leitor3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrompida.");
        }

        System.out.println("\n Total de linhas processadas: " + linhas.size());
        System.out.println("\n Primeiras linhas lidas:");
        for (int i = 0; i < Math.min(5, linhas.size()); i++) {
            System.out.println(" - " + linhas.get(i));
        }
    }
    
}
