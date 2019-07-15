package com.test.money.transfer.configuration;

import com.test.money.transfer.dao.ClientMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

public class MyBatisModuleImpl extends MyBatisModule {

  protected void initialize() {
    bindDataSourceProviderType(PooledDataSourceProvider.class);
    bindTransactionFactoryType(JdbcTransactionFactory.class);
    addMapperClass(ClientMapper.class);
  }
}
