package com.excelsoft.service.impl;


import com.excelsoft.dao.UserDao;
import com.excelsoft.model.Mstuser;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class UserManagerImplTest extends BaseManagerMockTestCase {
    //~ Instance fields ========================================================

    @Mock
    private UserDao userDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private PasswordTokenManager passwordTokenManager;


    @InjectMocks
    private UserManagerImpl userManager = new UserManagerImpl();


    //~ Methods ================================================================

    @Test
    public void testGetUser() throws Exception {
        //given
        final Mstuser testData = new Mstuser();
       // testData.getRoles().add(new Role("user"));

        given(userDao.get("es")).willReturn(testData);

        //then
        Mstuser user = userManager.getUser("es");

        //then
        assertTrue(user != null);
        assert user != null;
        log.debug(user.getReason());
    }

    /*@Test
    public void testSaveUser() throws Exception {
        //given
        final Mstuser testData = userManager.get("es");
       // testData.getRoles().add(new Role("user"));
        log.debug(testData.getReason());
        given(userDao.get("es")).willReturn(testData);


        final Mstuser user = userManager.getUser("es");
        user.setReason("303-555-1212");

        given(userDao.saveUser(user)).willReturn(user);

        log.debug(user.getReason());
        //when
        Mstuser returned = userManager.saveUser(user);
log.debug(returned.getReason());
        //then
        assertTrue(returned.getReason().equals("303-555-1212"));
       // assertTrue(returned.getRoles().size() == 1);
    }

    @Test
    public void testAddAndRemoveUser() throws Exception {
        //given
    	Mstuser user = userDao.get("abc");

        // call populate method in super class to populate test data
        // from a properties file matching this class name
        user = (Mstuser) populate(user);


        Role role = new Role(Constants.USER_ROLE);
        //user.addRole(role);

        final Mstuser user1 = user;
        given(userDao.save(user1)).willReturn(user1);


        //when
        user = userManager.saveUser(user);

        //then
        assertTrue(user.getUserName().equals("abc"));
       // assertTrue(user.getRoles().size() == 1);

        //given
        willDoNothing().given(userDao).remove("abc");
        userManager.removeUser("abc");

        given(userDao.get("abc")).willReturn(null);

        //when
        user = userManager.getUser("abc");

        //then
        assertNull(user);
        verify(userDao).remove("abc");
    }

    @Test
    public void testUserExistsException() throws UserExistsException {
        // set expectations
        final Mstuser user = userDao.get("abc");
        user.setEMailAddress("mattigns.com");

        willThrow(new DataIntegrityViolationException("")).given(userDao).save(user);

        userManager.save(user);
		fail("Expected UserExistsException not thrown");
    }*/
}
