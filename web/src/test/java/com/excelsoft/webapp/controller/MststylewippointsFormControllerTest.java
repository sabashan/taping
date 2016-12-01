package com.excelsoft.webapp.controller;

import com.excelsoft.webapp.controller.BaseControllerTestCase;
import com.excelsoft.model.Mststylewippoints;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MststylewippointsFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststylewippointsFormController form;
    private Mststylewippoints mststylewippoints;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/mststylewippointsform");
        request.addParameter("wippointCode", "4");

        mststylewippoints = form.showForm(request);
        assertNotNull(mststylewippoints);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/mststylewippointsform");
        request.addParameter("wippointCode", "4");

        mststylewippoints = form.showForm(request);
        assertNotNull(mststylewippoints);
        mststylewippoints.setWippointCode("7");
        log.debug("in test***"+mststylewippoints.toString());
        request = newPost("/mststylewippointsform");

        mststylewippoints = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(mststylewippoints).getBindingResult();
        form.onSubmit(mststylewippoints, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/mststylewippointsform");
        request.addParameter("delete", "delete");
        request.addParameter("wippointCode", "4");
        mststylewippoints = new Mststylewippoints();
        mststylewippoints.setWippointCode("4");

        BindingResult errors = new DataBinder(mststylewippoints).getBindingResult();
        form.onSubmit(mststylewippoints, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
