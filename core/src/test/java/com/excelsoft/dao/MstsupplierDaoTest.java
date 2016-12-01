package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstsupplier;
import com.excelsoft.model.MstsupplierId;

import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstsupplierDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstsupplierDao mstsupplierDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstsupplier() {
        Mstsupplier mstsupplier = new Mstsupplier();

        // enter all required fields
        final MstsupplierId id = new MstsupplierId("OGL", "AAL");
        mstsupplier.setId(id);
        log.debug("adding mstsupplier...");
        mstsupplier = mstsupplierDao.save(mstsupplier);

        mstsupplier = mstsupplierDao.get(mstsupplier.getId());

        assertNotNull(mstsupplier.getId());

        log.debug("removing mstsupplier...");

        mstsupplierDao.remove(mstsupplier.getId());

        // should throw DataAccessException 
        mstsupplierDao.get(mstsupplier.getId());
    }
}