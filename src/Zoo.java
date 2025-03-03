import java.time.LocalDate;
import java.util.List;

public class Zoo {
    LocalDate dataUrodzenia = LocalDate.now();
    Zwierze pingwin = new Zwierze("Ptak",dataUrodzenia,"Dobry",TypObiektu.WYBIEG);
    Zwierze Jaguar = new Zwierze("Ssak",dataUrodzenia,"Dobry",TypObiektu.WYBIEG);
    Zwierze Jasczurka = new Zwierze("Gad",dataUrodzenia,"zły",TypObiektu.KLATKA);
    List <Zwierze> zwierzeta;
    List<Obiekt> obiekty;

}
