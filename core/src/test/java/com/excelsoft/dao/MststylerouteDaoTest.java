package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mststyleroute;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MststylerouteDaoTest extends BaseDaoTestCase {
    @Autowired
    private MststylerouteDao mststylerouteDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMststyleroute() {
        Mststyleroute mststyleroute = new Mststyleroute();

        // enter all required fields
        mststyleroute.setComponentId("JpNsGiNlTm");
        mststyleroute.setMainColor("HzFeHb");

        log.debug("adding mststyleroute...");
        mststyleroute = mststylerouteDao.save(mststyleroute);

        mststyleroute = mststylerouteDao.get(mststyleroute.getStyleRouteId());

        assertNotNull(mststyleroute.getStyleRouteId());

        log.debug("removing mststyleroute...");

        mststylerouteDao.remove(mststyleroute.getStyleRouteId());

        // should throw DataAccessException 
        mststylerouteDao.get(mststyleroute.getStyleRouteId());
    }
}