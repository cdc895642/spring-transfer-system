package com.test.money.transfer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String message;
}
