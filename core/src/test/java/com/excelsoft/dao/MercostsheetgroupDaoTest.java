package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mercostsheetgroup;

public class MercostsheetgroupDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetgroupDao mercostsheetgroupDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetgroup() {
        Mercostsheetgroup mercostsheetgroup = new Mercostsheetgroup();

        // enter all required fields

        log.debug("adding mercostsheetgroup...");
        mercostsheetgroup = mercostsheetgroupDao.save(mercostsheetgroup);

        mercostsheetgroup = mercostsheetgroupDao.get(mercostsheetgroup.getId());

        assertNotNull(mercostsheetgroup.getId());

        log.debug("removing mercostsheetgroup...");

        mercostsheetgroupDao.remove(mercostsheetgroup.getId());

        // should throw DataAccessException 
        mercostsheetgroupDao.get(mercostsheetgroup.getId());
    }
}