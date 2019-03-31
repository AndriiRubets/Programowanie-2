package zajecie_1.Zadanie_domowe;

public class Rates  {
    public String currency,code;
    public double bid,ask;

    @Override
    public String toString() {
        return "Rates{" +
                "currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}


