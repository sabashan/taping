package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstoperationDao;
import com.excelsoft.model.Mstoperation;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstoperationManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstoperationManagerImpl manager;

    @Mock
    private MstoperationDao dao;


    @Test
    public void testGetMstoperation() {
        log.debug("testing get...");
        //given
        final int operationNo = 1;
        final Mstoperation mstoperation = new Mstoperation();
        given(dao.get(operationNo)).willReturn(mstoperation);

        //when
        Mstoperation result = manager.get(operationNo);

        //then
        assertSame(mstoperation, result);
    }

    @Test
    public void testGetMstoperations() {
        log.debug("testing getAll...");
        //given
        final List mstoperations = new ArrayList();
        given(dao.getAll()).willReturn(mstoperations);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstoperations, result);
    }

    @Test
    public void testSaveMstoperation() {
        log.debug("testing save...");

        //given
        final Mstoperation mstoperation = new Mstoperation();
        // enter all required fields
        


        given(dao.save(mstoperation)).willReturn(mstoperation);

        //when
        manager.save(mstoperation);

        //then
        verify(dao).save(mstoperation);
    }

    @Test
    public void testRemoveMstoperation() {
        log.debug("testing remove...");

        //given
        final int operationNo = 1;
        willDoNothing().given(dao).remove(operationNo);

        //when
        manager.remove(operationNo);

        //then
        verify(dao).remove(operationNo);
    }
}