public class Platnosc {
    double price;
    private RodzajPlatnosci rodzajPlatnosci;

    public void paragon(double price, String rodzajPlatnosci) {
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Paragon:");
        System.out.println("Zapłacono " + price + " Metodą: " + rodzajPlatnosci);
        System.out.println("-------------------------------");
    }

    public void change(double price) {
        if (rodzajPlatnosci == RodzajPlatnosci.GOTOWKA && price > 20) {
            double reszta = price - 20;
            System.out.println("Reszta do zwrotu: " + reszta + " zł");
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
