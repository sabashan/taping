package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MststylepictureDao;
import com.excelsoft.model.Mststylepicture;
import com.excelsoft.model.MststylepictureId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststylepictureManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MststylepictureManagerImpl manager;

    @Mock
    private MststylepictureDao dao;


    @Test
    public void testGetMststylepicture() {
        log.debug("testing get...");
        //given
        final MststylepictureId id = new MststylepictureId("Pic1", "SSS1", "LO1", "Comp1", "Cus1", "Dep1");
        final Mststylepicture mststylepicture = new Mststylepicture();
        given(dao.get(id)).willReturn(mststylepicture);

        //when
        Mststylepicture result = manager.get(id);

        //then
        assertSame(mststylepicture, result);
    }

    @Test
    public void testGetMststylepictures() {
        log.debug("testing getAll...");
        //given
        final List mststylepictures = new ArrayList();
        given(dao.getAll()).willReturn(mststylepictures);

        //when
        List result = manager.getAll();

        //then
        assertSame(mststylepictures, result);
    }

    @Test
    public void testSaveMststylepicture() {
        log.debug("testing save...");

        //given
        final Mststylepicture mststylepicture = new Mststylepicture();
        // enter all required fields
        


        given(dao.save(mststylepicture)).willReturn(mststylepicture);

        //when
        manager.save(mststylepicture);

        //then
        verify(dao).save(mststylepicture);
    }

    @Test
    public void testRemoveMststylepicture() {
        log.debug("testing remove...");

        //given
       final MststylepictureId id = new MststylepictureId("Pic1", "SSS1", "LO1", "Comp1", "Cus1", "Dep1");
        
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}