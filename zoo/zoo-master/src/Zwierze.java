import java.time.LocalDate;

public class Zwierze {
    private String nazwa;
    private String typ;
    private LocalDate dataUrodzenia;
    private String stan;
    private TypObiektu typObiektu;

    // Konstruktor klasy Zwierze
    public Zwierze(String nazwa, LocalDate dataUrodzenia, String stan, TypObiektu typObiektu) {
        this.nazwa = nazwa;
        this.dataUrodzenia = dataUrodzenia;
        this.stan = stan;
        this.typObiektu = typObiektu;
    }
    public String getName() {
        return nazwa;
    }

}
