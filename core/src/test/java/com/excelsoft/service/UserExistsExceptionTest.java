package com.excelsoft.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.excelsoft.model.Mstuser;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(
        locations = {"/applicationContext-service.xml",
                     "/applicationContext-resources.xml",
                     "classpath:/applicationContext-dao.xml"})
public class UserExistsExceptionTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private UserManager manager;
    private Log log = LogFactory.getLog(UserExistsExceptionTest.class);

    @Test(expected = UserExistsException.class)
    public void testAddExistingUser() throws Exception {
        log.debug("entered 'testAddExistingUser' method");
        assertNotNull(manager);

        Mstuser user = manager.getUser("es");

        // create new object with null id - Hibernate doesn't like setId(null)
        Mstuser user2 = new Mstuser();
      //  BeanUtils.copyProperties(user, user2);
        
      //  user2.setUserId("es");
       // user2.setVersion(null);
     //   user2.setUserName("es");
        user2.setUserPw(user.getUserPw());
        user2.setEMailAddress(user.getEMailAddress());
        user2.setUserName(user.getUserName());
        user2.setUserType(user.getUserType());
        user2.setUserGroup(user.getUserGroup());
        user2.setUserId(user.getUserId());
        log.debug("ho ho");
        // try saving as new user, this should fail UserExistsException b/c of unique keys
        manager.saveUser(user2);
    }
}
