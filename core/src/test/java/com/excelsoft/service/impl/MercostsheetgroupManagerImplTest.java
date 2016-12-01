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

import com.excelsoft.dao.MercostsheetgroupDao;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.MercostsheetgroupId;

public class MercostsheetgroupManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetgroupManagerImpl manager;

    @Mock
    private MercostsheetgroupDao dao;


    @Test
    public void testGetMercostsheetgroup() {
        log.debug("testing get...");
        //given
        final MercostsheetgroupId id = new MercostsheetgroupId();
        final Mercostsheetgroup mercostsheetgroup = new Mercostsheetgroup();
        given(dao.get(id)).willReturn(mercostsheetgroup);

        //when
        Mercostsheetgroup result = manager.get(id);

        //then
        assertSame(mercostsheetgroup, result);
    }

    
	@SuppressWarnings("rawtypes")
	@Test
    public void testGetMercostsheetgroups() {
        log.debug("testing getAll...");
        //given
		final List mercostsheetgroups = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetgroups);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetgroups, result);
    }

    @Test
    public void testSaveMercostsheetgroup() {
        log.debug("testing save...");

        //given
        final Mercostsheetgroup mercostsheetgroup = new Mercostsheetgroup();
        // enter all required fields
        


        given(dao.save(mercostsheetgroup)).willReturn(mercostsheetgroup);

        //when
        manager.save(mercostsheetgroup);

        //then
        verify(dao).save(mercostsheetgroup);
    }

    @Test
    public void testRemoveMercostsheetgroup() {
        log.debug("testing remove...");

        //given
        final MercostsheetgroupId id = new MercostsheetgroupId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}