package com.excelsoft.dao;

import com.excelsoft.dao.BaseDaoTestCase;
import com.excelsoft.model.Mercostsheethdr;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MercostsheethdrDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheethdrDao mercostsheethdrDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheethdr() {
        Mercostsheethdr mercostsheethdr = new Mercostsheethdr();

        // enter all required fields
        mercostsheethdr.setSeason("QfLoHeHhYu");

        log.debug("adding mercostsheethdr...");
        mercostsheethdr = mercostsheethdrDao.save(mercostsheethdr);

        mercostsheethdr = mercostsheethdrDao.get(mercostsheethdr.getId());

        assertNotNull(mercostsheethdr.getId());

        log.debug("removing mercostsheethdr...");

        mercostsheethdrDao.remove(mercostsheethdr.getId());

        // should throw DataAccessException 
        mercostsheethdrDao.get(mercostsheethdr.getId());
    }
}