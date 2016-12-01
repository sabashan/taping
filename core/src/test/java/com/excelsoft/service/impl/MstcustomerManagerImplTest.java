package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstcustomerDao;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstcustomerManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstcustomerManagerImpl manager;

    @Mock
    private MstcustomerDao dao;


    @Test
    public void testGetMstcustomer() {
        log.debug("testing get...");
        //given
        final String custCode = "Cus1";
        final Mstcustomer mstcustomer = new Mstcustomer();
        given(dao.get(custCode)).willReturn(mstcustomer);

        //when
        Mstcustomer result = manager.get(custCode);

        //then
        assertSame(mstcustomer, result);
    }

    @Test
    public void testGetMstcustomers() {
        log.debug("testing getAll...");
        //given
        final List mstcustomers = new ArrayList();
        given(dao.getAll()).willReturn(mstcustomers);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstcustomers, result);
    }

    @Test
    public void testSaveMstcustomer() {
        log.debug("testing save...");

        //given
        final Mstcustomer mstcustomer = new Mstcustomer();
        // enter all required fields
        mstcustomer.setCustName("BmNhEbDaJrVdXeNkEpAeUwLvAaEjEkXkQpCvFyUt");
        


        given(dao.save(mstcustomer)).willReturn(mstcustomer);

        //when
        manager.save(mstcustomer);

        //then
        verify(dao).save(mstcustomer);
    }

    @Test
    public void testRemoveMstcustomer() {
        log.debug("testing remove...");

        //given
        final String custCode = "Cus1";
        willDoNothing().given(dao).remove(custCode);

        //when
        manager.remove(custCode);

        //then
        verify(dao).remove(custCode);
    }
}