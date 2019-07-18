package com.test.money.transfer.service;

import com.test.money.transfer.model.Account;
import com.test.money.transfer.validator.Validator;
import java.util.List;

public class AccountServiceImpl implements AccountService, BaseService {

  @Override
  public Account create(Account account, Validator<Account>... validators) {
    if (!check(account, validators)) {
      throw new IllegalArgumentException("check account - something went wrong");
    }
    return null;
  }

  @Override
  public Account update(Account account, Validator<Account>... validators) {
    return null;
  }

  @Override
  public List<Account> getAccountsByClientId(int clientId) {
    return null;
  }
}
