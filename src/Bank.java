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

    public void druckeAlleKunde() {
        for (Kunde kunden : myKunden) {
            System.out.println("Kontoinhaber: " + kunden.getName()
                    + " KTO-Nr.: " + kunden.getMyKonten().
                    + " BLZ: " + blz + " , " + institutname
                    + " Kontostand: " + kunden.getMyKonten().
        }

    }

    public void druckeAlleKonten() {
        for (Konto konten : myKonten) {
            System.out.println("Kontoauszug " +
                    " KTO-NR.: " + konten.getKontonummer()
                    + " BLZ: " + blz + " , " + institutname
                    + " Kontostand: " + konten.getKontostand()
                    + "Kontoinhaber: " + konten.getMyKunde());

            for (int i = 0; i <konten.getMyBew().size(); i++) {
                System.out.println(i + "," + konten.getMyBew().
            }
        }
    }
}
