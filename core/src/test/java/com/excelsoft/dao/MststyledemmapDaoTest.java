package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mststyledemmap;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststyledemmapDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststyledemmapDao mststyledemmapDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststyledemmap() {
        Mststyledemmap mststyledemmap = new Mststyledemmap();

        // enter all required fields

        log.debug("adding mststyledemmap...");
        mststyledemmap = mststyledemmapDao.save(mststyledemmap);

        mststyledemmap = mststyledemmapDao.get(mststyledemmap.getId());

        assertNotNull(mststyledemmap.getId());

        log.debug("removing mststyledemmap...");

        mststyledemmapDao.remove(mststyledemmap.getId());

        // should throw DataAccessException 
        mststyledemmapDao.get(mststyledemmap.getId());
    }
}