package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheetorder;

public class MerordersheetorderDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheetorderDao merordersheetorderDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheetorder() {
        Merordersheetorder merordersheetorder = new Merordersheetorder();

        // enter all required fields

        log.debug("adding merordersheetorder...");
        merordersheetorder = merordersheetorderDao.save(merordersheetorder);

        merordersheetorder = merordersheetorderDao.get(merordersheetorder.getId());

        assertNotNull(merordersheetorder.getId());

        log.debug("removing merordersheetorder...");

        merordersheetorderDao.remove(merordersheetorder.getId());

        // should throw DataAccessException 
        merordersheetorderDao.get(merordersheetorder.getId());
    }
}