package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MststylewippointitemtypeDao;
import com.excelsoft.model.Mststylewippointitemtype;
import com.excelsoft.model.MststylewippointitemtypeId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststylewippointitemtypeManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MststylewippointitemtypeManagerImpl manager;

    @Mock
    private MststylewippointitemtypeDao dao;


    @Test
    public void testGetMststylewippointitemtype() {
        log.debug("testing get...");
        //given
        final MststylewippointitemtypeId id =  new MststylewippointitemtypeId("4", "Labelx");
        final Mststylewippointitemtype mststylewippointitemtype = new Mststylewippointitemtype();
        given(dao.get(id)).willReturn(mststylewippointitemtype);

        //when
        Mststylewippointitemtype result = manager.get(id);

        //then
        assertSame(mststylewippointitemtype, result);
    }

    @Test
    public void testGetMststylewippointitemtypes() {
        log.debug("testing getAll...");
        //given
        final List mststylewippointitemtypes = new ArrayList();
        given(dao.getAll()).willReturn(mststylewippointitemtypes);

        //when
        List result = manager.getAll();

        //then
        assertSame(mststylewippointitemtypes, result);
    }

    @Test
    public void testSaveMststylewippointitemtype() {
        log.debug("testing save...");

        //given
        final Mststylewippointitemtype mststylewippointitemtype = new Mststylewippointitemtype();
        // enter all required fields
        


        given(dao.save(mststylewippointitemtype)).willReturn(mststylewippointitemtype);

        //when
        manager.save(mststylewippointitemtype);

        //then
        verify(dao).save(mststylewippointitemtype);
    }

    @Test
    public void testRemoveMststylewippointitemtype() {
        log.debug("testing remove...");

        //given
        final MststylewippointitemtypeId id = new MststylewippointitemtypeId("4", "Labelx");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}