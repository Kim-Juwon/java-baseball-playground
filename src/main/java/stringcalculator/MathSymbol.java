package stringcalculator;

public enum MathSymbol {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    public static MathSymbol identify(String value) {
        for (MathSymbol mathSymbol : values()) {
            if (mathSymbol.getSymbol().equals(value)) {
                return mathSymbol;
            }
        }
        return null;
    }

    MathSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    private final String symbol;
}
