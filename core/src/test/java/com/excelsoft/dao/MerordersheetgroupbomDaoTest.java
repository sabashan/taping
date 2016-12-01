package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheetgroupbom;

public class MerordersheetgroupbomDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheetgroupbomDao merordersheetgroupbomDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheetgroupbom() {
        Merordersheetgroupbom merordersheetgroupbom = new Merordersheetgroupbom();

        // enter all required fields

        log.debug("adding merordersheetgroupbom...");
        merordersheetgroupbom = merordersheetgroupbomDao.save(merordersheetgroupbom);

        merordersheetgroupbom = merordersheetgroupbomDao.get(merordersheetgroupbom.getId());

        assertNotNull(merordersheetgroupbom.getId());

        log.debug("removing merordersheetgroupbom...");

        merordersheetgroupbomDao.remove(merordersheetgroupbom.getId());

        // should throw DataAccessException 
        merordersheetgroupbomDao.get(merordersheetgroupbom.getId());
    }
}