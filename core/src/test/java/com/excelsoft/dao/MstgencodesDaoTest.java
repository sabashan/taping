package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstgencodes;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstgencodesDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstgencodesDao mstgencodesDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstgencodes() {
        Mstgencodes mstgencodes = new Mstgencodes();

        // enter all required fields
        mstgencodes.setUomDenom(1743956167);

        log.debug("adding mstgencodes...");
        mstgencodes = mstgencodesDao.save(mstgencodes);

        mstgencodes = mstgencodesDao.get(mstgencodes.getId());

        assertNotNull(mstgencodes.getId());

        log.debug("removing mstgencodes...");

        mstgencodesDao.remove(mstgencodes.getId());

        // should throw DataAccessException 
        mstgencodesDao.get(mstgencodes.getId());
    }
}