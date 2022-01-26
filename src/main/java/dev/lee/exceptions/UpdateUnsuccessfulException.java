package dev.lee.exceptions;

public class UpdateUnsuccessfulException extends RuntimeException {

    public UpdateUnsuccessfulException() {
        super();
    }

    public UpdateUnsuccessfulException(String message) {
        super(message);
    }

    public UpdateUnsuccessfulException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateUnsuccessfulException(Throwable cause) {
        super(cause);
    }

    public UpdateUnsuccessfulException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}