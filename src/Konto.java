import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Konto {
     private String ktoNummer;
   public static double kontostand;
    public static double habenzins;
    private Kunde myKunde;
    List<Kontobewegung> myBew = new ArrayList<>();
    public List<Kontobewegung> kontobewegungList = new ArrayList<>();


    public Konto(String ktoNummer, double habenzins, Kunde myKunde,  double kontostand,LocalDate date){
        this.ktoNummer = ktoNummer;
        this.habenzins = habenzins;
        this.myKunde = myKunde;
        this.kontostand = kontostand;
        myKunde.addKunde(this);
        Bank.myKonten.add(this);
    }

    public void einzahlen(double betrag, LocalDate datum) {
        zinssummeBerechnen(datum);
        kontostand +=betrag;
        myBew.add(new Kontobewegung(betrag,datum,this,"Einzahlen"));
    }


    public String getKtoNummer() {
        return ktoNummer;
    }

    public void setKtoNummer(String ktoNummer) {
        this.ktoNummer = ktoNummer;
    }

    public double getKontostand() {
        return kontostand;
    }

    public List<Kontobewegung> getKontobewegungList() {
        return kontobewegungList;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public double getHabenzins() {
        return habenzins;
    }

    public void setHabenzins(double habenzins) {
        this.habenzins = habenzins;
    }

    public Kunde getMyKunde() {
        return myKunde;
    }

    public void setMyKunde(Kunde myKunde) {
        this.myKunde = myKunde;
    }

    public List<Kontobewegung> getMyBew() {
        return myBew;
    }

    public void setMyBew(List<Kontobewegung> myBew) {
        this.myBew = myBew;
    }


    public abstract void zinssummeBerechnen(LocalDate date);
    public abstract void abheben(double betrag, LocalDate date);
    public abstract void berechneZinsen(LocalDate date);
}