package com.test.money.transfer.service;

import com.test.money.transfer.filter.TransferFilter;
import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Transfer;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TransferServiceImplTest {

    @Mock
    private TransferFilter filter;
    @Mock
    private HistoryService historyService;
    @Mock
    private AccountService accountService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void perform_accountsCorrect_updateBothAccounts() throws InterruptedException {
        //Arrange
        int accountId = 1;
        BigDecimal sum = BigDecimal.ONE;
        Transfer transfer = new Transfer();
        Account account = new Account();
        account.setId(accountId);
        account.setBalance(sum);
        transfer.setFrom(account);
        transfer.setTo(account);
        transfer.setAmount(sum);
        TransferServiceImpl transferService = new TransferServiceImpl();
        when(accountService.findById(anyInt())).thenReturn(account);
        transferService.setHistoryService(historyService);
        transferService.setAccountService(accountService);

        //Act
        Transfer result = transferService.perform(transfer);

        //Assert
        verify(accountService, times(2)).update(any(), any());
    }

    @Test(expected = IllegalArgumentException.class)
    public void perform_AccountsAreInvalid_throwException() throws InterruptedException {
        //Arrange
        Transfer transfer = new Transfer();
        TransferServiceImpl transferService = new TransferServiceImpl();
        transferService.setHistoryService(historyService);
        transferService.setFilter(filter);
        when(filter.doFilter(transfer)).thenThrow(IllegalArgumentException.class);

        //Act
        Transfer result = transferService.perform(transfer);
    }

    @Test
    public void perform_correctTransfer_returnIsfnishedTransferWithCurrenDate()
        throws InterruptedException {
        //Arrange
        int accountId = 1;
        BigDecimal sum = BigDecimal.ONE;
        Transfer transfer = new Transfer();
        Account account = new Account();
        account.setId(accountId);
        account.setBalance(sum);
        transfer.setFrom(account);
        transfer.setTo(account);
        transfer.setAmount(sum);
        TransferServiceImpl transferService = new TransferServiceImpl();
        transferService.setHistoryService(historyService);
        transferService.setAccountService(accountService);

        //Act
        Transfer result = transferService.perform(transfer);

        //Assert
        assertNotNull(result.getDate());
        assertTrue(result.isFinished());
    }
}