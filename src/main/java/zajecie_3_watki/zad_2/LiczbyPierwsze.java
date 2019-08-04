package zajecie_3_watki.zad_2;

public class LiczbyPierwsze {

    public boolean czyLiczbaJestPierwsza(long liczbe) {
        if (liczbe <= 1) return false;

        for (long i = 2; i < liczbe; i++) {
            if (liczbe % i == 0) {
                return false;
            }
        }
        return true;
    }
}
