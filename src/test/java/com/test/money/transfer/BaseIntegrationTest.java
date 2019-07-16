package com.test.money.transfer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.test.money.transfer.configuration.DatabaseModule;
import com.test.money.transfer.configuration.MyBatisModuleImpl;
import com.test.money.transfer.dao.AccountMapper;
import com.test.money.transfer.dao.ClientMapper;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class BaseIntegrationTest {

    private Injector injector;
    protected ClientMapper clientDao;
    protected AccountMapper accountDao;
    private Flyway flyway;

    @Before
    public void setUp() {
        flyway = Flyway.configure()
                .dataSource("jdbc:hsqldb:mem:appmemdb", "admin", "password")
                .load();
        flyway.migrate();

        List<Module> modules = createMyBatisModule();
        injector = Guice.createInjector(modules);
        clientDao = injector.getInstance(ClientMapper.class);
        accountDao = injector.getInstance(AccountMapper.class);
    }

    @After
    public void tearDown() {
        flyway.clean();
    }

    private List<Module> createMyBatisModule() {
        List<Module> modules = new ArrayList<>();
        modules.add(new DatabaseModule());
        modules.add(new MyBatisModuleImpl());

        return modules;
    }
}
