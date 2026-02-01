package Ficha_Exercicio_7;

public class HandlerExcecoes implements Thread.UncaughtExceptionHandler {
    
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Excecao capturada no thread "
            + t.getName() + ": " + e.getMessage()
        );
    }
}
