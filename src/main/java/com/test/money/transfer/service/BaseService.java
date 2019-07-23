package com.test.money.transfer.service;

import com.test.money.transfer.validator.Validator;

/**
 * Base interface for services.
 */
public interface BaseService {

  /**
   * Runs the validators if they exist.
   * @param input Object for checks.
   * @param validators Array of the validators.
   * @param <T> Type of the object for check.
   * @return False if input object failed validation, true - otherwise.
   */
  default <T> boolean check(T input, Validator<T>... validators) {
    if (validators != null) {
      for (Validator<T> validator : validators) {
        if (!validator.validate(input)) {
          return false;
        }
      }
    }
    return true;
  }


}
