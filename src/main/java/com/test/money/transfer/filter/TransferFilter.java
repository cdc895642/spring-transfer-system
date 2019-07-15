package com.test.money.transfer.filter;

import com.test.money.transfer.model.Transfer;

public interface TransferFilter {

  boolean doFilter(Transfer transfer);

  TransferFilter linkWith(TransferFilter nextFilter);

}
