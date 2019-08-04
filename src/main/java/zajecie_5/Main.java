package zajecie_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    private static Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        File scziezka = new File("quiz");
        graQUIZ(scziezka);
    }

    private static void graQUIZ(File plik) throws IOException, InterruptedException {
        System.out.println("Witamy w grze QUIZ. Gra jest napisana przez Junior Developer Andrzej Rubets.");
        Wyniki wyniki = new Wyniki();
        wyniki.zoladowaajTop10();
        do {
            System.out.println("\nWybierz:\n1) -> Zagrac w QIUZ\n2) -> Zobaczyc TOP-10 wynikow\n\n0) -> Wyjsc z aplikacji");
            String linia = scaner.nextLine();
            Integer odpowiedz = mojParse(linia);
            if (odpowiedz == null) {
            } else if (odpowiedz == 1) {
                Grac grac = trescGry(plik);
                wyniki.dodacGracza(grac);
            } else if (odpowiedz == 2) {
                System.out.println("TOP-10 grzeczej z najwieksza ilosciu punktow:");
                wyniki.wyswietlTop10();
            } else if (odpowiedz == 0) {
                wyniki.zachowajTop10();
                break;
            }
        } while (true);
    }

    private static Grac trescGry(File plik) throws FileNotFoundException, InterruptedException {

        System.out.println("Wpisz swoje imie/nick");
        String imieGracza = scaner.nextLine().trim();
        TreeMap<String, List<ZadanieQuiz>> katalogKategorii = ladowanieBazyKategorii(plik);
        List<ZadanieQuiz> listaZadanZWybranejKategorii = ladowanieWybrenejKategorii(katalogKategorii);
        Collections.shuffle(listaZadanZWybranejKategorii);
        System.out.println("Masz 10 pytan z wybranej kategorii. Na kazde z pytan masz 10 sekund aby odpowiedz. Powodzenia! Naciśnij ENTER aby zaczac gre.");
        scaner.nextLine();
        int punkty = 0;
        for (int i = 0; i < 10; i++) {
            ZadanieQuiz zadanieZWybrenejKategorii = listaZadanZWybranejKategorii.get(i);
            System.out.println(zadanieZWybrenejKategorii.pytanie);
            List<String> odpowiedziLosowe = new ArrayList<>(zadanieZWybrenejKategorii.odpowiedzi);
            System.out.println("Wybierz jedna i napisz numer twojej odpowiedzi (1-" + odpowiedziLosowe.size() + "). Pamietaj, na odpowiedz 10 secund!");
            String prawidlowaOdpowiedz = odpowiedziLosowe.get(0);
            Collections.shuffle(odpowiedziLosowe);
            Integer numerOdpowiedzi;
            for (int j = 0; j < odpowiedziLosowe.size(); j++) {
                System.out.println(" " + (j + 1) + ") " + odpowiedziLosowe.get(j));
            }

            ConsoleInput con = new ConsoleInput(
                    10,
                    TimeUnit.SECONDS
            );
            numerOdpowiedzi = con.readLine();

            if (numerOdpowiedzi == null) {
                System.out.println("Nie wpisałes odpowiedz za wyznaczony czas!");
            } else if (numerOdpowiedzi == -1 || numerOdpowiedzi < 1 || numerOdpowiedzi > odpowiedziLosowe.size()) {
                System.out.println("BŁĄD! Twoja odpowiedz musi byc numerem z zaproponowycnych odpowiedziej!");
            } else if (odpowiedziLosowe.get(numerOdpowiedzi - 1).equals(prawidlowaOdpowiedz)) {
                System.out.println("Twoja odpowiedz prawidlowa. +1 punkt!");
                punkty++;
            } else {
                System.out.println("Podales nie prawidlowa odpowiedz.");
            }
            System.out.println("Masz " + punkty + "/10 punktow.\n");
        }
        System.out.println("KONIEC GRY! Zdobyles " + punkty + "/10 punktow!");

        return new Grac(imieGracza, punkty);
    }

    private static List<ZadanieQuiz> ladowanieWybrenejKategorii(TreeMap<String, List<ZadanieQuiz>> katalogKategorii) {
        Integer numerKategorii;
        List<String> kategorie = new ArrayList<>(katalogKategorii.keySet());
        do {
            System.out.println("Wybierz jedna z kategorii: ");
            for (int j = 0; j < kategorie.size(); j++) {
                System.out.println("  " + (j + 1) + ") > " + kategorie.get(j));
            }
            numerKategorii = mojParse(scaner.nextLine());
        } while (numerKategorii == null || numerKategorii < 1 || numerKategorii > katalogKategorii.size());
        String wybranaKategoria = kategorie.get((numerKategorii) - 1);
        return katalogKategorii.get(wybranaKategoria);
    }

    private static Integer mojParse(String odpowiedz) {
        int liczba;
        try {
            liczba = Integer.valueOf(odpowiedz);
            return liczba;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static TreeMap<String, List<ZadanieQuiz>> ladowanieBazyKategorii(File sciezka) throws FileNotFoundException {
        File[] pliki = sciezka.listFiles();

        // Map<NAZWA KATEGORII, LISTA ZADAN QUIZOWYCH>
        TreeMap<String, List<ZadanieQuiz>> pytaniaWKategoriach = new TreeMap<>();
        List<ZadanieQuiz> pytaniaWszystkichKategori = new ArrayList<>();
        if (pliki != null) {
            for (File p : pliki) {
                String kategorija = p.getName().replace(".txt", "");
                pytaniaWKategoriach.put(kategorija, odczytaniePliku(p));
                pytaniaWszystkichKategori.addAll(pytaniaWKategoriach.get(kategorija));
            }
            pytaniaWKategoriach.put("WSZYSTKIE KATOGORIE", pytaniaWszystkichKategori);
        }
        return pytaniaWKategoriach;
    }


    private static List<ZadanieQuiz> odczytaniePliku(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<ZadanieQuiz> zadania = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String pytanie = scanner.nextLine();
            int iloscOdpowiedzi = Integer.parseInt(scanner.nextLine());
            List<String> odpowiedzi = new ArrayList<>();
            for (int i = 0; i < iloscOdpowiedzi; i++) {
                String odpowiedz = scanner.nextLine();
                odpowiedzi.add(odpowiedz);
            }
            zadania.add(new ZadanieQuiz(pytanie, odpowiedzi));
        }
        return zadania;
    }
}