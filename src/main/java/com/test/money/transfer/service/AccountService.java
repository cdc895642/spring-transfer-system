package com.test.money.transfer.service;

import com.test.money.transfer.model.Account;
import com.test.money.transfer.validator.Validator;
import java.util.List;

public interface AccountService {

  Account create(Account account, Validator<Account>... validators);

  Account update(Account account, Validator<Account>... validators);

  List<Account> getAccountsByClientId(int clientId);
}
