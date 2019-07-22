package com.test.money.transfer.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.test.money.transfer.exception.BadArgsException;
import spark.Request;

public abstract class JsonConverter {

    private static Gson jsonConverter = new Gson();

    public static <T> T convertFromJson(Request request, Class<T> clazz) {
        T result = null;
        try {
            result = jsonConverter.fromJson(request.body(), clazz);
        } catch (JsonSyntaxException e) {
            throw new BadArgsException("request body is not a valid json object", e);
        }
        return result;
    }

    public static String convertToJson(Object input) {
        return jsonConverter.toJson(input);
    }
}
