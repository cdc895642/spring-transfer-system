package com.test.money.transfer.service;

import com.test.money.transfer.model.Client;
import java.util.List;

public interface ClientService {

  Client save(Client client);

  List<Client> findAll();
}
