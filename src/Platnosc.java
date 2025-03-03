public class Platnosc {
    double price;
    RodzajPlatnosci rodzajPlatnosci;

    public void paragon (double price, String rodzajPlatnosci){
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Zapłacono "+ price+ " Metodą: "+ rodzajPlatnosci);
        System.out.println("-------------------------------");
    }

    @Override
    public String toString() {
        return "Platnosc{" +
                "price=" + price +
                ", rodzajPlatnosci=" + rodzajPlatnosci +
                '}';
    }
}
