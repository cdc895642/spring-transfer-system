package com.test.money.transfer.dao;

import static org.junit.Assert.*;

import com.test.money.transfer.BaseIntegrationDbTest;
import com.test.money.transfer.model.Client;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Test;

import java.util.List;

public class ClientMapperDbTest extends BaseIntegrationDbTest {

    @Test
    public void create_insertRecord_returnNewId() {
        //Arrange
        Client firstClient = new Client();
        firstClient.setName("first1");
        firstClient.setEmail("a@email.com");

        //Act
        clientDao.create(firstClient);

        //Arrange
        assertNotNull(firstClient.getId());
    }

    @Test(expected = PersistenceException.class)
    public void create_insert2RecordsTheSameEmail_throwException() {
        //Arrange
        Client firstClient = new Client();
        firstClient.setName("first1");
        firstClient.setEmail("a@email.com");
        Client secondClient = new Client();
        secondClient.setName("second1");
        secondClient.setEmail("a@email.com");

        //Act
        clientDao.create(firstClient);
        clientDao.create(secondClient);
    }

    @Test
    public void findAll_returnNotEmptyResult() {
        // Arrange
        final int NOT_EXPECTED_RESULT = 0;
        //create record in table
        Client firstClient = new Client();
        firstClient.setName("first1");
        firstClient.setEmail("a@email.com");
        clientDao.create(firstClient);

        //Act
        List<Client> allClients = clientDao.findAll();

        //Assert
        assertNotEquals(NOT_EXPECTED_RESULT, allClients.size());
    }

    @Test
    public void findById_correctId_returnResult() {
        //Arrange
        int EXPECTED_CLIENT_ID = 1;

        //Act
        Client result = clientDao.findById(EXPECTED_CLIENT_ID);

        //Assert
        assertEquals(new Integer(EXPECTED_CLIENT_ID), result.getId());
    }

    @Test
    public void findById_incorrectId_returnNull() {
        //Arrange
        int EXPECTED_CLIENT_ID = 100000000;

        //Act
        Client result = clientDao.findById(EXPECTED_CLIENT_ID);

        //Assert
        assertNull(result);
    }

}