package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstparameter;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstparameterDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstparameterDao mstparameterDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstparameter() {
        Mstparameter mstparameter = new Mstparameter();

        // enter all required fields

        log.debug("adding mstparameter...");
        mstparameter = mstparameterDao.save(mstparameter);

        mstparameter = mstparameterDao.get(mstparameter.getCompName());

        assertNotNull(mstparameter.getCompName());

        log.debug("removing mstparameter...");

        mstparameterDao.remove(mstparameter.getCompName());

        // should throw DataAccessException 
        mstparameterDao.get(mstparameter.getCompName());
    }
}