package com.excelsoft.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstitemtypeDao;
import com.excelsoft.model.Mstitemtype;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstitemtypeManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstitemtypeManagerImpl manager;

    @Mock
    private MstitemtypeDao dao;


    @Test
    public void testGetMstitemtype() {
        log.debug("testing get...");
        //given
        final String itemType = "Interlix";
        final Mstitemtype mstitemtype = new Mstitemtype();
        given(dao.get(itemType)).willReturn(mstitemtype);

        //when
        Mstitemtype result = manager.get(itemType);

        //then
        assertSame(mstitemtype, result);
    }

    @Test
    public void testGetMstitemtypes() {
        log.debug("testing getAll...");
        //given
        final List mstitemtypes = new ArrayList();
        given(dao.getAll()).willReturn(mstitemtypes);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstitemtypes, result);
    }

    @Test
    public void testSaveMstitemtype() {
        log.debug("testing save...");

        //given
        final Mstitemtype mstitemtype = new Mstitemtype();
        // enter all required fields
        mstitemtype.setCodeLength(new BigDecimal(10));
        mstitemtype.setItemGroup("DvIjKjPxZa");
        mstitemtype.setType1Name("WuVgKoFtYjHgTnEpXwPa");
        mstitemtype.setType2Name("HpWrOwBxLpXhEhUjKcKk");
        mstitemtype.setType3Name("QxLfBgUdPoLxBoFeExRu");
        mstitemtype.setType4Name("TzWxLgRzKgUpJsVpHvDx");
        mstitemtype.setType5Name("EyOwWlTyUoOqAwJgXeSz");
        mstitemtype.setType6Name("MxMbJdKrYoPxJxPoVrUj");
        


        given(dao.save(mstitemtype)).willReturn(mstitemtype);

        //when
        manager.save(mstitemtype);

        //then
        verify(dao).save(mstitemtype);
    }

    @Test
    public void testRemoveMstitemtype() {
        log.debug("testing remove...");

        //given
        final String itemType = "Interlix";
        willDoNothing().given(dao).remove(itemType);

        //when
        manager.remove(itemType);

        //then
        verify(dao).remove(itemType);
    }
}