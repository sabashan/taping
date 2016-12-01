package com.excelsoft.service.impl;

import com.excelsoft.Constants;
import com.excelsoft.dao.UserDao;
import com.excelsoft.model.Mstuser;
import com.excelsoft.service.UserManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserSecurityAdviceTest {

    @Mock
    private UserDao userDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    ApplicationContext ctx = null;
    SecurityContext initialSecurityContext = null;

    @Before
    public void setUp() throws Exception {
        // store initial security context for later restoration
        initialSecurityContext = SecurityContextHolder.getContext();

        SecurityContext context = new SecurityContextImpl();
        Mstuser user = new Mstuser("user");
        user.setUserId("user");
        user.setUserPw("password");
        user.setUserGroup(Constants.ADMIN_ROLE);
        user.setUserType("Admin");

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        token.setDetails(user);
        context.setAuthentication(token);
        SecurityContextHolder.setContext(context);
    }

    @After
    public void tearDown() {
        SecurityContextHolder.setContext(initialSecurityContext);
    }

   /* @Test
    public void testAddUserWithoutAdminRole() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assertTrue(auth.isAuthenticated());
        UserManager userManager = makeInterceptedTarget();
        Mstuser user = new Mstuser("es");
        user.setUserId("es");

        try {
            userManager.saveUser(user);
            fail("AccessDeniedException not thrown");
        } catch (AccessDeniedException expected) {
            assertNotNull(expected);
            Assert.assertEquals(expected.getMessage(), UserSecurityAdvice.ACCESS_DENIED);
        }
    }

    @Test
    public void testAddUserAsAdmin() throws Exception {
        SecurityContext securityContext = new SecurityContextImpl();
        Mstuser user = new Mstuser("es");
        user.setUserId("es");
        user.setUserGroup(Constants.ADMIN_ROLE);
        user.setUserType("Admin");
        user.setUserName("es");
        
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        token.setDetails(user);
        securityContext.setAuthentication(token);
        SecurityContextHolder.setContext(securityContext);

        UserManager userManager = makeInterceptedTarget();
        final Mstuser adminUser = new Mstuser("es");
        adminUser.setUserId("es");

        given(userDao.saveUser(adminUser)).willReturn(adminUser);
        given(passwordEncoder.encode(adminUser.getPassword())).willReturn(adminUser.getPassword());

        userManager.saveUser(adminUser);
    }

    @Test
    public void testUpdateUserProfile() throws Exception {
        UserManager userManager = makeInterceptedTarget();
        final Mstuser user = new Mstuser("user");
        user.setUserId("user");
        user.setUserGroup(Constants.ADMIN_ROLE);
        user.setUserType("Admin");
        user.setUserName("user");

        given(userDao.saveUser(user)).willReturn(user);
        given(user.getPassword()).willReturn(user.getPassword());

        userManager.saveUser(user);
    }

    // Test fix to http://issues.appfuse.org/browse/APF-96
    @Test
    public void testChangeToAdminRoleFromUserRole() throws Exception {
        UserManager userManager = makeInterceptedTarget();
        Mstuser user = new Mstuser("user");
        user.setUserId("user");
        user.setUserGroup(Constants.ADMIN_ROLE);
        user.setUserType("Admin");

        try {
            userManager.saveUser(user);
            fail("AccessDeniedException not thrown");
        } catch (AccessDeniedException expected) {
            assertNotNull(expected);
            assertEquals(expected.getMessage(), UserSecurityAdvice.ACCESS_DENIED);
        }
    }

    // Test fix to http://issues.appfuse.org/browse/APF-96
    @Test
    public void testAddAdminRoleWhenAlreadyHasUserRole() throws Exception {
        UserManager userManager = makeInterceptedTarget();
        Mstuser user = new Mstuser("user");
        user.setUserId("user");
        user.setUserGroup(Constants.ADMIN_ROLE);
        user.setUserType("Admin");

        try {
            userManager.saveUser(user);
            fail("AccessDeniedException not thrown");
        } catch (AccessDeniedException expected) {
            assertNotNull(expected);
            assertEquals(expected.getMessage(), UserSecurityAdvice.ACCESS_DENIED);
        }
    }

    // Test fix to http://issues.appfuse.org/browse/APF-96
    @Test
    public void testAddUserRoleWhenHasAdminRole() throws Exception {
        SecurityContext securityContext = new SecurityContextImpl();
        Mstuser user1 = new Mstuser("user");
        user1.setUserId("user");
        user1.setUserName("user");
        user1.setUserPw("user");
        user1.setUserGroup(Constants.ADMIN_ROLE);
        user1.setUserType("Admin");
        
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user1.getUsername(), user1.getPassword(), user1.getAuthorities());
        token.setDetails(user1);
        securityContext.setAuthentication(token);
        SecurityContextHolder.setContext(securityContext);

        UserManager userManager = makeInterceptedTarget();
        final Mstuser user = new Mstuser("user");
        user.setUserId("user");
        user.setUserName("user");
        user.setUserPw("user");
        user.setUserGroup(Constants.ADMIN_ROLE);
        user.setUserType("Admin");

        given(userDao.saveUser(user)).willReturn(user);
        given(user.getPassword()).willReturn(user.getPassword());

        userManager.saveUser(user);
    }*/

    // Test fix to http://issues.appfuse.org/browse/APF-96
    @Test
    public void testUpdateUserWithUserRole() throws Exception {
        UserManager userManager = makeInterceptedTarget();
        final Mstuser user = new Mstuser("user");
        user.setUserId("user");
        user.setUserName("user");
        user.setUserPw("user");
        user.setUserGroup(Constants.ADMIN_ROLE);
        user.setUserType("Admin");

        given(userDao.saveUser(user)).willReturn(user);
        given(passwordEncoder.encode(user.getPassword())).willReturn(user.getPassword());

        userManager.saveUser(user);
    }

    private UserManager makeInterceptedTarget() {
        ctx = new ClassPathXmlApplicationContext("/applicationContext-test.xml");

        UserManager userManager = (UserManager) ctx.getBean("target");
        userManager.setUserDao(userDao);
        userManager.setPasswordEncoder(passwordEncoder);
        return userManager;
    }
}
