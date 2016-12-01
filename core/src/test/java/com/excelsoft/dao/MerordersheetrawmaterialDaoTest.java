package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;
import com.excelsoft.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Merordersheetrawmaterial;


public class MerordersheetrawmaterialDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerordersheetrawmaterialDao merordersheetrawmaterialDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerordersheetrawmaterial() {
        Merordersheetrawmaterial merordersheetrawmaterial = new Merordersheetrawmaterial();

        // enter all required fields

        log.debug("adding merordersheetrawmaterial...");
        merordersheetrawmaterial = merordersheetrawmaterialDao.save(merordersheetrawmaterial);

        merordersheetrawmaterial = merordersheetrawmaterialDao.get(merordersheetrawmaterial.getId());

        assertNotNull(merordersheetrawmaterial.getId());

        log.debug("removing merordersheetrawmaterial...");

        merordersheetrawmaterialDao.remove(merordersheetrawmaterial.getId());

        // should throw DataAccessException 
        merordersheetrawmaterialDao.get(merordersheetrawmaterial.getId());
    }
}