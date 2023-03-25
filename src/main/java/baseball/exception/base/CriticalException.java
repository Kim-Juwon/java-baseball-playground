package baseball.exception.base;

import baseball.exception.message.ExceptionMessage;

public class CriticalException extends CustomException {
    public CriticalException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
