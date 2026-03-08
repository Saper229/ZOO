import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> birds = new ArrayList<>();
    private List<Animal> mammals = new ArrayList<>();
    private List<Animal> reptiles = new ArrayList<>();

    public Zoo() {
        birds.add(new Animal("Eagle", "Healthy", ObjectType.AVIARY));
        mammals.add(new Animal("Lion", "Healthy", ObjectType.PADDOCK));
        reptiles.add(new Animal("Snake", "Healthy", ObjectType.TERRARIUM));
    }

    public List<Animal> getAnimalsBySection(String section) {
        return switch (section.toLowerCase()) {
            case "bird" -> birds;
            case "mammal" -> mammals;
            case "reptile" -> reptiles;
            default -> { System.exit(0); yield null; }
        };
    }

    public void showAllAnimalsSimplified() {
        List<Animal> all = new ArrayList<>();
        all.addAll(birds); all.addAll(mammals); all.addAll(reptiles);
        all.forEach(a -> System.out.println("- " + a.getName()));
    }

    public void addAnimal(String sec, Animal a) { getAnimalsBySection(sec).add(a); }
    public void removeAnimal(String sec, String name) {
        getAnimalsBySection(sec).removeIf(a -> a.getName().equalsIgnoreCase(name));
    }
}