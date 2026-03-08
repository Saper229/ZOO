import java.time.LocalDate;
import java.util.Scanner;

public class Animal {
    private String name;
    private String healthStatus;
    private ObjectType objectType;

    public Animal(String name, String healthStatus, ObjectType objectType) {
        this.name = name;
        this.healthStatus = healthStatus;
        this.objectType = objectType;
    }

    public String getName() { return name; }
    public void setObjectType(ObjectType objectType) { this.objectType = objectType; }

    @Override
    public String toString() {
        return String.format("Animal: %-12s | Health: %-8s | Location: %s", name, healthStatus, objectType);
    }

    // Pomocnicza metoda do wyboru przechowalni (ObjectType)
    private static ObjectType chooseObjectType(Scanner scanner) {
        System.out.println("Select location type:");
        System.out.println("1-CAGE, 2-AVIARY, 3-TERRARIUM, 4-AQUARIUM, 5-PADDOCK");
        if (!scanner.hasNextInt()) System.exit(0);
        int choice = scanner.nextInt(); scanner.nextLine();

        if (choice < 1 || choice > 5) {
            System.out.println("Invalid storage type!");
            System.exit(0);
        }
        return ObjectType.values()[choice - 1];
    }

    public static void manageAnimals(Zoo zoo, Scanner scanner) {
        System.out.println("\nSelect section: 1-Mammals, 2-Birds, 3-Reptiles");
        if (!scanner.hasNextInt()) System.exit(0);
        int s = scanner.nextInt(); scanner.nextLine();

        String section = (s == 1) ? "mammal" : (s == 2) ? "bird" : (s == 3) ? "reptile" : null;
        if (section == null) System.exit(0);

        boolean sectionActive = true;
        while (sectionActive) {
            System.out.println("\n--- Current " + section + "s ---");
            zoo.getAnimalsBySection(section).forEach(System.out::println);

            System.out.println("\nActions: 1-Add New, 2-Edit Location, 3-Remove, 4-Back");
            if (!scanner.hasNextInt()) System.exit(0);
            int action = scanner.nextInt(); scanner.nextLine();

            switch (action) {
                case 1 -> { // DODAWANIE
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Where to put the animal?");
                    ObjectType type = chooseObjectType(scanner);
                    zoo.addAnimal(section, new Animal(name, "Healthy", type));
                    System.out.println("Animal added successfully.");
                }
                case 2 -> { // EDYCJA LOKALIZACJI
                    System.out.print("Enter animal name to move: ");
                    String nameToEdit = scanner.nextLine();
                    Animal found = zoo.getAnimalsBySection(section).stream()
                            .filter(a -> a.getName().equalsIgnoreCase(nameToEdit))
                            .findFirst().orElse(null);

                    if (found == null) {
                        System.out.println("Animal not found!");
                        System.exit(0);
                    }

                    System.out.println("Select new location for " + found.getName() + ":");
                    found.setObjectType(chooseObjectType(scanner));
                    System.out.println("Location updated.");
                }
                case 3 -> { // USUWANIE
                    System.out.print("Enter name to remove: ");
                    String toRemove = scanner.nextLine();
                    zoo.removeAnimal(section, toRemove);
                }
                case 4 -> sectionActive = false;
                default -> System.exit(0);
            }
        }
    }
}