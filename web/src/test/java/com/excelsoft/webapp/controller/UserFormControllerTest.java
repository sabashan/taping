package com.excelsoft.webapp.controller;

import com.excelsoft.Constants;
import com.excelsoft.model.Mstuser;
import com.excelsoft.service.UserManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import static org.junit.Assert.*;

public class UserFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private UserFormController c = null;
    private MockHttpServletRequest request;
    private Mstuser user;

    @Test
    public void testAdd() throws Exception {
        log.debug("testing add new user...");
        request = newGet("/userform.html");
        request.addParameter("method", "Add");
        request.addUserRole(Constants.ADMIN_ROLE);

        user = c.showForm(request, new MockHttpServletResponse());
        assertNull(user.getUsername());
    }

    @Test
    public void testAddWithoutPermission() throws Exception {
        log.debug("testing add new user...");
        request = newGet("/userform.html");
        request.addParameter("method", "Add");

        try {
            c.showForm(request, new MockHttpServletResponse());
            fail("AccessDeniedException not thrown...");
        } catch (AccessDeniedException ade) {
            assertNotNull(ade.getMessage());
        }     
    }

    @Test
    public void testCancel() throws Exception {
        log.debug("testing cancel...");
        request = newPost("/userform.html");
        request.addParameter("cancel", "");

        BindingResult errors = new DataBinder(user).getBindingResult();
        String view = c.onSubmit(user, errors, request, new MockHttpServletResponse());

        assertEquals("redirect:/home", view);
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/userform.html");
        request.addParameter("id", "es"); // regular user
        request.addUserRole(Constants.ADMIN_ROLE);

        Mstuser user = c.showForm(request, new MockHttpServletResponse());
        assertEquals("es", user.getUsername());
    }

    @Test
    public void testEditWithoutPermission() throws Exception {
        log.debug("testing edit...");
        request = newGet("/userform.html");
        request.addParameter("id", "es"); // regular user

        try {
            c.showForm(request, new MockHttpServletResponse());
            fail("AccessDeniedException not thrown...");
        } catch (AccessDeniedException ade) {
            assertNotNull(ade.getMessage());
        }
    }

    @Test
    public void testEditProfile() throws Exception {
        log.debug("testing edit profile...");
        request = newGet("/userform.html");
        request.setRemoteUser("user");

        user = c.showForm(request, new MockHttpServletResponse());
        assertEquals("user", user.getUsername());
    }

    @Test
    public void testSave() throws Exception {
        request = newPost("/userform.html");
        // set updated properties first since adding them later will
        // result in multiple parameters with the same name getting sent
        Mstuser user = ((UserManager) applicationContext.getBean("userManager")).getUser("es");

        request.setRemoteUser(user.getUsername());
        log.debug(user.getUsername());
        BindingResult errors = new DataBinder(user).getBindingResult();
        c.onSubmit(user, errors, request, new MockHttpServletResponse());

        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testAddWithMissingFields() throws Exception {
        log.debug("Testing missing Fields");
    	request = newPost("/userform.html");
        user = new Mstuser();
        user.setUserName("users");
        request.setRemoteUser("es");
       // request.set

        BindingResult errors = new DataBinder(user).getBindingResult();
        log.debug("Berfor submit ");
        c.onSubmit(user, errors, request, new MockHttpServletResponse());
        log.debug("Error conunt "+errors.getAllErrors().size());
        assertEquals(1, errors.getAllErrors().size()); //4
        
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/userform.html");
        request.addParameter("delete", "");
        user = new Mstuser();
        user.setUserId("abc");

        BindingResult errors = new DataBinder(user).getBindingResult();
        c.onSubmit(user, errors, request, new MockHttpServletResponse());
        
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
