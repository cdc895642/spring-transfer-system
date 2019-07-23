package com.test.money.transfer.controller;

import com.test.money.transfer.filter.TransferFilter;
import com.test.money.transfer.model.Transfer;
import com.test.money.transfer.service.TransferService;
import com.test.money.transfer.util.JsonConverter;
import com.test.money.transfer.validator.NotNullValueValidatorImpl;

import javax.inject.Inject;

import static spark.Spark.post;

/**
 * Rest-Controller for transfers money between accounts of the clients.
 */
public class TransferController extends AbstractController {

    private TransferService transferService;
    private NotNullValueValidatorImpl<Transfer> nullValueValidator;
    private TransferFilter transferFilter;

    @Override
    public void init() {
        post("/transfers", (req, resp) -> {
            resp.type(JSON_FORMAT);
            resp.status(201);
            return transferService.perform(new Transfer());
        }, JsonConverter::convertToJson);
    }

    public TransferController() {
        init();
    }

    @Inject
    public void setTransferService(TransferService transferService) {
        this.transferService = transferService;
    }

    @Inject
    public void setNullValueValidator(NotNullValueValidatorImpl<Transfer> nullValueValidator) {
        this.nullValueValidator = nullValueValidator;
    }

    @Inject
    public void setTransferFilter(TransferFilter transferFilter) {
        this.transferFilter = transferFilter;
    }
}
