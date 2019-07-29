package com.test.money.transfer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.test.money.transfer.configuration.DatabaseModule;
import com.test.money.transfer.configuration.MyBatisModuleImpl;
import com.test.money.transfer.dao.AccountMapper;
import com.test.money.transfer.dao.ClientMapper;
import com.test.money.transfer.dao.CurrencyMapper;
import com.test.money.transfer.dao.TransferHistoryMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class BaseIntegrationDbTest {

    private Injector injector;
    protected ClientMapper clientDao;
    protected AccountMapper accountDao;
    protected CurrencyMapper currencyDao;
    protected TransferHistoryMapper transferHistoryDao;
    private Flyway flyway;

    @Before
    public void setUp() {
        flyway = Flyway.configure()
                .dataSource("jdbc:hsqldb:mem:appmemdb", "admin", "password")
//            .dataSource("jdbc:mysql://192.168.99.1:3306/db?useSSL=false", "root", "root")
                .load();
        flyway.migrate();

        List<Module> modules = createMyBatisModule();
        injector = Guice.createInjector(modules);
        JdbcTransactionFactory transactionFactory = injector
            .getInstance(JdbcTransactionFactory.class);

        clientDao = injector.getInstance(ClientMapper.class);
        accountDao = injector.getInstance(AccountMapper.class);
        currencyDao = injector.getInstance(CurrencyMapper.class);
        transferHistoryDao = injector.getInstance(TransferHistoryMapper.class);
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
