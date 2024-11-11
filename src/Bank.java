import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static String blz;
    private static String institutname;
    public static List<Kunde> myKunden = new ArrayList<>();
   public static List<Konto> myKonten = new ArrayList<>();

    public Bank(String blz, String institutname, List<Kunde> myKunden, List<Konto> myKonten) {
        this.blz = blz;
        this.institutname = institutname;
        this.myKunden = myKunden;
        this.myKonten = myKonten;
    }
    public  static void eröffneSparkonto(String kontonummer, double kontostand,double habenzins, Kunde myKunde, LocalDate date, char art){
        Sparkonto sparkonto = new Sparkonto(kontonummer,kontostand, Konto.habenzins,myKunde,art,date);
        myKunde.getMyKonten().add(sparkonto);
    }
    public static void eröffneGirokonto(String kontonummer, double kontostand, double habenzins, Kunde myKunde, double sollzins, double dispo, LocalDate date){
       Girokonto girokonto = new Girokonto(kontonummer,habenzins,myKunde,sollzins,dispo,kontostand,date);
       myKunde.getMyKonten().add(girokonto);
    }


    public static void druckeAlleKonten(){
        for (Konto konto : myKonten){
            System.out.println("Kontoauszug");
            System.out.println("kto-NR.:" + konto.getKtoNummer()
            + "BLZ: :" + blz + " , " + institutname + " ");
            System.out.printf(" Kontostand: %.2f Euro\n", konto.getKontostand());
            System.out.println(" Kontoinhaber: " + konto.getMyKunde().getName());

            int bewegungsnummer = 1;

            for (Kontobewegung kontobewegung : konto.getMyBew()){
                System.out.printf(bewegungsnummer + " " +
                        kontobewegung.getDatum().format(DateTimeFormatter.ofPattern("dd.MMM.yyyy")) + " " +
                        String.format("%.2f Euro ", kontobewegung.getBetrag()));

                if (kontobewegung.getBetrag()>0){
                    System.out.println("Einzahlung");
                } else if(kontobewegung.getBetrag()<0){
                    System.out.println("Auszahung");
                } else {
                    System.out.println("Zinsbuchung");
                }
                bewegungsnummer++;
            }

        }

    }
    public static void druckeAlleKunden(){
        for(Kunde kunde: myKunden){
            System.out.println("Kontoinhaber: " + kunde.getName());
            for (Konto konto  : kunde.getMyKonten()){
                System.out.println(" kto-nr.: " + konto.getKtoNummer()
                    + " BLZ: " + blz + " " + institutname
                    + " kontostand: " + konto.getKontostand() + " Euro");
            }

        }


    }
}