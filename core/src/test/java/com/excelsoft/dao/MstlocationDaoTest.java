package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mstlocation;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MstlocationDaoTest extends BaseDaoTestCase {
    @Autowired
    private MstlocationDao mstlocationDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMstlocation() {
        Mstlocation mstlocation = new Mstlocation();

        // enter all required fields
        mstlocation.setContactName("LcFbFkGtAdTzAaRdUkFnLbQaNgWiIz");
        mstlocation.setEmailAddr("EjJdSgHwZyMqYmVvBsMu");
        mstlocation.setFaxNo("BzTzXyAuHyZgQwXvJyOf");
        mstlocation.setLocationAddr("KlSnXgOvYoZsMpWyTgIaYlCbNjQpZzMvNnYgUgAwFaRiGlGyApYsDfDoYtBfGqUvZgEmEmYfWuPeQeEbRfPiLrYiFrEmYvKlDrIl");
        mstlocation.setLocationName("ZjDxJoAaKjPaZhZiBsDfEqCeDcVqJiGqCpSrXeKa");
        mstlocation.setLocationType("N");
        mstlocation.setTelNo("TuEcTmYiVfEvBxJuHjKr");

        log.debug("adding mstlocation...");
        mstlocation = mstlocationDao.save(mstlocation);

        mstlocation = mstlocationDao.get(mstlocation.getLocationCode());

        assertNotNull(mstlocation.getLocationCode());

        log.debug("removing mstlocation...");

        mstlocationDao.remove(mstlocation.getLocationCode());

        // should throw DataAccessException 
        mstlocationDao.get(mstlocation.getLocationCode());
    }
}