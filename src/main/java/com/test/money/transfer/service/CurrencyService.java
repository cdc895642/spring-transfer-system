package com.test.money.transfer.service;

import com.test.money.transfer.model.Currency;
import com.test.money.transfer.validator.Validator;

import java.util.List;

/**
 * Contains methods for work with currencies.
 */
public interface CurrencyService {

    /**
     * Get all currencies which registered in the database.
     * @return List of the all currencies.
     */
    List<Currency> findAll();

    /**
     * Create new currency.
     * @param currency New currency.
     * @param validators Array of validators to validate currency.
     * @return Created currency.
     */
    Currency create(Currency currency, Validator<Currency>... validators);
}
