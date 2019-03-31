package zajecie_1;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;

import java.io.*;
import java.util.Locale;

public class Main_zadLanguage {
    public static void main(String[] args) {
        DetectLanguage.apiKey = "6e99fd9280e7caf475224358e0dcf0b1";

        File dir = new File("pliki");
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

                    String linia;
                    StringBuilder calyTekstZPliku = new StringBuilder();
                    while ((linia = bufferedReader.readLine()) != null) {
                        calyTekstZPliku.append(linia);
                    }
                    String detectString = DetectLanguage.simpleDetect(calyTekstZPliku.toString());
                    System.out.println("Jezyk pliku " + f.getName() + " - "
                            + new Locale(detectString).getDisplayLanguage() + "/"
                            + new Locale(detectString).getDisplayLanguage(Locale.forLanguageTag(detectString)) + "/"
                            + new Locale(detectString).getDisplayLanguage(Locale.ENGLISH));


                } catch (IOException | APIError e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
