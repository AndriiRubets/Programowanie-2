import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().trim();
        System.out.println("Wejście: " + text);
        int licznik = 0;
        StringBuilder wynik = new StringBuilder();
        String[] tablicaPoSplicie = text.split(" ");
        for (String s : tablicaPoSplicie) {
            String[] literySlowa = s.split("");
            wynik.append(literySlowa[0].toUpperCase());
            wynik.append(s.substring(1));
            licznik += s.length();
        }
        System.out.println("Wyjscie: " + wynik);
        System.out.println("Ilosc znakow: " + licznik);
        System.out.println("Ilosc SMS: " + Math.ceil(licznik / 160.0));
    }

    private static String skracaczSMS(String text) {
        String[] tablicaPoSplicie = text.split(" ");
        StringBuilder wynik = new StringBuilder();
        for (String s : tablicaPoSplicie) {
            if (s.isEmpty()) {
                continue;
            }
            char pierwszaLitera = s.charAt(0);
            pierwszaLitera = Character.toUpperCase(pierwszaLitera);
            String noweSlowo = pierwszaLitera + s.substring(1);
            wynik.append(noweSlowo);
        }
        return wynik.toString();
    }
    private static int kosztSMS(String text){
        int ileZnakow = text.length();
        if (ileZnakow <=160) {
            return 1;
        }else {
            return ((ileZnakow-1)/153)+1;
        }
    }
}

