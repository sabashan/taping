package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheetgroupcolor;

public class MerordersheetgroupcolorDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheetgroupcolorDao merordersheetgroupcolorDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheetgroupcolor() {
        Merordersheetgroupcolor merordersheetgroupcolor = new Merordersheetgroupcolor();

        // enter all required fields

        log.debug("adding merordersheetgroupcolor...");
        merordersheetgroupcolor = merordersheetgroupcolorDao.save(merordersheetgroupcolor);

        merordersheetgroupcolor = merordersheetgroupcolorDao.get(merordersheetgroupcolor.getId());

        assertNotNull(merordersheetgroupcolor.getId());

        log.debug("removing merordersheetgroupcolor...");

        merordersheetgroupcolorDao.remove(merordersheetgroupcolor.getId());

        // should throw DataAccessException 
        merordersheetgroupcolorDao.get(merordersheetgroupcolor.getId());
    }
}