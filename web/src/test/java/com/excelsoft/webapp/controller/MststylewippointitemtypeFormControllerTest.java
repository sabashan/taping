package com.excelsoft.webapp.controller;

import com.excelsoft.webapp.controller.BaseControllerTestCase;
import com.excelsoft.model.Mststylewippointitemtype;
import com.excelsoft.model.MststylewippointitemtypeId;

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

public class MststylewippointitemtypeFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststylewippointitemtypeFormController form;
    private Mststylewippointitemtype mststylewippointitemtype;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/mststylewippointitemtypeform");
        request.addParameter("wippointCode", "4");
        request.addParameter("itemType", "Labelx");
        mststylewippointitemtype = form.showForm(request);
        assertNotNull(mststylewippointitemtype);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/mststylewippointitemtypeform");
        request.addParameter("wippointCode", "4");
        request.addParameter("itemType", "Labelx");
        mststylewippointitemtype = form.showForm(request);
        assertNotNull(mststylewippointitemtype);

        request = newPost("/mststylewippointitemtypeform");
        request.addParameter("wippointCode", "4");
        request.addParameter("itemType", "Labelx");

        mststylewippointitemtype = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(mststylewippointitemtype).getBindingResult();
        form.onSubmit(mststylewippointitemtype, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/mststylewippointitemtypeform");
        request.addParameter("delete", "");
        request.addParameter("wipPoint", "5");
    	request.addParameter("itemType", "DENIMx");
    	request.addParameter("attach", "1");
        mststylewippointitemtype = new Mststylewippointitemtype();
        mststylewippointitemtype.setId(new MststylewippointitemtypeId("5", "DENIMx"));

        BindingResult errors = new DataBinder(mststylewippointitemtype).getBindingResult();
        form.onSubmit(mststylewippointitemtype, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
