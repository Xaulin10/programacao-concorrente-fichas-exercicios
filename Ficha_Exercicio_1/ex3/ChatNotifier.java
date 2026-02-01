public class ChatNotifier implements Runnable {
    
    private Mensagem msg;
    private int delay;

    public ChatNotifier(Mensagem msg, int delay) {
        this.msg = msg;
        this.delay = delay;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(delay);

            System.out.println("\n-- Notificacao --");
            System.out.println("Remetente: " + msg.getRemente());
            System.out.println("Destinatario: " + msg.getDestinatario());
            System.out.println("Mensagem: " + msg.getConteudo());
                
        }catch (InterruptedException e) {
            System.out.println("Sistema foi interrumpida");
        }
    }
}
