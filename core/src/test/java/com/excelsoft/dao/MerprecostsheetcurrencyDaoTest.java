package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Merprecostsheetcurrency;
import com.excelsoft.model.MerprecostsheetcurrencyId;
import com.excelsoft.util.ConvertUtil;

import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MerprecostsheetcurrencyDaoTest extends BaseDaoTestCase {
    @Autowired
    private MerprecostsheetcurrencyDao merprecostsheetcurrencyDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMerprecostsheetcurrency() {
        Merprecostsheetcurrency merprecostsheetcurrency = new Merprecostsheetcurrency();

        // enter all required fields
        MerprecostsheetcurrencyId id=new MerprecostsheetcurrencyId("1", ConvertUtil.getDecimal("1"),"Static" ,"Yen");
        merprecostsheetcurrency.setId(id);
        log.debug("adding merprecostsheetcurrency...");
        merprecostsheetcurrency = merprecostsheetcurrencyDao.save(merprecostsheetcurrency);

        merprecostsheetcurrency = merprecostsheetcurrencyDao.get(merprecostsheetcurrency.getId());

        assertNotNull(merprecostsheetcurrency.getId());

        log.debug("removing merprecostsheetcurrency...");

        merprecostsheetcurrencyDao.remove(merprecostsheetcurrency.getId());

        // should throw DataAccessException 
        merprecostsheetcurrencyDao.get(merprecostsheetcurrency.getId());
    }
}