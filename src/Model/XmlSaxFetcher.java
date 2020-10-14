package Model;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class XmlSaxFetcher implements Fetcher{

    private final String path;
    private final String url;
    public XmlSaxFetcher(String url, String path){
        this.url=url;
        this.path=path;
    }

    @Override
    public CurrencyContener getData() {
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SaxHandler handler = new SaxHandler();
            saxParser.parse(new File(path), handler);

            return handler.getCurrencyContener();

        }
        catch (ParserConfigurationException | SAXException | IOException e){
            System.out.print("File read error: " + e.toString());
            return null;
        }

    }

    @Override
    public String getFile() {
        try{
            InputStream inputStream = new URL(url).openStream();
            Files.copy(inputStream, Paths.get("src/lasta.xml"), StandardCopyOption.REPLACE_EXISTING);
            return "";
        }
        catch(Exception e){
            return "Problem z pobraniem danych: " + e.getMessage();
        }


    }
}
