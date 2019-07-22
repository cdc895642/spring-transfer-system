package com.test.money.transfer.dao;

import com.test.money.transfer.model.Transfer;
import java.util.List;

/**
 * Operations with history of the transfers.
 */
public interface TransferHistoryMapper {

  /**
   * Save transfer in the history.
   *
   * @param transfer Transfer for save.
   */
  void save(Transfer transfer);

  /**
   * Get all transfers from the database.
   * @return List of the transfers.
   */
  List<Transfer> findAll();
}
