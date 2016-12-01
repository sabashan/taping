package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mercostsheetrowmaterial;

public class MercostsheetrowmaterialDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetrowmaterialDao mercostsheetrowmaterialDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetrowmaterial() {
        Mercostsheetrowmaterial mercostsheetrowmaterial = new Mercostsheetrowmaterial();

        // enter all required fields

        log.debug("adding mercostsheetrowmaterial...");
        mercostsheetrowmaterial = mercostsheetrowmaterialDao.save(mercostsheetrowmaterial);

        mercostsheetrowmaterial = mercostsheetrowmaterialDao.get(mercostsheetrowmaterial.getId());

        assertNotNull(mercostsheetrowmaterial.getId());

        log.debug("removing mercostsheetrowmaterial...");

        mercostsheetrowmaterialDao.remove(mercostsheetrowmaterial.getId());

        // should throw DataAccessException 
        mercostsheetrowmaterialDao.get(mercostsheetrowmaterial.getId());
    }
}