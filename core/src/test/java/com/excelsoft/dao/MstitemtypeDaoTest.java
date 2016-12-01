package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstitemtype;

import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class MstitemtypeDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstitemtypeDao mstitemtypeDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstitemtype() {
        Mstitemtype mstitemtype = new Mstitemtype();

        // enter all required fields
        mstitemtype.setItemType("testItem");
        mstitemtype.setCodeLength(new BigDecimal(10));
        mstitemtype.setItemGroup("");
        mstitemtype.setType1Name("");
        mstitemtype.setType2Name("");
        mstitemtype.setType3Name("");
        mstitemtype.setType4Name("");
        mstitemtype.setType5Name("");
        mstitemtype.setType6Name("");

        log.debug("adding mstitemtype...");
        try{
        mstitemtype = mstitemtypeDao.save(mstitemtype);
        }catch(Exception e){
        	log.debug(e);
        }
        log.debug("1");
        mstitemtype = mstitemtypeDao.get(mstitemtype.getItemType());
        log.debug("2");
        assertNotNull(mstitemtype.getItemType());
        log.debug("3");
        log.debug("removing mstitemtype...");
        log.debug("4");
        mstitemtypeDao.remove(mstitemtype.getItemType());

        // should throw DataAccessException 
        mstitemtypeDao.get(mstitemtype.getItemType());
    }
}