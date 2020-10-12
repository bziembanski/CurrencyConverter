import java.util.*;

class CurrencyContener {
    private final HashMap<String, Currency> _contener;
    CurrencyContener(HashMap<String, Currency> contener){
        _contener=contener;
    }

    Currency getCurrency(String code){
        return _contener.get(code);
    }

    List<AbstractMap.SimpleImmutableEntry<String,String>> getCurrencyList(){
        List<AbstractMap.SimpleImmutableEntry<String,String>> list = new ArrayList<>();
        for (Map.Entry<String, Currency> curr : _contener.entrySet()) {
            list.add(new AbstractMap.SimpleImmutableEntry<>(curr.getKey(), curr.getValue().getName()));
        }
        return list;
    }

    HashMap<String, Currency> getContener(){
        return _contener;
    }
}
