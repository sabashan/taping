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

import com.excelsoft.dao.MercostsheetcountryDao;
import com.excelsoft.model.Mercostsheetcountry;
import com.excelsoft.model.MercostsheetcountryId;

public class MercostsheetcountryManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetcountryManagerImpl manager;

    @Mock
    private MercostsheetcountryDao dao;


    @Test
    public void testGetMercostsheetcountry() {
        log.debug("testing get...");
        //given
        final MercostsheetcountryId id = new MercostsheetcountryId();
        final Mercostsheetcountry mercostsheetcountry = new Mercostsheetcountry();
        given(dao.get(id)).willReturn(mercostsheetcountry);

        //when
        Mercostsheetcountry result = manager.get(id);

        //then
        assertSame(mercostsheetcountry, result);
    }

    @Test
    public void testGetMercostsheetcountries() {
        log.debug("testing getAll...");
        //given
        final List mercostsheetcountries = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetcountries);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetcountries, result);
    }

    @Test
    public void testSaveMercostsheetcountry() {
        log.debug("testing save...");

        //given
        final Mercostsheetcountry mercostsheetcountry = new Mercostsheetcountry();
        // enter all required fields
        


        given(dao.save(mercostsheetcountry)).willReturn(mercostsheetcountry);

        //when
        manager.save(mercostsheetcountry);

        //then
        verify(dao).save(mercostsheetcountry);
    }

    @Test
    public void testRemoveMercostsheetcountry() {
        log.debug("testing remove...");

        //given
        final MercostsheetcountryId id = new MercostsheetcountryId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}