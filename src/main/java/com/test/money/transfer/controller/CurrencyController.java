package com.test.money.transfer.controller;

import static spark.Spark.get;
import static spark.Spark.post;

import com.test.money.transfer.model.Currency;
import com.test.money.transfer.service.CurrencyService;
import com.test.money.transfer.util.JsonConverter;
import com.test.money.transfer.validator.NullValueValidatorImpl;

import javax.inject.Inject;

public class CurrencyController extends AbstractController {

    private CurrencyService currencyService;
    private NullValueValidatorImpl<Currency> nullValueValidator;

    public CurrencyController() {
        init();
    }

    @Override
    public void init() {
        get("/currencies", (req, resp) -> {
            resp.type(JSON_FORMAT);
            return currencyService.findAll();
        }, JsonConverter::convertToJson);

        post("/currencies", (req, resp) -> {
            Currency currency = JsonConverter.convertFromJson(req, Currency.class);
            resp.type(JSON_FORMAT);
            return currencyService.create(currency, nullValueValidator);
        }, JsonConverter::convertToJson);

    }

    @Inject
    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Inject
    public void setNullValueValidator(NullValueValidatorImpl<Currency> nullValueValidator) {
        this.nullValueValidator = nullValueValidator;
    }
}
