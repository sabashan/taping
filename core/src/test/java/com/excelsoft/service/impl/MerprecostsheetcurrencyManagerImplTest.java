package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MerprecostsheetcurrencyDao;
import com.excelsoft.model.Merprecostsheetcurrency;
import com.excelsoft.model.MerprecostsheetcurrencyId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import com.excelsoft.util.ConvertUtil;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MerprecostsheetcurrencyManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MerprecostsheetcurrencyManagerImpl manager;

    @Mock
    private MerprecostsheetcurrencyDao dao;


    @Test
    public void testGetMerprecostsheetcurrency() {
        log.debug("testing get...");
        //given
        final MerprecostsheetcurrencyId id = new MerprecostsheetcurrencyId("1", ConvertUtil.getDecimal("1"),"Static", "Yen");
        final Merprecostsheetcurrency merprecostsheetcurrency = new Merprecostsheetcurrency();
        given(dao.get(id)).willReturn(merprecostsheetcurrency);

        //when
        Merprecostsheetcurrency result = manager.get(id);

        //then
        assertSame(merprecostsheetcurrency, result);
    }

   
	
	@Test
    public void testGetMerprecostsheetcurrencies() {
        log.debug("testing getAll...");
        //given
        
		final List merprecostsheetcurrencies = new ArrayList();
        given(dao.getAll()).willReturn(merprecostsheetcurrencies);

        //when
        List result = manager.getAll();

        //then
        assertSame(merprecostsheetcurrencies, result);
    }

    @Test
    public void testSaveMerprecostsheetcurrency() {
        log.debug("testing save...");

        //given
        final Merprecostsheetcurrency merprecostsheetcurrency = new Merprecostsheetcurrency();
        // enter all required fields
        


        given(dao.save(merprecostsheetcurrency)).willReturn(merprecostsheetcurrency);

        //when
        manager.save(merprecostsheetcurrency);

        //then
        verify(dao).save(merprecostsheetcurrency);
    }

    @Test
    public void testRemoveMerprecostsheetcurrency() {
        log.debug("testing remove...");

        //given
        final MerprecostsheetcurrencyId id = new MerprecostsheetcurrencyId("1", ConvertUtil.getDecimal("1"),"Static", "Yen");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}