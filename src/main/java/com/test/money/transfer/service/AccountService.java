package com.test.money.transfer.service;

import com.test.money.transfer.model.Account;
import com.test.money.transfer.validator.Validator;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service for work with clients` accounts
 */
public interface AccountService {

  /**
   * Create account for existing user.
   * @param account New account.
   * @param validators Additional validators for account.
   * @return Created account
   */
  Account create(Account account, Validator<Account>... validators);

  /**
   * Change balance in existing account.
   * @param account An existing account (should have not null field with Account Id)
   * @param validators Array of validators to validate account
   * @return Updated account
   */
  Account update(Account account, Validator<Account>... validators);

  /**
   * Get all accounts of the client.
   * @param clientId Client Id.
   * @return List of accounts of the client.
   */
  List<Account> getAccountsByClientId(int clientId);

  /**
   * Get account by it id.
   * @param accountId Account id.
   * @return Account or null if account with such id is not exist.
   */
  Account findById(int accountId);
}
