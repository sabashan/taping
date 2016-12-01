package com.excelsoft.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.excelsoft.dao.MstsmvvoulmeratesDao;
import com.excelsoft.model.Mstsmvvoulmerates;
import com.excelsoft.model.MstsmvvoulmeratesId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.util.DateUtil;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MstsmvvoulmeratesManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstsmvvoulmeratesManagerImpl manager;

    @Mock
    private MstsmvvoulmeratesDao dao;


    @Test
    public void testGetMstsmvvoulmerates() {
        log.debug("testing get...");
        //given
       Date frmdate= DateUtil.getdate("2012-01-01");
       Date tomdate= DateUtil.getdate("2012-12-31");
       BigDecimal toVol=ConvertUtil.getDecimal("1.000000");
        final MstsmvvoulmeratesId id = new MstsmvvoulmeratesId("ASDA", frmdate, tomdate, "1",toVol , toVol);
        final Mstsmvvoulmerates mstsmvvoulmerates = new Mstsmvvoulmerates();
        given(dao.get(id)).willReturn(mstsmvvoulmerates);

        //when
        Mstsmvvoulmerates result = manager.get(id);

        //then
        assertSame(mstsmvvoulmerates, result);
    }

   
	@Test
    public void testGetMstsmvvoulmeratess() {
        log.debug("testing getAll...");
        //given
        final List mstsmvvoulmeratess = new ArrayList();
        given(dao.getAll()).willReturn(mstsmvvoulmeratess);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstsmvvoulmeratess, result);
    }

    @Test
    public void testSaveMstsmvvoulmerates() {
        log.debug("testing save...");

        //given
        final Mstsmvvoulmerates mstsmvvoulmerates = new Mstsmvvoulmerates();
        // enter all required fields
        


        given(dao.save(mstsmvvoulmerates)).willReturn(mstsmvvoulmerates);

        //when
        manager.save(mstsmvvoulmerates);

        //then
        verify(dao).save(mstsmvvoulmerates);
    }

    @Test
    public void testRemoveMstsmvvoulmerates() {
        log.debug("testing remove...");

        //given
        Date frmdate= DateUtil.getdate("2012-01-01");
        Date tomdate= DateUtil.getdate("2012-12-31");
        BigDecimal toVol=ConvertUtil.getDecimal("1.000000");
        final MstsmvvoulmeratesId id = new MstsmvvoulmeratesId("ASDA", frmdate, tomdate, "1",toVol , toVol);
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}