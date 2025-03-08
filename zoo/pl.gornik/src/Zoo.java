import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

        goscie = new ArrayList<>();
        goscie.add(new Goscie("Anna", "Kowalska"));
        goscie.add(new Goscie("Piotr", "Nowak"));
        goscie.add(new Goscie("Michał", "Wiśniewski"));
        goscie.add(new Goscie("Katarzyna", "Wójcik"));
        goscie.add(new Goscie("Jan", "Kowalczyk"));
        goscie.add(new Goscie("Ewa", "Kozak"));
        goscie.add(new Goscie("Tomasz", "Mazur"));
        goscie.add(new Goscie("Zofia", "Zielińska"));
        goscie.add(new Goscie("Adam", "Kamiński"));
        goscie.add(new Goscie("Karolina", "Lewandowska"));

        pracownicy = new ArrayList<>();
        pracownicy.add(new Pracownik("Jan", "Nowak", 523523));
        pracownicy.add(new Pracownik("Kasia", "Kowalska", 235235));
        pracownicy.add(new Pracownik("Tomasz", "Mazur", 235232345));

    }

    public int getTotalAnimals() {
        return ptaki.size() + ssaki.size() + gady.size();
    }

    public int getTotalWorkers() {
        return pracownicy.size();
    }

    public int getTotalGuests() {
        return goscie.size();
    }

    private List<Goscie> goscie;
    private List<Zwierze> animals;
    private List<Pracownik> pracownicy;

    public void manageWorkers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===============");
            System.out.println("Wybierz akcję dla pracowników:");
            System.out.println("1 - Dodaj pracownika");
            System.out.println("2 - Usuń pracownika");
            System.out.println("3 - Edytuj pracownika");
            System.out.println("4 - Zakończ");
            for(Pracownik pracownik: pracownicy){
                System.out.println(pracownik);
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Podaj imię pracownika:");
                    String name = scanner.nextLine();
                    System.out.println("Podaj nazwisko pracownika:");
                    String surname = scanner.nextLine();
                    System.out.println("Podaj stanowisko pracownika:");
                    int id = scanner.nextInt();
                    Pracownik pracownik = new Pracownik(name,surname, id);
                    addPracownik(pracownik);
                    System.out.println("Pracownik dodany.");
                    break;
                case 2:
                    System.out.println("Podaj imię pracownika do usunięcia:");
                    String nameDelete = scanner.nextLine();
                    System.out.println("Podaj nazwisko pracownika do usunięcia:");
                    String surnameDelete = scanner.nextLine();
                    removePracownik(nameDelete, surnameDelete);
                    System.out.println("Pracownik usunięty.");
                    break;
                case 3:
                    System.out.println("Podaj imię pracownika do edytowania:");
                    String guestName = scanner.nextLine();
                    System.out.println("Podaj nazwisko pracownika do edytowania:");
                    String surnameGuest = scanner.nextLine();
                    System.out.println("Podaj nowe imię pracownika:");
                    String newName = scanner.nextLine();
                    System.out.println("Podaj nowe nazwisko pracownika:");
                    String newSurname = scanner.nextLine();
                    System.out.println("Podaj nowe ID Pracownka:");
                    int newId = scanner.nextInt();
                    editPracownik(guestName, surnameGuest, newName, newSurname, newId);
                    System.out.println("Dane pracownika edytowane.");
                    break;
                case 4:
                    System.out.println("Zakończono zarządzanie pracownikami.");
                    return;
                default:
                    System.out.println("Nieznana opcja.");
                    break;
            }
        }
    }

    public void addPracownik(Pracownik pracownik) {
        pracownik.add(pracownik);
    }
    public void removePracownik(String imie, String nazwisko) {
        pracownicy.removeIf(p -> p.getImie().equalsIgnoreCase(imie) && p.getNazwisko().equalsIgnoreCase(nazwisko));
    }
    public void editPracownik(String imie, String nazwisko, String newImie, String newNazwisko, int newId) {
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getImie().equalsIgnoreCase(imie) && pracownik.getNazwisko().equalsIgnoreCase(nazwisko)) {
                pracownik.setImie(newImie);
                pracownik.setNazwisko(newNazwisko);
                pracownik.setId(newId);
                break;
            }
        }
    }

    public void showBirds() {
        System.out.println("Sekcja: Ptaki");
        for (Zwierze zwierze : ptaki) {
            System.out.println(zwierze);
        }
    }

    public void showMammals() {
        System.out.println("Sekcja: Ssaki");
        for (Zwierze zwierze : ssaki) {
            System.out.println(zwierze);
        }
    }

    public void showReptiles() {
        System.out.println("Sekcja: Gady");
        for (Zwierze zwierze : gady) {
            System.out.println(zwierze);
        }
    }

    public void addAnimal(String section, Zwierze animal) {
        switch (section.toLowerCase()) {
            case "ptak" -> ptaki.add(animal);
            case "ssak" -> ssaki.add(animal);
            case "gady" -> gady.add(animal);
            default -> System.out.println("Nieznana sekcja!");
        }
    }

    public void removeAnimal(String section, String name) {
        switch (section.toLowerCase()) {
            case "ptak" -> ptaki.removeIf(z -> z.getName().equalsIgnoreCase(name));
            case "ssak" -> ssaki.removeIf(z -> z.getName().equalsIgnoreCase(name));
            case "gady" -> gady.removeIf(z -> z.getName().equalsIgnoreCase(name));
            default -> System.out.println("Nieznana sekcja!");
        }
    }

    public List<Zwierze> getAnimalsBySection(String section) {
        return switch (section.toLowerCase()) {
            case "ptak" -> ptaki;
            case "ssak" -> ssaki;
            case "gady" -> gady;
            default -> new ArrayList<>();
        };
    }
    public void addGosc(Goscie gosc) {
        goscie.add(gosc);
    }

    public void removeGosc(String imie, String nazwisko) {
        goscie.removeIf(g -> g.getImie().equalsIgnoreCase(imie) && g.getNazwisko().equalsIgnoreCase(nazwisko));
    }

    public void editGosc(String imie, String nazwisko, String newName, String newSurname) {
        for (Goscie gosc : goscie) {
            if (gosc.getImie().equalsIgnoreCase(imie) && gosc.getNazwisko().equalsIgnoreCase(nazwisko)) {
                gosc.setName(newName);
                gosc.setSurname(newSurname);
                break;
            }
        }
    }

    public void manageGuests() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz akcję:");
            System.out.println("1 - Dodaj gościa");
            System.out.println("2 - Usuń gościa");
            System.out.println("3 - Edytuj gościa");
            System.out.println("4 - Zakończ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Konsumowanie nowej linii po nextInt()

            switch (choice) {
                case 1:
                    System.out.println("Podaj imię gościa:");
                    String imie = scanner.nextLine();
                    System.out.println("Podaj nazwisko gościa:");
                    String nazwisko = scanner.nextLine();
                    Goscie gosc = new Goscie(imie, nazwisko);
                    addGosc(gosc);
                    System.out.println("Gość dodany.");
                    break;
                case 2:
                    System.out.println("Podaj imię gościa do usunięcia:");
                    String imieUsun = scanner.nextLine();
                    System.out.println("Podaj nazwisko gościa do usunięcia:");
                    String nazwiskoUsun = scanner.nextLine();
                    removeGosc(imieUsun, nazwiskoUsun);
                    System.out.println("Gość usunięty.");
                    break;
                case 3:
                    System.out.println("Podaj imię gościa do edytowania:");
                    String guestName = scanner.nextLine();
                    System.out.println("Podaj nazwisko gościa do edytowania:");
                    String surnameGuest = scanner.nextLine();
                    System.out.println("Podaj nowe imie gościa:");
                    String newName = scanner.nextLine();
                    System.out.println("Podaj nowe nazwisko gościa:");
                    String newSurname = scanner.nextLine();
                    editGosc(guestName, surnameGuest, newName, newSurname);
                    System.out.println("Dane gościa edytowane.");
                    break;
                case 4:
                    System.out.println("Zakończono zarządzanie gośćmi.");
                    return;
                default:
                    System.out.println("Nieznana opcja.");
                    break;
            }
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