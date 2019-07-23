package com.test.money.transfer.configuration;

import com.google.inject.AbstractModule;
import com.test.money.transfer.validator.NotNullValueValidatorImpl;

/**
 * Instantiate the Validators and inject them to the application.
 */
public class ValidatorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(NotNullValueValidatorImpl.class);
    }
}
