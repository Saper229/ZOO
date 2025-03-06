import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    LocalDate dataUrodzenia = LocalDate.now();

    // Przykładowe zwierzęta
    Zwierze pingwin = new Zwierze("Pingwin", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze orzeł = new Zwierze("Orzeł", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze strus = new Zwierze("Struś", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze pelikan = new Zwierze("Pelikan", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze flaming = new Zwierze("Flaming", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze papuga = new Zwierze("Papuga", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);

    Zwierze jaguar = new Zwierze("Jaguar", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze lew = new Zwierze("Lew", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze zebra = new Zwierze("Zebra", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze wilk = new Zwierze("Wilk", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze słoń = new Zwierze("Słoń", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);
    Zwierze tygrys = new Zwierze("Tygrys", dataUrodzenia, "Dobry", TypObiektu.WYBIEG);

    Zwierze jaszczurka = new Zwierze("Jaszczurka", dataUrodzenia, "Zły", TypObiektu.KLATKA);
    Zwierze wąż = new Zwierze("Wąż", dataUrodzenia, "Zły", TypObiektu.KLATKA);
    Zwierze gekon = new Zwierze("Gekon", dataUrodzenia, "Zły", TypObiektu.KLATKA);
    Zwierze kameleon = new Zwierze("Kameleon", dataUrodzenia, "Zły", TypObiektu.KLATKA);
    Zwierze krokodyl = new Zwierze("Krokodyl", dataUrodzenia, "Zły", TypObiektu.KLATKA);
    Zwierze agama = new Zwierze("Agama", dataUrodzenia, "Zły", TypObiektu.KLATKA);

    List<Zwierze> ptaki = new ArrayList<>();
    List<Zwierze> ssaki = new ArrayList<>();
    List<Zwierze> gady = new ArrayList<>();

    public Zoo() {
        ptaki.add(pingwin);
        ptaki.add(orzeł);
        ptaki.add(strus);
        ptaki.add(pelikan);
        ptaki.add(flaming);
        ptaki.add(papuga);

        ssaki.add(jaguar);
        ssaki.add(lew);
        ssaki.add(zebra);
        ssaki.add(wilk);
        ssaki.add(słoń);
        ssaki.add(tygrys);

        gady.add(jaszczurka);
        gady.add(wąż);
        gady.add(gekon);
        gady.add(kameleon);
        gady.add(krokodyl);
        gady.add(agama);
    }

    public void pokazPtaki() {
        System.out.println("Sekcja: Ptaki");
        for (Zwierze zwierze : ptaki) {
            System.out.println(zwierze.getName());
        }
    }

    public void pokazSsaki() {
        System.out.println("Sekcja: Ssaki");
        for (Zwierze zwierze : ssaki) {
            System.out.println(zwierze.getName());
        }
    }

    public void pokazGady() {
        System.out.println("Sekcja: Gady");
        for (Zwierze zwierze : gady) {
            System.out.println(zwierze.getName());
        }
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "dataUrodzenia=" + dataUrodzenia +
                ", pingwin=" + pingwin +
                ", orzeł=" + orzeł +
                ", strus=" + strus +
                ", pelikan=" + pelikan +
                ", flaming=" + flaming +
                ", papuga=" + papuga +
                ", jaguar=" + jaguar +
                ", lew=" + lew +
                ", zebra=" + zebra +
                ", wilk=" + wilk +
                ", słoń=" + słoń +
                ", tygrys=" + tygrys +
                ", jaszczurka=" + jaszczurka +
                ", wąż=" + wąż +
                ", gekon=" + gekon +
                ", kameleon=" + kameleon +
                ", krokodyl=" + krokodyl +
                ", agama=" + agama +
                ", ptaki=" + ptaki +
                ", ssaki=" + ssaki +
                ", gady=" + gady +
                '}';
    }
}