package com.test.money.transfer.validator;

public interface Validator<T> {

  boolean validate(T input);
}
