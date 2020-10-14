package Model;

import java.util.*;

public class CurrencyContener {
    private final ArrayList<Currency> _contener;
    public CurrencyContener(ArrayList<Currency> contener){
        _contener=contener;
    }

    public Currency getCurrency(int index){
        return _contener.get(index);
    }

    public ArrayList<String> getCurrencyList(){
        ArrayList<String> list = new ArrayList<>();
        for (Currency curr : _contener) {
            list.add(curr.getName());
        }
        return list;
    }

}
