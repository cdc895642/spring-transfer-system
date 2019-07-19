package com.test.money.transfer.service;

import com.test.money.transfer.dao.AccountMapper;
import com.test.money.transfer.exception.TransferException;
import com.test.money.transfer.model.Account;
import com.test.money.transfer.validator.Validator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    @Mock
    private Validator<Account> validator;
    @Mock
    private AccountMapper accountDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create_validAccountDbSaveRecord_returnId() {
        //Arrange
        final int EXPECTED_ID = 1;
        when(validator.validate(any())).thenReturn(true);
        doNothing().when(accountDao).create(any(Account.class));
        Account account = new Account();
        account.setId(EXPECTED_ID);
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(accountDao);

        //Act
        Account result = accountService.create(account, validator);

        //Assert
        assertEquals(Integer.valueOf(EXPECTED_ID), result.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_invalidAccount_throwException() {
        //Arrange
        final int EXPECTED_ID = 1;
        when(validator.validate(any())).thenReturn(false);
        doNothing().when(accountDao).create(any(Account.class));
        Account account = new Account();
        account.setId(EXPECTED_ID);
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(accountDao);

        //Act
        accountService.create(account, validator);
    }

    @Test(expected = TransferException.class)
    public void create_validAccountRecordNotSaved_throwException() {
        //Arrange
        when(validator.validate(any())).thenReturn(true);
        doNothing().when(accountDao).create(any(Account.class));
        Account account = new Account();
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(accountDao);

        //Act
        accountService.create(account, validator);
    }

    @Test
    public void update_validAccountChangeBalance_returnResult() {
        //Arrange
        final int ACCOUNT_ID = 1;
        Account account = new Account();
        account.setId(ACCOUNT_ID);
        account.setBalance(BigDecimal.valueOf(10000));
        when(validator.validate(any())).thenReturn(true);
        doNothing().when(accountDao).update(account);
        when(accountDao.findById(ACCOUNT_ID)).thenReturn(account);
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(accountDao);

        //Act
        Account result=accountService.update(account, validator);

        //Assert
        assertNotNull(result);
    }

    @Test
    public void getAccountsByClientId_correctId_returnNotEmptyList() {
        //Arrange
        int clientId = 1;
        final int UNEXPECTED_SIZE = 0;
        when(accountDao.getAccountsByClientId(clientId)).thenReturn(Arrays.asList(new Account()));
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(accountDao);

        //Act
        List<Account> result = accountService.getAccountsByClientId(clientId);

        //Assert
        assertNotEquals(UNEXPECTED_SIZE, result.size());
    }

    @Test
    public void getAccountsByClientId_incorrectId_returnEmptyList() {
        //Arrange
        int clientId = 1;
        final int EXPECTED_SIZE = 0;
        when(accountDao.getAccountsByClientId(clientId)).thenReturn(new ArrayList<>());
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(accountDao);

        //Act
        List<Account> result = accountService.getAccountsByClientId(clientId);

        //Assert
        assertEquals(EXPECTED_SIZE, result.size());
    }
}