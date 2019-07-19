package com.test.money.transfer.service;

import com.test.money.transfer.model.Transfer;
import com.test.money.transfer.validator.CheckClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.guice.transactional.Isolation;
import org.mybatis.guice.transactional.Transactional;

import java.time.LocalDateTime;

@Slf4j
public class TransferServiceImpl implements TransferService {

    private CheckClientValidator checkClientValidator;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Transfer perform(Transfer transfer) {
        if (transfer.)
        transfer.setDate(LocalDateTime.now());
        return transfer;
    }


}
