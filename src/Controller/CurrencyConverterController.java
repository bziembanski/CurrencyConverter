package Controller;

import Model.Converter;
import Model.CurrencyContener;
import Model.Fetcher;
import Model.XmlSaxFetcher;
import View.CurrencyConverterView;

public class CurrencyConverterController {
    public final CurrencyConverterView view;
    public final CurrencyContener model;
    private final Converter converter;
    private final String url = "https://www.nbp.pl/kursy/xml/lasta.xml";
    private final String path = "src/lasta.xml";

    public CurrencyConverterController(CurrencyConverterView view){
        this.view = view;
        Fetcher fetcher = new XmlSaxFetcher(this.url, this.path);
        String fetchResult = fetcher.getFile();
        this.view.setErrorMessage(fetchResult);
        this.model = fetcher.getData();
        this.converter = new Converter(this.model);

        this.view.addButtonConvertClickListener(e -> {
            double value;
            try{
                value = Double.parseDouble(view.getValue());
                String result = String.format("%.4f",converter.convert(view.getFromCurrency(),
                        view.getToCurrency(), value)).replaceAll(",",".");
                view.setTextFieldToText(result);
                view.setErrorMessage("");
            }
            catch(Exception exception){
                view.setErrorMessage("Upewnij się czy poprawnie wpisałeś liczbę!");
            }

        });
        this.view.addButtonSwapClickListener(e -> {
            int from = view.getFromCurrency();
            int to = view.getToCurrency();
            view.setFromCurrency(to);
            view.setToCurrency(from);
        });

        this.view.populateComboBox(model.getCurrencyList());
    }


}
