package com.test.money.transfer.validator;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

/**
 * Check if the input object equals null.
 * @param <T> Type of the input object.
 */
@Singleton
@Slf4j
public class NotNullValueValidatorImpl<T> implements Validator<T> {

    /**
     * Check if the input object equals null.
     * @param input Input object for validation.
     * @return True if input object is not null, false - otherwise.
     */
    @Override
    public boolean validate(T input) {
        if (input == null) {
            log.info("object cannot be null");
            return false;
        }
        return true;
    }
}
