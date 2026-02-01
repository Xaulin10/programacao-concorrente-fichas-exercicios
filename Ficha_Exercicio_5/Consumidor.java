public class Consumidor implements Runnable {
    private final SharedBuffer buffer;
    
    public Consumidor(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (!buffer.isFound()) {
                synchronized (buffer) {
                    if (!buffer.isFound()) {
                        buffer.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}