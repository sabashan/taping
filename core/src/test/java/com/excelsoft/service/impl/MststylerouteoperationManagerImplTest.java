package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MststylerouteoperationDao;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.MststylerouteoperationId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststylerouteoperationManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MststylerouteoperationManagerImpl manager;

    @Mock
    private MststylerouteoperationDao dao;


    @Test
    public void testGetMststylerouteoperation() {
        log.debug("testing get...");
        //given
        final MststylerouteoperationId id = new MststylerouteoperationId();// 7L;
        final Mststylerouteoperation mststylerouteoperation = new Mststylerouteoperation();
        given(dao.get(id)).willReturn(mststylerouteoperation);

        //when
        Mststylerouteoperation result = manager.get(id);

        //then
        assertSame(mststylerouteoperation, result);
    }

    @Test
    public void testGetMststylerouteoperations() {
        log.debug("testing getAll...");
        //given
        final List mststylerouteoperations = new ArrayList();
        given(dao.getAll()).willReturn(mststylerouteoperations);

        //when
        List result = manager.getAll();

        //then
        assertSame(mststylerouteoperations, result);
    }

    @Test
    public void testSaveMststylerouteoperation() {
        log.debug("testing save...");

        //given
        final Mststylerouteoperation mststylerouteoperation = new Mststylerouteoperation();
        // enter all required fields
        


        given(dao.save(mststylerouteoperation)).willReturn(mststylerouteoperation);

        //when
        manager.save(mststylerouteoperation);

        //then
        verify(dao).save(mststylerouteoperation);
    }

    @Test
    public void testRemoveMststylerouteoperation() {
        log.debug("testing remove...");

        //given
        final MststylerouteoperationId id = new MststylerouteoperationId();//-11L;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}