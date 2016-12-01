package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheetgroupdemmap;

public class MerordersheetgroupdemmapDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheetgroupdemmapDao merordersheetgroupdemmapDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheetgroupdemmap() {
        Merordersheetgroupdemmap merordersheetgroupdemmap = new Merordersheetgroupdemmap();

        // enter all required fields

        log.debug("adding merordersheetgroupdemmap...");
        merordersheetgroupdemmap = merordersheetgroupdemmapDao.save(merordersheetgroupdemmap);

        merordersheetgroupdemmap = merordersheetgroupdemmapDao.get(merordersheetgroupdemmap.getId());

        assertNotNull(merordersheetgroupdemmap.getId());

        log.debug("removing merordersheetgroupdemmap...");

        merordersheetgroupdemmapDao.remove(merordersheetgroupdemmap.getId());

        // should throw DataAccessException 
        merordersheetgroupdemmapDao.get(merordersheetgroupdemmap.getId());
    }
}