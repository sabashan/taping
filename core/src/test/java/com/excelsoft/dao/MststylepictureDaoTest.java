package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mststylepicture;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststylepictureDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststylepictureDao mststylepictureDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststylepicture() {
        Mststylepicture mststylepicture = new Mststylepicture();

        // enter all required fields

        log.debug("adding mststylepicture...");
        mststylepicture = mststylepictureDao.save(mststylepicture);

        mststylepicture = mststylepictureDao.get(mststylepicture.getId());

        assertNotNull(mststylepicture.getId());

        log.debug("removing mststylepicture...");

        mststylepictureDao.remove(mststylepicture.getId());

        // should throw DataAccessException 
        mststylepictureDao.get(mststylepicture.getId());
    }
}