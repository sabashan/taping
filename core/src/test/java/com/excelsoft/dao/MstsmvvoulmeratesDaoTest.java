package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstsmvvoulmerates;
import com.excelsoft.model.MstsmvvoulmeratesId;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.util.DateUtil;

import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

public class MstsmvvoulmeratesDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstsmvvoulmeratesDao mstsmvvoulmeratesDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstsmvvoulmerates() {
        Mstsmvvoulmerates mstsmvvoulmerates = new Mstsmvvoulmerates();

        // enter all required fields
        Date frmdate= DateUtil.getdate("2012-01-01");
        Date tomdate= DateUtil.getdate("2012-12-31");
        BigDecimal toVol=ConvertUtil.getDecimal("1.000000");
        MstsmvvoulmeratesId id=new MstsmvvoulmeratesId("ASDA", frmdate, tomdate, "01", toVol, toVol);
        mstsmvvoulmerates.setId(id);
        log.debug("adding mstsmvvoulmerates...");
        mstsmvvoulmerates = mstsmvvoulmeratesDao.save(mstsmvvoulmerates);

        mstsmvvoulmerates = mstsmvvoulmeratesDao.get(mstsmvvoulmerates.getId());

        assertNotNull(mstsmvvoulmerates.getId());

        log.debug("removing mstsmvvoulmerates...");

        mstsmvvoulmeratesDao.remove(mstsmvvoulmerates.getId());

        // should throw DataAccessException 
        mstsmvvoulmeratesDao.get(mstsmvvoulmerates.getId());
    }
}