package com.test.money.transfer.model;

import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Account {

  @Setter
  private Integer id;
  private final Client client;
  private final Currency currency;
  @Setter
  private BigDecimal balance;
}
