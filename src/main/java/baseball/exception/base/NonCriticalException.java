package baseball.exception.base;

import baseball.exception.message.ExceptionMessage;

public class NonCriticalException extends CustomException {
    public NonCriticalException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
