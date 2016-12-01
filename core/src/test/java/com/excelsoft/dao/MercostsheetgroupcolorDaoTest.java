package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mercostsheetgroupcolor;

public class MercostsheetgroupcolorDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetgroupcolorDao mercostsheetgroupcolorDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetgroupcolor() {
        Mercostsheetgroupcolor mercostsheetgroupcolor = new Mercostsheetgroupcolor();

        // enter all required fields

        log.debug("adding mercostsheetgroupcolor...");
        mercostsheetgroupcolor = mercostsheetgroupcolorDao.save(mercostsheetgroupcolor);

        mercostsheetgroupcolor = mercostsheetgroupcolorDao.get(mercostsheetgroupcolor.getId());

        assertNotNull(mercostsheetgroupcolor.getId());

        log.debug("removing mercostsheetgroupcolor...");

        mercostsheetgroupcolorDao.remove(mercostsheetgroupcolor.getId());

        // should throw DataAccessException 
        mercostsheetgroupcolorDao.get(mercostsheetgroupcolor.getId());
    }
}