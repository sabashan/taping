package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MstdepartmentDao;
import com.excelsoft.model.Mstdepartment;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MstdepartmentManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MstdepartmentManagerImpl manager;

    @Mock
    private MstdepartmentDao dao;


    @Test
    public void testGetMstdepartment() {
        log.debug("testing get...");
        //given
        final String depCode = "Dep1";
        final Mstdepartment mstdepartment = new Mstdepartment();
        given(dao.get(depCode)).willReturn(mstdepartment);

        //when
        Mstdepartment result = manager.get(depCode);

        //then
        assertSame(mstdepartment, result);
    }

    @Test
    public void testGetMstdepartments() {
        log.debug("testing getAll...");
        //given
        final List mstdepartments = new ArrayList();
        given(dao.getAll()).willReturn(mstdepartments);

        //when
        List result = manager.getAll();

        //then
        assertSame(mstdepartments, result);
    }

    @Test
    public void testSaveMstdepartment() {
        log.debug("testing save...");

        //given
        final Mstdepartment mstdepartment = new Mstdepartment();
        // enter all required fields
        


        given(dao.save(mstdepartment)).willReturn(mstdepartment);

        //when
        manager.save(mstdepartment);

        //then
        verify(dao).save(mstdepartment);
    }

    @Test
    public void testRemoveMstdepartment() {
        log.debug("testing remove...");

        //given
        final String depCode = "Dep1";
        willDoNothing().given(dao).remove(depCode);

        //when
        manager.remove(depCode);

        //then
        verify(dao).remove(depCode);
    }
}