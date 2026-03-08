import java.time.LocalDate;

public class Payment {
    public void printReceipt(double amount, String method) {
        System.out.println("\n-------------------------------");
        System.out.println("RECEIPT:");
        System.out.println("Paid: " + amount + " PLN");
        System.out.println("Method: " + method);
        System.out.println("Date: " + LocalDate.now());
        System.out.println("-------------------------------\n");
    }

    public void calculateChange(double paid, double price) {
        double change = paid - price;
        if (change > 0) {
            System.out.println("Change to return: " + change + " PLN");
        }
    }
}