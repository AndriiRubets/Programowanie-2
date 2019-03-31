package zajecie_1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

public class zad_ChukNoriss {
    public static void main(String[] args) throws IOException {
        URL website = new URL("https://api.chucknorris.io/jokes/random");
        Set<ZartOChukNorisie> zartyOChuckNorisie10 = new HashSet<>();
        int licznik=0;
        while (zartyOChuckNorisie10.size() < 10) {
            URLConnection connection = website.openConnection();
            connection.addRequestProperty("User-Agent", "Chrome");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            String inputLine = in.readLine();
            licznik++;
//            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = new Gson();
            ZartOChukNorisie zart = gson.fromJson(inputLine, ZartOChukNorisie.class);

            System.out.println();
            System.out.println(zart.value);

            zartyOChuckNorisie10.add(zart);
            in.close();

        }
        System.out.println(licznik);
    }
}
