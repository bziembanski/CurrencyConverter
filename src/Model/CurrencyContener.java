package Model;

import java.util.*;

public class CurrencyContener {
    private final HashMap<String, Currency> _contener;
    public CurrencyContener(HashMap<String, Currency> contener){
        _contener=contener;
    }

    public Currency getCurrency(String code){
        return _contener.get(code);
    }

    public List<AbstractMap.SimpleImmutableEntry<String,String>> getCurrencyList(){
        List<AbstractMap.SimpleImmutableEntry<String,String>> list = new ArrayList<>();
        for (Map.Entry<String, Currency> curr : _contener.entrySet()) {
            list.add(new AbstractMap.SimpleImmutableEntry<>(curr.getKey(), curr.getValue().getName()));
        }
        return list;
    }

    public HashMap<String, Currency> getContener(){
        return _contener;
    }
}
