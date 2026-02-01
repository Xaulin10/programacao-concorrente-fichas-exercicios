import java.util.Random;

public class SensorTemperatura {
    private Random random = new Random();

    public int lerTemperatura() {
        return 15 + random.nextInt(21); // gere uma valor entre 15 e 35
    }
}