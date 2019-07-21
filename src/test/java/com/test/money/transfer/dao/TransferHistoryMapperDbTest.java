package com.test.money.transfer.dao;

import com.test.money.transfer.BaseIntegrationDbTest;
import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Transfer;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class TransferHistoryMapperDbTest extends BaseIntegrationDbTest {

    @Test
    public void save_correctInput_saveRocrd() {
        //Arrange
        Transfer transfer = new Transfer();
        Account from = new Account();
        from.setId(1);
        transfer.setFrom(from);
        Account to =new Account();
        to.setId(2);
        transfer.setTo(to);
        LocalDateTime date = LocalDateTime.now();
        transfer.setDate(date);
        transfer.setFinished(true);
        BigDecimal amount = new BigDecimal(10).setScale(2);
        transfer.setAmount(amount);

        //Act
        transferHistoryDao.save(transfer);

        //Assert
        assertNotNull(transfer.getId());
    }

    @Test
    public void findAll__returnList() {
        //Arrange
        final int NOT_EXPECTED_SIZE = 0;
        List<Transfer> transfers = transferHistoryDao.findAll();

        //Assert
        assertNotEquals(NOT_EXPECTED_SIZE, transfers.size());
    }
}