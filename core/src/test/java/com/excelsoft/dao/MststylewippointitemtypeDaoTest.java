package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mststylewippointitemtype;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststylewippointitemtypeDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststylewippointitemtypeDao mststylewippointitemtypeDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststylewippointitemtype() {
        Mststylewippointitemtype mststylewippointitemtype = new Mststylewippointitemtype();

        // enter all required fields

        log.debug("adding mststylewippointitemtype...");
        mststylewippointitemtype = mststylewippointitemtypeDao.save(mststylewippointitemtype);

        mststylewippointitemtype = mststylewippointitemtypeDao.get(mststylewippointitemtype.getId());

        assertNotNull(mststylewippointitemtype.getId());

        log.debug("removing mststylewippointitemtype...");

        mststylewippointitemtypeDao.remove(mststylewippointitemtype.getId());

        // should throw DataAccessException 
        mststylewippointitemtypeDao.get(mststylewippointitemtype.getId());
    }
}