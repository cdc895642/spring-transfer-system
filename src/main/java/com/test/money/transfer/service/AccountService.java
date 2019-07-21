package com.test.money.transfer.service;

import com.test.money.transfer.model.Account;
import com.test.money.transfer.validator.Validator;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

  Account create(Account account, Validator<Account>... validators);

  /**
   * Change balance in existing account.
   * @param account an existing account (should have not null field with Account Id)
   * @param validators array of validators to validate account
   * @return updated account
   */
  Account update(Account account, Validator<Account>... validators);

  List<Account> getAccountsByClientId(int clientId);

  Account findById(int accountId);
}
