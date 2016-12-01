package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mercostsheetgroupsetting;

public class MercostsheetgroupsettingDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetgroupsettingDao mercostsheetgroupsettingDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetgroupsetting() {
        Mercostsheetgroupsetting mercostsheetgroupsetting = new Mercostsheetgroupsetting();

        // enter all required fields

        log.debug("adding mercostsheetgroupsetting...");
        mercostsheetgroupsetting = mercostsheetgroupsettingDao.save(mercostsheetgroupsetting);

        mercostsheetgroupsetting = mercostsheetgroupsettingDao.get(mercostsheetgroupsetting.getId());

        assertNotNull(mercostsheetgroupsetting.getId());

        log.debug("removing mercostsheetgroupsetting...");

        mercostsheetgroupsettingDao.remove(mercostsheetgroupsetting.getId());

        // should throw DataAccessException 
        mercostsheetgroupsettingDao.get(mercostsheetgroupsetting.getId());
    }
}