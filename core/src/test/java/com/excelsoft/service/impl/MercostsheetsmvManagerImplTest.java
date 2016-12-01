package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MercostsheetsmvDao;
import com.excelsoft.model.Mercostsheetsmv;
import com.excelsoft.model.MercostsheetsmvId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import com.excelsoft.util.ConvertUtil;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MercostsheetsmvManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetsmvManagerImpl manager;

    @Mock
    private MercostsheetsmvDao dao;


    @Test
    public void testGetMercostsheetsmv() {
        log.debug("testing get...");
        //given
        final MercostsheetsmvId id = new MercostsheetsmvId(ConvertUtil.getDecimal("1"), "S3", ConvertUtil.getDecimal("3"), "ST3");
        final Mercostsheetsmv mercostsheetsmv = new Mercostsheetsmv();
        given(dao.get(id)).willReturn(mercostsheetsmv);

        //when
        Mercostsheetsmv result = manager.get(id);

        //then
        assertSame(mercostsheetsmv, result);
    }

  
	@Test
    public void testGetMercostsheetsmvs() {
        log.debug("testing getAll...");
        //given
        final List mercostsheetsmvs = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetsmvs);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetsmvs, result);
    }

    @Test
    public void testSaveMercostsheetsmv() {
        log.debug("testing save...");

        //given
        final Mercostsheetsmv mercostsheetsmv = new Mercostsheetsmv();
        // enter all required fields
        


        given(dao.save(mercostsheetsmv)).willReturn(mercostsheetsmv);

        //when
        manager.save(mercostsheetsmv);

        //then
        verify(dao).save(mercostsheetsmv);
    }

    @Test
    public void testRemoveMercostsheetsmv() {
        log.debug("testing remove...");

        //given
        final MercostsheetsmvId id = new MercostsheetsmvId(ConvertUtil.getDecimal("1"), "S3", ConvertUtil.getDecimal("3"), "ST3");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}