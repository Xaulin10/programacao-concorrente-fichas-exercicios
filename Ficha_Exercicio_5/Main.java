import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        String docente;
        // ler o nome do docente a procurar
        if (args.length > 0) {
            docente = args[0];
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduza o nome do docente a procurar: ");
            docente = sc.nextLine();
            sc.close();
        }

        String[] ficheiros = {
            "docentes/ficha1.txt",
            "docentes/ficha2.txt",
            "docentes/ficha3.txt",
            "docentes/ficha4.txt",
            "docentes/ficha5.txt",
            "docentes/ficha6.txt",
            "docentes/ficha7.txt",
            "docentes/ficha8.txt",
            "docentes/ficha9.txt"
        };

        SharedBuffer buffer = new SharedBuffer();
        // criar produtores
        Thread[] produtores = new Thread[ficheiros.length];
        for (int i = 0; i < ficheiros.length; i++) {
            produtores[i] = new Thread(new Produtor(ficheiros[i], docente, buffer));
            produtores[i].start();
        }

        // consumidor (monitoracao / sincronizacao)
        Thread consumidor = new Thread(new Consumidor(buffer));
        consumidor.start();

        // esperar produtores
        for (Thread t : produtores) {
            t.join();
        }

        buffer.setFinished();
        consumidor.join();

        // resultado
        if (buffer.isFound()) {
            System.out.println("\n Docente encontrado!");
            System.out.println("Ficheiro: " + buffer.getFoundFile());
            System.out.println("Linha: " + buffer.getFoundLine());
        }else {
            System.out.println("\n Docente nao encontrado.");
        }
    }
}