package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mercostsheetunapprovedloged;

public class MercostsheetunapprovedlogedDaoTest extends BaseDaoTestCase {
    @Autowired
    private MercostsheetunapprovedlogedDao mercostsheetunapprovedlogedDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMercostsheetunapprovedloged() {
        Mercostsheetunapprovedloged mercostsheetunapprovedloged = new Mercostsheetunapprovedloged();

        // enter all required fields

        log.debug("adding mercostsheetunapprovedloged...");
        mercostsheetunapprovedloged = mercostsheetunapprovedlogedDao.save(mercostsheetunapprovedloged);

        mercostsheetunapprovedloged = mercostsheetunapprovedlogedDao.get(mercostsheetunapprovedloged.getId());

        assertNotNull(mercostsheetunapprovedloged.getId());

        log.debug("removing mercostsheetunapprovedloged...");

        mercostsheetunapprovedlogedDao.remove(mercostsheetunapprovedloged.getId());

        // should throw DataAccessException 
        mercostsheetunapprovedlogedDao.get(mercostsheetunapprovedloged.getId());
    }
}