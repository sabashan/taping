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
import com.excelsoft.dao.MerordersheetdemDao;
import com.excelsoft.model.Merordersheetdem;
import com.excelsoft.model.MerordersheetdemId;

public class MerordersheetdemManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MerordersheetdemManagerImpl manager;

    @Mock
    private MerordersheetdemDao dao;


    @Test
    public void testGetMerordersheetdem() {
        log.debug("testing get...");
        //given
        final MerordersheetdemId id = new MerordersheetdemId("qas", "ert", "bnv", "mmm", "qasd", "vcxz", "qasd", 0L, "0", "HC");
        final Merordersheetdem merordersheetdem = new Merordersheetdem();
        given(dao.get(id)).willReturn(merordersheetdem);

        //when
        Merordersheetdem result = manager.get(id);

        //then
        assertSame(merordersheetdem, result);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
    public void testGetMerordersheetdems() {
        log.debug("testing getAll...");
        //given
        final List merordersheetdems = new ArrayList();
        given(dao.getAll()).willReturn(merordersheetdems);

        //when
        List result = manager.getAll();

        //then
        assertSame(merordersheetdems, result);
    }

    @Test
    public void testSaveMerordersheetdem() {
        log.debug("testing save...");

        //given
        final Merordersheetdem merordersheetdem = new Merordersheetdem();
        // enter all required fields
        


        given(dao.save(merordersheetdem)).willReturn(merordersheetdem);

        //when
        manager.save(merordersheetdem);

        //then
        verify(dao).save(merordersheetdem);
    }

    @Test
    public void testRemoveMerordersheetdem() {
        log.debug("testing remove...");

        //given
        final MerordersheetdemId id = new MerordersheetdemId("qas", "ert", "bnv", "mmm", "qasd", "vcxz", "qasd", 0L, "0", "HC");;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}