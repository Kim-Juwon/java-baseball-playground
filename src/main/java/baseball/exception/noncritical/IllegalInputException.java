package baseball.exception.noncritical;

import baseball.exception.message.ExceptionMessage;
import baseball.exception.base.NonCriticalException;

public class IllegalInputException extends NonCriticalException {
    public IllegalInputException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
