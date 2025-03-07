import java.time.LocalDate;

public class Goscie {
    String imie;
    String nazwisko;
    LocalDate dataWizyty;

    public Goscie(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataWizyty = LocalDate.now();
    }

    public void add(Goscie gosc) {
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setSurname(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setName(String imie) {
        this.imie = imie;
    }

    @Override
    public String toString() {
        return "Gość: " + imie + " " + nazwisko;
    }
}
