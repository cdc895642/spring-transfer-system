package com.test.money.transfer.configuration;

import com.google.inject.AbstractModule;
import com.test.money.transfer.service.*;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CurrencyService.class).to(CurrencyServiceImpl.class);
        bind(ClientService.class).to(ClientServiceImpl.class);
        bind(AccountService.class).to(AccountServiceImpl.class);
        bind(TransferService.class).to(TransferServiceImpl.class);
    }

}
