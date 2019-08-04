package zajecie_2_generiki.zad_1;

import java.util.ArrayList;
import java.util.List;

public class Szafa<T extends But,K extends But> {
    private List<Pudelko<T,K>> buty=new ArrayList<Pudelko<T,K>>();

    public void dodajPare(T but1, K but2){
        Pudelko<T,K> para =new Pudelko<T,K>(but1,but2);
    }


}
