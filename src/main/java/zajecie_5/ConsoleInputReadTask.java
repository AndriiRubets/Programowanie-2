package zajecie_5;

import java.io.*;
import java.util.concurrent.Callable;

public class ConsoleInputReadTask implements Callable<Integer> {
    public Integer call() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        Integer input = 0;
        do {
            try {
                while (!br.ready()  /*  ADD SHUTDOWN CHECK HERE */) {
                    Thread.sleep(200);
                }
                input = Integer.valueOf(br.readLine());
            } catch (InterruptedException e) {
                return null;
            } catch (NumberFormatException e) {
                System.out.println();
                return -1;
            }
        } while (0 == input);
        return input;
    }
}