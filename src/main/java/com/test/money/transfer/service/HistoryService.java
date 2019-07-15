package com.test.money.transfer.service;

import com.test.money.transfer.model.Transfer;
import java.util.List;

public interface HistoryService {

  List<Transfer> findAll();

  Transfer save(Transfer transfer);

}
