import java.util.ArrayList;

public class Sparkonto extends Konto{
    private char art;

    public Sparkonto(String kontonummer, Double kontostand, String habenzins, Kunde myKunde, ArrayList<Kontobewegung> myBew, Bank bank) {
        super(kontonummer, kontostand, habenzins, myKunde, myBew, bank);
    }
}
