package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mststylewippoints;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststylewippointsDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststylewippointsDao mststylewippointsDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststylewippoints() {
        Mststylewippoints mststylewippoints = new Mststylewippoints();

        // enter all required fields

        log.debug("adding mststylewippoints...");
        mststylewippoints = mststylewippointsDao.save(mststylewippoints);

        mststylewippoints = mststylewippointsDao.get(mststylewippoints.getWippointCode());

        assertNotNull(mststylewippoints.getWippointCode());

        log.debug("removing mststylewippoints...");

        mststylewippointsDao.remove(mststylewippoints.getWippointCode());

        // should throw DataAccessException 
        mststylewippointsDao.get(mststylewippoints.getWippointCode());
    }
}