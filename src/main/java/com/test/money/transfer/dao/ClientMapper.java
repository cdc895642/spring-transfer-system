package com.test.money.transfer.dao;

import com.test.money.transfer.model.Client;
import java.util.List;

/**
 * Operations with clients.
 */
public interface ClientMapper {

  /**
   * Create new client.
   *
   * @param client Object with info about new client.
   */
  void create(Client client);

  /**
   * Get all clients from the database.
   * @return List of the clients.
   */
  List<Client> findAll();

  /**
   * Get client by it id.
   * @param id Id of the client.
   * @return Client or null if client with this id is not exist.
   */
  Client findById(int id);
}
