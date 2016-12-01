package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MercostsheetdemmapDao;
import com.excelsoft.model.Mercostsheetdemmap;
import com.excelsoft.model.MercostsheetdemmapId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MercostsheetdemmapManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetdemmapManagerImpl manager;

    @Mock
    private MercostsheetdemmapDao dao;


    @Test
    public void testGetMercostsheetdemmap() {
        log.debug("testing get...");
        //given
        final MercostsheetdemmapId id = new MercostsheetdemmapId();
        final Mercostsheetdemmap mercostsheetdemmap = new Mercostsheetdemmap();
        given(dao.get(id)).willReturn(mercostsheetdemmap);

        //when
        Mercostsheetdemmap result = manager.get(id);

        //then
        assertSame(mercostsheetdemmap, result);
    }

    @Test
    public void testGetMercostsheetdemmaps() {
        log.debug("testing getAll...");
        //given
        final List mercostsheetdemmaps = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetdemmaps);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetdemmaps, result);
    }

    @Test
    public void testSaveMercostsheetdemmap() {
        log.debug("testing save...");

        //given
        final Mercostsheetdemmap mercostsheetdemmap = new Mercostsheetdemmap();
        // enter all required fields
        


        given(dao.save(mercostsheetdemmap)).willReturn(mercostsheetdemmap);

        //when
        manager.save(mercostsheetdemmap);

        //then
        verify(dao).save(mercostsheetdemmap);
    }

    @Test
    public void testRemoveMercostsheetdemmap() {
        log.debug("testing remove...");

        //given
        final MercostsheetdemmapId id = new MercostsheetdemmapId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}