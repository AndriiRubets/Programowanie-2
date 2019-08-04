package zajecie_4_watki.zad_1_wyliczenie_pola_funkcji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        double przedzialPoczatkowy = 0.0;
        double przedzialKoncowy = 15.0;
        double iloscProstokantow = 1_500_000.0;

        double startTime = System.currentTimeMillis();
        System.out.println(getSumePola(przedzialPoczatkowy, przedzialKoncowy, iloscProstokantow));
        double runTime = System.currentTimeMillis() - startTime;
        System.out.println("Wyliczenie trwa: " + runTime + " milisec");
        System.out.println();

        double startTime2 = System.currentTimeMillis();
        System.out.println(sumaPolProstakantowPrzezWatki(przedzialPoczatkowy, przedzialKoncowy, iloscProstokantow, 10));
        double runTime2 = System.currentTimeMillis() - startTime;
        System.out.println("Wyliczenie na wielu watkow trwa: " + runTime2 + " milisec");
        System.out.println();
    }


    private static double getSumePola(double przedzialPoczatkowy, double przedzialKoncowy, double iloscProstokatow) {
        System.out.println("Wyliczenie pola dla xPoczatkowe - "+przedzialPoczatkowy+" i xKoncowe - "+przedzialKoncowy);
        double sumaPola = 0;
        double krokDlaProstokonta = (przedzialKoncowy - przedzialPoczatkowy) / iloscProstokatow;
        for (double i = przedzialPoczatkowy; i <= przedzialKoncowy; i += krokDlaProstokonta) {
            double sumaProstokata = function(i + (krokDlaProstokonta / 2)) * krokDlaProstokonta;
            sumaPola += Math.abs(sumaProstokata);
        }

        return sumaPola;
    }

    private static double function(double x) {
        return (3 * Math.sin(x)) - (0.2 * Math.pow(x, 3)) + (3 * Math.pow(x, 2));
    }

    private static double sumaPolProstakantowPrzezWatki(double przedzialPoczatkowy, double przedzialKoncowy, double iloscProstokatow, int watkow) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(watkow);

        double przedzialWatku = (przedzialKoncowy - przedzialPoczatkowy) / watkow;

        final double[] sum={0.0};
        for (int i = 0; i < watkow; i++) {
            final double poczatek = przedzialPoczatkowy + i * przedzialWatku;
            final double koniec = poczatek + przedzialWatku;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {

                    double sumaPolaWantka=getSumePola(poczatek,koniec,iloscProstokatow/watkow);
                    sum[0]+=sumaPolaWantka;
//                    long longSuma = (long) getSumePola((int) poczatek, (int) koniec, iloscProstokatow / watkow);
//                    sumaPola.addAndGet(longSuma);

//                    for (long i = przedzialPoczatkowy; i <= przedzialWatku; i += krokDlaProstokonta) {
//                        double sumaProstokata = function(i - (krokDlaProstokonta / 2)) * krokDlaProstokonta;
//                        Long.parseLong(String.valueOf(sumaProstokata));
//                        sumaPola.incrementAndGet();
//                    }
                }
            });

        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
        return sum[0];
    }
}
