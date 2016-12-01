package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mercostsheetsmv;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MercostsheetsmvDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetsmvDao mercostsheetsmvDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetsmv() {
        Mercostsheetsmv mercostsheetsmv = new Mercostsheetsmv();

        // enter all required fields

        log.debug("adding mercostsheetsmv...");
        mercostsheetsmv = mercostsheetsmvDao.save(mercostsheetsmv);

        mercostsheetsmv = mercostsheetsmvDao.get(mercostsheetsmv.getId());

        assertNotNull(mercostsheetsmv.getId());

        log.debug("removing mercostsheetsmv...");

        mercostsheetsmvDao.remove(mercostsheetsmv.getId());

        // should throw DataAccessException 
        mercostsheetsmvDao.get(mercostsheetsmv.getId());
    }
}