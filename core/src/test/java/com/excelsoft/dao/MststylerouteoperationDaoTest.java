package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mststylerouteoperation;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststylerouteoperationDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststylerouteoperationDao mststylerouteoperationDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststylerouteoperation() {
        Mststylerouteoperation mststylerouteoperation = new Mststylerouteoperation();

        // enter all required fields

        log.debug("adding mststylerouteoperation...");
        mststylerouteoperation = mststylerouteoperationDao.save(mststylerouteoperation);

        mststylerouteoperation = mststylerouteoperationDao.get(mststylerouteoperation.getId());

        assertNotNull(mststylerouteoperation.getId());

        log.debug("removing mststylerouteoperation...");

        mststylerouteoperationDao.remove(mststylerouteoperation.getId());

        // should throw DataAccessException 
        mststylerouteoperationDao.get(mststylerouteoperation.getId());
    }
}