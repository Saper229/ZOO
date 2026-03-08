import java.util.Scanner;
// Importowanie Twoich wyjątków z pakietu
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        Payment payment = new Payment();

        try {
            System.out.println("=== ZOO MANAGEMENT SYSTEM ===");
            System.out.println("Select your role: 1 - Guest, 2 - Employee");

            if (!scanner.hasNextLine()) throw new InvalidInputException("No input provided.");
            String role = scanner.nextLine();

            if (role.equals("1")) {
                handleGuest(scanner, zoo, payment);
            } else if (role.equals("2")) {
                handleEmployee(scanner, zoo);
            } else {
                throw new InvalidInputException("Invalid choice. Exiting system.");
            }
        } catch (ZooException e) {
            // Tutaj przechwytujemy każdy z Twoich 4 wyjątków
            System.out.println("\n[TERMINATED] Reason: " + e.getMessage());
            System.exit(0);
        } finally {
            scanner.close();
        }
    }

    private static void handleGuest(Scanner scanner, Zoo zoo, Payment payment) throws ZooException {
        double ticketPrice = 20.0;
        System.out.println("\n--- GUEST PANEL ---");
        System.out.println("Entry ticket: " + ticketPrice + " PLN");
        System.out.println("Select payment method: 1-BLIK, 2-CARD, 3-CASH");

        if (!scanner.hasNextLine()) throw new InvalidInputException("No input.");
        String method = scanner.nextLine();

        switch (method) {
            case "1" -> {
                int generatedBlik = PaymentType.BLIK.generateBlik();
                System.out.println("Your BLIK code: " + generatedBlik);
                System.out.print("Enter code: ");
                if (!scanner.hasNextInt()) throw new InvalidInputException("Format error.");
                if (scanner.nextInt() != generatedBlik) throw new UnauthorizedException("Incorrect BLIK code!");
                scanner.nextLine();
                payment.printReceipt(ticketPrice, "BLIK");
            }
            case "2" -> {
                System.out.print("Enter PIN (8520): ");
                if (!scanner.hasNextInt()) throw new InvalidInputException("Format error.");
                if (scanner.nextInt() != 8520) throw new UnauthorizedException("Incorrect PIN!");
                scanner.nextLine();
                payment.printReceipt(ticketPrice, "CARD");
            }
            case "3" -> {
                System.out.print("Enter amount: ");
                if (!scanner.hasNextDouble()) throw new InvalidInputException("Format error.");
                double providedAmount = scanner.nextDouble();
                scanner.nextLine();
                if (providedAmount < ticketPrice) throw new InsufficientFundsException("Insufficient funds!");
                payment.calculateChange(providedAmount, ticketPrice);
                payment.printReceipt(ticketPrice, "CASH");
            }
            default -> throw new InvalidInputException("Unknown payment method.");
        }

        System.out.println("\nWelcome to the Zoo! Here is our current animal list:");
        zoo.showAllAnimalsSimplified();
    }

    private static void handleEmployee(Scanner scanner, Zoo zoo) throws ZooException {
        System.out.println("\n--- EMPLOYEE LOGIN ---");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        String password = Employee.generatePassword(firstName, lastName);
        System.out.println("[SECURE INFO] Your generated password: " + password);
        System.out.print("Enter password to login: ");

        if (!scanner.nextLine().equals(password)) throw new UnauthorizedException("Access Denied! Incorrect password.");

        Employee employee = new Employee(firstName, lastName, 101);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- ADMINISTRATIVE PANEL ---");
            System.out.println("1 - Manage Animals");
            System.out.println("2 - View Full Detailed Report");
            System.out.println("3 - Logout & Exit");

            if (!scanner.hasNextInt()) throw new InvalidInputException("Format error.");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> Animal.manageAnimals(zoo, scanner); // Pamiętaj dodać throws ZooException w klasie Animal
                case 2 -> employee.viewDetailedReport(zoo);
                case 3 -> isRunning = false;
                default -> throw new InvalidInputException("Invalid option.");
            }
        }
    }
}