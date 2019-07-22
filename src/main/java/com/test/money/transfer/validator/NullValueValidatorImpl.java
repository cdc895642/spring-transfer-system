package com.test.money.transfer.validator;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

@Singleton
@Slf4j
public class NullValueValidatorImpl<T> implements Validator<T> {

    @Override
    public boolean validate(T input) {
        if (input == null) {
            log.info("object cannot be null");
            return false;
        }
        return true;
    }
}
