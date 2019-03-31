package zajecie_1.Zadanie_domowe;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {

    private static final String SCIEZKA_DO_POBRANIA_URL_KURS_WALUT_MIESAC_TEMU = "http://api.nbp.pl/api/exchangerates/tables/c/2019-03-01/";
    private static final String SCIEZKA_DO_POBRANIA_URL_KURS_WALUT_DZISIAJ = "http://api.nbp.pl/api/exchangerates/tables/c/";
    private static final Gson GSON = new Gson();

    public static void main(String[] args) throws IOException {

        kwotyWalutZa100PLN(SCIEZKA_DO_POBRANIA_URL_KURS_WALUT_DZISIAJ);
        System.out.println();
        kwotyWalutZa100PLN(SCIEZKA_DO_POBRANIA_URL_KURS_WALUT_MIESAC_TEMU);
        System.out.println();
        porownanieKorzysciWymianyDzisiajIMiesiacTemu(Waluty.GBP);
        porownanieKorzysciWymianyDzisiajIMiesiacTemu(Waluty.EUR);
        porownanieKorzysciWymianyDzisiajIMiesiacTemu(Waluty.CHF);
        porownanieKorzysciWymianyDzisiajIMiesiacTemu(Waluty.USD);


    }

    private static void porownanieKorzysciWymianyDzisiajIMiesiacTemu(Waluty waluty) throws IOException {
        Rates[] kursyWalutDzisiaj = getCorency(SCIEZKA_DO_POBRANIA_URL_KURS_WALUT_DZISIAJ)[0].rates;
        Rates[] kursyWalutMiesiacTemu = getCorency(SCIEZKA_DO_POBRANIA_URL_KURS_WALUT_MIESAC_TEMU)[0].rates;


        double kursWalutyDzisiaj = 0;
        for (Rates rate : kursyWalutDzisiaj) {
            if (rate.code.equalsIgnoreCase(String.valueOf(waluty))) {
                kursWalutyDzisiaj = rate.ask;
            }
        }
        double  kursWalutyMiesiacTemu= 0;
        for (Rates rate : kursyWalutMiesiacTemu)
            if (rate.code.equalsIgnoreCase(String.valueOf(waluty))) {
                kursWalutyMiesiacTemu = rate.ask;
            }



        double roznica = 100 / kursWalutyDzisiaj - 100 / kursWalutyMiesiacTemu;
        if (roznica < 0) {
            System.out.println("Miesąc temu zarobilismy by na zakupie " + waluty + " za 100 PLN " + String.format("%.2f", Math.abs(roznica)) + " " + waluty);
        } else if (roznica > 0) {
            System.out.println("Miesąc temu ztracilismy by na zakupie " + waluty + " za 100 PLN " + String.format("%.2f", Math.abs(roznica)) + " " + waluty);
        } else {
            System.out.println("Taką samą kwotę kupilismy by!");
        }

    }


    private static void kwotyWalutZa100PLN(String sciezka) throws IOException {
        Rates[] kursWalut = getCorency(sciezka)[0].rates;
        for (Rates rate : kursWalut) {
            for (Waluty s : Waluty.values()) {
                if (rate.code.equalsIgnoreCase(String.valueOf(s))) {
                    double sprzedazWaluty = 100 / rate.ask;
                    System.out.println("Na dzień " + getCorency(sciezka)[0].tradingDate
                            + " za 100 PLN mozesz kupic "
                            + String.format("%.2f", sprzedazWaluty)
                            + " "
                            + s
                            + " za kursem sprzedazy zgodnie z NBP - "
                            + rate.ask);
                }
            }

        }
    }


    private static Bank[] getCorency(String sciezka) throws IOException {
        URL website = new URL(sciezka);
        URLConnection connection = website.openConnection();
        connection.addRequestProperty("User-Agent", "Chrome");
        InputStream is = connection.getInputStream();
        try (Scanner scanner = new Scanner(is)) {
            String line = scanner.nextLine();
//            System.out.println(line);
            return GSON.fromJson(line, Bank[].class);
        }
    }
}
