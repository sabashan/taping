package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheetdem;

public class MerordersheetdemDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheetdemDao merordersheetdemDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheetdem() {
        Merordersheetdem merordersheetdem = new Merordersheetdem();

        // enter all required fields

        log.debug("adding merordersheetdem...");
        merordersheetdem = merordersheetdemDao.save(merordersheetdem);

        merordersheetdem = merordersheetdemDao.get(merordersheetdem.getId());

        assertNotNull(merordersheetdem.getId());

        log.debug("removing merordersheetdem...");

        merordersheetdemDao.remove(merordersheetdem.getId());

        // should throw DataAccessException 
        merordersheetdemDao.get(merordersheetdem.getId());
    }
}