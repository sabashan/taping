package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.MststylemainColor;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststylemainColorDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststylemainColorDao mststylemainColorDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststylemainColor() {
        MststylemainColor mststylemainColor = new MststylemainColor();

        // enter all required fields

        log.debug("adding mststylemainColor...");
        mststylemainColor = mststylemainColorDao.save(mststylemainColor);

        mststylemainColor = mststylemainColorDao.get(mststylemainColor.getId());

        assertNotNull(mststylemainColor.getId());

        log.debug("removing mststylemainColor...");

        mststylemainColorDao.remove(mststylemainColor.getId());

        // should throw DataAccessException 
        mststylemainColorDao.get(mststylemainColor.getId());
    }
}