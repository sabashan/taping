package com.excelsoft.service.impl;

import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.excelsoft.dao.MercostsheetcurrencyDao;
import com.excelsoft.model.Mercostsheetcurrency;
import com.excelsoft.model.MercostsheetcurrencyId;

public class MercostsheetcurrencyManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetcurrencyManagerImpl manager;

    @Mock
    private MercostsheetcurrencyDao dao;


    @Test
    public void testGetMercostsheetcurrency() {
        log.debug("testing get...");
        //given
        final MercostsheetcurrencyId id = new MercostsheetcurrencyId();
        final Mercostsheetcurrency mercostsheetcurrency = new Mercostsheetcurrency();
        given(dao.get(id)).willReturn(mercostsheetcurrency);

        //when
        Mercostsheetcurrency result = manager.get(id);

        //then
        assertSame(mercostsheetcurrency, result);
    }

    @Test
    public void testGetMercostsheetcurrencies() {
        log.debug("testing getAll...");
        //given
        final List mercostsheetcurrencies = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetcurrencies);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetcurrencies, result);
    }

    @Test
    public void testSaveMercostsheetcurrency() {
        log.debug("testing save...");

        //given
        final Mercostsheetcurrency mercostsheetcurrency = new Mercostsheetcurrency();
        // enter all required fields
        


        given(dao.save(mercostsheetcurrency)).willReturn(mercostsheetcurrency);

        //when
        manager.save(mercostsheetcurrency);

        //then
        verify(dao).save(mercostsheetcurrency);
    }

    @Test
    public void testRemoveMercostsheetcurrency() {
        log.debug("testing remove...");

        //given
        final MercostsheetcurrencyId id = new MercostsheetcurrencyId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}