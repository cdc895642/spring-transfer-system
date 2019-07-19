package com.test.money.transfer.service;

import com.test.money.transfer.dao.ClientMapper;
import com.test.money.transfer.model.Client;
import com.test.money.transfer.validator.Validator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class ClientServiceImplTest {

    @Mock
    private ClientMapper clientDao;
    @Mock
    private Validator<Client> validator;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IllegalArgumentException.class)
    public void save_notValidClient_throwException() {
        //Arrange
        int clientId = 1;
        when(validator.validate(any())).thenReturn(false);
        Client client = new Client();
        client.setId(clientId);
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao);

        //Act
        clientService.create(client, validator);
    }

    @Test
    public void save_validClient_returnClient() {
        //Arrange
        int clientId = 1;
        when(validator.validate(any())).thenReturn(true);
        Client client = new Client();
        client.setId(clientId);
        doNothing().when(clientDao).create(client);
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao);

        //Act
        Client result = clientService.create(client, validator);

        //Assert
        assertEquals(client, result);
    }

    @Test
    public void findAll_returnList() {
        //Arrange
        when(clientDao.findAll()).thenReturn(new ArrayList<>());
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao);

        //Act
        List<Client> result = clientService.findAll();

        //Assert
        assertNotNull(result);
    }
}