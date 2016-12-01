package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstpicture;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstpictureDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstpictureDao mstpictureDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstpicture() {
        Mstpicture mstpicture = new Mstpicture();

        // enter all required fields

        log.debug("adding mstpicture...");
        mstpicture = mstpictureDao.save(mstpicture);

        mstpicture = mstpictureDao.get(mstpicture.getPicCode());

        assertNotNull(mstpicture.getPicCode());

        log.debug("removing mstpicture...");

        mstpictureDao.remove(mstpicture.getPicCode());

        // should throw DataAccessException 
        mstpictureDao.get(mstpicture.getPicCode());
    }
}