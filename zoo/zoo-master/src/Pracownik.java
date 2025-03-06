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
        String changedName = imie.length() >= 2 ? imie.substring(0, 2) : imie;
        String changedSurname = nazwisko.length() >= 3 ? nazwisko.substring(0, 3) : nazwisko;
        int pass = (int) ((Math.random()*1000)+1);

        return changedName + changedSurname + pass;
    }

    public static boolean isPasswordValid(String imie, String nazwisko, String password) {
        password = generatePassword(imie,nazwisko);
        return password.equals(password);
    }
}
