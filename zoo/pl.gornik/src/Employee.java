import java.util.Random;

public class Employee extends Person {
    private int id;

    public Employee(String firstName, String lastName, int id) {
        super(firstName, lastName);
        this.id = id;
    }

    public static String generatePassword(String firstName, String lastName) {
        String p1 = firstName.substring(0, Math.min(firstName.length(), 2));
        String p2 = lastName.substring(0, Math.min(lastName.length(), 3));
        return (p1 + p2 + "123").toLowerCase();
    }

    public void viewDetailedReport(Zoo zoo) {
        System.out.println("\n--- DETAILED STAFF REPORT ---");
        System.out.println("Birds:"); zoo.getAnimalsBySection("bird").forEach(System.out::println);
        System.out.println("Mammals:"); zoo.getAnimalsBySection("mammal").forEach(System.out::println);
        System.out.println("Reptiles:"); zoo.getAnimalsBySection("reptile").forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Employee: " + firstName + " " + lastName + " (ID: " + id + ")";
    }
}