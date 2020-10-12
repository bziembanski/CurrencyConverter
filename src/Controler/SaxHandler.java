package Controler;

import Model.Currency;
import Model.CurrencyContener;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;

public class SaxHandler extends DefaultHandler {
    private HashMap<String, Currency> currMap = null;
    private Currency currency = null;

    boolean bScaler = false, bCode = false, bRate = false, bName = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case "pozycja" -> {
                currency = new Currency();
                if (currMap == null)
                    currMap = new HashMap<>();
            }
            case "nazwa_waluty" -> bName = true;
            case "przelicznik" -> bScaler = true;
            case "kod_waluty" -> bCode = true;
            case "kurs_sredni" -> bRate = true;
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if(qName.equals("pozycja")){
            currMap.put(currency.getCode(), currency);}
    }

    public void characters(char[] ch, int start, int length) {
        if(bCode){
            currency.setCode(new String(ch,start,length));
            bCode=false;
        }
        if(bName){
            currency.setName(new String(ch,start,length));
            bName=false;
        }
        if(bScaler){
            String scaler = new String(ch,start,length);
            scaler = scaler.replace(',','.');
            currency.setScaler(Integer.parseInt(scaler));
            bScaler=false;
        }
        if(bRate){
            String rate = new String(ch,start,length);
            rate = rate.replace(',','.');
            currency.setRate(Double.parseDouble(rate));
            bRate=false;
        }

    }

    public CurrencyContener getCurrencyContener(){
        return new CurrencyContener(currMap);
    }
}

