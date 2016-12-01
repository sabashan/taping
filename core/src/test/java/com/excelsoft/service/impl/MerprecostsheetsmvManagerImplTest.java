package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MerprecostsheetsmvDao;
import com.excelsoft.model.Merprecostsheetsmv;
import com.excelsoft.model.MerprecostsheetsmvId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import com.excelsoft.util.ConvertUtil;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MerprecostsheetsmvManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MerprecostsheetsmvManagerImpl manager;

    @Mock
    private MerprecostsheetsmvDao dao;


    @Test
    public void testGetMerprecostsheetsmv() {
        log.debug("testing get...");
        //given
        final MerprecostsheetsmvId id = new MerprecostsheetsmvId(ConvertUtil.getDecimal("1"), "2", ConvertUtil.getDecimal("1"),"Static");
        final Merprecostsheetsmv merprecostsheetsmv = new Merprecostsheetsmv();
        given(dao.get(id)).willReturn(merprecostsheetsmv);

        //when
        Merprecostsheetsmv result = manager.get(id);

        //then
        assertSame(merprecostsheetsmv, result);
    }

    @Test
    public void testGetMerprecostsheetsmvs() {
        log.debug("testing getAll...");
        //given
        final List merprecostsheetsmvs = new ArrayList();
        given(dao.getAll()).willReturn(merprecostsheetsmvs);

        //when
        List result = manager.getAll();

        //then
        assertSame(merprecostsheetsmvs, result);
    }

    @Test
    public void testSaveMerprecostsheetsmv() {
        log.debug("testing save...");

        //given
        final Merprecostsheetsmv merprecostsheetsmv = new Merprecostsheetsmv();
        // enter all required fields
        


        given(dao.save(merprecostsheetsmv)).willReturn(merprecostsheetsmv);

        //when
        manager.save(merprecostsheetsmv);

        //then
        verify(dao).save(merprecostsheetsmv);
    }

    @Test
    public void testRemoveMerprecostsheetsmv() {
        log.debug("testing remove...");

        //given
        final MerprecostsheetsmvId id = new MerprecostsheetsmvId(ConvertUtil.getDecimal("1"), "2", ConvertUtil.getDecimal("1"),"Static");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}