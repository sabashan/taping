package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstitemDao;
import com.excelsoft.model.Mstitem;
import com.excelsoft.model.MstitemId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings("unchecked")
public class MstitemManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstitemManagerImpl manager;

    @Mock
    private MstitemDao dao;


    @Test
    public void testGetMstitem() {
        log.debug("testing get...");
        //given
        final MstitemId id = new MstitemId("BACK CINCH", "0157485");
        final Mstitem mstitem = new Mstitem();
        given(dao.get(id)).willReturn(mstitem);

        //when
        Mstitem result = manager.get(id);

        //then
        assertSame(mstitem, result);
    }

    
	@SuppressWarnings("rawtypes")
	@Test
    public void testGetMstitems() {
        log.debug("testing getAll...");
        //given
        final List mstitems = new ArrayList();
        given(dao.getAll()).willReturn(mstitems);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstitems, result);
    }

    @Test
    public void testSaveMstitem() {
        log.debug("testing save...");

        //given
        final Mstitem mstitem = new Mstitem();
        final MstitemId id = new MstitemId("BACK CINCH", "0157485");
        mstitem.setId(id);
        // enter all required fields
        mstitem.setCreateDate(new java.util.Date());
        mstitem.setDesignNo("1");
        mstitem.setItemDesc("1");
        mstitem.setItemGroup("1");
        mstitem.setType1Code("1");
        mstitem.setType2Code("1");
        mstitem.setType3Code("1");
        mstitem.setType4Code("1");
        mstitem.setType5Code("1");
        mstitem.setType6Code("1");
        mstitem.setUom("1");
        mstitem.setUserId("1");
        


        given(dao.save(mstitem)).willReturn(mstitem);

        //when
        manager.save(mstitem);

        //then
        verify(dao).save(mstitem);
    }

    @Test
    public void testRemoveMstitem() {
        log.debug("testing remove...");

        //given
        final MstitemId id = new MstitemId("BACK CINCH", "0157485");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}