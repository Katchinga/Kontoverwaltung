import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Girokonto extends Konto {
    double sollzins;
    double dispo;
    double zinssumme = 0;
    DecimalFormat f = new DecimalFormat("00.0#");


    public Girokonto(String ktoNummer,double habenzins, Kunde myKunde, double sollzins, double dispo, double kontostand, LocalDate date) {
        super(ktoNummer, habenzins, myKunde, kontostand, date);
        this.sollzins = sollzins;
        this.dispo = dispo;
    }
    public void abheben(double betrag, LocalDate date){
        zinssummeBerechnen(date);
        if(kontostand - betrag >-dispo){
            kontostand -= betrag;
            getKontobewegungList().add(new Kontobewegung(-betrag,date,this,"Auszahlung"));
        }else {
            System.out.println("Kreditlimit von Konto " + getKtoNummer()+ " Überzogen. Buchung über - " +
                    betrag + " Euro vom " + date.getDayOfMonth() + " . " + date.getMonth() +
                    ". " + date.getYear() + "  wurde nicht ausgeführt");
        }
    }
    public void berechneZinsen(LocalDate date) {
        zinssummeBerechnen(date);
        Kontobewegung kontobewegung = new Kontobewegung(zinssumme,date,this,"Zinsen");
        getKontobewegungList().add(kontobewegung);
        kontostand += zinssumme;
        zinssumme = 0;
    }
    @Override
    public void zinssummeBerechnen(LocalDate date) {
        if (kontobewegungList.size() > 1) {
            if (kontostand > 0) {
                String s = f.format(kontostand * habenzins / 100 * rechneTage(getKontobewegungList().get(getKontobewegungList().size() - 1).getDatum(), date) / 365);
                s = s.replace(',', ',');
                zinssumme = zinssumme + Double.valueOf(s);
            } else {
                String s = f.format(kontostand * habenzins / 100 * rechneTage(getKontobewegungList().get(getKontobewegungList().size() - 1).getDatum(), date) / 365);
                s = s.replace(',', ',');
                zinssumme = zinssumme + Double.valueOf(s);
            }
        }
    }
    public long rechneTage(LocalDate start, LocalDate ende){
        long i = ChronoUnit.DAYS.between(start,ende);
        return i;
    }



}




