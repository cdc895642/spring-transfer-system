package com.test.money.transfer.dao;

import static org.junit.Assert.*;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.test.money.transfer.configuration.DatabaseModule;
import com.test.money.transfer.configuration.MyBatisModuleImpl;
import com.test.money.transfer.model.Client;
import java.util.ArrayList;
import java.util.List;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;

public class ClientMapperTest {

  private Injector injector;

  @Before
  public void setUp() throws Exception {
    Flyway.configure()
        .dataSource("jdbc:hsqldb:mem:appmemdb", "admin", "password")
        .load()
        .migrate();

    List<Module> modules = createMyBatisModule();
    injector = Guice.createInjector(modules);
  }

  private List<Module> createMyBatisModule() {
    List<Module> modules = new ArrayList<>();
    modules.add(new DatabaseModule());
    modules.add(new MyBatisModuleImpl());

    return modules;
  }

  @Test
  public void create() throws Exception {
    Client firstClient = new Client();
    firstClient.setFirstName("first1");
    firstClient.setLastName("last1");
    ClientMapper clientDao = injector.getInstance(ClientMapper.class);
    clientDao.create(firstClient);
    firstClient.setLastName("last2");
    clientDao.create(firstClient);
    List<Client> all = clientDao.findAll();
    all.size();
    Client client = all.get(0);
    client.getFirstName();
  }

  @Test
  public void findAll() throws Exception {
  }

}