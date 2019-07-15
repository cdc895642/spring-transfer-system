package com.test.money.transfer.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Transfer {

  @Setter
  private Integer id;
  private final Account from;
  private final Account to;
  private final BigDecimal amount;
  @Setter
  private Date date;
  @Setter
  private boolean finished = false;
}
