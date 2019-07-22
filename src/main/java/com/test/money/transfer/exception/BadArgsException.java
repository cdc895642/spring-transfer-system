package com.test.money.transfer.exception;

/**
 * Throw when methods receive incorrect arguments.
 */
public class BadArgsException extends TransferException {

    public BadArgsException(String message, Throwable cause) {
        super(message, cause);
    }

}
