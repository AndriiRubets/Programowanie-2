package zajecie_4_watki.zad_2_koty;

import com.google.gson.Gson;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackAttachment;
import net.gpedro.integrations.slack.SlackMessage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) throws IOException {
        URL website = new URL("https://aws.random.cat/meow");


        for (int i = 0; i < 1; i++) {

            URLConnection connection = website.openConnection();
            connection.addRequestProperty("User-Agent", "Chrome");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));
            String inputLine = in.readLine();
            Gson gson = new Gson();
            ZdjecieKota zdjecieKota = gson.fromJson(inputLine, ZdjecieKota.class);

            InputStream inputStream = new URL(zdjecieKota.file).openStream();
            int lengthFile = zdjecieKota.file.length();

            File file = new File("/Users/ar/kot_" + i + "." + zdjecieKota.file.substring(lengthFile - 3));
            Files.copy(inputStream, Paths.get(String.valueOf(file)), StandardCopyOption.REPLACE_EXISTING);


            SlackApi api = new SlackApi("https://hooks.slack.com/services/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");

            SlackMessage slackMessage = new SlackMessage("koty");
            SlackAttachment slackAttachment = new SlackAttachment();
            slackAttachment.setImageUrl(zdjecieKota.file);
            slackAttachment.setFallback("Obrazek kota");

            slackMessage.addAttachments(slackAttachment);
            api.call(slackMessage);


            BufferedImage bImage = null;
            bImage = ImageIO.read(file);
            System.out.println("rozdzielczosc zdjecia: " + bImage.getHeight() + "x" + bImage.getWidth());
            System.out.println("Rozmier pliku " + file.length() / 1024 + " kb");


//            float[] blurKernel = { 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f, 1 / 9f };
//            BufferedImageOp blur = new ConvolveOp(new Kernel(3, 3, blurKernel));
//            bImage = blur.filter(bImage, null);

        }


    }
}
