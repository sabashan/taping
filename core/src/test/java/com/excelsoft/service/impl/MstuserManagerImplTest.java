package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstuserDao;
import com.excelsoft.model.Mstuser;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstuserManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstuserManagerImpl manager;

    @Mock
    private MstuserDao dao;


    @Test
    public void testGetMstuser() {
        log.debug("testing get...");
        //given
        final String userId = "SS";
        final Mstuser mstuser = new Mstuser();
        given(dao.get(userId)).willReturn(mstuser);

        //when
        Mstuser result = manager.get(userId);

        //then
        assertSame(mstuser, result);
    }

    
	@Test
    public void testGetMstusers() {
        log.debug("testing getAll...");
        //given
        final List mstusers = new ArrayList();
        given(dao.getAll()).willReturn(mstusers);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstusers, result);
    }

    @Test
    public void testSaveMstuser() {
        log.debug("testing save...");

        //given
        final Mstuser mstuser = new Mstuser();
        // enter all required fields
        mstuser.setUserName("NvLeWoZzMpTtUfLnHvGn");
        mstuser.setUserPw("ZvSeYkQwToDlDbBkDvRp");
        mstuser.setUserType("WjTtPq");
        


        given(dao.save(mstuser)).willReturn(mstuser);

        //when
        manager.save(mstuser);

        //then
        verify(dao).save(mstuser);
    }

    @Test
    public void testRemoveMstuser() {
        log.debug("testing remove...");

        //given
        final String userId = "SS";
        willDoNothing().given(dao).remove(userId);

        //when
        manager.remove(userId);

        //then
        verify(dao).remove(userId);
    }
}