package com.test.money.transfer.dao;

import com.test.money.transfer.model.Account;

import java.util.List;

/**
 * Operations with accounts of the clients.
 */
public interface AccountMapper {

    /**
     * Create new account of the existing client.
     *
     * @param account New account.
     */
    void create(Account account);

    /**
     * Get list of accounts of the client (find by client id).
     * @param clientId Client id.
     * @return List of accounts of the client
     */
    List<Account> getAccountsByClientId(int clientId);

    /**
     * Update existing account of the client. Update only balance.
     * @param account Existing account with new balance.
     */
    void update(Account account);

    /**
     * Find account by it id.
     * @param accountId Id of the account.
     * @return Existing account or null.
     */
    Account findById(int accountId);
}
