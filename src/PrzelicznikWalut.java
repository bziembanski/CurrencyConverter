import Controler.Converter;
import Controler.XmlSaxFetcher;
import Model.CurrencyContener;

public class PrzelicznikWalut {
    public static void main(String[] args) {
        XmlSaxFetcher fetcher = new XmlSaxFetcher();
        CurrencyContener contener = fetcher.getData("lasta.xml");
        Converter converter = new Converter(contener);
        System.out.println(converter.convert("USD", "AUD", 1.0));

    }
}
