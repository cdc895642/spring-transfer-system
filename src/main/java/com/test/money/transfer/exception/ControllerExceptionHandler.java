package com.test.money.transfer.exception;

import com.test.money.transfer.model.Error;
import com.test.money.transfer.util.JsonConverter;
import lombok.extern.slf4j.Slf4j;
import spark.ExceptionHandler;
import spark.Request;
import spark.Response;

/**
 * Exception handler for controllers.
 */
@Slf4j
public class ControllerExceptionHandler implements ExceptionHandler<Exception> {

    private final static String JSON_TYPE = "application/json";

    @Override
    public void handle(Exception exception, Request request, Response response) {
        log.error("exception during request/response", exception);
        response.type(JSON_TYPE);
        String message = null;
        // Handle the exception here
        if (exception instanceof BadArgsException) {
            response.status(400);
            message = exception.getMessage();
        } else if (exception instanceof IllegalArgumentException) {
            response.status(400);
            message = exception.getMessage();
        } else {
            response.status(500);
            message = "some exception occurred,  please check the logs";
        }
        Error error = Error.builder().message(message).build();
        response.body(JsonConverter.convertToJson(error));
    }
}
