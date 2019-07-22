package com.test.money.transfer.configuration;

import com.google.inject.AbstractModule;
import com.test.money.transfer.controller.*;

/**
 * Instantiate the controllers and inject them to the application.
 */
public class ControllerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TransferController.class).asEagerSingleton();
        bind(AccountController.class).asEagerSingleton();
        bind(ClientController.class).asEagerSingleton();
        bind(CurrencyController.class).asEagerSingleton();
        bind(FrontController.class).asEagerSingleton();
    }
}
