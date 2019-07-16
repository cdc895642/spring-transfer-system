package com.test.money.transfer.dao;

import com.test.money.transfer.BaseIntegrationTest;
import com.test.money.transfer.model.Account;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountMapperTest extends BaseIntegrationTest {

    void create(Account account){}


    @Test
    public void getAccountsByClientId(){
        List<Account> accountsByClientId = accountDao.getAccountsByClientId(1);
        accountsByClientId.size();
    }
}