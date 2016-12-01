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

import com.excelsoft.dao.MercostsheetgroupdemmapDao;
import com.excelsoft.model.Mercostsheetgroupdemmap;
import com.excelsoft.model.MercostsheetgroupdemmapId;

public class MercostsheetgroupdemmapManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetgroupdemmapManagerImpl manager;

    @Mock
    private MercostsheetgroupdemmapDao dao;


    @Test
    public void testGetMercostsheetgroupdemmap() {
        log.debug("testing get...");
        //given
        final MercostsheetgroupdemmapId id = new MercostsheetgroupdemmapId();
        final Mercostsheetgroupdemmap mercostsheetgroupdemmap = new Mercostsheetgroupdemmap();
        given(dao.get(id)).willReturn(mercostsheetgroupdemmap);

        //when
        Mercostsheetgroupdemmap result = manager.get(id);

        //then
        assertSame(mercostsheetgroupdemmap, result);
    }

    @Test
    public void testGetMercostsheetgroupdemmaps() {
        log.debug("testing getAll...");
        //given
        final List mercostsheetgroupdemmaps = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetgroupdemmaps);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetgroupdemmaps, result);
    }

    @Test
    public void testSaveMercostsheetgroupdemmap() {
        log.debug("testing save...");

        //given
        final Mercostsheetgroupdemmap mercostsheetgroupdemmap = new Mercostsheetgroupdemmap();
        // enter all required fields
        


        given(dao.save(mercostsheetgroupdemmap)).willReturn(mercostsheetgroupdemmap);

        //when
        manager.save(mercostsheetgroupdemmap);

        //then
        verify(dao).save(mercostsheetgroupdemmap);
    }

    @Test
    public void testRemoveMercostsheetgroupdemmap() {
        log.debug("testing remove...");

        //given
        final MercostsheetgroupdemmapId id = new MercostsheetgroupdemmapId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}