package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MststylerouteoperationdemmapDao;
import com.excelsoft.model.Mststylerouteoperationdemmap;
import com.excelsoft.model.MststylerouteoperationdemmapId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MststylerouteoperationdemmapManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MststylerouteoperationdemmapManagerImpl manager;

    @Mock
    private MststylerouteoperationdemmapDao dao;


    @Test
    public void testGetMststylerouteoperationdemmap() {
        log.debug("testing get...");
        //given
        final MststylerouteoperationdemmapId id = new MststylerouteoperationdemmapId();//7L;
        final Mststylerouteoperationdemmap mststylerouteoperationdemmap = new Mststylerouteoperationdemmap();
        given(dao.get(id)).willReturn(mststylerouteoperationdemmap);

        //when
        Mststylerouteoperationdemmap result = manager.get(id);

        //then
        assertSame(mststylerouteoperationdemmap, result);
    }

    @Test
    public void testGetMststylerouteoperationdemmaps() {
        log.debug("testing getAll...");
        //given
        final List mststylerouteoperationdemmaps = new ArrayList();
        given(dao.getAll()).willReturn(mststylerouteoperationdemmaps);

        //when
        List result = manager.getAll();

        //then
        assertSame(mststylerouteoperationdemmaps, result);
    }

    @Test
    public void testSaveMststylerouteoperationdemmap() {
        log.debug("testing save...");

        //given
        final Mststylerouteoperationdemmap mststylerouteoperationdemmap = new Mststylerouteoperationdemmap();
        // enter all required fields
        


        given(dao.save(mststylerouteoperationdemmap)).willReturn(mststylerouteoperationdemmap);

        //when
        manager.save(mststylerouteoperationdemmap);

        //then
        verify(dao).save(mststylerouteoperationdemmap);
    }

    @Test
    public void testRemoveMststylerouteoperationdemmap() {
        log.debug("testing remove...");

        //given
        final MststylerouteoperationdemmapId id = new MststylerouteoperationdemmapId();//-11L;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}