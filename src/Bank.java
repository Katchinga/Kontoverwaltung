import java.util.ArrayList;

public class Bank {
    private String blz;
    private String institutname;
    private ArrayList<Konto> myKonten = new ArrayList<>();
    private ArrayList<Kunde> myKunden = new ArrayList<>();

    public Bank(String blz, String institutname) {
        this.blz = blz;
        this.institutname = institutname;
    }

    public static void main(String[] args) {
        Bank bank = new Bank("48169", "Sparkasse Geld");
        bank.AllesAusführen();
    }

    public void AllesAusführen() {
        // Konto eröffnen
        Konto neuesKonto = new Konto("1", 0.0, "0", null, new ArrayList<>(), this);
        neuesKonto.eröffnen("Jonas", "Am Entenbein 123", "1", 100.0, "0", "1");

        // Einzahlung vornehmen
        neuesKonto.einzahlen(50.0);

        // Alle Konten und Kunden ausgeben
        druckeAlleKonten();
        druckeAlleKunden();
    }

    public void druckeAlleKunden() {
        for (Kunde kunde : myKunden) {
            System.out.println("Kontoinhaber: " + kunde.getName());
            for (Konto konto : kunde.getMyKonten()) {
                System.out.println("     Kto-Nr.: " + konto.getKontonummer()
                        + ", BLZ: " + this.blz
                        + ", " + this.institutname
                        + ", Kontostand: " + konto.getKontostand() + " Euro");
            }
        }
    }


    public void druckeAlleKonten() {
        for (Konto konto : myKonten) {
            System.out.println("\nKontoauszug");
            System.out.println("     Kto-Nr.: " + konto.getKontonummer()
                    + ", BLZ: " + this.blz
                    + ", " + this.institutname
                    + ", Kontostand: " + konto.getKontostand() + " Euro");
            System.out.println("     Kontoinhaber: " + konto.getMyKunde().getName());

            int bewegungNummer = 1;
            for (Kontobewegung bewegung : konto.getMyBew()) {
                System.out.println(bewegungNummer + "   " + bewegung.getDatum().toString()
                        + "   " + bewegung.getBetrag() + " Euro");
                bewegungNummer++;
            }
        }
    }

    public ArrayList<Konto> getMyKonten() {
        return myKonten;
    }

    public ArrayList<Kunde> getMyKunden() {
        return myKunden;
    }
}
