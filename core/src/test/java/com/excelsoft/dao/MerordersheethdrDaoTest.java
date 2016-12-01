package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheethdr;

public class MerordersheethdrDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheethdrDao merordersheethdrDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheethdr() {
        Merordersheethdr merordersheethdr = new Merordersheethdr();

        // enter all required fields

        log.debug("adding merordersheethdr...");
        merordersheethdr = merordersheethdrDao.save(merordersheethdr);

        merordersheethdr = merordersheethdrDao.get(merordersheethdr.getId());

        assertNotNull(merordersheethdr.getId());

        log.debug("removing merordersheethdr...");

        merordersheethdrDao.remove(merordersheethdr.getId());

        // should throw DataAccessException 
        merordersheethdrDao.get(merordersheethdr.getId());
    }
}