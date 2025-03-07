import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        System.out.println("Witaj w ZOO");
        System.out.println("Kim jesteś, Gościem czy pracownikiem?(Gość-1, Pracownik-2)");
        String zapytaj = scanner.nextLine();

        if (zapytaj.equalsIgnoreCase("1")) {
            System.out.println("Wstęp kosztuje 20zł");
            int getPrice = 20;
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
            } else if (zapytaj2.equalsIgnoreCase("karta")) {
                System.out.println("------------------------------");
                int card = RodzajPlatnosci.KARTA.cardPayment();
                System.out.println(card);
                System.out.println("------------------------------");
                System.out.println("Proszę podać PIN karty:");
                int pin = scanner.nextInt();
                scanner.nextLine();

                if (pin == card) {
                    System.out.println("PIN jest poprawny, transakcja się powiodła");
                    Platnosc platnosc2 = new Platnosc();
                    platnosc2.paragon(getPrice, zapytaj2);
                } else {
                    System.out.println("Niepoprawny PIN, transakcja nie powiodła się");
                }
            } else if (zapytaj2.equalsIgnoreCase("gotówka")) {
                System.out.println("Proszę zapłacić gotówką (podaj kwotę):");
                double price = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Transakcja się powiodła");
                Platnosc platnosc2 = new Platnosc();
                platnosc2.getRodzajPlatnosci(RodzajPlatnosci.GOTOWKA);
                platnosc2.paragon(getPrice, zapytaj2);
                platnosc2.change(price);
            } else {
                System.out.println("Nieznana metoda płatności");
            }
            System.out.println();
            System.out.println("---------------------------------------------------------");
            while(true) {
                System.out.println("Gdzie teraz chcesz się udać?");
                System.out.println("1 - Ssaki");
                System.out.println("2 - Ptaki");
                System.out.println("3 - Gady");
                System.out.println("4 - Zakończ");
                System.out.println("Wybierz Opcję do wyboru");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        zoo.pokazSsaki();
                        break;
                    case 2:
                        zoo.pokazPtaki();
                        break;
                    case 3:
                        zoo.pokazGady();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Nieznana sekcja");
                        break;
                }
            }
        } else if (zapytaj.equalsIgnoreCase("2")) {
            System.out.println("Podaj imię pracownika:");
            String name = scanner.nextLine();
            System.out.println("Podaj nazwisko pracownika:");
            String surname = scanner.nextLine();
            String password = Pracownik.generatePassword(name, surname);
            System.out.println("==================================");
            System.out.println("Hasło dostępu pracownika: " + password);
            System.out.println("==================================");
            System.out.println("Podaj Hasło Pracownika");
            String sendPassword = scanner.nextLine();
            if (sendPassword.equals(password)) {
                System.out.println("Hasło poprawne, masz dostęp do sekcji Panelu");
                while (true) {
                    System.out.println("Czy chcesz Zarządzać ZOO?");
                    String askForContinue = scanner.nextLine();
                    if (askForContinue.equalsIgnoreCase("nie")) {
                        break;
                    } else {
                        System.out.println("Wybierz kategorię:");
                        System.out.println("1 - Zarządzanie zwierzętami");
                        System.out.println("2 - Zarządzanie gośćmi");
                        System.out.println("3 - Zarządzanie pracownikami");
                        System.out.println("4 - Zakończ");
                        int guestsOrAnimals = scanner.nextInt();
                        if (guestsOrAnimals == 1) {
                            System.out.println("1 - Ssaki");
                            System.out.println("2 - Ptaki");
                            System.out.println("3 - Gady");
                            System.out.println("Wybierz sekcję, którą chcesz zobaczyć i edytować:");

                            int choice = scanner.nextInt();
                            scanner.nextLine();

                            switch (choice) {
                                case 1:
                                    zoo.pokazSsaki();
                                    Zwierze.modifyAnimal(zoo, scanner, "ssak");
                                    break;
                                case 2:
                                    zoo.pokazPtaki();
                                    Zwierze.modifyAnimal(zoo, scanner, "ptak");
                                    break;
                                case 3:
                                    zoo.pokazGady();
                                    Zwierze.modifyAnimal(zoo, scanner, "gady");
                                    break;
                                default:
                                    System.out.println("Nieznana sekcja");
                                    break;
                            }
                        } else if (guestsOrAnimals == 2) {
                            zoo.zarzadzajGosciami();
                        }
                        else if (guestsOrAnimals == 3) {
                            zoo.zarzadzajPracownikami();
                        }
                        else if (guestsOrAnimals == 4) {
                            System.out.println("Zakończono program.");
                            break;
                        } else {
                            System.out.println("Nieznana opcja.");
                        }
                    }
                }
            } else {
                System.out.println("Niepoprawne hasło!");
            }

        } else {
            System.out.println("Nieznana opcja, powinieneś być gościem lub pracownikiem!");
        }
    }
}
