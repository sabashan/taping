package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstcustomer;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstcustomerDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstcustomerDao mstcustomerDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstcustomer() {
        Mstcustomer mstcustomer = new Mstcustomer();

        // enter all required fields
        mstcustomer.setCustName("UiGoHmAtVsDvQsHgAcEiOtPrGqUrGdMtAsOzAtJd");

        log.debug("adding mstcustomer...");
        mstcustomer = mstcustomerDao.save(mstcustomer);

        mstcustomer = mstcustomerDao.get(mstcustomer.getCustCode());

        assertNotNull(mstcustomer.getCustCode());

        log.debug("removing mstcustomer...");

        mstcustomerDao.remove(mstcustomer.getCustCode());

        // should throw DataAccessException 
        mstcustomerDao.get(mstcustomer.getCustCode());
    }
}