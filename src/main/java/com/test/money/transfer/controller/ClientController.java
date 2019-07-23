package com.test.money.transfer.controller;

import com.test.money.transfer.model.Client;
import com.test.money.transfer.service.ClientService;
import com.test.money.transfer.util.JsonConverter;
import com.test.money.transfer.validator.NotNullValueValidatorImpl;

import javax.inject.Inject;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Rest-Controller for operations with clients.
 */
public class ClientController extends AbstractController {

    private ClientService clientService;
    private NotNullValueValidatorImpl<Client> nullValueValidator;

    public ClientController() {
        init();
    }

    @Override
    public void init() {
        get("/clients", (req, resp) -> {
            resp.type(JSON_FORMAT);
            return clientService.findAll();
        }, JsonConverter::convertToJson);

        post("/clients", (req, resp) -> {
            Client client = JsonConverter.convertFromJson(req, Client.class);
            resp.type(JSON_FORMAT);
            resp.status(201);
            return clientService.create(client, nullValueValidator);
        }, JsonConverter::convertToJson);
    }

    @Inject
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Inject
    public void setNullValueValidator(NotNullValueValidatorImpl<Client> nullValueValidator) {
        this.nullValueValidator = nullValueValidator;
    }
}
