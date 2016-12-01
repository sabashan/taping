package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstcurrency;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstcurrencyDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstcurrencyDao mstcurrencyDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstcurrency() {
        Mstcurrency mstcurrency = new Mstcurrency();

        // enter all required fields
        mstcurrency.setCurName("YUROs");
        mstcurrency.setCurRate(1L);
        mstcurrency.setValidUntil(new java.util.Date());
        mstcurrency.setCurCode("YUROs");
        log.debug("adding mstcurrency...");
        mstcurrency = mstcurrencyDao.save(mstcurrency);

        mstcurrency = mstcurrencyDao.get(mstcurrency.getCurCode());

        assertNotNull(mstcurrency.getCurCode());

        log.debug("removing mstcurrency...");

        mstcurrencyDao.remove(mstcurrency.getCurCode());

        // should throw DataAccessException 
        mstcurrencyDao.get(mstcurrency.getCurCode());
    }
}