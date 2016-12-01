package com.excelsoft.webapp.controller;

import com.excelsoft.webapp.controller.BaseControllerTestCase;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import static org.junit.Assert.*;

public class MststyleheaderFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststyleheaderFormController form;
    private Mststyleheader mststyleheader;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/mststyleheaderform");
        
        request.addParameter("styleId", "STX022");
        request.addParameter("locationCode", "HC");
        request.addParameter("compCode", "Redln");
        request.addParameter("custCode", "THILAK");
        request.addParameter("depCode", "TRANS");
        
        Model  model = form.showForm(request);
        assertNotNull(model);
    }

    @Test
    public void testSave() throws Exception {
    	 log.debug("testing Save...");
        request = newGet("/mststyleheaderform");
        request.addParameter("styleId", "STX022");
        request.addParameter("locationCode", "HC");
        request.addParameter("compCode", "Redln");
        request.addParameter("custCode", "THILAK");
        request.addParameter("depCode", "TRANS");
        request.addParameter("userId","es");
        request.setRemoteUser("es");
        request.addParameter("section","Section01");
        //dataImg dataComponent colors dataCcolor dimensionRemove verticalRemove
        Model  model = form.showForm(request);
        assertNotNull(model);
       
        MststyleheaderId mststyleheaderid= new MststyleheaderId("STX022","HC","TRANS","Redln","THILAK");
        mststyleheader=new Mststyleheader(mststyleheaderid);

        // update required fields
        mststyleheader.setFlag("Pending");
        mststyleheader.setProductRange("Size");
        mststyleheader.setUserId("es");

        BindingResult errors = new DataBinder(mststyleheader).getBindingResult();
        form.onSubmit(mststyleheader, errors, request, new MockHttpServletResponse());
       // log.debug(errors.toString());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
    	 log.debug("testing Remove...");
    	 request = newGet("/mststyleheaderform");
         request.addParameter("id.styleId", "STX022");
         request.addParameter("id.locationCode", "HC");
         request.addParameter("id.compCode", "Redln");
         request.addParameter("id.custCode", "THILAK");
         request.addParameter("id.depCode", "TRANS");
         request.addParameter("userId","es");
         request.addParameter("delete", "");
         request.setRemoteUser("es");
         //dataImg dataComponent colors dataCcolor dimensionRemove verticalRemove
         Model  model = form.showForm(request);
         assertNotNull(model);
        
         MststyleheaderId mststyleheaderid= new MststyleheaderId("STX022","HC","TRANS","Redln","THILAK");
         mststyleheader=new Mststyleheader(mststyleheaderid);
    
    	
    	
    	mststyleheader.setId(mststyleheaderid);
    	
    	mststyleheader.setFlag("Pending");
        mststyleheader.setProductRange("Size");
        mststyleheader.setUserId("es");
        
    	BindingResult errors = new DataBinder(mststyleheader).getBindingResult();
        form.onSubmit(mststyleheader, errors, request, new MockHttpServletResponse());
   
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
