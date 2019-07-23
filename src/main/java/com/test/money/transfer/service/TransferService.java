package com.test.money.transfer.service;

import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Transfer;
import com.test.money.transfer.validator.Validator;

/**
 * Contains methods for work with the transfers.
 */
public interface TransferService {

    /**
     * Performs the transfer.
     * @param transfer Transfer to perform.
     * @param validators Array of validators to validate accounts which used in the transfer.
     * @return Performed transfer.
     * @throws InterruptedException If multithreading exception occurs.
     */
    Transfer perform(Transfer transfer, Validator<Account>... validators) throws InterruptedException;
}
