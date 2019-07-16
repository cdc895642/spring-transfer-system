package com.test.money.transfer.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {

  @Setter
  private Integer id;
  @Setter
  private Client client;
  @Setter
  private Currency currency;
  @Setter
  private BigDecimal balance;

  public Account(Integer id, Currency currency, BigDecimal balance) {
    this.id = id;
    this.currency = currency;
    this.balance = balance;
  }
}
