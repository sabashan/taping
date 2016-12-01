package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstsmvrates;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstsmvratesDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstsmvratesDao mstsmvratesDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstsmvrates() {
        Mstsmvrates mstsmvrates = new Mstsmvrates();

        // enter all required fields

        log.debug("adding mstsmvrates...");
        mstsmvrates = mstsmvratesDao.save(mstsmvrates);

        mstsmvrates = mstsmvratesDao.get(mstsmvrates.getId());

        assertNotNull(mstsmvrates.getId());

        log.debug("removing mstsmvrates...");

        mstsmvratesDao.remove(mstsmvrates.getId());

        // should throw DataAccessException 
        mstsmvratesDao.get(mstsmvrates.getId());
    }
}