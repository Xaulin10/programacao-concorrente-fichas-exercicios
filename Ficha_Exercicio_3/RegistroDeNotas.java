import java.util.Map;

public class RegistroDeNotas {
    private Map<Integer, Double> medias;

    public RegistroDeNotas(Map<Integer, Double> medias) {
        this.medias = medias;
    }

    public void AtualizarMedias(int id, double nota) {
        medias.put(id, nota);
    }
}
