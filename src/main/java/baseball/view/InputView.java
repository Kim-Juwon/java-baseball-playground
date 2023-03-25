package baseball.view;

import baseball.component.Numbers;
import baseball.exception.message.ExceptionMessage;
import baseball.exception.noncritical.IllegalInputException;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WHITESPACE_REGEX = "\\s+";
    private static final int CORRECT_NUMBERS_LENGTH = 3;
    private static final int CORRECT_STRINGS_LENGTH = 1;
    private final Scanner scanner = new Scanner(System.in);

    public static InputView create() {
        return new InputView();
    }

    public void showInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public Numbers input() {
        return Numbers.from(read());
    }

    private String read() {
        String string = readFirstStringFrom(readStringsByRemovingWhitespaces());
        validate(string);
        return string;
    }

    private String readFirstStringFrom(String[] strings) {
        validate(strings);
        return strings[0];
    }

    private String[] readStringsByRemovingWhitespaces() {
        return scanner.nextLine()
                .trim()
                .split(WHITESPACE_REGEX);
    }

    // 아래부터는 입력값에 대한 유효성 검증을 위한 메소드이다.

    private boolean isNull(Object object) {
        return object == null;
    }

    private void validate(String string) {
        validateCorrectLength(string);
        validateBetweenOneAndNine(string);
        validateNonDuplication(string);
    }

    private void validate(String[] strings) {
        validateCorrectLength(strings);
        validateFirstValueExist(strings);
    }

    private void validateCorrectLength(String string) {
        if (isNull(string) || string.length() != CORRECT_NUMBERS_LENGTH) {
            throw new IllegalInputException(ExceptionMessage.NUMBERS_LENGTH_MUST_BE_THREE);
        }
    }

    private void validateBetweenOneAndNine(String string) {
        if (isNull(string)) {
            throw new IllegalInputException(ExceptionMessage.INPUT_VALUE_IS_INVALID);
        }

        IntStream.range(0, string.length())
                .filter(index -> !isBetweenOneAndNine(string.charAt(index)))
                .forEach(index -> {
                    throw new IllegalInputException(ExceptionMessage.NUMBER_MUST_BE_BETWEEN_ONE_AND_NINE);
                });
    }

    private void validateNonDuplication(String string) {
        if (string.length() != getDeduplicatedLengthFrom(string)) {
            throw new IllegalInputException(ExceptionMessage.DUPLICATE_NUMBER_EXIST);
        }
    }

    private long getDeduplicatedLengthFrom(String string) {
        return IntStream.range(0, string.length())
                .map(string::charAt)
                .distinct()
                .count();
    }

    private boolean isBetweenOneAndNine(char ch) {
        return ch >= '1' && ch <= '9';
    }

    private void validateCorrectLength(String[] strings) {
        if (isNull(strings) || strings.length != CORRECT_STRINGS_LENGTH) {
            throw new IllegalInputException(ExceptionMessage.INPUT_VALUE_IS_INVALID);
        }
    }

    private void validateFirstValueExist(String[] strings) {
        if (isNull(strings) || isNull(strings[0])) {
            throw new IllegalInputException(ExceptionMessage.INPUT_VALUE_IS_INVALID);
        }
    }
}
