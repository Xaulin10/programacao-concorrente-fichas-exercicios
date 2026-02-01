package Ficha_Exercicio_6;

public class Computador implements Runnable {
    
    private final int id;
    private boolean ativo = true;

    public Computador(int id) {
        this.id = id;
    }

    public synchronized void encerrar() {
        ativo = false;
        notify();
    }

    @Override
    public synchronized void run() {
        try {
            while (ativo) {
                System.out.println("COmputador " + id + " esta operando...");
                Thread.sleep(2000);

                System.out.println("Computador " + id + " aguardando liberacao para o proximo ciclo.");
                wait();
            }
            System.out.println("Computador " + id + " foi encerrada.");
        } catch (InterruptedException e) {
            System.out.println("Computador " + id + " interrompido.");
        }
    }

}
