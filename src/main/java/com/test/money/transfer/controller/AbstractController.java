package com.test.money.transfer.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.test.money.transfer.exception.TypeConverterException;
import spark.Request;

public abstract class AbstractController {

    protected Gson jsonConverter = new Gson();

    public abstract void init();

    protected <T> T getRequestBody(Request request, Class<T> clazz) {
        T result = null;
        try {
            result = jsonConverter.fromJson(request.body(), clazz);
        } catch (JsonSyntaxException e) {
            throw new TypeConverterException("request body is not a valid json object", e);
        }
        return result;
    }
}
