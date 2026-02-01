public class Main3 {
    public static void main(String[] args) {

        Mensagem m1 = new Mensagem("Ana", "Joao", "Ola Joao, como vai");
        Mensagem m2 = new Mensagem("Paula","Paulo", "Preciso falar contigo");
        Mensagem m3 = new Mensagem("Carlos", "joana", "Recebeste o texto");
    
    
        Thread t1 = new Thread(new ChatNotifier(m1, 1000));
        Thread t2 = new Thread(new ChatNotifier(m2, 2000));
        Thread t3 = new Thread(new ChatNotifier(m3, 3000));


        t1.start();
        t2.start();
        t3.start();


        try {
            
            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException e) {
            System.out.println("Erro na espera dos threads");
        }

        System.out.println("Todas as mensagens foram enviadas.");
    }

}       
