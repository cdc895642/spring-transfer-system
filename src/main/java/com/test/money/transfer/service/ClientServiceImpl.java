package com.test.money.transfer.service;

import com.test.money.transfer.dao.ClientMapper;
import com.test.money.transfer.model.Client;
import com.test.money.transfer.validator.Validator;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.guice.transactional.Transactional;

import javax.inject.Inject;
import java.util.List;

@Slf4j
public class ClientServiceImpl implements ClientService, BaseService {

    private ClientMapper clientDao;

    @Inject
    public void setClientDao(ClientMapper clientDao) {
        this.clientDao = clientDao;
    }

    @Transactional
    @Override
    public Client create(Client client, Validator<Client>... validators) {
        if (!check(client, validators)) {
            log.error("client is exist or is not valid : {}", client);
            throw new IllegalArgumentException("check client - something went wrong");
        }
        clientDao.create(client);
        return client;
    }

    @Transactional
    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }
}
