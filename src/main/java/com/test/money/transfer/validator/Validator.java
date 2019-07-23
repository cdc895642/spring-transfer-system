package com.test.money.transfer.validator;

/**
 * Base interface for validators.
 * @param <T> Type of the input object for validation.
 */
public interface Validator<T> {

  /**
   * Validate input object.
   * @param input Input object for validation.
   * @return True if input object is valid, false - otherwise.
   */
  boolean validate(T input);
}
