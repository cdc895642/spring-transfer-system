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

    @Test
    public void save_changeBalanceCorrectAccount_changeBalance() {
        //Arrange
        final BigDecimal NEW_BALANCE = BigDecimal.valueOf(1000000.00).setScale(2);
        final int CLIENT_ID = 1;
        Account account = accountDao.getAccountsByClientId(CLIENT_ID).get(0);
        account.setBalance(NEW_BALANCE);

        //Act
        accountDao.save(account);
        Account result = accountDao.getAccountsByClientId(CLIENT_ID).get(0);

        //Assert
        assertEquals(NEW_BALANCE, result.getBalance());
    }

    @Test(expected = PersistenceException.class)
    public void create_createAccountWithTheSameCleintAndCurrency_throwException() {
        //Arrange
        Client client = new Client();
        client.setId(1);
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(10));
        account.setClient(client);
        Currency usd = new Currency();
        usd.setId(1);
        account.setCurrency(usd);

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
        Currency eur = new Currency();
        eur.setId(2);
        account.setCurrency(eur);

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