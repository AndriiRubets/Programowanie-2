package zajecie_3_watki.zad_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    static int licznikStaticLiczbPierwszych = 0;


    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        File plik = new File("C:\\Users\\ar\\Downloads\\numbers.txt");
        if (!plik.exists()) {
            System.out.println("Ten plik nie istnieje");
        } else {
            try {
                Scanner scanner=new Scanner(plik);
                long licznikPierwszychLiczb = 0;
                long startTime = System.currentTimeMillis();
                while (scanner.hasNextLong()) {
                    long number=scanner.nextLong();

                    executor.submit(new Zadanie(number));
                }
                executor.shutdown();

                long runTime = System.currentTimeMillis() - startTime;
                System.out.println(runTime / 1000 + " secunds");
                System.out.println(licznikStaticLiczbPierwszych);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    static public boolean czyLiczbaJestPierwsza(long liczbe) {
//        if (liczbe <= 1) return false;
//
//        for (long i = 2; i < liczbe; i++) {
//            if (liczbe % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}