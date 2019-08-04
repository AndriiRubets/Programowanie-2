package zajecie_3_watki.zad_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Zadanie implements Runnable{
    long liczba;

    public Zadanie(long liczba) {
        this.liczba = liczba;
    }

    @Override
    public void run() {
        if (czyLiczbaJestPierwsza(liczba)) {
            Main.licznikStaticLiczbPierwszych++;
            System.out.println("Sprawdzamy liczbe: "+liczba);
        }

    }
    static public boolean czyLiczbaJestPierwsza(long liczbe) {
        if (liczbe <= 1) return false;

        for (long i = 2; i < liczbe; i++) {
            if (liczbe % i == 0) {
                return false;
            }
        }
        return true;
    }
}
