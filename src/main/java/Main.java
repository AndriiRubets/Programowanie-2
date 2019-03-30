import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

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


}

