import java.time.LocalDateTime;
import java.util.ArrayList;

public class Kunde {
    private String name;
    private String adresse;
    private LocalDateTime kundeSeit;
    private ArrayList<Konto> myKonten;
    String Kundennummer;

    public Kunde(String kundennummer, String name, String adresse, LocalDateTime kundeSeit, ArrayList<Konto> myKonten) {
        this.name = name;
        this.adresse = adresse;
        this.kundeSeit = kundeSeit;
        this.myKonten = myKonten;
        this.Kundennummer = kundennummer;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public LocalDateTime getKundeSeit() {
        return kundeSeit;
    }

    public ArrayList<Konto> getMyKonten() {
        return myKonten;
    }

    public String getKundennummer() {
        return Kundennummer;
    }
}
