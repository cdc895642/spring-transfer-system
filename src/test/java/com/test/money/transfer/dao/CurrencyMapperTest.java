package com.test.money.transfer.dao;

import static org.junit.Assert.*;

import com.test.money.transfer.BaseIntegrationTest;
import com.test.money.transfer.model.Currency;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Test;

public class CurrencyMapperTest extends BaseIntegrationTest {

  @Test
  public void findIdByCurrencyCode_correctArgument_returnResult() {
    //Arrange
    final int EXPECTED_ID = 1;

    //Act
    int result = currencyDao.findIdByCurrencyCode("USD");

    //Assert
    assertEquals(EXPECTED_ID, result);
  }

  @Test
  public void findIdByCurrencyCode_incorrectArgument_returnNull() {
    //Act
    Integer result = currencyDao.findIdByCurrencyCode("USD1");

    //Assert
    assertNull(result);
  }

  @Test
  public void create_correctValue_returnNewId() {
    //Arrange
    Currency currency = new Currency();
    currency.setCode("RUB");

    //Act
    currencyDao.create(currency);

    //Assert
    assertNotNull(currency.getId());
  }

  @Test(expected = PersistenceException.class)
  public void create_existValue_throwException() {
    //Arrange
    Currency currency = new Currency();
    currency.setCode("USD");

    //Act
    currencyDao.create(currency);
  }

  @Test
  public void findAll_returnResult() {
    //Arrange
    final int UNEXPECTED_RESULT = 0;

    //Act
    List<Currency> all = currencyDao.findAll();

    //Assert
    assertNotEquals(UNEXPECTED_RESULT, all.size());
  }

  @Test
  public void findCurrencyById_correctArg_returnResult() throws Exception {
    //Arrange
    final int EXPECTED_ID = 1;
    final String EXPECTED_CODE = "USD";

    //Act
    Currency currency = currencyDao.findCurrencyById(EXPECTED_ID);

    //Assert
    assertEquals(Integer.valueOf(EXPECTED_ID), currency.getId());
    assertEquals(EXPECTED_CODE, currency.getCode());
  }

  @Test
  public void findCurrencyById_incorrectArg_returnNull() throws Exception {
    //Arrange
    final int ID = 1000000;

    //Act
    Currency currency = currencyDao.findCurrencyById(ID);

    //Assert
    assertNull(currency);
  }

}