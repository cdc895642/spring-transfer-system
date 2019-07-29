package com.test.money.transfer.configuration;

import static com.google.inject.name.Names.bindProperties;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.util.Providers;
import java.util.Properties;
import org.mybatis.guice.datasource.helper.JdbcUrlAntFormatter;

/**
 * Configure DataSource fot the application.
 */
public class DatabaseModule implements Module {

    public void configure(Binder binder) {
        bindProperties(binder, createMyBatisProperties());
        binder.bindConstant().annotatedWith(Names.named("JDBC.driver")).to("org.hsqldb.jdbcDriver");
//        binder.bindConstant().annotatedWith(Names.named("JDBC.driver")).to("com.mysql.jdbc.Driver");
        binder.bind(Key.get(String.class, Names.named("JDBC.url"))).toProvider(
            Providers.guicify(new JdbcUrlAntFormatter("jdbc:hsqldb:mem:appmemdb")));
//            Providers.guicify(new JdbcUrlAntFormatter("jdbc:mysql://localhost:3306/db")));
    }

    private Properties createMyBatisProperties() {
        final Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "prod");
        myBatisProperties.setProperty("JDBC.username", "admin");
        myBatisProperties.setProperty("JDBC.password", "password");
//        myBatisProperties.setProperty("JDBC.username", "root");
//        myBatisProperties.setProperty("JDBC.password", "root");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");
        return myBatisProperties;
    }
}
