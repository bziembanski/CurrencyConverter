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

    Double convert(String from, String to, Double value){
        if(from.equals("PLN"))
            return plnToOther(currencyContener.getCurrency(to), value);
        else if(to.equals("PLN"))
            return otherToPln(currencyContener.getCurrency(from), value);
        else
            return otherToOther(currencyContener.getCurrency(from), currencyContener.getCurrency(to), value);
    }
}
