package com.test.money.transfer.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Transfer {

  private Integer id;
  private Account from;
  private Account to;
  private BigDecimal amount;
  private Date date;
  private boolean finished = false;
}
