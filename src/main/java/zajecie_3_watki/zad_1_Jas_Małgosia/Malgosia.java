package zajecie_3_watki.zad_1_Jas_Małgosia;

public class Malgosia implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Malgosia zaczyna poranne bieganie");
            Thread.sleep(6000);
            System.out.println("Malgosia skonczyla poranne bieganie");

            System.out.println("Malgosia zaczyna przyjmowac prysznic");
            Thread.sleep(2000);
            System.out.println("Malgosia skonczyla przyjmowac prysznic");

            System.out.println("Malgosia zaczyna jesc sniadanie");
            Thread.sleep(1000);
            System.out.println("Malgosia skonczyla jesc sniadanie");

            System.out.println("Malgosia zaczyna ubierac sie");
            Thread.sleep(1000);
            System.out.println("Malgosia skonczyla ubierac sie");


            System.out.println("Malgosia zaczyna spotkanie z kolezanką");
            Thread.sleep(25000);
            System.out.println("Malgosia skonczyla spotkanie z kolezanką");


            Main.countDownLatch.countDown();


        } catch (InterruptedException e) {
            e.getMessage();
        }




    }
}
