package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstgencodesDao;
import com.excelsoft.model.Mstgencodes;
import com.excelsoft.model.MstgencodesId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstgencodesManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstgencodesManagerImpl manager;

    @Mock
    private MstgencodesDao dao;


    @Test
    public void testGetMstgencodes() {
        log.debug("testing get...");
        //given
        final MstgencodesId id = new MstgencodesId("COLOR","CD1");
        final Mstgencodes mstgencodes = new Mstgencodes();
        given(dao.get(id)).willReturn(mstgencodes);

        //when
        Mstgencodes result = manager.get(id);

        //then
        assertSame(mstgencodes, result);
    }

    @Test
    public void testGetMstgencodess() {
        log.debug("testing getAll...");
        //given
        final List mstgencodess = new ArrayList();
        given(dao.getAll()).willReturn(mstgencodess);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstgencodess, result);
    }

    @Test
    public void testSaveMstgencodes() {
        log.debug("testing save...");

        //given
        final Mstgencodes mstgencodes = new Mstgencodes();
        
        mstgencodes.setUomDenom(883139198);
        


        given(dao.save(mstgencodes)).willReturn(mstgencodes);

        //when
        manager.save(mstgencodes);

        //then
        verify(dao).save(mstgencodes);
    }

    @Test
    public void testRemoveMstgencodes() {
        log.debug("testing remove...");

        //given
        final MstgencodesId id = new MstgencodesId("COLOR","CD1");
        //final Mstgencodes mstgencodes = new Mstgencodes();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}