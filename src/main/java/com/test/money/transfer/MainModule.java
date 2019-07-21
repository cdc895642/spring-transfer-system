package com.test.money.transfer;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.test.money.transfer.configuration.ControllerModule;
import com.test.money.transfer.configuration.DatabaseModule;
import com.test.money.transfer.configuration.MyBatisModuleImpl;
import java.util.Arrays;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new DatabaseModule());
        install(new ControllerModule());
        install(new MyBatisModuleImpl());
    }
}
