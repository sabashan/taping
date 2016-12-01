package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstoperation;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstoperationDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstoperationDao mstoperationDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstoperation() {
        Mstoperation mstoperation = new Mstoperation();

        // enter all required fields

        log.debug("adding mstoperation...");
        mstoperation = mstoperationDao.save(mstoperation);

        mstoperation = mstoperationDao.get(mstoperation.getOperationNo());

        assertNotNull(mstoperation.getOperationNo());

        log.debug("removing mstoperation...");

        mstoperationDao.remove(mstoperation.getOperationNo());

        // should throw DataAccessException 
        mstoperationDao.get(mstoperation.getOperationNo());
    }
}