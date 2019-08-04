package zajecie_2_generiki.zad_3_listaPowiazana;

public class MyLinkedList<T> {
    private MyNode<T> head = null;

    public MyLinkedList(MyNode<T> head) {
        this.head = head;
    }

    public MyLinkedList() {
    }

    public MyNode<T> getHead() {
        return head;
    }

    public void dodajNowyjElementDoListy(T vaues) {
        MyNode<T> newNode = new MyNode<>(vaues);
        if (this.head == null) {
            this.head = newNode;
        } else {
            MyNode<T> candidateLast = this.head;
            while (candidateLast.next != null) {
                candidateLast = candidateLast.getNext();
            }
            candidateLast.setNext(newNode);
        }
    }

    public T odczytajPierwszy() {
        return head.data;
    }

    public T odczytajDowolny(int indeks) {
        int licznik = 1;
        MyNode<T> candidate = head;
        while (licznik < indeks) {
            candidate = candidate.getNext();
            licznik++;
        }
        return candidate.getData();
    }


    public void dodajZPrzodu(T value) {
        MyNode<T> newNode = new MyNode<>(value);
        MyNode<T> staryHead = head;
        head = newNode;
        head.setNext(staryHead);
    }

    public void usunElement(int indeks) {
        int licznik = 1;
        MyNode<T> candidate = head;
        while (licznik + 1 < indeks) {
            candidate = candidate.getNext();
            licznik++;
        }
        candidate.setNext(candidate.getNext().getNext());
    }

    public void wstawWSrodek(T value, int indeks) {
        MyNode<T> newNode = new MyNode<>(value);
        int licznik = 1;
        MyNode<T> candidate = head;
        while (licznik < indeks) {
            candidate = candidate.getNext();
            licznik++;
        }
        MyNode<T> nastepnyPo = candidate.getNext();
        candidate.setNext(newNode);
        newNode.setNext(nastepnyPo);
    }


    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}





