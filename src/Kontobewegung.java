import java.time.LocalDate;
import java.time.LocalDateTime;

public class Kontobewegung {

    private double betrag;
    private  LocalDate datum;
    private Konto myKonto;
    String buchungstext;
    private String text;
    public Kontobewegung(double betrag, LocalDate datum, Konto myKonto,String buchungstext) {
        this.betrag = betrag;
        this.datum = datum;
        this.myKonto = myKonto;
        this.buchungstext= buchungstext;
    }

    public String getText() {
        return text;
    }

    public double getBetrag() {
        return betrag;
    }

    public LocalDate getDatum() {
        return datum;
    }
}
