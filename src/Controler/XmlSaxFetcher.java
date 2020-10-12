package Controler;

import Model.Currency;
import Model.CurrencyContener;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class XmlSaxFetcher implements Fetcher{
    @Override
    public CurrencyContener getData(String path) {
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SaxHandler handler = new SaxHandler();
            saxParser.parse(new File("src/lasta.xml"), handler);

            return handler.getCurrencyContener();

        }
        catch (ParserConfigurationException | SAXException | IOException e){
            System.out.print("File read error: " + e.toString());
            return null;
        }

    }
}
