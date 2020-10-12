import java.util.HashMap;

public interface Fetcher {
    HashMap<String, Currency> getData(String path);
}
