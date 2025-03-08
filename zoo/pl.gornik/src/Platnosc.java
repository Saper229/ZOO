import java.time.LocalDate;

public class Platnosc {
    double price;
    private RodzajPlatnosci rodzajPlatnosci;

    public void paragon(double price, String rodzajPlatnosci) {
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Paragon:");
        System.out.println("Zapłacono " + price);
        System.out.println("Metodą: " + rodzajPlatnosci);
        LocalDate date = LocalDate.now();
        System.out.println("Data "+date);
        System.out.println("-------------------------------");
    }

    public void change(double price) {
        if (rodzajPlatnosci == RodzajPlatnosci.GOTOWKA && price > 20) {
            double changes = price - 20;
            System.out.println("Reszta do zwrotu: " + changes + " zł");
            System.out.println("-------------------------------");
        }
    }

    public double getPrice(RodzajPlatnosci getPrice) {
        return price;
    }

    public RodzajPlatnosci getRodzajPlatnosci(RodzajPlatnosci gotowka) {
        return rodzajPlatnosci;
    }

    @Override
    public String toString() {
        return "Platnosc{" +
                "price=" + price +
                ", rodzajPlatnosci=" + rodzajPlatnosci +
                '}';
    }
}
