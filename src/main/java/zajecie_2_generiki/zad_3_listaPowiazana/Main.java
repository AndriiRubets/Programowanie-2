package zajecie_2_generiki.zad_3_listaPowiazana;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList=new MyLinkedList<>();

        myLinkedList.dodajNowyjElementDoListy("D");
        myLinkedList.dodajNowyjElementDoListy("U");
        myLinkedList.dodajNowyjElementDoListy("P");
        myLinkedList.dodajNowyjElementDoListy("A");
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.odczytajPierwszy());
        System.out.println(myLinkedList.odczytajDowolny(2));
        System.out.println(myLinkedList.odczytajDowolny(3));
        System.out.println(myLinkedList.odczytajDowolny(4));
        myLinkedList.dodajZPrzodu("A");
        System.out.println(myLinkedList);
        myLinkedList.usunElement(2);
        System.out.println(myLinkedList);
        myLinkedList.wstawWSrodek("Q",2);
        System.out.println(myLinkedList);
    }
}
