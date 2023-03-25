package baseball.view;

import baseball.component.Hint;
import baseball.component.FinishingStatus;
import baseball.exception.message.ExceptionMessage;
import baseball.exception.base.NonCriticalException;
import baseball.exception.noncritical.IllegalInputException;

import java.util.Scanner;

public class ResultView {
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MESSAGE_FOR_QUESTION_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String WHITESPACE_REGEX = "\\s+";
    private static final String UNEXPECTED_ERROR_MESSAGE = "예기치 못한 에러가 발생하였습니다.";
    private final Scanner scanner = new Scanner(System.in);

    public static ResultView create() {
        return new ResultView();
    }

    public void showResultFrom(Hint hint) {
        if (isSuccess(hint)) {
            showSuccessView();
            return;
        }

        showHintFrom(hint);
    }

    public void showQuestion() {
        System.out.println(MESSAGE_FOR_QUESTION_RESTART);
    }

    public void showErrorFrom(Throwable throwable) {
        if (throwable instanceof NonCriticalException) {
            System.out.println(throwable.getMessage());
            return;
        }

        System.out.println(UNEXPECTED_ERROR_MESSAGE);
    }

    private boolean isSuccess(Hint hint) {
        return hint.isThreeStrike();
    }

    private void showSuccessView() {
        System.out.println(SUCCESS_MESSAGE);
    }

    private void showHintFrom(Hint hint) {
        System.out.println(hint.makeString());
    }

    public FinishingStatus input() {
        return FinishingStatus.from(read());
    }

    private int read() {
        String string = readFirstStringFrom(readStringsByRemovingWhitespaces());
        int intValue = parseToInt(string);
        validate(intValue);
        return intValue;
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

    private int parseToInt(String string) {
        if (isNull(string)) {
            throw new IllegalInputException(ExceptionMessage.INPUT_VALUE_IS_INVALID);
        }

        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalInputException(ExceptionMessage.INPUT_VALUE_IS_INVALID);
        }
    }

    // 아래부터는 입력값에 대한 유효성 검증을 위한 메소드들이다.

    private boolean isNull(Object object) {
        return object == null;
    }

    private void validate(int intValue) {
        validateAnyMatches(intValue);
    }

    private void validate(String[] strings) {
        validateCorrectLength(strings);
        validateFirstValueExist(strings);
    }

    private void validateAnyMatches(int intValue) {
        if (!FinishingStatus.anyMatch(intValue)) {
            throw new IllegalInputException(ExceptionMessage.INPUT_VALUE_IS_INVALID);
        }
    }

    private void validateCorrectLength(String[] strings) {
        if (isNull(strings) || strings.length != 1) {
            throw new IllegalInputException(ExceptionMessage.INPUT_VALUE_IS_INVALID);
        }
    }

    private void validateFirstValueExist(String[] strings) {
        if (isNull(strings) || strings[0] == null) {
            throw new IllegalInputException(ExceptionMessage.INPUT_VALUE_IS_INVALID);
        }
    }
}
