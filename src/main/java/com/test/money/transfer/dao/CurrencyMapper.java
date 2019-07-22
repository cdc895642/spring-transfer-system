package com.test.money.transfer.dao;

import com.test.money.transfer.model.Currency;
import java.util.List;

/**
 * Operations with currencies.
 */
public interface CurrencyMapper {

  /**
   * Get id of the currency by it code.
   *
   * @param code Code of the currency (USD, EUR, etc)
   * @return Id of the currency.
   */
  Integer findIdByCurrencyCode(String code);

  /**
   * Get currency by it id.
   * @param id Id of the currency.
   * @return Currency or null if currency with such id is not exist.
   */
  Currency findCurrencyById(int id);

  /**
   * Create new currency.
   * @param currency New currency.
   */
  void create(Currency currency);

  /**
   * Get all currencies from the database.
   * @return List of the currencies.
   */
  List<Currency> findAll();

}
