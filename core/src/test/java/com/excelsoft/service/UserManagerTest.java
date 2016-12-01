package com.excelsoft.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.excelsoft.model.Mstuser;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserManagerTest extends BaseManagerTestCase {
    private Log log = LogFactory.getLog(UserManagerTest.class);
    @Autowired
    private UserManager mgr;
  
    private Mstuser user;

    @Test
    public void testGetUser() throws Exception {
        user = mgr.getUserByUsername("user");
        assertNotNull(user);
        
        log.debug(user);
        assertEquals("ADM", user.getUserGroup());
    }

    @Test
    public void testSaveUser() throws Exception {
        user = mgr.getUserByUsername("user");
        user.setReason("303-555-1212");

        log.debug("saving user with updated Reason number: " + user);

        user = mgr.saveUser(user);
        assertEquals("303-555-1212", user.getReason());
    }

    @Test
    public void testAddAndRemoveUser() throws Exception {
        user = mgr.get("user");

        // call populate method in super class to populate test data
        // from a properties file matching this class name
        user = (Mstuser) populate(user);

      //  user.addRole(roleManager.getRole(Constants.USER_ROLE));

        user = mgr.saveUser(user);
        assertEquals("user", user.getUserName());

        log.debug("removing user...");

        mgr.removeUser(user.getUserId().toString());

        try {
            user = mgr.getUserByUsername("user");
            fail("Expected 'Exception' not thrown");
        } catch (Exception e) {
            log.debug(e);
            assertNotNull(e);
        }
    }
    
    @Test
    public void testGetAll() throws Exception {
    	 log.debug("Getting All  user...");
        List<Mstuser> found = mgr.getUsers();
        log.debug("*** user...");
        assertNotEquals(0, found.size());
    }


}
