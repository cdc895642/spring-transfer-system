package com.test.money.transfer.service;

import com.test.money.transfer.model.Currency;
import com.test.money.transfer.validator.Validator;

import java.util.List;

public interface CurrencyService {

    List<Currency> findAll();

    Currency create(Currency currency, Validator<Currency>... validators);
}
