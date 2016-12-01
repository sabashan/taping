package com.excelsoft.webapp.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import com.excelsoft.model.Merordersheetorder;
import com.excelsoft.model.MerordersheetorderId;


public class MerordersheetorderFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MerordersheetorderFormController form;
    private Merordersheetorder merordersheetorder;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/merordersheetorderform");
        request.addParameter("ordersheetId", "1");
        merordersheetorder = form.showForm(request);
        assertNotNull(merordersheetorder);
    }

    @Test
    public void testSave() throws Exception {
    	
        request = newGet("/merordersheetorderform");
        request.addParameter("ordersheetId", "1");
        merordersheetorder = form.showForm(request);
        assertNotNull(merordersheetorder);
        request = newPost("/merordersheetorderform");        
        MerordersheetorderId id= new MerordersheetorderId(1L);
        merordersheetorder = new Merordersheetorder(id);
        BindingResult errors = new DataBinder(merordersheetorder).getBindingResult();
        form.onSubmit(merordersheetorder, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/merordersheetorderform");
        request.addParameter("delete", "");
        merordersheetorder = new Merordersheetorder();
        MerordersheetorderId id=new MerordersheetorderId(1L, "0","HC");
        merordersheetorder.setId(id);

        BindingResult errors = new DataBinder(merordersheetorder).getBindingResult();
        form.onSubmit(merordersheetorder, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
