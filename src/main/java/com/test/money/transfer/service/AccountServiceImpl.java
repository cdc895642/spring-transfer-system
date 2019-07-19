package com.test.money.transfer.service;

import com.test.money.transfer.dao.AccountMapper;
import com.test.money.transfer.exception.TransferException;
import com.test.money.transfer.model.Account;
import com.test.money.transfer.validator.Validator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.guice.transactional.Transactional;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class AccountServiceImpl implements AccountService, BaseService {

  private AccountMapper accountDao;

  @Inject
  public void setAccountDao(AccountMapper accountDao) {
    this.accountDao = accountDao;
  }

  @Transactional
  @Override
  public Account create(Account account, Validator<Account>... validators) {
    if (!check(account, validators)) {
      log.error("account is not valid : {}", account);
      throw new IllegalArgumentException("check account - something went wrong");
    }
    accountDao.create(account);
    if (account.getId() == null) {
      log.error("during the process of creation account something went wrong : {}", account);
      throw new TransferException("during the process of creating the account something went wrong");
    }
    return account;
  }

  @Transactional
  @Override
  public Account update(Account account, Validator<Account>... validators) {
    if (!check(account, validators)) {
      throw new IllegalArgumentException("check account - something went wrong");
    }
    accountDao.update(account);
    return  accountDao.findById(account.getId());
  }

  @Transactional
  @Override
  public List<Account> getAccountsByClientId(int clientId) {
    return accountDao.getAccountsByClientId(clientId);
  }
}
