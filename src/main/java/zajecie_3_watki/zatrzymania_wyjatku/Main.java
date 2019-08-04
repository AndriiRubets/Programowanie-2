package zajecie_3_watki.zatrzymania_wyjatku;

public class Main  {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable());
        t.start();
        System.out.println("Hello World!");
    }
}
