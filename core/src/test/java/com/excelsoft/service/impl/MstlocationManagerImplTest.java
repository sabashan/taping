package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstlocationDao;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstlocationManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstlocationManagerImpl manager;

    @Mock
    private MstlocationDao dao;


    @Test
    public void testGetMstlocation() {
        log.debug("testing get...");
        //given
        final String locationCode = "Lo1";
        final Mstlocation mstlocation = new Mstlocation();
        given(dao.get(locationCode)).willReturn(mstlocation);

        //when
        Mstlocation result = manager.get(locationCode);

        //then
        assertSame(mstlocation, result);
    }

    @Test
    public void testGetMstlocations() {
        log.debug("testing getAll...");
        //given
        final List mstlocations = new ArrayList();
        given(dao.getAll()).willReturn(mstlocations);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstlocations, result);
    }

    @Test
    public void testSaveMstlocation() {
        log.debug("testing save...");

        //given
        final Mstlocation mstlocation = new Mstlocation();
        // enter all required fields
        mstlocation.setContactName("CpGrEqXfVcAsXrOrXoAjElPbYzVqDb");
        mstlocation.setEmailAddr("SoCbNjTmChXbDlCuIvUt");
        mstlocation.setFaxNo("GfZsLpLkTcLmFfBvXgEk");
        mstlocation.setLocationAddr("FuObPaGjHnLsLdJpLnTlSvAcXqVnNfFnUfXsXfQrXwQqHxBwKpMsXcNpEmCxDsRiRtJmCvCmHzTuFtTzAbYjRsXqAvJjXnPoQdDy");
        mstlocation.setLocationName("KqEdPvUnPiJdUxBhBaMxNfHiYyBfOtEhArEjWpYd");
        mstlocation.setLocationType("E");
        mstlocation.setTelNo("YvLcVaAyHhDrZgXtFqTw");
        


        given(dao.save(mstlocation)).willReturn(mstlocation);

        //when
        manager.save(mstlocation);

        //then
        verify(dao).save(mstlocation);
    }

    @Test
    public void testRemoveMstlocation() {
        log.debug("testing remove...");

        //given
        final String locationCode = "Lo1";
        willDoNothing().given(dao).remove(locationCode);

        //when
        manager.remove(locationCode);

        //then
        verify(dao).remove(locationCode);
    }
}