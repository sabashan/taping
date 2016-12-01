package com.excelsoft.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;
import com.excelsoft.model.Mstuser;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

public class GenericDaoTest extends BaseDaoTestCase {
    Log log = LogFactory.getLog(GenericDaoTest.class);
GenericDao<Mstuser, String> genericDao;
    @Autowired
    SessionFactory sessionFactory;

    @Before
    public void setUp() {
        genericDao = new GenericDaoHibernate<Mstuser, String>(Mstuser.class, sessionFactory);
    }

    @Test
    public void getUser() {
        Mstuser user = genericDao.get("es");
        assertNotNull(user);
        assertEquals("es", user.getUsername());
    }
}
