import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Map<Integer, Double> medias1 = new HashMap<>();
        Map<Integer, Double> medias2 = new HashMap<>();
        Map<Integer, Double> medias3 = new HashMap<>();

        BufferedReader reader1 = new BufferedReader(new FileReader(new File("notas1.txt")));
        BufferedReader reader2 = new BufferedReader(new FileReader(new File("notas2.txt")));
        BufferedReader reader3 = new BufferedReader(new FileReader(new File("notas3.txt")));

        RegistroDeNotas notas1 = new RegistroDeNotas(medias1);
        RegistroDeNotas notas2 = new RegistroDeNotas(medias2);
        RegistroDeNotas notas3 = new RegistroDeNotas(medias3);

        Thread processador1 = new Thread(new ProcessadorDeNotas(reader1, notas1));
        Thread processador2 = new Thread(new ProcessadorDeNotas(reader2, notas2));
        Thread processador3 = new Thread(new ProcessadorDeNotas(reader3, notas3));

        processador1.start();
        processador2.start();
        processador3.start();

        Thread.sleep(10000);

        processador1.interrupt();
        processador2.interrupt();
        processador3.interrupt();

        for (Map.Entry<Integer, Double> entry : medias1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Map.Entry<Integer, Double> entry : medias2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Map.Entry<Integer, Double> entry : medias3.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
