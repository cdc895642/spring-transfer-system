package com.test.money.transfer.dao;

import com.test.money.transfer.model.Client;
import java.util.List;

public interface ClientMapper {

  void create(Client client);

  List<Client> findAll();

  Client findById(int id);
}
