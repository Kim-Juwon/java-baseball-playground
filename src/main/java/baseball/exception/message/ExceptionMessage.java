package baseball.exception.message;

public enum ExceptionMessage {
    INPUT_VALUE_IS_INVALID("입력한 값이 유효하지 않습니다."),
    NUMBERS_LENGTH_MUST_BE_THREE("3자리수를 입력하여야 합니다."),
    NUMBER_MUST_BE_BETWEEN_ONE_AND_NINE("1부터 9까지의 수로 이루어져 있어야 합니다."),
    DUPLICATE_NUMBER_EXIST("중복되는 값이 있습니다."),
    HINT_IS_INVALID("힌트의 상태가 올바르지 않습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
