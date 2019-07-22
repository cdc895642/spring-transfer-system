package com.test.money.transfer.filter;

import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Transfer;
import com.test.money.transfer.service.AccountService;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;

//todo integration test with service
@Slf4j
public class CheckAccountsFilter extends AbstractTransferFilter {

    private AccountService accountService;

    @Override
    public boolean doFilter(Transfer transfer) {

        if (transfer.getAmount() == null) {
            log.info("amount in transfer cannot be null {}", transfer);
            return false;
        }
        if (transfer.getFrom() == null || transfer.getTo() == null) {
            log.info("accounts in transfer cannot be null {}", transfer);
            return false;
        }
        if (transfer.getFrom().getId() == null || transfer.getTo().getId() == null) {
            log.info("ids in accounts cannot be null {}", transfer);
            return false;
        }

        getAccountInfo(transfer);
        Account fromAccount = transfer.getFrom();
        Account toAccount = transfer.getTo();

        //check that accounts are not the same
        if (fromAccount.getId().equals(toAccount.getId())) {
            log.info("accounts from {} and account to {} cannot be the same", fromAccount,
                toAccount);
            return false;
        }

        //check that accounts have the same currency
        if (!fromAccount.getCurrency().equals(toAccount.getCurrency())) {
            log.info("accounts must have the same currencies : account from - {}; account to - {}",
                fromAccount, toAccount);
            return false;
        }
//todo check in test comparing of the bigdecimals
        //check that account "fromAccount" has enough money
        if (fromAccount.getBalance().compareTo(transfer.getAmount()) < 0) {
            log.info(
                "balance of the account 'from' ({}) is lower than the sum of the transaction {}",
                fromAccount.getBalance(), transfer.getAmount());
            return false;
        }

        return doNextFilter(transfer);
    }

    /**
     * Get info about accounts from the Database and write it to the transfer
     *
     * @param transfer object with info about the accounts
     */
    private void getAccountInfo(Transfer transfer) {
        //get info
        Account fromAccount = accountService.findById(transfer.getFrom().getId());
        Account toAccount = accountService.findById(transfer.getTo().getId());
        //save info
        transfer.setFrom(fromAccount);
        transfer.setTo(toAccount);
    }

    @Inject
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
