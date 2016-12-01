package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstuser;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstuserDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstuserDao mstuserDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstuser() {
        Mstuser mstuser = new Mstuser();

        // enter all required fields
        mstuser.setUserName("PcLfZjYePkQrWnMqMfDr");
        mstuser.setUserPw("ZcRqMhJuAuEpYjGjTaIe");
        mstuser.setUserType("GgTiBi");

        log.debug("adding mstuser...");
        mstuser = mstuserDao.save(mstuser);

        mstuser = mstuserDao.get(mstuser.getUserId());

        assertNotNull(mstuser.getUserId());

        log.debug("removing mstuser...");

        mstuserDao.remove(mstuser.getUserId());

        // should throw DataAccessException 
        mstuserDao.get(mstuser.getUserId());
    }
}