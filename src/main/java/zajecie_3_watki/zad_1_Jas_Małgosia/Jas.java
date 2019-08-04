package zajecie_3_watki.zad_1_Jas_Małgosia;

public class Jas implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Jas zaczyna gotowac sniadanie");
            Thread.sleep(5000);
            System.out.println("Jas skonczyl gotowac sniadanie");

            System.out.println("Jas zaczyna przyjmowac prysznic");
            Thread.sleep(3000);
            System.out.println("Jas skonczyl przyjmowac prysznic");

            System.out.println("Jas zaczyna ubierac sie");
            Thread.sleep(1000);
            System.out.println("Jas skonczyl ubierac sie");

            System.out.println("Jas idzie na zakupy");
            Thread.sleep(15000);
            System.out.println("Jas wrocil sie z zakupow");


            Main.countDownLatch.await();


            System.out.println("Jas zaczyna grac na konsoli");
            Thread.sleep(5000);
            System.out.println("Jas skonczyl grac na konsoli");


        } catch (InterruptedException e) {
            e.getMessage();
        }


    }
}
