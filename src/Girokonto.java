import java.util.ArrayList;

public class Girokonto extends Konto{
    private double sollzins;
    private double dispo;


    public Girokonto(String kontonummer, Double kontostand, String habenzins, Kunde myKunde, ArrayList<Kontobewegung> myBew,Bank bank) {
        super(kontonummer, kontostand, habenzins, myKunde, myBew,bank);
    }
}

