package zajecie_3_watki.zad_1_Jas_Małgosia;

import java.util.concurrent.CountDownLatch;

public class Main {
    static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void main(String[] args) {
        Thread jas=new Thread(new Jas());
        Thread malgosia=new Thread(new Malgosia());

        jas.start();
        malgosia.start();


        try {
            jas.join();
            malgosia.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("koniec dnia");
    }
}
