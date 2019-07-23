package com.test.money.transfer.service;

import com.test.money.transfer.model.Client;
import com.test.money.transfer.validator.Validator;

import java.util.List;

/**
 * Represents methods for work with client information.
 */
public interface ClientService {

  /**
   * Insert client into the database. All checks must be carried out through the validators.
   * @param client new client
   * @param validators validators that check the new cleint
   * @return new client with filled id field.
   */
  Client create(Client client, Validator<Client>... validators);

  /**
   * Get all Clients registered in the database.
   * @return List of the all clients.
   */
  List<Client> findAll();
}
