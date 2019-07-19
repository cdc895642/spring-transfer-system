package com.test.money.transfer.service;

import com.test.money.transfer.model.Client;
import com.test.money.transfer.validator.Validator;

import java.util.List;

public interface ClientService {

  /**
   * Insert client into the database. All checks must be carried out through the validators.
   * @param client new client
   * @param validators validators that check the new cleint
   * @return new client with filled id field.
   */
  Client create(Client client, Validator<Client>... validators);

  List<Client> findAll();
}
