package com.test.money.transfer.configuration;

import com.google.inject.AbstractModule;
import com.test.money.transfer.controller.CurrencyController;

public class ControllerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CurrencyController.class).asEagerSingleton();
    }
}
