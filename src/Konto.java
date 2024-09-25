import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konto {
    private String kontonummer;
    private Double Kontostand;
    private String habenzins;
    private Kunde myKunde;
    private Bank bank;
    private ArrayList<Kontobewegung> myBew = new ArrayList<>();

    public Konto(String kontonummer, Double kontostand, String habenzins, Kunde myKunde, ArrayList<Kontobewegung> myBew, Bank bank) {
        this.kontonummer = kontonummer;
        this.Kontostand = kontostand;
        this.habenzins = habenzins;
        this.myKunde = myKunde;
        this.myBew = myBew;
        this.bank = bank;
    }

    public void einzahlen(double betrag) {
        this.Kontostand += betrag;
        myBew.add(new Kontobewegung(betrag, LocalDateTime.now(), this));
        System.out.println("Einzahlung von " + betrag + " auf das Konto " + this.kontonummer + " erfolgreich.");
    }

    public void eröffnen(String kundenName, String adresse, String kontonummer, double startEinzahlung, String habenzins, String kundennummer) {
        ArrayList<Kunde> kundenListe = bank.getMyKunden();

        Kunde vorhandenerKunde = null;
        for (Kunde kunde : kundenListe) {
            if (kunde.getName().equals(kundenName)) {
                vorhandenerKunde = kunde;
                break;
            }
        }

        if (vorhandenerKunde == null) {
            ArrayList<Konto> kontenListe = new ArrayList<>();
            vorhandenerKunde = new Kunde(kundennummer, kundenName, adresse, LocalDateTime.now(), kontenListe);
            kundenListe.add(vorhandenerKunde);
            System.out.println("Neuer kunde hinzugefügt: " + kundenName);
        }

        ArrayList<Kontobewegung> kontobewegungen = new ArrayList<>();
        Konto neuesKonto = new Konto(kontonummer, 0.0, habenzins, vorhandenerKunde, kontobewegungen, bank);
        neuesKonto.einzahlen(startEinzahlung);
        vorhandenerKunde.getMyKonten().add(neuesKonto);
        bank.getMyKonten().add(neuesKonto);
        System.out.println("Neues Konto hinzugefügt:  Vom User:" + kundenName);

    }

    public String getKontonummer() {
        return kontonummer;
    }

    public Double getKontostand() {
        return Kontostand;
    }

    public String getHabenzins() {
        return habenzins;
    }

    public Kunde getMyKunde() {
        return myKunde;
    }

    public ArrayList<Kontobewegung> getMyBew() {
        return myBew;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
