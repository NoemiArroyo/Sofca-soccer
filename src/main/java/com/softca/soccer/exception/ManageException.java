package com.softca.soccer.exception;

public class ManageException extends Exception{
    public ManageException() {
        super();
    }

    public ManageException(String message) {
        super(message);
    }

    public ManageException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ManageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ManageException(Throwable cause) {
        super(cause);
    }
}
