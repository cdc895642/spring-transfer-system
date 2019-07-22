package com.test.money.transfer.controller;

import com.test.money.transfer.exception.ControllerExceptionHandler;
import com.test.money.transfer.model.Error;
import com.test.money.transfer.util.JsonConverter;

import javax.inject.Singleton;

import static spark.Spark.exception;
import static spark.Spark.notFound;

@Singleton
public class FrontController extends AbstractController {

    private ControllerExceptionHandler exceptionHandler = new ControllerExceptionHandler();

    public FrontController() {
        init();
    }

    @Override
    public void init() {
        exception(Exception.class, exceptionHandler);
        notFound(JsonConverter.convertToJson(
                Error
                        .builder()
                        .message("unsupported operation")
                        .build()));
    }
}
