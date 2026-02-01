import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) {

        SensorTemperatura sensor = new SensorTemperatura();
        List<Integer> leituras = Collections.synchronizedList(new ArrayList<>());

        Thread monitorThread = new Thread(new MonitorTemperatura(sensor, leituras));

        monitorThread.start();

        try {
            monitorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n Leituras de temperaturas registadas:");
        System.out.println(" " + leituras + "°C");
    }
    
}
