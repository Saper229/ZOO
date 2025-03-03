import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj w ZOO");
        System.out.println("Kim jesteś, Gościem czy pracownikiem?");
        String zapytaj = scanner.nextLine();

        if (zapytaj.equalsIgnoreCase("gość")) {
            System.out.println("Proszę zapłacić 20zł za wejście");
            int getPrice = scanner.nextInt();
            scanner.nextLine();  // Czyści bufor po nextInt

            if (getPrice < 20) {
                System.out.println("Nie ma pan/i środków");
            } else {
                System.out.println("Proszę wybrać metodę płatności (blik, karta, gotówka):");
                String zapytaj2 = scanner.nextLine();

                if (zapytaj2.equalsIgnoreCase("blik")) {
                    System.out.println("------------------------------");
                    int blik = RodzajPlatnosci.BLIK.blikPayment();
                    System.out.println(blik);
                    System.out.println("------------------------------");
                    System.out.println("Podaj Kod Blik:");
                    int zapytaj3 = scanner.nextInt();
                    scanner.nextLine();

                    if (zapytaj3 == blik) {
                        System.out.println("Kod jest poprawny, transakcja przeszła");
                        Platnosc platnosc = new Platnosc();
                        platnosc.paragon(getPrice, zapytaj2);
                    } else {
                        System.out.println("Transakcja nie powiodła się");
                    }
                } else if (zapytaj2.equalsIgnoreCase("karta") || zapytaj2.equalsIgnoreCase("gotówka")) {
                    System.out.println("Transakcja się powiodła");
                    Platnosc platnosc2 = new Platnosc();
                    platnosc2.paragon(getPrice, zapytaj2);
                } else {
                    System.out.println("Nieznana metoda płatności");
                }
                System.out.println();
                System.out.println("---------------------------------------------------------");
                System.out.println("Gdzie teraz chcesz się udać?");
            }
        } else {
            System.out.println("Miałeś być gościem, a nie pracownikiem!");
        }
    }
}