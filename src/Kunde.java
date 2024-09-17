import java.time.LocalDateTime;
import java.util.ArrayList;

public class Kunde {
    private String name;
    private String adresse;
    private LocalDateTime kundeSeit;
    private ArrayList<Konto> myKonten;

    public Kunde(String kundennummer, String name, String adresse, LocalDateTime kundeSeit, ArrayList<Konto> myKonten) {
        this.name = name;
        this.adresse = adresse;
        this.kundeSeit = kundeSeit;
        this.myKonten = myKonten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDateTime getKundeSeit() {
        return kundeSeit;
    }

    public void setKundeSeit(LocalDateTime kundeSeit) {
        this.kundeSeit = kundeSeit;
    }

    public ArrayList<Konto> getMyKonten() {
        return myKonten;
    }

    public void setMyKonten(ArrayList<Konto> myKonten) {
        this.myKonten = myKonten;
    }
}
