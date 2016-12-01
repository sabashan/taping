package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstparameterDao;
import com.excelsoft.model.Mstparameter;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstparameterManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstparameterManagerImpl manager;

    @Mock
    private MstparameterDao dao;


    @Test
    public void testGetMstparameter() {
        log.debug("testing get...");
        //given
        final String compName = "Orient Garments PLC";
        final Mstparameter mstparameter = new Mstparameter();
        given(dao.get(compName)).willReturn(mstparameter);

        //when
        Mstparameter result = manager.get(compName);

        //then
        assertSame(mstparameter, result);
    }

    @Test
    public void testGetMstparameters() {
        log.debug("testing getAll...");
        //given
        final List mstparameters = new ArrayList();
        given(dao.getAll()).willReturn(mstparameters);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstparameters, result);
    }

    @Test
    public void testSaveMstparameter() {
        log.debug("testing save...");

        //given
        final Mstparameter mstparameter = new Mstparameter();
        // enter all required fields
        


        given(dao.save(mstparameter)).willReturn(mstparameter);

        //when
        manager.save(mstparameter);

        //then
        verify(dao).save(mstparameter);
    }

    @Test
    public void testRemoveMstparameter() {
        log.debug("testing remove...");

        //given
        final String compName = "Orient Garments PLC";
        willDoNothing().given(dao).remove(compName);

        //when
        manager.remove(compName);

        //then
        verify(dao).remove(compName);
    }
}