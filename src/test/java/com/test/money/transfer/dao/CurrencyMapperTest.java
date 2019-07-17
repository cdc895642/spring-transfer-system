package com.test.money.transfer.dao;

import static org.junit.Assert.*;

import com.test.money.transfer.BaseIntegrationTest;
import com.test.money.transfer.model.Currency;
import com.test.money.transfer.model.CurrencyModel;
import java.util.List;
import org.junit.Test;

public class CurrencyMapperTest extends BaseIntegrationTest {

  @Test
  public void findIdByCurrencyCode() throws Exception {
    int idByCurrencyCode = currencyDao.findIdByCurrencyCode(Currency.USD);
    assertEquals(idByCurrencyCode, 1);
  }

  @Test
  public void create() throws Exception {
  }

  @Test
  public void findAll() throws Exception {
    List<CurrencyModel> all = currencyDao.findAll();
    all.size();
  }

  @Test
  public void findCurrencyCodeById() throws Exception {
    Currency currency = currencyDao.findCurrencyCodeById(1);
    currency.toString();
  }

}