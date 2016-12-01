package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MerprecostsheetrowmaterialsDao;
import com.excelsoft.model.Merprecostsheetrowmaterials;
import com.excelsoft.model.MerprecostsheetrowmaterialsId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import com.excelsoft.util.ConvertUtil;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MerprecostsheetrowmaterialsManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MerprecostsheetrowmaterialsManagerImpl manager;

    @Mock
    private MerprecostsheetrowmaterialsDao dao;


    @Test
    public void testGetMerprecostsheetrowmaterials() {
        log.debug("testing get...");
        //given
        final MerprecostsheetrowmaterialsId id = new MerprecostsheetrowmaterialsId("1", ConvertUtil.getDecimal("1") ,"Static", ConvertUtil.getDecimal("1"), "1");
        final Merprecostsheetrowmaterials merprecostsheetrowmaterials = new Merprecostsheetrowmaterials();
        given(dao.get(id)).willReturn(merprecostsheetrowmaterials);

        //when
        Merprecostsheetrowmaterials result = manager.get(id);

        //then
        assertSame(merprecostsheetrowmaterials, result);
    }

    @Test
    public void testGetMerprecostsheetrowmaterialss() {
        log.debug("testing getAll...");
        //given
        final List merprecostsheetrowmaterialss = new ArrayList();
        given(dao.getAll()).willReturn(merprecostsheetrowmaterialss);

        //when
        List result = manager.getAll();

        //then
        assertSame(merprecostsheetrowmaterialss, result);
    }

    @Test
    public void testSaveMerprecostsheetrowmaterials() {
        log.debug("testing save...");

        //given
        final Merprecostsheetrowmaterials merprecostsheetrowmaterials = new Merprecostsheetrowmaterials();
        // enter all required fields
        final MerprecostsheetrowmaterialsId id = new MerprecostsheetrowmaterialsId("1", ConvertUtil.getDecimal("1") ,"Static", ConvertUtil.getDecimal("1"), "1");
        merprecostsheetrowmaterials.setId(id);


        given(dao.save(merprecostsheetrowmaterials)).willReturn(merprecostsheetrowmaterials);

        //when
        manager.save(merprecostsheetrowmaterials);

        //then
        verify(dao).save(merprecostsheetrowmaterials);
    }

    @Test
    public void testRemoveMerprecostsheetrowmaterials() {
        log.debug("testing remove...");

        //given
        final MerprecostsheetrowmaterialsId id = new MerprecostsheetrowmaterialsId("1", ConvertUtil.getDecimal("1") ,"Static", ConvertUtil.getDecimal("1"), "1");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}