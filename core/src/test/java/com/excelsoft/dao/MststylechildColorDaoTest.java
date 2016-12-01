package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.MststylechildColor;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststylechildColorDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststylechildColorDao mststylechildColorDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststylechildColor() {
        MststylechildColor mststylechildColor = new MststylechildColor();

        // enter all required fields

        log.debug("adding mststylechildColor...");
        mststylechildColor = mststylechildColorDao.save(mststylechildColor);

        mststylechildColor = mststylechildColorDao.get(mststylechildColor.getId());

        assertNotNull(mststylechildColor.getId());

        log.debug("removing mststylechildColor...");

        mststylechildColorDao.remove(mststylechildColor.getId());

        // should throw DataAccessException 
        mststylechildColorDao.get(mststylechildColor.getId());
    }
}