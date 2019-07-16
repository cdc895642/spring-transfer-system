package com.test.money.transfer.dao;

import com.test.money.transfer.model.Client;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface ClientMapper {

  void create(Client client);

  List<Client> findAll();
}
