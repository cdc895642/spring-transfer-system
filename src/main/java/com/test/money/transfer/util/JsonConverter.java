package com.test.money.transfer.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.test.money.transfer.exception.BadArgsException;
import spark.Request;

/**
 * Methods for converting POJO-objects from/to Json format.
 */
public abstract class JsonConverter {

    private static Gson jsonConverter = new Gson();

    /**
     * Convert request body in json format to POJO-object.
     * @param request Request for processing.
     * @param clazz Class of the POJO-object.
     * @param <T> Type of the POJO-object.
     * @return Created from Json  POJO-object.
     */
    public static <T> T convertFromJson(Request request, Class<T> clazz) {
        T result = null;
        try {
            result = jsonConverter.fromJson(request.body(), clazz);
        } catch (JsonSyntaxException e) {
            throw new BadArgsException("request body is not a valid json object", e);
        }
        return result;
    }

    /**
     * Convert input object to Json-string.
     * @param input Object for converting.
     * @return Json-string.
     */
    public static String convertToJson(Object input) {
        return jsonConverter.toJson(input);
    }
}
