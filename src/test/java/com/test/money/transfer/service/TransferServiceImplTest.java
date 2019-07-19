package com.test.money.transfer.service;

import com.test.money.transfer.model.Transfer;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferServiceImplTest {

    @Test(expected = IllegalArgumentException.class)
    public void perform_AccountsAreInvalid_throwException() {
        //Arrange
        Transfer transfer = new Transfer();
        TransferServiceImpl transferService = new TransferServiceImpl();

        //Act
        Transfer result = transferService.perform(transfer);

        //Assert
        assertNotNull(result.getDate());
    }

    @Test
    public void perform_correctTransfer_returnTransferWithCurrenDate() {
        //Arrange
        Transfer transfer = new Transfer();
        TransferServiceImpl transferService = new TransferServiceImpl();

        //Act
        Transfer result = transferService.perform(transfer);

        //Assert
        assertNotNull(result.getDate());
    }
}