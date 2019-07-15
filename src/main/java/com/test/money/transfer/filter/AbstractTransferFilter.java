package com.test.money.transfer.filter;

import com.test.money.transfer.model.Transfer;

public abstract class AbstractTransferFilter implements TransferFilter {

  private TransferFilter nextFilter;

  public TransferFilter linkWith(TransferFilter nextFilter) {
    this.nextFilter = nextFilter;
    return nextFilter;
  }

  public boolean doNextFilter(Transfer transfer) {
    if (nextFilter == null) {
      return true;
    }
    return nextFilter.doFilter(transfer);
  }
}
