package com.test.money.transfer.service;

import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Transfer;
import com.test.money.transfer.validator.Validator;

public interface TransferService {

    Transfer perform(Transfer transfer, Validator<Account>... validators) throws InterruptedException;
}
