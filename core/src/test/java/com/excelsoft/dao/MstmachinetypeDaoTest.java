package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstmachinetype;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstmachinetypeDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstmachinetypeDao mstmachinetypeDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstmachinetype() {
        Mstmachinetype mstmachinetype = new Mstmachinetype();

        // enter all required fields

        log.debug("adding mstmachinetype...");
        mstmachinetype = mstmachinetypeDao.save(mstmachinetype);

        mstmachinetype = mstmachinetypeDao.get(mstmachinetype.getTypeCode());

        assertNotNull(mstmachinetype.getTypeCode());

        log.debug("removing mstmachinetype...");

        mstmachinetypeDao.remove(mstmachinetype.getTypeCode());

        // should throw DataAccessException 
        mstmachinetypeDao.get(mstmachinetype.getTypeCode());
    }
}