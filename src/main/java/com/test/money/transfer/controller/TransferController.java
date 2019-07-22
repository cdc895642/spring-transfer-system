package com.test.money.transfer.controller;

import com.test.money.transfer.filter.CheckAccountsFilter;
import com.test.money.transfer.filter.TransferFilter;
import com.test.money.transfer.model.Transfer;
import com.test.money.transfer.service.TransferService;
import com.test.money.transfer.service.TransferServiceImpl;
import com.test.money.transfer.util.JsonConverter;
import com.test.money.transfer.validator.NullValueValidatorImpl;

import javax.inject.Inject;

import static spark.Spark.get;

public class TransferController extends AbstractController {

    private TransferService transferService;
    private NullValueValidatorImpl<Transfer> nullValueValidator;
    private TransferFilter transferFilter;

    @Override
    public void init() {
        get("/transfer/", (req, resp) -> {
            resp.type(JSON_FORMAT);
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
    public void setNullValueValidator(NullValueValidatorImpl<Transfer> nullValueValidator) {
        this.nullValueValidator = nullValueValidator;
    }

    public void setTransferFilter(TransferFilter transferFilter) {
        this.transferFilter = transferFilter;
    }
}
