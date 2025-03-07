import java.util.Scanner;
import java.time.LocalDate;

public class Zwierze {
    private static Zwierze Zwierze;
    private String name;
    private LocalDate dataUrodzenia;
    private String stanZdrowia;
    private TypObiektu typObiektu;

    public Zwierze(String name, LocalDate dataUrodzenia, String stanZdrowia, TypObiektu typObiektu) {
        this.name = name;
        this.dataUrodzenia = dataUrodzenia;
        this.stanZdrowia = stanZdrowia;
        this.typObiektu = typObiektu;
    }

    public String getName() {
        return name;
    }

    public TypObiektu getTypObiektu() {
        return typObiektu;
    }

    public void setTypObiektu(TypObiektu typObiektu) {
        this.typObiektu = typObiektu;
    }

    public static void modifyAnimal(Zoo zoo, Scanner scanner, String section) {
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - Edytować zwierzę");
        System.out.println("2 - Usunąć zwierzę");
        System.out.println("3 - Dodać zwierzę");
        System.out.println("5- Zakończ");
        int action = scanner.nextInt();
        scanner.nextLine();

        if (action == 1) {
            System.out.println("Podaj nazwę zwierzęcia, które chcesz edytować:");
            String name = scanner.nextLine();

            Zwierze selectedAnimal = zoo.getAnimalsBySection(section).stream()
                    .filter(z -> z.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);

            if (selectedAnimal != null) {
                System.out.println("Wybierz nowy typ obiektu:");
                System.out.println("1 - KLATKA");
                System.out.println("2 - WOLIERA");
                System.out.println("3 - TERRARIUM");
                System.out.println("4 - AKWARIUM");
                System.out.println("5 - WYBIEG");
                int choice = scanner.nextInt();
                scanner.nextLine();

                TypObiektu newType = switch (choice) {
                    case 1 -> TypObiektu.KLATKA;
                    case 2 -> TypObiektu.WOLIERA;
                    case 3 -> TypObiektu.TERRARIUM;
                    case 4 -> TypObiektu.AKWARIUM;
                    case 5 -> TypObiektu.WYBIEG;
                    default -> {
                        System.out.println("Niepoprawny wybór!");
                        yield selectedAnimal.getTypObiektu();
                    }
                };

                selectedAnimal.setTypObiektu(newType);
                System.out.println("Typ obiektu zmieniony na: " + newType);
            } else {
                System.out.println("Nie znaleziono zwierzęcia o podanej nazwie.");
            }
        } else if (action == 2) {
            System.out.println("Podaj nazwę zwierzęcia, które chcesz usunąć:");
            String name = scanner.nextLine();
            zoo.removeAnimal(section,name);
            System.out.println("Usunięto zwierzę: " + name);
        } else if (action == 3) {
            System.out.println("Podaj nazwę nowego zwierzęcia:");
            String name = scanner.nextLine();
            System.out.println("Podaj stan zdrowia zwierzęcia:");
            String stanZdrowia = scanner.nextLine();
            System.out.println("Wybierz typ obiektu:");
            System.out.println("1 - KLATKA");
            System.out.println("2 - WOLIERA");
            System.out.println("3 - TERRARIUM");
            System.out.println("4 - AKWARIUM");
            System.out.println("5 - WYBIEG");
            zoo.addAnimal(section,Zwierze);
            int choice = scanner.nextInt();
            scanner.nextLine();

            TypObiektu newType = switch (choice) {
                case 1 -> TypObiektu.KLATKA;
                case 2 -> TypObiektu.WOLIERA;
                case 3 -> TypObiektu.TERRARIUM;
                case 4 -> TypObiektu.AKWARIUM;
                case 5 -> TypObiektu.WYBIEG;
                default -> {
                    System.out.println("Niepoprawny wybór! Domyślnie WYBIEG.");
                    yield TypObiektu.WYBIEG;
                }
            };
        } else if (action == 5) {
            System.out.println("Koniec Edytowania");
        } else {
            System.out.println("Nieznana opcja.");
        }
    }

    @Override
    public String toString() {
        return "Zwierzę{" +
                "nazwa='" + name + '\'' +
                ", data urodzenia=" + dataUrodzenia +
                ", stan zdrowia='" + stanZdrowia + '\'' +
                ", typ obiektu=" + typObiektu +
                '}';
    }
}