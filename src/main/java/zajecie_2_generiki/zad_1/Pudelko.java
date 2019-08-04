package zajecie_2_generiki.zad_1;

public class Pudelko<T,K> {
    private T element1;
    private K element2;

    public Pudelko(T element1, K element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    public T getElement1() {
        return element1;
    }

    public K getElement2() {
        return element2;
    }
}
