import java.io.*;

public class ProcessadorDeNotas implements Runnable {
    private final BufferedReader reader;
    RegistroDeNotas notas;
    public ProcessadorDeNotas (BufferedReader reader, RegistroDeNotas notas) {
        this.reader = reader;
        this.notas = notas;
    }
    public void run() {
        String linha;
        try {
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                int Id = Integer.parseInt(dados[0].split(":")[1].trim());
                String nome = dados[1].split(":")[1].trim();
                String disciplina = dados[2].split(":")[1].trim();
                Double nota = Double.parseDouble(dados[3].split(":")[1].trim());

                System.out.println(Id + " " + nome + " " + disciplina + " " + nota);
                notas.AtualizarMedias(Id, 20);
            }
        }
        catch (Exception e) {
            System.out.println("Erro ao ler as notas: " + e.getMessage());
            return;
        }
    }

}
