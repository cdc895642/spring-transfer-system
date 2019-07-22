package com.test.money.transfer.service;

import com.test.money.transfer.validator.Validator;

public interface BaseService {

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
