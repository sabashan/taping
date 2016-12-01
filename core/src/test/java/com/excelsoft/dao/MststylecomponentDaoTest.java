package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mststylecomponent;

public class MststylecomponentDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststylecomponentDao mststylecomponentDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststylecomponent() {
        Mststylecomponent mststylecomponent = new Mststylecomponent();

        // enter all required fields

        log.debug("adding mststylecomponent...");
        mststylecomponent = mststylecomponentDao.save(mststylecomponent);

        mststylecomponent = mststylecomponentDao.get(mststylecomponent.getId());

        assertNotNull(mststylecomponent.getId());

        log.debug("removing mststylecomponent...");

        mststylecomponentDao.remove(mststylecomponent.getId());

        // should throw DataAccessException 
        mststylecomponentDao.get(mststylecomponent.getId());
    }
}