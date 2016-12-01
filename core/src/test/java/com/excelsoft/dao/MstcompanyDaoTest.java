package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstcompany;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstcompanyDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstcompanyDao mstcompanyDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstcompany() {
        Mstcompany mstcompany = new Mstcompany();

        // enter all required fields
        mstcompany.setYrEndDate(new java.util.Date());
        mstcompany.setYrStartDt(new java.util.Date());

        log.debug("adding mstcompany...");
        mstcompany = mstcompanyDao.save(mstcompany);

        mstcompany = mstcompanyDao.get(mstcompany.getCompCode());

        assertNotNull(mstcompany.getCompCode());

        log.debug("removing mstcompany...");

        mstcompanyDao.remove(mstcompany.getCompCode());

        // should throw DataAccessException 
        mstcompanyDao.get(mstcompany.getCompCode());
    }
}