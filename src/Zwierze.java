import java.time.LocalDate;
import java.util.Arrays;

public class Zwierze {
    String gatunek;
    LocalDate dataUrodzenia = LocalDate.now();
    String stanZdrowie;

    String type = Arrays.toString(TypObiektu.values());
    public Zwierze(String gatunek, LocalDate dataUrodzenia, String stanZdrowie, TypObiektu type) {
        this.gatunek = gatunek;
        this.dataUrodzenia = dataUrodzenia;
        this.stanZdrowie = stanZdrowie;
        this.type = String.valueOf(type);
    }

    @Override
    public String toString() {
        return "Zwierze{" +
                "gatunek='" + gatunek + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", stanZdrowie='" + stanZdrowie + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
