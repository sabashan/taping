package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstcompanyDao;
import com.excelsoft.model.Mstcompany;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstcompanyManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstcompanyManagerImpl manager;

    @Mock
    private MstcompanyDao dao;


    @Test
    public void testGetMstcompany() {
        log.debug("testing get...");
        //given
        final String compCode = "Comp1";
        final Mstcompany mstcompany = new Mstcompany();
        given(dao.get(compCode)).willReturn(mstcompany);

        //when
        Mstcompany result = manager.get(compCode);

        //then
        assertSame(mstcompany, result);
    }

    @Test
    public void testGetMstcompanies() {
        log.debug("testing getAll...");
        //given
        final List mstcompanies = new ArrayList();
        given(dao.getAll()).willReturn(mstcompanies);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstcompanies, result);
    }

    @Test
    public void testSaveMstcompany() {
        log.debug("testing save...");

        //given
        final Mstcompany mstcompany = new Mstcompany();
        // enter all required fields
        mstcompany.setYrEndDate(new java.util.Date());
        mstcompany.setYrStartDt(new java.util.Date());
        


        given(dao.save(mstcompany)).willReturn(mstcompany);

        //when
        manager.save(mstcompany);

        //then
        verify(dao).save(mstcompany);
    }

    @Test
    public void testRemoveMstcompany() {
        log.debug("testing remove...");

        //given
        final String compCode = "Comp1";
        willDoNothing().given(dao).remove(compCode);

        //when
        manager.remove(compCode);

        //then
        verify(dao).remove(compCode);
    }
}