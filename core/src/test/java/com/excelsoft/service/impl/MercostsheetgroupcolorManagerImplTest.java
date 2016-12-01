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

import com.excelsoft.dao.MercostsheetgroupcolorDao;
import com.excelsoft.model.Mercostsheetgroupcolor;
import com.excelsoft.model.MercostsheetgroupcolorId;

public class MercostsheetgroupcolorManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetgroupcolorManagerImpl manager;

    @Mock
    private MercostsheetgroupcolorDao dao;


    @Test
    public void testGetMercostsheetgroupcolor() {
        log.debug("testing get...");
        //given
        final MercostsheetgroupcolorId id = new MercostsheetgroupcolorId();
        final Mercostsheetgroupcolor mercostsheetgroupcolor = new Mercostsheetgroupcolor();
        given(dao.get(id)).willReturn(mercostsheetgroupcolor);

        //when
        Mercostsheetgroupcolor result = manager.get(id);

        //then
        assertSame(mercostsheetgroupcolor, result);
    }

    @Test
    public void testGetMercostsheetgroupcolors() {
        log.debug("testing getAll...");
        //given
        final List mercostsheetgroupcolors = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetgroupcolors);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetgroupcolors, result);
    }

    @Test
    public void testSaveMercostsheetgroupcolor() {
        log.debug("testing save...");

        //given
        final Mercostsheetgroupcolor mercostsheetgroupcolor = new Mercostsheetgroupcolor();
        // enter all required fields
        


        given(dao.save(mercostsheetgroupcolor)).willReturn(mercostsheetgroupcolor);

        //when
        manager.save(mercostsheetgroupcolor);

        //then
        verify(dao).save(mercostsheetgroupcolor);
    }

    @Test
    public void testRemoveMercostsheetgroupcolor() {
        log.debug("testing remove...");

        //given
        final MercostsheetgroupcolorId id = new MercostsheetgroupcolorId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}