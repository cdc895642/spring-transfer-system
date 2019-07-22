package com.test.money.transfer;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.test.money.transfer.configuration.*;

import java.util.Arrays;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ValidatorModule());
        install(new FilterModule());
        install(new DatabaseModule());
        install(new ControllerModule());
        install(new MyBatisModuleImpl());
        install(new ServiceModule());
    }
}
