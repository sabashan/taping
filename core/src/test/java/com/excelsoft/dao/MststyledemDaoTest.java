package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mststyledem;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststyledemDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststyledemDao mststyledemDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststyledem() {
        Mststyledem mststyledem = new Mststyledem();

        // enter all required fields

        log.debug("adding mststyledem...");
        mststyledem = mststyledemDao.save(mststyledem);

        mststyledem = mststyledemDao.get(mststyledem.getId());

        assertNotNull(mststyledem.getId());

        log.debug("removing mststyledem...");

        mststyledemDao.remove(mststyledem.getId());

        // should throw DataAccessException 
        mststyledemDao.get(mststyledem.getId());
    }
}