import java.time.LocalDateTime;

public class Kontobewegung {
    private Double betrag;
    private LocalDateTime datum;
    private Konto myKonto;

    public Kontobewegung(Double betrag, LocalDateTime datum, Konto myKonto) {
        this.betrag = betrag;
        this.datum = datum;
        this.myKonto = myKonto;
    }

    public Double getBetrag() {
        return betrag;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public Konto getMyKonto() {
        return myKonto;
    }

    public void setBetrag(Double betrag) {
        this.betrag = betrag;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }
}
