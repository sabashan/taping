package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MststylewippointsDao;
import com.excelsoft.model.Mststylewippoints;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststylewippointsManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MststylewippointsManagerImpl manager;

    @Mock
    private MststylewippointsDao dao;


    @Test
    public void testGetMststylewippoints() {
        log.debug("testing get...");
        //given
        final String wippointCode = "WIP1";
        final Mststylewippoints mststylewippoints = new Mststylewippoints();
        given(dao.get(wippointCode)).willReturn(mststylewippoints);

        //when
        Mststylewippoints result = manager.get(wippointCode);

        //then
        assertSame(mststylewippoints, result);
    }

    @Test
    public void testGetMststylewippointss() {
        log.debug("testing getAll...");
        //given
        final List mststylewippointss = new ArrayList();
        given(dao.getAll()).willReturn(mststylewippointss);

        //when
        List result = manager.getAll();

        //then
        assertSame(mststylewippointss, result);
    }

    @Test
    public void testSaveMststylewippoints() {
        log.debug("testing save...");

        //given
        final Mststylewippoints mststylewippoints = new Mststylewippoints();
        // enter all required fields
        


        given(dao.save(mststylewippoints)).willReturn(mststylewippoints);

        //when
        manager.save(mststylewippoints);

        //then
        verify(dao).save(mststylewippoints);
    }

    @Test
    public void testRemoveMststylewippoints() {
        log.debug("testing remove...");

        //given
        final String wippointCode = "WIP1";
        willDoNothing().given(dao).remove(wippointCode);

        //when
        manager.remove(wippointCode);

        //then
        verify(dao).remove(wippointCode);
    }
}