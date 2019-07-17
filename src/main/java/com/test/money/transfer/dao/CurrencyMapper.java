package com.test.money.transfer.dao;

import com.test.money.transfer.model.Currency;
import java.util.List;

public interface CurrencyMapper {

  Integer findIdByCurrencyCode(String code);

  Currency findCurrencyById(int id);

  void create(Currency currency);

  List<Currency> findAll();

}
