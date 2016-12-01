package com.excelsoft.webapp.controller;

import com.excelsoft.webapp.controller.BaseControllerTestCase;
import com.excelsoft.model.Merordersheethdr;
import com.excelsoft.model.MerordersheethdrId;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import static org.junit.Assert.*;

public class MerordersheethdrFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MerordersheethdrFormController form;
    private Merordersheethdr merordersheethdr;
    private MockHttpServletRequest request;

	@Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/merordersheethdrform");
       // request.addParameter("id", "-1");
        request.addParameter("planingOrdersheetNo","0");
        request.addParameter("orderType","HC");
        Model model;
        model = form.showForm(request);
        assertNotNull(model);
    }

    @Test
    public void testSave() throws Exception {
    	 log.debug("testing save...");
    	request = newGet("/merordersheethdrform");
        request.addParameter("planingOrdersheetNo","0");
        request.addParameter("orderType","HC");

        Model model;
        model =  form.showForm(request);
        log.debug(merordersheethdr);
        assertNotNull(model);

        request = newPost("/merordersheethdrform");
        
       // request.addParameter("planingordersheetNo","0");
        //request.addParameter("ordertype","HC");
        
       // merordersheethdr = form.showForm(request);
        // update required fields
        MerordersheethdrId id=new MerordersheethdrId("0", "HC");
        merordersheethdr=new Merordersheethdr(id);
        BindingResult errors = new DataBinder(merordersheethdr).getBindingResult();
        form.onSubmit(merordersheethdr, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
    	 log.debug("testing delete...");
    	request = newPost("/merordersheethdrform");
        request.addParameter("delete", "");
        merordersheethdr = new Merordersheethdr();
        MerordersheethdrId id=new MerordersheethdrId("0", "HC");
        merordersheethdr.setId(id);

        BindingResult errors = new DataBinder(merordersheethdr).getBindingResult();
        form.onSubmit(merordersheethdr, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
