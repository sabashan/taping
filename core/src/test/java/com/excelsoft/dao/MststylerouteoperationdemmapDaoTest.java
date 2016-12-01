package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mststylerouteoperationdemmap;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststylerouteoperationdemmapDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststylerouteoperationdemmapDao mststylerouteoperationdemmapDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststylerouteoperationdemmap() {
        Mststylerouteoperationdemmap mststylerouteoperationdemmap = new Mststylerouteoperationdemmap();

        // enter all required fields

        log.debug("adding mststylerouteoperationdemmap...");
        mststylerouteoperationdemmap = mststylerouteoperationdemmapDao.save(mststylerouteoperationdemmap);

        mststylerouteoperationdemmap = mststylerouteoperationdemmapDao.get(mststylerouteoperationdemmap.getId());

        assertNotNull(mststylerouteoperationdemmap.getId());

        log.debug("removing mststylerouteoperationdemmap...");

        mststylerouteoperationdemmapDao.remove(mststylerouteoperationdemmap.getId());

        // should throw DataAccessException 
        mststylerouteoperationdemmapDao.get(mststylerouteoperationdemmap.getId());
    }
}