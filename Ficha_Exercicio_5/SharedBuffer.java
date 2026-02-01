import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private Queue<String> buffer = new LinkedList<>();
    private boolean finished = false;
    private boolean found = false;
    private String foundFile = "";
    private int foundLine = -1;

    public synchronized void put(String value) throws InterruptedException {
        if (found) return;
        buffer.add(value);
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (buffer.isEmpty() && !finished && !found) {
            wait();
        }

        if (found) return null;
        if (buffer.isEmpty() && finished) return null;

        return buffer.poll();
    }

    public synchronized void setFinished() {
        finished = true;
        notifyAll();
    }

    public synchronized void setFound(String file, int line) {
        found = true;
        foundFile = file;
        foundLine = line;
        notifyAll();
    }

    public synchronized boolean isFound() {
        return found;
    }

    public synchronized String getFoundFile() {
        return foundFile;
    }

    public synchronized int getFoundLine() {
        return foundLine;
    }
}

