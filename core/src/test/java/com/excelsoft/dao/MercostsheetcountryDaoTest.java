package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mercostsheetcountry;

public class MercostsheetcountryDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetcountryDao mercostsheetcountryDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetcountry() {
        Mercostsheetcountry mercostsheetcountry = new Mercostsheetcountry();

        // enter all required fields

        log.debug("adding mercostsheetcountry...");
        mercostsheetcountry = mercostsheetcountryDao.save(mercostsheetcountry);

        mercostsheetcountry = mercostsheetcountryDao.get(mercostsheetcountry.getId());

        assertNotNull(mercostsheetcountry.getId());

        log.debug("removing mercostsheetcountry...");

        mercostsheetcountryDao.remove(mercostsheetcountry.getId());

        // should throw DataAccessException 
        mercostsheetcountryDao.get(mercostsheetcountry.getId());
    }
}