package com.test.money.transfer.configuration;

import com.google.inject.AbstractModule;
import com.test.money.transfer.filter.TransferFilter;

/**
 * Instantiate the TransferFilters and inject them to the application.
 */
public class FilterModule  extends AbstractModule {

    @Override
    protected void configure() {
        bind(TransferFilter.class).toProvider(TransferFilterProvider.class);
    }
}
