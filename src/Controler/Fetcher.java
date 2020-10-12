package Controler;

import Model.Currency;
import Model.CurrencyContener;

import java.util.HashMap;

public interface Fetcher {
    CurrencyContener getData(String path);
}
