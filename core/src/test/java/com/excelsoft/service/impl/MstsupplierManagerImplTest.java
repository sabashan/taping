package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstsupplierDao;
import com.excelsoft.model.Mstsupplier;
import com.excelsoft.model.MstsupplierId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstsupplierManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstsupplierManagerImpl manager;

    @Mock
    private MstsupplierDao dao;


    @Test
    public void testGetMstsupplier() {
        log.debug("testing get...");
        //given
        final MstsupplierId id = new MstsupplierId("OGL", "AAL");
        final Mstsupplier mstsupplier = new Mstsupplier();
        given(dao.get(id)).willReturn(mstsupplier);

        //when
        Mstsupplier result = manager.get(id);

        //then
        assertSame(mstsupplier, result);
    }

    @Test
    public void testGetMstsuppliers() {
        log.debug("testing getAll...");
        //given
        final List mstsuppliers = new ArrayList();
        given(dao.getAll()).willReturn(mstsuppliers);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstsuppliers, result);
    }

    @Test
    public void testSaveMstsupplier() {
        log.debug("testing save...");

        //given
        final Mstsupplier mstsupplier = new Mstsupplier();
        // enter all required fields
        
        final MstsupplierId id = new MstsupplierId("OGL", "AAL");
        mstsupplier.setId(id);
        given(dao.save(mstsupplier)).willReturn(mstsupplier);

        //when
        manager.save(mstsupplier);

        //then
        verify(dao).save(mstsupplier);
    }

    @Test
    public void testRemoveMstsupplier() {
        log.debug("testing remove...");

        //given
        final MstsupplierId id = new MstsupplierId("OGL", "AAL");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}