package com.test.money.transfer.filter;

import com.test.money.transfer.model.Transfer;

/**
 * Base interface for transfer filters.
 */
public interface TransferFilter {

  /**
   * Perform some operation with transfer before the process of the transfer.
   *
   * @param transfer Transfer which will be processed after filters.
   * @return True - if filter/s is/are finished correctly, and false in opposite case.
   */
  boolean doFilter(Transfer transfer);

  /**
   * Use for link with other filter.
   * @param nextFilter Next filter which will be used in the chain of the filters.
   * @return Next filter.
   */
  TransferFilter linkWith(TransferFilter nextFilter);

}
