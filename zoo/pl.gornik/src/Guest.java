import java.time.LocalDate;

public class Guest extends Person {
    private LocalDate visitDate;

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
        this.visitDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Guest: " + firstName + " " + lastName + " (Date: " + visitDate + ")";
    }
}