import java.util.Objects;
import java.util.Random;

public class Pracownik extends Goscie {
    private String imie;
    private String nazwisko;
    private int id;

    public Pracownik(String imie, String nazwisko, int id) {
        super(imie,nazwisko);
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

    @Override
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pracownik(String imie, String nazwisko, String imie1, String nazwisko1, int id) {
        super(imie, nazwisko);
        this.imie = imie1;
        this.nazwisko = nazwisko1;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Pracownik: " + imie + " " + nazwisko+" "+ id;
    }
}
