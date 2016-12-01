package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstdepartment;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstdepartmentDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstdepartmentDao mstdepartmentDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstdepartment() {
        Mstdepartment mstdepartment = new Mstdepartment();

        // enter all required fields

        log.debug("adding mstdepartment...");
        mstdepartment = mstdepartmentDao.save(mstdepartment);

        mstdepartment = mstdepartmentDao.get(mstdepartment.getDepCode());

        assertNotNull(mstdepartment.getDepCode());

        log.debug("removing mstdepartment...");

        mstdepartmentDao.remove(mstdepartment.getDepCode());

        // should throw DataAccessException 
        mstdepartmentDao.get(mstdepartment.getDepCode());
    }
}