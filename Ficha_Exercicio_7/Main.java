public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        Thread.setDefaultUncaughtExceptionHandler(new HandlerExcecoes());

        java.util.Timer timer = new java.util.Timer();
        RelatorioTimer tarefa = new RelatorioTimer();

        timer.schedule(tarefa, 0, 5000);

        Thread.sleep(20000);
        timer.cancel();

        System.out.println("Agendamento de relatorio encerrado.");
    }
                
}
