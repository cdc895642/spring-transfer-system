package com.test.money.transfer.dao;

import com.test.money.transfer.model.Transfer;
import java.util.List;

public interface TransferHistoryMapper {

  void save(Transfer transfer);

  List<Transfer> findAll();
}
