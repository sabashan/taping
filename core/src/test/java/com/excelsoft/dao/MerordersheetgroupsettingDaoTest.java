package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheetgroupsetting;

public class MerordersheetgroupsettingDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheetgroupsettingDao merordersheetgroupsettingDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheetgroupsetting() {
        Merordersheetgroupsetting merordersheetgroupsetting = new Merordersheetgroupsetting();

        // enter all required fields

        log.debug("adding merordersheetgroupsetting...");
        merordersheetgroupsetting = merordersheetgroupsettingDao.save(merordersheetgroupsetting);

        merordersheetgroupsetting = merordersheetgroupsettingDao.get(merordersheetgroupsetting.getId());

        assertNotNull(merordersheetgroupsetting.getId());

        log.debug("removing merordersheetgroupsetting...");

        merordersheetgroupsettingDao.remove(merordersheetgroupsetting.getId());

        // should throw DataAccessException 
        merordersheetgroupsettingDao.get(merordersheetgroupsetting.getId());
    }
}