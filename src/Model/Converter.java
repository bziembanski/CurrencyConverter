package Model;

import Model.Currency;
import Model.CurrencyContener;

public class Converter {
    private final CurrencyContener currencyContener;

    public Converter(CurrencyContener currencyContener){
        this.currencyContener = currencyContener;
    }

    private Double otherToPln(Currency other, Double value){
        return value * other.getRate() / other.getScaler();
    }

    private Double plnToOther(Currency other, Double value){
        return value / other.getRate() * other.getScaler();
    }

    private Double otherToOther(Currency from, Currency to, Double value){
        return plnToOther(to, otherToPln(from, value));
    }

    public Double convert(int from, int to, Double value){
        if(from == 0)
            return plnToOther(currencyContener.getCurrency(to), value);
        else if(to == 0)
            return otherToPln(currencyContener.getCurrency(from), value);
        else
            return otherToOther(currencyContener.getCurrency(from), currencyContener.getCurrency(to), value);
    }
}
