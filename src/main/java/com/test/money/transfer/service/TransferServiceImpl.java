package com.test.money.transfer.service;

import com.test.money.transfer.filter.TransferFilter;
import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Transfer;
import com.test.money.transfer.validator.Validator;
import java.util.concurrent.Semaphore;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.guice.transactional.Isolation;
import org.mybatis.guice.transactional.Transactional;

import java.time.LocalDateTime;

@Singleton
@Slf4j
public class TransferServiceImpl implements TransferService {

    private static final Semaphore SEMAPHORE = new Semaphore(1, true);
    private TransferFilter filter;
    private HistoryService historyService;
    private AccountService accountService;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Transfer perform(Transfer transfer, Validator<Account>... validators) throws InterruptedException {
        try {
            SEMAPHORE.acquire();
            //pass transfer through the filter chain
            if (filter != null && !filter.doFilter(transfer)) {
                log.info("transfer is incorrect, please check your data {}", transfer);
                saveHistory(transfer, false);
                throw new IllegalArgumentException("transfer is incorrect, please check your data");
            }
            //if everything is fine change balance for both accounts
            Account fromAccount = transfer.getFrom();
            Account toAccount = transfer.getTo();
            fromAccount.setBalance(fromAccount.getBalance().subtract(transfer.getAmount()));
            toAccount.setBalance(toAccount.getBalance().add(transfer.getAmount()));
            //update amounts in the database
            accountService.update(fromAccount, validators);
            accountService.update(toAccount, validators);
        } catch (InterruptedException e) {
            log.error("exception during transfer {}", transfer, e);
            throw e;
        } finally {
            SEMAPHORE.release();
            //save transfer in the history
            saveHistory(transfer, true);
        }
        return transfer;
    }

    private void saveHistory(Transfer transfer, boolean isFinished) {
        transfer.setFinished(isFinished);
        transfer.setDate(LocalDateTime.now());
        if (historyService != null) {
            historyService.save(transfer);
        }
    }

    @Inject
    public void setFilter(TransferFilter filter) {
        this.filter = filter;
    }

    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Inject
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

}
