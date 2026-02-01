public class Main {
    public static void main(String[] args) {
        FilaDePedidos fila = new FilaDePedidos(new String[6]);
        Cozinheiro cozinheiro = new Cozinheiro(fila);
        garcom garcon = new garcom(fila);
        Thread cozinheiro1Thread = new Thread(cozinheiro);
        Thread cozinheiro2Thread = new Thread(cozinheiro);
        Thread cozinheiro3Thread = new Thread(cozinheiro);
        Thread cozinheiro4Thread = new Thread(cozinheiro);
        Thread cozinheiro5Thread = new Thread(cozinheiro);

        Thread garconThread1 = new Thread(garcon);
        Thread garconThread2 = new Thread(garcon);
        Thread garconThread3 = new Thread(garcon);
        Thread garconThread4 = new Thread(garcon);
        Thread garconThread5 = new Thread(garcon);

        cozinheiro1Thread.start();
        cozinheiro2Thread.start();
        cozinheiro3Thread.start();
        cozinheiro4Thread.start();
        cozinheiro5Thread.start();

        garconThread1.start();
        garconThread2.start();
        garconThread3.start();
        garconThread4.start();
        garconThread5.start();


        try {
            Thread.sleep(15000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
