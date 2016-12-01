package com.excelsoft.webapp.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.MststylerouteoperationId;

public class MststyleoperationFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststyleoperationFormController form;
    private Mststylerouteoperation mststylerouteoperation;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/mststyleoperationform");
        
        request.addParameter("styleId", "ST1022");
        request.addParameter("locationCode", "HO");
        request.addParameter("compCode", "Hamdia");
        request.addParameter("custCode", "KANDY");
        request.addParameter("depCode", "FINAN");
        request.addParameter("componentId", "1");
        request.addParameter("mainColor", "Blue");
        request.addParameter("styleRouteId", "1");
        request.addParameter("targetDate", "2014-06-06");
        request.addParameter("opeartionNo","1");

        mststylerouteoperation = form.showForm(request);

        mststylerouteoperation = form.showForm(request);
        assertNotNull(mststylerouteoperation);
    }

    @Test
    public void testSave() throws Exception {
    	request = newGet("/mststyleoperationform");
        
        request.addParameter("styleId", "ST1022");
        request.addParameter("locationCode", "HO");
        request.addParameter("compCode", "Hamdia");
        request.addParameter("custCode", "KANDY");
        request.addParameter("depCode", "FINAN");
        request.addParameter("componentId", "1");
        request.addParameter("mainColor", "Blue");
        request.addParameter("styleRouteId", "1");
        request.addParameter("targetDate", "2014-06-06");
        request.addParameter("opeartionNo","1");

        mststylerouteoperation = form.showForm(request);

        request = newPost("/mststyleoperationform");

        // update required fields

        BindingResult errors = new DataBinder(mststylerouteoperation).getBindingResult();
        form.onSubmit(mststylerouteoperation, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
    	request = newGet("/mststyleoperationform");
        
        request.addParameter("styleId", "ST1022");
        request.addParameter("locationCode", "HO");
        request.addParameter("compCode", "Hamdia");
        request.addParameter("custCode", "KANDY");
        request.addParameter("depCode", "FINAN");
        request.addParameter("componentId", "1");
        request.addParameter("mainColor", "Blue");
        request.addParameter("styleRouteId", "1");
        request.addParameter("targetDate", "2014-06-06");
        request.addParameter("opeartionNo","1");

        mststylerouteoperation = form.showForm(request);
        mststylerouteoperation.setId(new MststylerouteoperationId(1, 1L));

        request = newPost("/mststyleoperationform");
        request.addParameter("id.opeartionNo","1");
        request.addParameter("delete", "");
       // mststyleoperation = new Mststyleoperation();
       // mststyleoperation.setId(-2L);

        BindingResult errors = new DataBinder(mststylerouteoperation).getBindingResult();
        form.onSubmit(mststylerouteoperation, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
