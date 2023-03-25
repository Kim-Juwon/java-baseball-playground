package baseball.exception.critical;

import baseball.exception.base.CriticalException;
import baseball.exception.message.ExceptionMessage;

public class InvalidHintException extends CriticalException {
    public InvalidHintException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
