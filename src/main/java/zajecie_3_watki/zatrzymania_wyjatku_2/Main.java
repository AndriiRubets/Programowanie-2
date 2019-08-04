package zajecie_3_watki.zatrzymania_wyjatku_2;

public class Main {
private static volatile boolean stopRequested=false;

    public static void main(String[] args) throws Exception {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (!stopRequested) {
                    i++;
                }
                System.out.println("Wartosc i = " + i);

            }
        });
        t.start();
        Thread.sleep(5000);
        stopRequested=true;
        System.out.println("To juz jest koniec");
    }

}

