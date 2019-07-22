package com.test.money.transfer.exception;

/**
 * Base exception for other types of exceptions in the application.
 */
public class TransferException extends RuntimeException {

    public TransferException(Throwable cause) {
        super(cause);
    }

    public TransferException() {
    }

    public TransferException(String message) {
        super(message);
    }

    public TransferException(String message, Throwable cause) {
        super(message, cause);
    }
}
