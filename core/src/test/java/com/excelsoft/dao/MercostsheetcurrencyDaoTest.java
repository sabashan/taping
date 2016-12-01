package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mercostsheetcurrency;

public class MercostsheetcurrencyDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetcurrencyDao mercostsheetcurrencyDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetcurrency() {
        Mercostsheetcurrency mercostsheetcurrency = new Mercostsheetcurrency();

        // enter all required fields

        log.debug("adding mercostsheetcurrency...");
        mercostsheetcurrency = mercostsheetcurrencyDao.save(mercostsheetcurrency);

        mercostsheetcurrency = mercostsheetcurrencyDao.get(mercostsheetcurrency.getId());

        assertNotNull(mercostsheetcurrency.getId());

        log.debug("removing mercostsheetcurrency...");

        mercostsheetcurrencyDao.remove(mercostsheetcurrency.getId());

        // should throw DataAccessException 
        mercostsheetcurrencyDao.get(mercostsheetcurrency.getId());
    }
}