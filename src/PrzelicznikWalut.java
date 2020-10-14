import Controller.CurrencyConverterController;
import View.CurrencyConverterView;

public class PrzelicznikWalut {
    public static void main(String[] args) {
        CurrencyConverterController controller = new CurrencyConverterController(new CurrencyConverterView());
    }
}
