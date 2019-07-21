package com.test.money.transfer.validator;

import com.test.money.transfer.model.Account;

//todo create + and create integration test
public class CheckAccountValidator implements Validator<Account> {
    @Override
    public boolean validate(Account input) {
        return false;
    }
}
