import java.util.List;
public class MonitorTemperatura implements Runnable {
    private SensorTemperatura sensor;
    private List<Integer> lista;

    public MonitorTemperatura(SensorTemperatura sensor, List<Integer> lista) {
        this.sensor = sensor;
        this.lista = lista;
    }

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();

        while (System.currentTimeMillis() - inicio < 15000) {
            int leitura = sensor.lerTemperatura();
            lista.add(leitura);

            System.out.println("Temperatura lida: " + leitura + "°C");

            if (leitura > 30) {
                System.out.println("Alerta! Temperatura alta! Monitorização será interrompida.");
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }

        System.out.println("Monitorização terminada.");
    }
}