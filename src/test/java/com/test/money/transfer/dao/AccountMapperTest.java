package com.test.money.transfer.dao;

import com.test.money.transfer.BaseIntegrationTest;
import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Client;
import com.test.money.transfer.model.Currency;
import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class AccountMapperTest extends BaseIntegrationTest {

    @Test(expected = PersistenceException.class)
    public void create_createAccountWithTheSameCleintAndCurrency_throwException() {
        //Arrange
        Client client = new Client();
        client.setId(1);
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(10));
        account.setClient(client);
        account.setCurrency(Currency.USD);

        //Act
        accountDao.create(account);
    }

    @Test
    public void create_createNewAccount_returnNewId() {
        //Arrange
        Client client = new Client();
        client.setId(1);
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(10));
        account.setClient(client);
        account.setCurrency(Currency.EUR);

        //Act
        accountDao.create(account);

        //Assert
        assertNotNull(account.getId());
    }


    @Test
    public void getAccountsByClientId_returnResult() {
        //Act
        final int UNEXPECTED_RESULT = 0;
        List<Account> accountsByClientId = accountDao.getAccountsByClientId(1);

        //Assert
        assertNotEquals(UNEXPECTED_RESULT, accountsByClientId.size());
    }
}