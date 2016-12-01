package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mercostsheetdemmap;

public class MercostsheetdemmapDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetdemmapDao mercostsheetdemmapDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetdemmap() {
        Mercostsheetdemmap mercostsheetdemmap = new Mercostsheetdemmap();

        // enter all required fields

        log.debug("adding mercostsheetdemmap...");
        mercostsheetdemmap = mercostsheetdemmapDao.save(mercostsheetdemmap);

        mercostsheetdemmap = mercostsheetdemmapDao.get(mercostsheetdemmap.getId());

        assertNotNull(mercostsheetdemmap.getId());

        log.debug("removing mercostsheetdemmap...");

        mercostsheetdemmapDao.remove(mercostsheetdemmap.getId());

        // should throw DataAccessException 
        mercostsheetdemmapDao.get(mercostsheetdemmap.getId());
    }
}