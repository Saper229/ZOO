import java.util.Objects;
import java.util.Random;

public class Pracownik extends Goscie {
    String imie;
    String nazwisko;
    int id;

    public Pracownik(String imie, String nazwisko, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
    }

    public static String generatePassword(String imie, String nazwisko) {
        String changedName = imie.substring(0, Math.min(imie.length(), 2));
        String changedSurname = nazwisko.substring(0, Math.min(nazwisko.length(), 3));
        Random random = new Random();
        int randomNum = (int) ((Math.random()*1000)+1);
        return changedName + changedSurname + randomNum;
    }
}
