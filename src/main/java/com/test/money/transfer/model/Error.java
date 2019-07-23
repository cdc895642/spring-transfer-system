package com.test.money.transfer.model;

import lombok.Builder;
import lombok.Data;

/**
 * Represent error message that is returned to the user in case of an exception.
 */
@Data
@Builder
public class Error {
    /**
     * Message for the user.
     */
    private String message;
}
