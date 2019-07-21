package com.test.money.transfer.controller;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;
import com.test.money.transfer.dao.CurrencyMapper;
import com.test.money.transfer.exception.TypeConverterException;
import com.test.money.transfer.model.Currency;
import javax.inject.Inject;

public class CurrencyController extends AbstractController {

    private CurrencyMapper currencyMapper;
    private static final String JSON_FORMAT = "application/json";

    public CurrencyController() {
        init();
    }

    @Override
    public void init() {
        get("/currencies", (req, resp) -> {
            resp.type(JSON_FORMAT);
            return currencyMapper.findAll();
        }, jsonConverter::toJson);

        post("/currencies", (req, resp) -> {
            Currency currency = getRequestBody(req, Currency.class);
            resp.type("application/json");
            return currencyMapper.findAll();
        }, jsonConverter::toJson);

        exception(Exception.class, (exception, request, response) -> {
            response.type("application/json");
            // Handle the exception here
            if (exception instanceof TypeConverterException) {
                response.status(410);
            }
//            response.status(400);
            response.body("{\"message\":\"" + exception.getMessage() + "\"}");

        });
    }

    @Inject
    public void setCurrencyMapper(CurrencyMapper currencyMapper) {
        this.currencyMapper = currencyMapper;
    }
}
