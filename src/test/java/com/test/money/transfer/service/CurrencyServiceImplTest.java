package com.test.money.transfer.service;

import com.test.money.transfer.dao.CurrencyMapper;
import com.test.money.transfer.model.Currency;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CurrencyServiceImplTest {

    @Mock
    private CurrencyMapper currencyDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll__returnList() {
        //Arrange
        when(currencyDao.findAll()).thenReturn(new ArrayList<>());
        CurrencyServiceImpl currencyService = new CurrencyServiceImpl();
        currencyService.setCurrencyDao(currencyDao);

        //Act
        List<Currency> result = currencyService.findAll();

        //Assert
        assertNotNull(result);
    }

    @Test
    public void create_correctInput_returnNewCurrency() {
        //Arrange
        int currencyId = 1;
        Currency currency = new Currency();
        currency.setId(1);
        CurrencyServiceImpl currencyService = new CurrencyServiceImpl();
        currencyService.setCurrencyDao(currencyDao);

        //Act
        Currency result = currencyService.create(currency);

        //Assert
        assertEquals(currency, result);
    }
}