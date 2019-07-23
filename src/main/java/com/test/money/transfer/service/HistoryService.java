package com.test.money.transfer.service;

import com.test.money.transfer.model.Transfer;
import java.util.List;

/**
 * Contains methods for work with history of the transfers.
 */
public interface HistoryService {

  /**
   * Get all transfers from the database.
   * @return List of the all transfers.
   */
  List<Transfer> findAll();

  /**
   * Save in the database information about the proceeded transfer.
   * @param transfer Proceeded transfer.
   * @return Saved transfer.
   */
  Transfer save(Transfer transfer);

}
