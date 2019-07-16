package com.test.money.transfer.dao;

import com.test.money.transfer.model.Account;

import java.util.List;

public interface AccountMapper {

    void create(Account account);

    List<Account> getAccountsByClientId(int clientId);
}
