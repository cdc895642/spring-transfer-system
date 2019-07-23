package com.test.money.transfer.service;

import com.test.money.transfer.dao.CurrencyMapper;
import com.test.money.transfer.model.Currency;
import com.test.money.transfer.validator.Validator;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Base implementation of the CurrencyService interface.
 */
@Singleton
@Slf4j
public class CurrencyServiceImpl implements CurrencyService, BaseService {

    private CurrencyMapper currencyDao;

    @Override
    public List<Currency> findAll() {
        return currencyDao.findAll();
    }

    @Override
    public Currency create(Currency currency, Validator<Currency>... validators) {
        if (!check(currency, validators)) {
            log.error("client is not exist or is not valid : {}", currency);
            throw new IllegalArgumentException("check currency - something went wrong");
        }
        currencyDao.create(currency);
        return currency;
    }

    @Inject
    public void setCurrencyDao(CurrencyMapper currencyDao) {
        this.currencyDao = currencyDao;
    }
}
