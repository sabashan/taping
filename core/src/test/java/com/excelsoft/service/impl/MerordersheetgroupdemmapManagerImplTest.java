package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.excelsoft.dao.MerordersheetgroupdemmapDao;
import com.excelsoft.model.Merordersheetgroupdemmap;
import com.excelsoft.model.MerordersheetgroupdemmapId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MerordersheetgroupdemmapManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MerordersheetgroupdemmapManagerImpl manager;

    @Mock
    private MerordersheetgroupdemmapDao dao;


    @Test
    public void testGetMerordersheetgroupdemmap() {
        log.debug("testing get...");
        //given
        final MerordersheetgroupdemmapId id = new MerordersheetgroupdemmapId("qqq", "eee", "rrr", "uuuu", 1L, 1L, "0", "HC");
        final Merordersheetgroupdemmap merordersheetgroupdemmap = new Merordersheetgroupdemmap();
        given(dao.get(id)).willReturn(merordersheetgroupdemmap);

        //when
        Merordersheetgroupdemmap result = manager.get(id);

        //then
        assertSame(merordersheetgroupdemmap, result);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
    public void testGetMerordersheetgroupdemmaps() {
        log.debug("testing getAll...");
        //given
        final List merordersheetgroupdemmaps = new ArrayList();
        given(dao.getAll()).willReturn(merordersheetgroupdemmaps);

        //when
        List result = manager.getAll();

        //then
        assertSame(merordersheetgroupdemmaps, result);
    }

    @Test
    public void testSaveMerordersheetgroupdemmap() {
        log.debug("testing save...");

        //given
        final Merordersheetgroupdemmap merordersheetgroupdemmap = new Merordersheetgroupdemmap();
        // enter all required fields
        


        given(dao.save(merordersheetgroupdemmap)).willReturn(merordersheetgroupdemmap);

        //when
        manager.save(merordersheetgroupdemmap);

        //then
        verify(dao).save(merordersheetgroupdemmap);
    }

    @Test
    public void testRemoveMerordersheetgroupdemmap() {
        log.debug("testing remove...");

        //given
        final MerordersheetgroupdemmapId id = new MerordersheetgroupdemmapId("qqq", "eee", "rrr", "uuuu", 1L, 1L, "0", "HC");
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}