import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        System.out.println("Witaj w ZOO");
        System.out.println("Kim jesteś, Gościem czy pracownikiem?(Gość-1, Pracownik-2)");
        String ask = scanner.nextLine();

        if (ask.equalsIgnoreCase("1")) {
            System.out.println("Wstęp kosztuje 20zł");
            int getPrice = 20;
            System.out.println("Proszę wybrać metodę płatności (blik, karta, gotówka):");
            System.out.println("BLIK - 1");
            System.out.println("Karta - 2");
            System.out.println("Gotówka - 3");
            String secondAsk = scanner.nextLine();
            if (secondAsk.equalsIgnoreCase("1")) {
                System.out.println("------------------------------");
                int blik = RodzajPlatnosci.BLIK.blikPayment();
                System.out.println(blik);
                System.out.println("------------------------------");
                System.out.println("Podaj Kod Blik:");
                int thirdAsk = scanner.nextInt();
                scanner.nextLine();

                if (thirdAsk == blik) {
                    System.out.println("Kod jest poprawny, transakcja przeszła");
                    Platnosc validuty = new Platnosc();
                    validuty.paragon(getPrice,"BLIK");
                } else {
                    System.out.println("Transakcja nie powiodła się");
                    return;
                }
            } else if (secondAsk.equalsIgnoreCase("2")) {
                System.out.println("------------------------------");
                int card = RodzajPlatnosci.KARTA.cardPayment();
                System.out.println(card);
                System.out.println("------------------------------");
                System.out.println("Proszę podać PIN karty:");
                int pin = scanner.nextInt();
                scanner.nextLine();

                if (pin == card) {
                    System.out.println("PIN jest poprawny, transakcja się powiodła");
                    Platnosc validuty2 = new Platnosc();
                    validuty2.paragon(getPrice, "Kartą");
                } else {
                    System.out.println("Niepoprawny PIN, transakcja nie powiodła się");
                    return;
                }
            } else if (secondAsk.equalsIgnoreCase("3")) {
                System.out.println("Proszę zapłacić gotówką (podaj kwotę):");
                double price = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Transakcja się powiodła");
                Platnosc validity2 = new Platnosc();
                validity2.getRodzajPlatnosci(RodzajPlatnosci.GOTOWKA);
                validity2.paragon(getPrice, "Gotówka");
                validity2.change(price);
            } else {
                System.out.println("Nieznana metoda płatności");
                return;
            }
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
                        zoo.showMammals();
                        break;
                    case 2:
                        zoo.showBirds();
                        break;
                    case 3:
                        zoo.showReptiles();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Nieznana sekcja");
                        break;
                }
            }
        } else if (ask.equalsIgnoreCase("2")) {
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
                    System.out.println("Czy chcesz Zarządzać ZOO? (Wpisz 'tak' jeśli chcesz, jeśli nie chcesz napisz 'nie')");
                    String askForContinue = scanner.nextLine();
                    if (askForContinue.equalsIgnoreCase("nie")) {
                        break;
                    } else {
                        System.out.println("Wybierz kategorię:");
                        System.out.println("1 - Zarządzanie zwierzętami");
                        System.out.println("2 - Zarządzanie gośćmi");
                        System.out.println("3 - Zarządzanie pracownikami");
                        System.out.println("4 - Raport");
                        System.out.println("5 - Zakończ");
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
                                    zoo.showMammals();
                                    Zwierze.modifyAnimal(zoo, scanner, "ssak");
                                    break;
                                case 2:
                                    zoo.showBirds();
                                    Zwierze.modifyAnimal(zoo, scanner, "ptak");
                                    break;
                                case 3:
                                    zoo.showReptiles();
                                    Zwierze.modifyAnimal(zoo, scanner, "gady");
                                    break;
                                default:
                                    System.out.println("Nieznana sekcja");
                                    break;
                            }
                        } else if (guestsOrAnimals == 2) {
                            zoo.manageGuests();
                        }
                        else if (guestsOrAnimals == 3) {
                            zoo.manageWorkers();
                        }
                        else if (guestsOrAnimals == 4) {
                            int totalAnimals = zoo.getTotalAnimals();
                            int totalWorkers = zoo.getTotalWorkers();
                            int totalGuests = zoo.getTotalGuests();
                            System.out.println("Raport:");
                            System.out.println("Ilość Zwierząt"+totalAnimals);
                            System.out.println("Ilość Pracowników"+totalWorkers);
                            System.out.println("Ilość Gośći"+totalGuests);
                        } else if (guestsOrAnimals ==5 ) {
                            System.out.println("Zakończono działanie");
                            return;
                        }
                        else {
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
