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

import com.excelsoft.dao.MerordersheetrawmaterialDao;
import com.excelsoft.model.Merordersheetrawmaterial;
import com.excelsoft.model.MerordersheetrawmaterialId;
import com.excelsoft.util.ConvertUtil;


public class MerordersheetrawmaterialManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MerordersheetrawmaterialManagerImpl manager;

    @Mock
    private MerordersheetrawmaterialDao dao;


    @Test
    public void testGetMerordersheetrawmaterial() {
        log.debug("testing get...");
        //given
        final MerordersheetrawmaterialId id = new MerordersheetrawmaterialId("0",ConvertUtil.getDecimal("0"),"HC") ;
        final Merordersheetrawmaterial merordersheetrawmaterial = new Merordersheetrawmaterial();
        given(dao.get(id)).willReturn(merordersheetrawmaterial);

        //when
        Merordersheetrawmaterial result = manager.get(id);

        //then
        assertSame(merordersheetrawmaterial, result);
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testGetMerordersheetrawmaterials() {
        log.debug("testing getAll...");
        //given
        @SuppressWarnings("rawtypes")
		final List merordersheetrawmaterials = new ArrayList();
        given(dao.getAll()).willReturn(merordersheetrawmaterials);

        //when
        @SuppressWarnings("rawtypes")
		List result = manager.getAll();

        //then
        assertSame(merordersheetrawmaterials, result);
    }

    @Test
    public void testSaveMerordersheetrawmaterial() {
        log.debug("testing save...");

        //given
        final Merordersheetrawmaterial merordersheetrawmaterial = new Merordersheetrawmaterial();
        // enter all required fields
        


        given(dao.save(merordersheetrawmaterial)).willReturn(merordersheetrawmaterial);

        //when
        manager.save(merordersheetrawmaterial);

        //then
        verify(dao).save(merordersheetrawmaterial);
    }

    @Test
    public void testRemoveMerordersheetrawmaterial() {
        log.debug("testing remove...");

        //given
        final MerordersheetrawmaterialId id = new MerordersheetrawmaterialId("0",ConvertUtil.getDecimal("0"),"HC") ;;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}