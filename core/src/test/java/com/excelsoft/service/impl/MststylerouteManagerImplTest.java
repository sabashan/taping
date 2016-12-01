package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MststylerouteDao;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MststylerouteManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MststylerouteManagerImpl manager;

    @Mock
    private MststylerouteDao dao;


    @Test
    public void testGetMststyleroute() {
        log.debug("testing get...");
        //given
        final Long styleRouteId = 7L;
        final Mststyleroute mststyleroute = new Mststyleroute();
        given(dao.get(styleRouteId)).willReturn(mststyleroute);

        //when
        Mststyleroute result = manager.get(styleRouteId);

        //then
        assertSame(mststyleroute, result);
    }

    @Test
    public void testGetMststyleroutes() {
        log.debug("testing getAll...");
        //given
        final List mststyleroutes = new ArrayList();
        given(dao.getAll()).willReturn(mststyleroutes);

        //when
        List result = manager.getAll();

        //then
        assertSame(mststyleroutes, result);
    }

    @Test
    public void testSaveMststyleroute() {
        log.debug("testing save...");

        //given
        final Mststyleroute mststyleroute = new Mststyleroute();
        // enter all required fields
        mststyleroute.setComponentId("BdYvOkBdPu");
        mststyleroute.setMainColor("BjQaRe");
        


        given(dao.save(mststyleroute)).willReturn(mststyleroute);

        //when
        manager.save(mststyleroute);

        //then
        verify(dao).save(mststyleroute);
    }

    @Test
    public void testRemoveMststyleroute() {
        log.debug("testing remove...");

        //given
        final Long styleRouteId = -11L;
        willDoNothing().given(dao).remove(styleRouteId);

        //when
        manager.remove(styleRouteId);

        //then
        verify(dao).remove(styleRouteId);
    }
}