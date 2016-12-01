package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Merprecostsheetrowmaterials;
import com.excelsoft.model.MerprecostsheetrowmaterialsId;
import com.excelsoft.util.ConvertUtil;

import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class MerprecostsheetrowmaterialsDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerprecostsheetrowmaterialsDao merprecostsheetrowmaterialsDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerprecostsheetrowmaterials() {
        Merprecostsheetrowmaterials merprecostsheetrowmaterials = new Merprecostsheetrowmaterials();
        final MerprecostsheetrowmaterialsId id = new MerprecostsheetrowmaterialsId("1", ConvertUtil.getDecimal("1") ,"Static", ConvertUtil.getDecimal("1"), "1");
        merprecostsheetrowmaterials.setId(id);
        // enter all required fields

        log.debug("adding merprecostsheetrowmaterials...");
        merprecostsheetrowmaterials = merprecostsheetrowmaterialsDao.save(merprecostsheetrowmaterials);

        merprecostsheetrowmaterials = merprecostsheetrowmaterialsDao.get(merprecostsheetrowmaterials.getId());

        assertNotNull(merprecostsheetrowmaterials.getId());

        log.debug("removing merprecostsheetrowmaterials...");

        merprecostsheetrowmaterialsDao.remove(merprecostsheetrowmaterials.getId());

        // should throw DataAccessException 
        merprecostsheetrowmaterialsDao.get(merprecostsheetrowmaterials.getId());
    }
}