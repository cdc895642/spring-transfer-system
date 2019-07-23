package com.test.money.transfer.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.test.money.transfer.exception.BadArgsException;
import com.test.money.transfer.exception.TransferException;
import spark.Request;

import java.io.IOException;

/**
 * Methods for converting POJO-objects from/to Json format.
 */
public abstract class JsonConverter {

    private static ObjectMapper jsonConverter = new ObjectMapper();
    static {
        jsonConverter.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        jsonConverter.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

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
            result = jsonConverter.readValue(request.body(), clazz);
        } catch (IOException e) {
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
        try {
            return jsonConverter.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            throw new TransferException(e);
        }
    }
}
