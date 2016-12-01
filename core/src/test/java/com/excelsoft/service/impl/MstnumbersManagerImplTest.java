package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstnumbersDao;
import com.excelsoft.model.Mstnumbers;
import com.excelsoft.model.MstnumbersId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MstnumbersManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstnumbersManagerImpl manager;

    @Mock
    private MstnumbersDao dao;


    @Test
    public void testGetMstnumbers() {
        log.debug("testing get...");
        //given
        final MstnumbersId id = new MstnumbersId();//7L;
        final Mstnumbers mstnumbers = new Mstnumbers();
        given(dao.get(id)).willReturn(mstnumbers);

        //when
        Mstnumbers result = manager.get(id);

        //then
        assertSame(mstnumbers, result);
    }

    @Test
    public void testGetMstnumberss() {
        log.debug("testing getAll...");
        //given
        final List mstnumberss = new ArrayList();
        given(dao.getAll()).willReturn(mstnumberss);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstnumberss, result);
    }

    @Test
    public void testSaveMstnumbers() {
        log.debug("testing save...");

        //given
        final Mstnumbers mstnumbers = new Mstnumbers();
        // enter all required fields
        mstnumbers.setTrnNo(1503197532);
        


        given(dao.save(mstnumbers)).willReturn(mstnumbers);

        //when
        manager.save(mstnumbers);

        //then
        verify(dao).save(mstnumbers);
    }

    @Test
    public void testRemoveMstnumbers() {
        log.debug("testing remove...");

        //given
        final MstnumbersId id = new MstnumbersId();//-11L;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}