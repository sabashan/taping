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

import com.excelsoft.dao.MercostsheethdrDao;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;

public class MercostsheethdrManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheethdrManagerImpl manager;

    @Mock
    private MercostsheethdrDao dao;


    @Test
    public void testGetMercostsheethdr() {
        log.debug("testing get...");
        //given
        final MercostsheethdrId id = new MercostsheethdrId();
        final Mercostsheethdr mercostsheethdr = new Mercostsheethdr();
        given(dao.get(id)).willReturn(mercostsheethdr);

        //when
        Mercostsheethdr result = manager.get(id);

        //then
        assertSame(mercostsheethdr, result);
    }

    @Test
    public void testGetMercostsheethdrs() {
        log.debug("testing getAll...");
        //given
        final List mercostsheethdrs = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheethdrs);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheethdrs, result);
    }

    @Test
    public void testSaveMercostsheethdr() {
        log.debug("testing save...");

        //given
        final Mercostsheethdr mercostsheethdr = new Mercostsheethdr();
        // enter all required fields
        mercostsheethdr.setSeason("XdCwXgEiKb");
        


        given(dao.save(mercostsheethdr)).willReturn(mercostsheethdr);

        //when
        manager.save(mercostsheethdr);

        //then
        verify(dao).save(mercostsheethdr);
    }

    @Test
    public void testRemoveMercostsheethdr() {
        log.debug("testing remove...");

        //given
        final MercostsheethdrId id = new MercostsheethdrId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}