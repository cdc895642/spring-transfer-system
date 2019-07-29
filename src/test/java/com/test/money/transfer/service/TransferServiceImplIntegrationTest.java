package com.test.money.transfer.service;

import static org.junit.Assert.assertEquals;

import com.test.money.transfer.BaseIntegrationDbTest;
import com.test.money.transfer.dao.AccountMapper;
import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Transfer;
import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class TransferServiceImplIntegrationTest extends BaseIntegrationDbTest {

    @Test
    public void perform_changeTheSameAccountsInMultiThread_performAllTransfers()
        throws InterruptedException {
        //Arrange
        final int FROM_ACCOUNT_ID = 1;
        final int TO_ACCOUNT_ID = 2;
        final BigDecimal EXPECTED_FROM_ACCOUNT_BALANCE = BigDecimal.valueOf(-90);
        final BigDecimal EXPECTED_TO_ACCOUNT_BALANCE = BigDecimal.valueOf(110);
        final int EXPECTED_RESULT = 0;
        Account from = accountDao.findById(FROM_ACCOUNT_ID);
        Account to = accountDao.findById(TO_ACCOUNT_ID);
        Transfer transfer = new Transfer();
        transfer.setAmount(BigDecimal.ONE);
        transfer.setFrom(from);
        transfer.setTo(to);
        TransferServiceImpl transferService = new TransferServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(accountDao);
        transferService.setAccountService(accountService);
        CountDownLatch START = new CountDownLatch(100);

        //Act
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            es.execute(() -> {
                try {
                    transferService.perform(transfer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                START.countDown();
            });
        }
        es.shutdown();
        START.await();

        from = accountDao.findById(FROM_ACCOUNT_ID);
        to = accountDao.findById(TO_ACCOUNT_ID);

        //Assert
        System.out.println(from.getBalance() + " - " + to.getBalance());
        assertEquals(EXPECTED_RESULT, EXPECTED_FROM_ACCOUNT_BALANCE.compareTo(from.getBalance()));
        assertEquals(EXPECTED_RESULT, EXPECTED_TO_ACCOUNT_BALANCE.compareTo(to.getBalance()));
    }

    @Test
    public void perform_changeTheSameAccountsInOneThread_performAllTransfers()
        throws InterruptedException {
        //Arrange
        final int FROM_ACCOUNT_ID = 1;
        final int TO_ACCOUNT_ID = 2;
        final BigDecimal EXPECTED_FROM_ACCOUNT_BALANCE = BigDecimal.valueOf(-90);
        final BigDecimal EXPECTED_TO_ACCOUNT_BALANCE = BigDecimal.valueOf(110);
        final int EXPECTED_RESULT = 0;
        Account from = accountDao.findById(FROM_ACCOUNT_ID);
        Account to = accountDao.findById(TO_ACCOUNT_ID);
        Transfer transfer = new Transfer();
        transfer.setAmount(BigDecimal.ONE);
        transfer.setFrom(from);
        transfer.setTo(to);
        TransferServiceImpl transferService = new TransferServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(accountDao);
        transferService.setAccountService(accountService);

        //Act
        for (int i = 0; i < 100; i++) {
            transferService.perform(transfer);
        }

        from = accountDao.findById(FROM_ACCOUNT_ID);
        to = accountDao.findById(TO_ACCOUNT_ID);

        //Assert
        assertEquals(EXPECTED_RESULT, EXPECTED_FROM_ACCOUNT_BALANCE.compareTo(from.getBalance()));
        assertEquals(EXPECTED_RESULT, EXPECTED_TO_ACCOUNT_BALANCE.compareTo(to.getBalance()));
    }
}
