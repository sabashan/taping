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

import com.excelsoft.dao.MstpictureDao;
import com.excelsoft.model.Mstpicture;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstpictureManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstpictureManagerImpl manager;

    @Mock
    private MstpictureDao dao;


    @Test
    public void testGetMstpicture() {
        log.debug("testing get...");
        //given
        final String picCode = "Pic Code";
        final Mstpicture mstpicture = new Mstpicture("Pic Code","Pic Name",null);
        given(dao.get(picCode)).willReturn(mstpicture);

        //when
        Mstpicture result = manager.get(picCode);

        //then
        assertSame(mstpicture, result);
    }

    @Test
    public void testGetMstpictures() {
        log.debug("testing getAll...");
        //given
        final List mstpictures = new ArrayList();
        given(dao.getAll()).willReturn(mstpictures);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstpictures, result);
    }

    @Test
    public void testSaveMstpicture() {
        log.debug("testing save...");

        //given
        final Mstpicture mstpicture = new Mstpicture();
        // enter all required fields
        


        given(dao.save(mstpicture)).willReturn(mstpicture);

        //when
        manager.save(mstpicture);

        //then
        verify(dao).save(mstpicture);
    }

    @Test
    public void testRemoveMstpicture() {
        log.debug("testing remove...");

        //given
        final String picCode = "Pic Code";
        willDoNothing().given(dao).remove(picCode);

        //when
        manager.remove(picCode);

        //then
        verify(dao).remove(picCode);
    }
}