package com.excelsoft.webapp.controller;

import com.excelsoft.Constants;
import com.excelsoft.model.Mstuser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.subethamail.wiser.Wiser;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

public class SignupControllerTest extends BaseControllerTestCase {
    @Autowired
    private SignupController c = null;

    @Test
    public void testDisplayForm() throws Exception {
        Mstuser user = c.showForm();
        assertNotNull(user);
    }

    @Test
    public void testSignupUser() throws Exception {
        MockHttpServletRequest request = newPost("/signup.html");
        Mstuser user = new Mstuser();
       // user.setAddress(address);

        user.setUserGroup("ROLE_USER");
        user.setUserType("user");
        user.setUserPw("Password1");
        user.setUserId("First");
        user.setUserName("Last");
        user.setEMailAddress("self-registered@raibledesigns.com");
        user.setActiveInactiveFlag("T");

        HttpServletResponse response = new MockHttpServletResponse();

        // start SMTP Server
        Wiser wiser = new Wiser();
        wiser.setPort(getSmtpPort());
        wiser.start();

        BindingResult errors = new DataBinder(user).getBindingResult();
        c.onSubmit(user, errors, request, response);
        assertFalse("errors returned in model", errors.hasErrors());

        // verify an account information e-mail was sent
        wiser.stop();
        assertTrue(wiser.getMessages().size() == 1);

        // verify that success messages are in the request
        assertNotNull(request.getSession().getAttribute("successMessages"));
        assertNotNull(request.getSession().getAttribute(Constants.REGISTERED));

        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
