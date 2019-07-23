package com.test.money.transfer.configuration;

import com.google.inject.Provider;
import com.test.money.transfer.filter.CheckAccountsFilter;
import com.test.money.transfer.filter.TransferFilter;
import com.test.money.transfer.service.AccountService;

import javax.inject.Inject;

/**
 * Create TransferFilter object or chain of the filters.
 */
public class TransferFilterProvider implements Provider<TransferFilter> {


    private final AccountService accountService;

    @Inject
    public TransferFilterProvider(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public TransferFilter get() {
        CheckAccountsFilter checkAccountsFilter = new CheckAccountsFilter();
        checkAccountsFilter.setAccountService(accountService);
        return checkAccountsFilter;
    }
}
