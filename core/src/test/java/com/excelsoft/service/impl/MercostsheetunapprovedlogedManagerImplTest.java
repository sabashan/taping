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

import com.excelsoft.dao.MercostsheetunapprovedlogedDao;
import com.excelsoft.model.Mercostsheetunapprovedloged;
import com.excelsoft.model.MercostsheetunapprovedlogedId;

public class MercostsheetunapprovedlogedManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MercostsheetunapprovedlogedManagerImpl manager;

    @Mock
    private MercostsheetunapprovedlogedDao dao;


    @Test
    public void testGetMercostsheetunapprovedloged() {
        log.debug("testing get...");
        //given
        final MercostsheetunapprovedlogedId id = new MercostsheetunapprovedlogedId();
        final Mercostsheetunapprovedloged mercostsheetunapprovedloged = new Mercostsheetunapprovedloged();
        given(dao.get(id)).willReturn(mercostsheetunapprovedloged);

        //when
        Mercostsheetunapprovedloged result = manager.get(id);

        //then
        assertSame(mercostsheetunapprovedloged, result);
    }

    @Test
    public void testGetMercostsheetunapprovedlogeds() {
        log.debug("testing getAll...");
        //given
        final List mercostsheetunapprovedlogeds = new ArrayList();
        given(dao.getAll()).willReturn(mercostsheetunapprovedlogeds);

        //when
        List result = manager.getAll();

        //then
        assertSame(mercostsheetunapprovedlogeds, result);
    }

    @Test
    public void testSaveMercostsheetunapprovedloged() {
        log.debug("testing save...");

        //given
        final Mercostsheetunapprovedloged mercostsheetunapprovedloged = new Mercostsheetunapprovedloged();
        // enter all required fields
        


        given(dao.save(mercostsheetunapprovedloged)).willReturn(mercostsheetunapprovedloged);

        //when
        manager.save(mercostsheetunapprovedloged);

        //then
        verify(dao).save(mercostsheetunapprovedloged);
    }

    @Test
    public void testRemoveMercostsheetunapprovedloged() {
        log.debug("testing remove...");

        //given
        final MercostsheetunapprovedlogedId id = new MercostsheetunapprovedlogedId();
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}