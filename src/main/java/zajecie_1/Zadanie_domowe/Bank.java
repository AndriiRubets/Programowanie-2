package zajecie_1.Zadanie_domowe;


import java.util.Arrays;

public class Bank {
    public String table, no, tradingDate, effectiveDate;
    public Rates[] rates;

    @Override
    public String toString() {
        return "Bank{" +
                "table='" + table + '\'' +
                ", no='" + no + '\'' +
                ", tradingDate='" + tradingDate + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", rates=" + Arrays.toString(rates) +
                '}';
    }
}
