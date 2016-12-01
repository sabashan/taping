package com.excelsoft.webapp.controller;

import com.excelsoft.util.ConvertUtil;
import com.excelsoft.webapp.controller.BaseControllerTestCase;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import static org.junit.Assert.*;

public class MerprecostsheetFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MerprecostsheetFormController form;
    private Merprecostsheet merprecostsheet;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/merprecostsheetform");
        request.addParameter("preCostSheetNo", "1");
        request.addParameter("versionNo", "1");
        request.addParameter("costsheetType", "HC");

        Model model = form.showForm(request);
        assertNotNull(model);
    }

    @Test
    public void testSave() throws Exception {
    	log.debug("testing save...");
        request = newGet("/merprecostsheetform");
        request.addParameter("id.preCostSheetNo", "2");
        request.addParameter("id.versionNo", "0");
        request.addParameter("id.costsheetType", "HO");
        
        request.addParameter("locationCode","HC") ;
        request.addParameter("custCode","THILAK") ;
        request.addParameter("styleId","STX022") ;
        request.addParameter("depCode","TRANS") ;
        request.addParameter("compCode","Redln") ;
        
        request.addParameter("section", "section1");
        Model model = form.showForm(request);
        assertNotNull(model);
        MerprecostsheetId id=new MerprecostsheetId("2", ConvertUtil.getDecimal("O"),"HO");
        merprecostsheet =new Merprecostsheet();
        merprecostsheet.setId(id);
        
        // update required fields
        merprecostsheet.setSeason("AUTOM");
        BindingResult errors = new DataBinder(merprecostsheet).getBindingResult();
        form.onSubmit(merprecostsheet, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
    	log.debug("testing delete...");
        request = newPost("/merprecostsheetform");
        request.addParameter("delete", "");
        merprecostsheet = new Merprecostsheet();
        final MerprecostsheetId id = new MerprecostsheetId("2", ConvertUtil.getDecimal("O"),"HO");
        merprecostsheet.setId(id);
        merprecostsheet.setSeason("S01");
        BindingResult errors = new DataBinder(merprecostsheet).getBindingResult();
        form.onSubmit(merprecostsheet, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
