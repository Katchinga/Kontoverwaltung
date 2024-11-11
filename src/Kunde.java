import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Kunde {
    private String  kundenNummer;
    private String name;
    private String adresse;
    private LocalDate kundeSeit;
    public static ArrayList<Konto> myKonten = new ArrayList<>();

    public Kunde(String kundenNummer, String name, String adresse, LocalDate kundeSeit, String kontoNr,double kontostand, double habenzins, double sollzins, double dispo, char art) {
        this.kundenNummer = kundenNummer;
        this.name = name;
        this.adresse = adresse;
        this.kundeSeit = kundeSeit;
        if(art== ' '){
            Bank.eröffneGirokonto(kontoNr, kontostand,habenzins,this,sollzins,dispo,kundeSeit);
        }else {
            Bank.eröffneSparkonto(kontoNr,kontostand,sollzins,this,kundeSeit,art);
        }
        Bank.myKunden.add(this);

    }

    public void addKunde(Konto konto){
        myKonten.add(konto);
    }

    public String getKundenNummer() {
        return kundenNummer;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public LocalDate getKundeSeit() {
        return kundeSeit;
    }

    public ArrayList<Konto> getMyKonten() {
        return myKonten;
    }
}
