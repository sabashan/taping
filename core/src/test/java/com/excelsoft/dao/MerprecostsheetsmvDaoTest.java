package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Merprecostsheetsmv;
import com.excelsoft.model.MerprecostsheetsmvId;
import com.excelsoft.util.ConvertUtil;

import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class MerprecostsheetsmvDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerprecostsheetsmvDao merprecostsheetsmvDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerprecostsheetsmv() {
        Merprecostsheetsmv merprecostsheetsmv = new Merprecostsheetsmv();
        final MerprecostsheetsmvId id = new MerprecostsheetsmvId(ConvertUtil.getDecimal("1"), "2", ConvertUtil.getDecimal("1"),"Static");
        // enter all required fields
        merprecostsheetsmv.setId(id);
        log.debug("adding merprecostsheetsmv...");
        merprecostsheetsmv = merprecostsheetsmvDao.save(merprecostsheetsmv);

        merprecostsheetsmv = merprecostsheetsmvDao.get(merprecostsheetsmv.getId());

        assertNotNull(merprecostsheetsmv.getId());

        log.debug("removing merprecostsheetsmv...");

        merprecostsheetsmvDao.remove(merprecostsheetsmv.getId());

        // should throw DataAccessException 
        merprecostsheetsmvDao.get(merprecostsheetsmv.getId());
    }
}