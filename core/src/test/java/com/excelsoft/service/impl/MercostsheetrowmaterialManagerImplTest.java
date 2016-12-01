package com.excelsoft.service.impl;

import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.excelsoft.dao.MercostsheetrowmaterialDao;
import com.excelsoft.model.Mercostsheetrowmaterial;
import com.excelsoft.model.MercostsheetrowmaterialId;

public class MercostsheetrowmaterialManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetrowmaterialManagerImpl manager;

    @Mock
    private MercostsheetrowmaterialDao dao;


    @Test
    public void testGetMercostsheetrowmaterial() {
        log.debug("testing get...");
        //given
        final MercostsheetrowmaterialId id = new MercostsheetrowmaterialId();
        final Mercostsheetrowmaterial mercostsheetrowmaterial = new Mercostsheetrowmaterial();
        given(dao.get(id)).willReturn(mercostsheetrowmaterial);

        //when
        Mercostsheetrowmaterial result = manager.get(id);

        //then
        assertSame(mercostsheetrowmaterial, result);
    }

    @Test
    public void testGetMercostsheetrowmaterials() {
        log.debug("testing getAll...");
        //given
        final List mercostsheetrowmaterials = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetrowmaterials);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetrowmaterials, result);
    }

    @Test
    public void testSaveMercostsheetrowmaterial() {
        log.debug("testing save...");

        //given
        final Mercostsheetrowmaterial mercostsheetrowmaterial = new Mercostsheetrowmaterial();
        // enter all required fields
        


        given(dao.save(mercostsheetrowmaterial)).willReturn(mercostsheetrowmaterial);

        //when
        manager.save(mercostsheetrowmaterial);

        //then
        verify(dao).save(mercostsheetrowmaterial);
    }

    @Test
    public void testRemoveMercostsheetrowmaterial() {
        log.debug("testing remove...");

        //given
        final MercostsheetrowmaterialId id = new MercostsheetrowmaterialId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}