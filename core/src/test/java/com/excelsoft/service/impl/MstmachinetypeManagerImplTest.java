package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstmachinetypeDao;
import com.excelsoft.model.Mstmachinetype;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstmachinetypeManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstmachinetypeManagerImpl manager;

    @Mock
    private MstmachinetypeDao dao;


    @Test
    public void testGetMstmachinetype() {
        log.debug("testing get...");
        //given
        final String typeCode = "DNM";
        final Mstmachinetype mstmachinetype = new Mstmachinetype();
        given(dao.get(typeCode)).willReturn(mstmachinetype);

        //when
        Mstmachinetype result = manager.get(typeCode);

        //then
        assertSame(mstmachinetype, result);
    }

    @Test
    public void testGetMstmachinetypes() {
        log.debug("testing getAll...");
        //given
        final List mstmachinetypes = new ArrayList();
        given(dao.getAll()).willReturn(mstmachinetypes);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstmachinetypes, result);
    }

    @Test
    public void testSaveMstmachinetype() {
        log.debug("testing save...");

        //given
        final Mstmachinetype mstmachinetype = new Mstmachinetype();
        // enter all required fields
        


        given(dao.save(mstmachinetype)).willReturn(mstmachinetype);

        //when
        manager.save(mstmachinetype);

        //then
        verify(dao).save(mstmachinetype);
    }

    @Test
    public void testRemoveMstmachinetype() {
        log.debug("testing remove...");

        //given
        final String typeCode = "DNM";
        willDoNothing().given(dao).remove(typeCode);

        //when
        manager.remove(typeCode);

        //then
        verify(dao).remove(typeCode);
    }
}