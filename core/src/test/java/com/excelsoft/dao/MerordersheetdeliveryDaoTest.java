package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheetdelivery;

public class MerordersheetdeliveryDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheetdeliveryDao merordersheetdeliveryDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheetdelivery() {
        Merordersheetdelivery merordersheetdelivery = new Merordersheetdelivery();

        // enter all required fields

        log.debug("adding merordersheetdelivery...");
        merordersheetdelivery = merordersheetdeliveryDao.save(merordersheetdelivery);

        merordersheetdelivery = merordersheetdeliveryDao.get(merordersheetdelivery.getId());

        assertNotNull(merordersheetdelivery.getId());

        log.debug("removing merordersheetdelivery...");

        merordersheetdeliveryDao.remove(merordersheetdelivery.getId());

        // should throw DataAccessException 
        merordersheetdeliveryDao.get(merordersheetdelivery.getId());
    }
}