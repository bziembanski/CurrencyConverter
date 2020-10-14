package Model;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SaxHandler extends DefaultHandler {
    private ArrayList<Currency> currList = null;
    private String code, name;
    private Double rate;
    private Integer scaler;

    boolean bScaler = false, bCode = false, bRate = false, bName = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case "pozycja" -> {
                if (currList == null)
                    currList = new ArrayList<>();
            }
            case "nazwa_waluty" -> bName = true;
            case "przelicznik" -> bScaler = true;
            case "kod_waluty" -> bCode = true;
            case "kurs_sredni" -> bRate = true;
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if(qName.equals("pozycja")){
            currList.add(new Currency(scaler, rate, code, name));}
    }

    public void characters(char[] ch, int start, int length) {
        if(bCode){
            code = new String(ch,start,length);
            bCode=false;
        }
        if(bName){
            name = new String(ch,start,length);
            bName=false;
        }
        if(bScaler){
            String tmp = new String(ch,start,length);
            tmp = tmp.replace(',','.');
            scaler = Integer.parseInt(tmp);
            bScaler=false;
        }
        if(bRate){
            String tmp = new String(ch,start,length);
            tmp = tmp.replace(',','.');
            rate = Double.parseDouble(tmp);
            bRate=false;
        }

    }

    public CurrencyContener getCurrencyContener(){
        Currency pln = new Currency(1, 1.0, "PLN", "złoty polski");
        currList.add(0,pln);
        return new CurrencyContener(currList);
    }
}

