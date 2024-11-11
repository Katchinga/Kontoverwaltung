import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Sparkonto extends Konto {
    char art;
    DecimalFormat f = new DecimalFormat("#0.00");
    double zinssumme= 0;

    public Sparkonto(String ktoNummer, double kontostand, double habenzins, Kunde myKunde,char art, LocalDate date) {
        super(ktoNummer,habenzins,myKunde,kontostand, date);
        this.art = art;
    }
    public void abheben(double betrag, LocalDate date){
        zinssummeBerechnen(date);
        if(kontostand - betrag < 0){
            System.out.println("Kreditlimit von Konto " + getKtoNummer()+ " Überzogen. Buchung über - " +
                    betrag + " Euro vom " + date.getDayOfMonth() + " . " + date.getMonth() +
                    ". " + date.getYear() + "  wurde nicht ausgeführt");

        }else {
            kontostand -= betrag;
        }
        getKontobewegungList().add(new Kontobewegung(-betrag,date,this,"Auszahlung"));
    }

    
    public void berechneZinsen(LocalDate date) {
        zinssummeBerechnen(date);
        Kontobewegung kontobewegung = new Kontobewegung(zinssumme, date,this,"Zinsen");
        getKontobewegungList().add(kontobewegung);
        kontostand+= zinssumme;
        zinssumme = 0;
    }
    public void zinssummeBerechnen(LocalDate date){
        if (myBew.size()> 1){
            String s = f.format(kontostand*habenzins/100*rechneTage(getKontobewegungList().get(getKontobewegungList().size()-1).getDatum(),date)/365);
        }
    }
    public long rechneTage(LocalDate start, LocalDate ende){
        return ChronoUnit.DAYS.between(start,ende);
    }

}
