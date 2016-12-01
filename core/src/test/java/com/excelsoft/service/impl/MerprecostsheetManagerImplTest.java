package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MerprecostsheetDao;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import com.excelsoft.util.ConvertUtil;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MerprecostsheetManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MerprecostsheetManagerImpl manager;

    @Mock
    private MerprecostsheetDao dao;


    @Test
    public void testGetMerprecostsheet() {
        log.debug("testing get...");
        //given
        final MerprecostsheetId id = new MerprecostsheetId("1", ConvertUtil.getDecimal("1"),"Static");
        final Merprecostsheet merprecostsheet = new Merprecostsheet();
        given(dao.get(id)).willReturn(merprecostsheet);

        //when
        Merprecostsheet result = manager.get(id);

        //then
        assertSame(merprecostsheet, result);
    }

    @Test
    public void testGetMerprecostsheets() {
        log.debug("testing getAll...");
        //given
        final List merprecostsheets = new ArrayList();
        given(dao.getAll()).willReturn(merprecostsheets);

        //when
        List result = manager.getAll();

        //then
        assertSame(merprecostsheets, result);
    }

    @Test
    public void testSaveMerprecostsheet() {
        log.debug("testing save...");

        //given
        final Merprecostsheet merprecostsheet = new Merprecostsheet();
        // enter all required fields
        merprecostsheet.setSeason("No");
        


        given(dao.save(merprecostsheet)).willReturn(merprecostsheet);

        //when
        manager.save(merprecostsheet);

        //then
        verify(dao).save(merprecostsheet);
    }

    @Test
    public void testRemoveMerprecostsheet() {
        log.debug("testing remove...");

        //given
        final MerprecostsheetId id = new MerprecostsheetId("1", ConvertUtil.getDecimal("1"),"Static");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}