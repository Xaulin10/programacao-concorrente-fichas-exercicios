import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Produtor implements Runnable {
    private final String filePath;
    private final String target;
    private final SharedBuffer buffer;

    public Produtor(String filePath, String target, SharedBuffer buffer) {
        this.filePath = filePath;
        this.target = target;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // Se a string for encontrada, não continuar a procurar
        if (buffer.isFound()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while (!buffer.isFound() && (line = br.readLine()) != null) {
                lineNumber++;

                if (line.trim().equalsIgnoreCase(target.trim())) {
                    buffer.setFound(filePath, lineNumber);
                    return;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler ficheiro: " + filePath);
        }
    }
}
