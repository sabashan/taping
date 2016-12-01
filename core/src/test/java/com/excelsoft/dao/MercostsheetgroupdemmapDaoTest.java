package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mercostsheetgroupdemmap;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MercostsheetgroupdemmapDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetgroupdemmapDao mercostsheetgroupdemmapDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetgroupdemmap() {
        Mercostsheetgroupdemmap mercostsheetgroupdemmap = new Mercostsheetgroupdemmap();

        // enter all required fields

        log.debug("adding mercostsheetgroupdemmap...");
        mercostsheetgroupdemmap = mercostsheetgroupdemmapDao.save(mercostsheetgroupdemmap);

        mercostsheetgroupdemmap = mercostsheetgroupdemmapDao.get(mercostsheetgroupdemmap.getId());

        assertNotNull(mercostsheetgroupdemmap.getId());

        log.debug("removing mercostsheetgroupdemmap...");

        mercostsheetgroupdemmapDao.remove(mercostsheetgroupdemmap.getId());

        // should throw DataAccessException 
        mercostsheetgroupdemmapDao.get(mercostsheetgroupdemmap.getId());
    }
}