package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstnumbers;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstnumbersDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstnumbersDao mstnumbersDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstnumbers() {
        Mstnumbers mstnumbers = new Mstnumbers();

        // enter all required fields
        mstnumbers.setTrnNo(455164727);

        log.debug("adding mstnumbers...");
        mstnumbers = mstnumbersDao.save(mstnumbers);

        mstnumbers = mstnumbersDao.get(mstnumbers.getId());

        assertNotNull(mstnumbers.getId());

        log.debug("removing mstnumbers...");

        mstnumbersDao.remove(mstnumbers.getId());

        // should throw DataAccessException 
        mstnumbersDao.get(mstnumbers.getId());
    }
}