package zajecie_2_generiki.zad_1;

public class Main {
    public static void main(String[] args) {
//        String string="hello";
//        Integer integer=1;
//        Pudelko<String, Integer> pudelko=new Pudelko<String, Integer>(string,integer);

        Pudelko<Trampek, Glan> trampekGlanPudelko = new Pudelko<>(new Trampek(), new Glan());


    }
}

