import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Kunde kunde1 = new Kunde("1", "Paul Müller", "Münster", LocalDate.of(2023, 02, 10), "500600800", 0, 1.5, 7.5, 3000, ' ');
        Kunde kunde2= new Kunde("2","Liese Fleißg","Osnabrück",LocalDate.of(2020,05,02),"50060090",0,1.5,7.5,2000,' ');
        Bank.eröffneSparkonto("22222222",0,5,kunde2,LocalDate.of(2023,01,2),'p');
        kunde1.getMyKonten().get(0).abheben(8500,LocalDate.of(2023,02,11));
        kunde2.getMyKonten().get(0).abheben(50,LocalDate.of(2023,02,11));
        kunde2.getMyKonten().get(0).abheben(100.50,LocalDate.of(2023,2,11));
        kunde2.getMyKonten().get(1).einzahlen(2850,LocalDate.of(2023,2,11));
        kunde1.getMyKonten().get(0).berechneZinsen(LocalDate.of(2023,2,10));
        kunde2.getMyKonten().get(0).berechneZinsen(LocalDate.of(2024,2,11));
        kunde2.getMyKonten().get(1).berechneZinsen(LocalDate.of(2024,2,11));
        Bank.druckeAlleKonten();
        Bank.druckeAlleKunden();



    }
}
