public class GestorCentroEstagio {
    
    private final Computador[] computadores;

    public GestorCentroEstagio(Computador[] computadores) {
        this.computadores = computadores;
    }

    public void liberarComputadores() {
        for (Computador c : computadores) {
            synchronized (c) {
                c.notify();
            }
        }
        System.out.println("Liberando computadores para o proximo ciclo...");
    }

    public void encerrarCentro() {
        for (Computador c : computadores) {
            c.encerrar();
        }
        System.out.println("Encerrando o centro de estagio...");
    }
}
