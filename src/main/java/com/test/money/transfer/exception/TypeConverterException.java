package com.test.money.transfer.exception;

public class TypeConverterException extends TransferException {

    public TypeConverterException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeConverterException(Throwable cause) {
        super(cause);
    }
}
