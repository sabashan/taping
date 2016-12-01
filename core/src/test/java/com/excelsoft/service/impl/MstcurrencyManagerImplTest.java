package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstcurrencyDao;
import com.excelsoft.model.Mstcurrency;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstcurrencyManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstcurrencyManagerImpl manager;

    @Mock
    private MstcurrencyDao dao;


    @Test
    public void testGetMstcurrency() {
        log.debug("testing get...");
        //given
        final String curCode = "YURO";
        final Mstcurrency mstcurrency = new Mstcurrency();
        given(dao.get(curCode)).willReturn(mstcurrency);

        //when
        Mstcurrency result = manager.get(curCode);

        //then
        assertSame(mstcurrency, result);
    }

    
	@Test
    public void testGetMstcurrencies() {
        log.debug("testing getAll...");
        //given
        final List mstcurrencies = new ArrayList();
        given(dao.getAll()).willReturn(mstcurrencies);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstcurrencies, result);
    }

    @Test
    public void testSaveMstcurrency() {
        log.debug("testing save...");

        //given
        final Mstcurrency mstcurrency = new Mstcurrency();
        // enter all required fields
        mstcurrency.setCurName("YURO");
        mstcurrency.setCurRate(8L);
        mstcurrency.setValidUntil(new java.util.Date());
        mstcurrency.setCurCode("YURO");
        


        given(dao.save(mstcurrency)).willReturn(mstcurrency);

        //when
        manager.save(mstcurrency);

        //then
        verify(dao).save(mstcurrency);
    }

    @Test
    public void testRemoveMstcurrency() {
        log.debug("testing remove...");

        //given
        final String curCode = "YURO";
        willDoNothing().given(dao).remove(curCode);

        //when
        manager.remove(curCode);

        //then
        verify(dao).remove(curCode);
    }
}