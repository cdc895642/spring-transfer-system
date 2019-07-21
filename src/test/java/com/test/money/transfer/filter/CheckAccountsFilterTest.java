package com.test.money.transfer.filter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Currency;
import com.test.money.transfer.model.Transfer;
import com.test.money.transfer.service.AccountService;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CheckAccountsFilterTest {

    @Mock
    private AccountService accountService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doFilter_correctTransfer_returnTrue() {
        //Arrange
        Currency currencyFrom = new Currency();
        currencyFrom.setCode("USD");
        currencyFrom.setId(1);
        Currency currencyTo = new Currency();
        currencyTo.setCode("USD");
        currencyTo.setId(1);
        BigDecimal amount = BigDecimal.ONE;
        Account from = new Account();
        from.setId(1);
        BigDecimal fromBalance = BigDecimal.TEN;
        from.setBalance(fromBalance);
        from.setCurrency(currencyFrom);
        Account to = new Account();
        to.setId(2);
        to.setCurrency(currencyTo);
        Transfer transfer = new Transfer();
        transfer.setFrom(from);
        transfer.setTo(to);
        transfer.setAmount(amount);
        CheckAccountsFilter filter = new CheckAccountsFilter();
        filter.setAccountService(accountService);
        when(accountService.findById(1)).thenReturn(from);
        when(accountService.findById(2)).thenReturn(to);

        //Act
        boolean result = filter.doFilter(transfer);

        //Assert
        assertTrue(result);
    }

    @Test
    public void doFilter_notEnoughMoneyFromAccount_returnFalse() {
        //Arrange
        Currency currencyFrom = new Currency();
        currencyFrom.setCode("USD");
        currencyFrom.setId(1);
        Currency currencyTo = new Currency();
        currencyTo.setCode("USD");
        currencyTo.setId(1);
        BigDecimal amount = BigDecimal.ONE;
        Account from = new Account();
        from.setId(1);
        BigDecimal fromBalance = BigDecimal.ZERO;
        from.setBalance(fromBalance);
        from.setCurrency(currencyFrom);
        Account to = new Account();
        to.setId(2);
        to.setCurrency(currencyTo);
        Transfer transfer = new Transfer();
        transfer.setFrom(from);
        transfer.setTo(to);
        transfer.setAmount(amount);
        CheckAccountsFilter filter = new CheckAccountsFilter();
        filter.setAccountService(accountService);
        when(accountService.findById(1)).thenReturn(from);
        when(accountService.findById(2)).thenReturn(to);

        //Act
        boolean result = filter.doFilter(transfer);

        //Assert
        assertFalse(result);
    }

    @Test
    public void doFilter_diffCurrencies_returnFalse() {
        //Arrange
        Currency currencyFrom = new Currency();
        currencyFrom.setCode("USD");
        currencyFrom.setId(1);
        Currency currencyTo = new Currency();
        currencyTo.setCode("EUR");
        currencyTo.setId(2);
        BigDecimal amount = BigDecimal.ONE;
        Account from = new Account();
        from.setId(1);
        from.setCurrency(currencyFrom);
        Account to = new Account();
        to.setId(2);
        to.setCurrency(currencyTo);
        Transfer transfer = new Transfer();
        transfer.setFrom(from);
        transfer.setTo(to);
        transfer.setAmount(amount);
        CheckAccountsFilter filter = new CheckAccountsFilter();
        filter.setAccountService(accountService);
        when(accountService.findById(1)).thenReturn(from);
        when(accountService.findById(2)).thenReturn(to);

        //Act
        boolean result = filter.doFilter(transfer);

        //Assert
        assertFalse(result);
    }

    @Test
    public void doFilter_accountsAreTheSame_returnFalse() {
        //Arrange
        int accountId = 1;
        BigDecimal amount = BigDecimal.ONE;
        Account from = new Account();
        from.setId(accountId);
        Account to = new Account();
        to.setId(accountId);
        Transfer transfer = new Transfer();
        transfer.setFrom(from);
        transfer.setTo(to);
        transfer.setAmount(amount);
        CheckAccountsFilter filter = new CheckAccountsFilter();
        filter.setAccountService(accountService);
        when(accountService.findById(accountId)).thenReturn(from).thenReturn(to);

        //Act
        boolean result = filter.doFilter(transfer);

        //Assert
        assertFalse(result);
    }

    @Test
    public void doFilter_accountIsNull_returnFalse() {
        //Arrange
        CheckAccountsFilter filter = new CheckAccountsFilter();
        filter.setAccountService(accountService);
        Transfer transfer = new Transfer();
        BigDecimal amount = BigDecimal.ONE;
        transfer.setAmount(amount);

        //Act
        boolean result = filter.doFilter(transfer);

        //Assert
        assertFalse(result);
    }

    @Test
    public void doFilter_accountIdIsNull_returnFalse() {
        //Arrange
        CheckAccountsFilter filter = new CheckAccountsFilter();
        filter.setAccountService(accountService);
        Transfer transfer = new Transfer();
        Account from = new Account();
        Account to = new Account();
        transfer.setFrom(from);
        transfer.setTo(to);
        BigDecimal amount = BigDecimal.ONE;
        transfer.setAmount(amount);

        //Act
        boolean result = filter.doFilter(transfer);

        //Assert
        assertFalse(result);
    }

    @Test
    public void doFilter_ammountIsNull_returnFalse() {
        //Arrange
        int amountId = 1;
        CheckAccountsFilter filter = new CheckAccountsFilter();
        filter.setAccountService(accountService);
        Transfer transfer = new Transfer();
        Account from = new Account();
        Account to = new Account();
        transfer.setFrom(from);
        transfer.setTo(to);
        from.setId(amountId);
        to.setId(amountId);

        //Act
        boolean result = filter.doFilter(transfer);

        //Assert
        assertFalse(result);
    }

}