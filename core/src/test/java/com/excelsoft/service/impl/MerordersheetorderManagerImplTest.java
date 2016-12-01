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
import com.excelsoft.dao.MerordersheetorderDao;
import com.excelsoft.model.Merordersheetorder;
import com.excelsoft.model.MerordersheetorderId;

public class MerordersheetorderManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MerordersheetorderManagerImpl manager;

    @Mock
    private MerordersheetorderDao dao;


    @Test
    public void testGetMerordersheetorder() {
        log.debug("testing get...");
        //given        
        final MerordersheetorderId id = new MerordersheetorderId(0L,"0","HC");
        final Merordersheetorder merordersheetorder = new Merordersheetorder();
        given(dao.get(id)).willReturn(merordersheetorder);

        //when
        Merordersheetorder result = manager.get(id);

        //then
        assertSame(merordersheetorder, result);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
    public void testGetMerordersheetorders() {
        log.debug("testing getAll...");
        //given      
		final List merordersheetorders = new ArrayList();
        given(dao.getAll()).willReturn(merordersheetorders);

        //when
        List result = manager.getAll();

        //then
        assertSame(merordersheetorders, result);
    }

    @Test
    public void testSaveMerordersheetorder() {
        log.debug("testing save...");

        //given
        final Merordersheetorder merordersheetorder = new Merordersheetorder();
        // enter all required fields
        


        given(dao.save(merordersheetorder)).willReturn(merordersheetorder);

        //when
        manager.save(merordersheetorder);

        //then
        verify(dao).save(merordersheetorder);
    }

    @Test
    public void testRemoveMerordersheetorder() {
        log.debug("testing remove...");

        //given
        final MerordersheetorderId id = new MerordersheetorderId(0L,"0","HC");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}