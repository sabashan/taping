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

import com.excelsoft.dao.MercostsheetgroupsettingDao;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.model.MercostsheetgroupsettingId;

public class MercostsheetgroupsettingManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetgroupsettingManagerImpl manager;

    @Mock
    private MercostsheetgroupsettingDao dao;


    @Test
    public void testGetMercostsheetgroupsetting() {
        log.debug("testing get...");
        //given
        final MercostsheetgroupsettingId id = new MercostsheetgroupsettingId();
        final Mercostsheetgroupsetting mercostsheetgroupsetting = new Mercostsheetgroupsetting();
        given(dao.get(id)).willReturn(mercostsheetgroupsetting);

        //when
        Mercostsheetgroupsetting result = manager.get(id);

        //then
        assertSame(mercostsheetgroupsetting, result);
    }

    @Test
    public void testGetMercostsheetgroupsettings() {
        log.debug("testing getAll...");
        //given
        final List mercostsheetgroupsettings = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetgroupsettings);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetgroupsettings, result);
    }

    @Test
    public void testSaveMercostsheetgroupsetting() {
        log.debug("testing save...");

        //given
        final Mercostsheetgroupsetting mercostsheetgroupsetting = new Mercostsheetgroupsetting();
        // enter all required fields
        


        given(dao.save(mercostsheetgroupsetting)).willReturn(mercostsheetgroupsetting);

        //when
        manager.save(mercostsheetgroupsetting);

        //then
        verify(dao).save(mercostsheetgroupsetting);
    }

    @Test
    public void testRemoveMercostsheetgroupsetting() {
        log.debug("testing remove...");

        //given
        final MercostsheetgroupsettingId id = new MercostsheetgroupsettingId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}