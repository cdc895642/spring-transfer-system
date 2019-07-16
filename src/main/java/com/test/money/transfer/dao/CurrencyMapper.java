package com.test.money.transfer.dao;

import com.test.money.transfer.model.Currency;
import com.test.money.transfer.model.CurrencyModel;
import java.util.List;

public interface CurrencyMapper {

  int findIdByCurrencyCode(Currency code);

  Currency findCurrencyCodeById(int id);

  void create(Currency code);

  List<CurrencyModel> findAll();

}
