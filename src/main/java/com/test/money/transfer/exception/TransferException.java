package com.test.money.transfer.exception;

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
