package com.test.money.transfer.service;

import com.test.money.transfer.model.Currency;
import java.util.List;

public interface CurrencyService {

    List<Currency> findAll();

    Currency create(Currency currency);
}
