package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstitem;
import com.excelsoft.model.MstitemId;

import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstitemDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstitemDao mstitemDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstitem() {
        Mstitem mstitem = new Mstitem();
        final MstitemId id = new MstitemId("BACK CINCH", "0157485");
        mstitem.setId(id);
        // enter all required fields
        mstitem.setCreateDate(new java.util.Date());
        mstitem.setDesignNo("1");
        mstitem.setItemDesc("1");
        mstitem.setItemGroup("1");
        mstitem.setType1Code("1");
        mstitem.setType2Code("1");
        mstitem.setType3Code("1");
        mstitem.setType4Code("1");
        mstitem.setType5Code("1");
        mstitem.setType6Code("1");
        mstitem.setUom("1");
        mstitem.setUserId("1");

        log.debug("adding mstitem...");
        mstitem = mstitemDao.save(mstitem);

        mstitem = mstitemDao.get(mstitem.getId());

        assertNotNull(mstitem.getId());

        log.debug("removing mstitem...");

        mstitemDao.remove(mstitem.getId());

        // should throw DataAccessException 
        mstitemDao.get(mstitem.getId());
    }
}