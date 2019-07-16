package com.test.money.transfer.service;

import com.test.money.transfer.model.Account;
import java.util.List;

public interface AccountService {

  Account save(Account account);

  List<Account> getAccountsByClientId(int clientId);
}
