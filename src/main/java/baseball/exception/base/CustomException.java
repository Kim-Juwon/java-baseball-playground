package baseball.exception.base;

import baseball.exception.message.ExceptionMessage;

public class CustomException extends RuntimeException {
    public CustomException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}
