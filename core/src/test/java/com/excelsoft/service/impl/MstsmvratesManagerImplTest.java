package com.excelsoft.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstsmvratesDao;
import com.excelsoft.model.Mstsmvrates;
import com.excelsoft.model.MstsmvratesId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "unchecked", "rawtypes" ,"deprecation"})
public class MstsmvratesManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstsmvratesManagerImpl manager;

    @Mock
    private MstsmvratesDao dao;


   
	@Test
    public void testGetMstsmvrates() {
        log.debug("testing get...");
        //given
        Date fdate=new Date(2014, 11, 30) ;
        Date tdate=new Date(2014, 11, 30) ;
        final MstsmvratesId id = new MstsmvratesId("THILAK", "01", fdate, tdate);
        final Mstsmvrates mstsmvrates = new Mstsmvrates();
        given(dao.get(id)).willReturn(mstsmvrates);

        //when
        Mstsmvrates result = manager.get(id);

        //then
        assertSame(mstsmvrates, result);
    }

	@Test
    public void testGetMstsmvratess() {
        log.debug("testing getAll...");
        //given
		final List mstsmvratess = new ArrayList();
        given(dao.getAll()).willReturn(mstsmvratess);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstsmvratess, result);
    }

    @Test
    public void testSaveMstsmvrates() {
        log.debug("testing save...");

        //given
        final Mstsmvrates mstsmvrates = new Mstsmvrates();
        // enter all required fields
        


        given(dao.save(mstsmvrates)).willReturn(mstsmvrates);

        //when
        manager.save(mstsmvrates);

        //then
        verify(dao).save(mstsmvrates);
    }

    @Test
    public void testRemoveMstsmvrates() {
        log.debug("testing remove...");

        //given
        Date fdate=new Date(2014, 11, 30) ;
        Date tdate=new Date(2014, 11, 30) ;
        final MstsmvratesId id = new MstsmvratesId("THILAK", "01", fdate, tdate);
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}