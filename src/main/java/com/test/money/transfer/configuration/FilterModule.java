package com.test.money.transfer.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.test.money.transfer.filter.CheckAccountsFilter;
import com.test.money.transfer.filter.TransferFilter;

public class FilterModule  extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    public TransferFilter getTransferFilter() {
        CheckAccountsFilter checkAccountsFilter = new CheckAccountsFilter();
        return checkAccountsFilter;
    }
}
