package com.test.money.transfer;

import com.google.inject.Guice;
import java.util.Arrays;
import org.flywaydb.core.Flyway;

public class TransferApplication {

  public static void main(String[] args) {
    Flyway flyway = Flyway.configure()
        .dataSource("jdbc:hsqldb:mem:appmemdb", "admin", "password")
        .load();
    flyway.migrate();

    Guice.createInjector(Arrays.asList(new MainModule()));
  }
}
