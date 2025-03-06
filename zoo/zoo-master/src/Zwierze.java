import java.time.LocalDate;
import java.util.Scanner;

public class Zwierze {
    private String nazwa;
    private String typ;
    private LocalDate dataUrodzenia;
    private String stan;
    private TypObiektu typObiektu;

    public Zwierze(String nazwa, LocalDate dataUrodzenia, String stan, TypObiektu typObiektu) {
        this.nazwa = nazwa;
        this.dataUrodzenia = dataUrodzenia;
        this.stan = stan;
        this.typObiektu = typObiektu;
    }
    public String getName() {
        return nazwa;
    }

    public static void modifyAnimal(Zoo zoo, Scanner scanner, String typ) {
        System.out.println("Podaj nazwę zwierzęcia, które chcesz zmodyfikować:");
        String nazwaZwierze = scanner.nextLine();
        Zwierze animal = null;
        if (typ.equals("ssak")) {
            for (Zwierze zwierze : zoo.ssaki) {
                if (zwierze.getName().equalsIgnoreCase(nazwaZwierze)) {
                    animal = zwierze;
                    break;
                }
            }
        } else if (typ.equals("ptak")) {
            for (Zwierze zwierze : zoo.ptaki) {
                if (zwierze.getName().equalsIgnoreCase(nazwaZwierze)) {
                    animal = zwierze;
                    break;
                }
            }
        } else if (typ.equals("gady")) {
            for (Zwierze zwierze : zoo.gady) {
                if (zwierze.getName().equalsIgnoreCase(nazwaZwierze)) {
                    animal = zwierze;
                    break;
                }
            }
        }

        if (animal != null) {
            System.out.println("Zwierzę znalezione: " + animal.getName());
            System.out.println("Podaj nowy stan zwierzęcia:");
            String newState = scanner.nextLine();
            animal.stan = newState;
            System.out.println("Nowy stan zwierzęcia: " + newState);
            System.out.println(animal);
        } else {
            System.out.println("Nie znaleziono zwierzęcia o tej nazwie.");
        }
    }

    @Override
    public String toString() {
        return "Zwierze{" +
                "nazwa='" + nazwa + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", stan='" + stan + '\'' +
                ", typObiektu=" + typObiektu +
                '}';
    }
}

