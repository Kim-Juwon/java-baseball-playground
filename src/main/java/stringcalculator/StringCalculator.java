package stringcalculator;

public class StringCalculator {
    private Integer temporaryResult = null;

    public int calculate(String value) {
        String[] dividedElements = divide(value);
        calculate(dividedElements);

        int result = temporaryResult;
        temporaryResult = null;

        return result;
    }

    private String[] divide(String value) {
        return value.split(" ");
    }

    private void calculate(String[] elements) {
        temporaryResult = Integer.parseInt(elements[0]);

        for (int i = 1; i < elements.length - 1; i += 2) {
            calculate(elements[i], elements[i + 1]);
        }
    }

    private void calculate(String mathSymbol, String number) {
        int value = Integer.parseInt(number);
        MathSymbol symbol = MathSymbol.identify(mathSymbol);

        if (symbol.equals(MathSymbol.ADDITION)) {
            temporaryResult += value;
        }
        if (symbol.equals(MathSymbol.SUBTRACTION)) {
            temporaryResult -= value;
        }
        if (symbol.equals(MathSymbol.MULTIPLICATION)) {
            temporaryResult *= value;
        }
        if (symbol.equals(MathSymbol.DIVISION)) {
            temporaryResult /= value;
        }
    }
}
