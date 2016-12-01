package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.util.ConvertUtil;

import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class MerprecostsheetDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerprecostsheetDao merprecostsheetDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerprecostsheet() {
        Merprecostsheet merprecostsheet = new Merprecostsheet();
        MerprecostsheetId id = new MerprecostsheetId("1", ConvertUtil.getDecimal("1"),"Static");
        merprecostsheet.setId(id);
        // enter all required fields
        merprecostsheet.setSeason("Summer");

        log.debug("adding merprecostsheet...");
        merprecostsheet = merprecostsheetDao.save(merprecostsheet);

        merprecostsheet = merprecostsheetDao.get(merprecostsheet.getId());

        assertNotNull(merprecostsheet.getId());

        log.debug("removing merprecostsheet...");

        merprecostsheetDao.remove(merprecostsheet.getId());

        // should throw DataAccessException 
        merprecostsheetDao.get(merprecostsheet.getId());
    }
}