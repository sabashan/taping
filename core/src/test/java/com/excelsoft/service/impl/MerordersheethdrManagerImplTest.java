package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.excelsoft.dao.MerordersheethdrDao;
import com.excelsoft.model.Merordersheethdr;
import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MerordersheethdrManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MerordersheethdrManagerImpl manager;

    @Mock
    private MerordersheethdrDao dao;


    @Test
    public void testGetMerordersheethdr() {
        log.debug("testing get...");
        //given
        final MerordersheethdrId id =new MerordersheethdrId("0", "HC");
        final Merordersheethdr merordersheethdr = new Merordersheethdr();
        given(dao.get(id)).willReturn(merordersheethdr);

        //when
        Merordersheethdr result = manager.get(id);

        //then
        assertSame(merordersheethdr, result);
    }

   
	@Test
    public void testGetMerordersheethdrs() {
        log.debug("testing getAll...");
        //given
		final List merordersheethdrs = new ArrayList();
        given(dao.getAll()).willReturn(merordersheethdrs);

        //when
        List result = manager.getAll();

        //then
        assertSame(merordersheethdrs, result);
    }

    @Test
    public void testSaveMerordersheethdr() {
        log.debug("testing save...");

        //given
        final Merordersheethdr merordersheethdr = new Merordersheethdr();
        // enter all required fields
        


        given(dao.save(merordersheethdr)).willReturn(merordersheethdr);

        //when
        manager.save(merordersheethdr);

        //then
        verify(dao).save(merordersheethdr);
    }

    @Test
    public void testRemoveMerordersheethdr() {
        log.debug("testing remove...");

        //given
        final MerordersheethdrId id =new MerordersheethdrId("0", "HC");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}