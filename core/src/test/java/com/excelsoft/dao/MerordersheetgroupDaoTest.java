package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheetgroup;

public class MerordersheetgroupDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheetgroupDao merordersheetgroupDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheetgroup() {
        Merordersheetgroup merordersheetgroup = new Merordersheetgroup();

        // enter all required fields

        log.debug("adding merordersheetgroup...");
        merordersheetgroup = merordersheetgroupDao.save(merordersheetgroup);

        merordersheetgroup = merordersheetgroupDao.get(merordersheetgroup.getId());

        assertNotNull(merordersheetgroup.getId());

        log.debug("removing merordersheetgroup...");

        merordersheetgroupDao.remove(merordersheetgroup.getId());

        // should throw DataAccessException 
        merordersheetgroupDao.get(merordersheetgroup.getId());
    }
}