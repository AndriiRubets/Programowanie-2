package zajecie_2_generiki.zad_3_listaPowiazana;

public class MyNode<T> {
    T data;
    MyNode<T> next;

    public MyNode(T data) {
        this.data = data;
        this.next = null;

    }

    public T getData() {
        return data;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
