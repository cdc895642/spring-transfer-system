package com.test.money.transfer.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private Integer id;
    private Client client;
    private Currency currency;
    private BigDecimal balance;

}
