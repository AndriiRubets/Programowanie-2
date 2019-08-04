package zajecie_5;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Wyniki {
    Map<String, Integer> listaWynikow = new HashMap<>();

    public void dodacGracza(Grac grac) {
        listaWynikow.put(grac.getImie(), grac.getIloscPunktow());
    }

    public Map<String, Integer> top10() {

        return listaWynikow.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public void wyswietlTop10() {
        System.out.println("IMIE/NICK   ILOSC PUNKTOW");
        top10().forEach((k, v) -> System.out.println(k + " - " + v));
    }

    public void zachowajTop10() {
        try {
            FileOutputStream fos =
                    new FileOutputStream("listaWynikow.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(top10());
            oos.close();
            fos.close();
            System.out.print("Lista wynikow zacjowana w  \"listaWynikow.txt\"");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Map<String, Integer> zoladowaajTop10() throws IOException {
        try {
            FileInputStream fis = new FileInputStream("listaWynikow.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaWynikow = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return listaWynikow;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return listaWynikow;
        }
        return listaWynikow;
    }
}
