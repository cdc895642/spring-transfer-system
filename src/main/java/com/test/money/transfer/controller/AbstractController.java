package com.test.money.transfer.controller;

/**
 * Base abstract class for other Controllers.
 */
public abstract class AbstractController {

    protected static final String JSON_FORMAT = "application/json";

    /**
     * Uses for describe routes for HTTP requests/responses. It must be called during the creating
     * of the controller or in other way, but before using the controller.
     */
    public abstract void init();

}
