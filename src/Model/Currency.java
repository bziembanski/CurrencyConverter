package Model;

public class Currency {
    private final Integer scaler;
    private final Double rate;
    private final String code;
    private final String name;

    public Currency(Integer scaler, Double rate, String code, String name) {
        this.scaler = scaler;
        this.rate = rate;
        this.code = code;
        this.name = name;
    }

    public Integer getScaler() {
        return scaler;
    }

    public Double getRate() {
        return rate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
