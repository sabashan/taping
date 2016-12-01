package com.excelsoft.webapp.controller;

import com.excelsoft.webapp.controller.BaseControllerTestCase;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.MststylerouteoperationId;

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

public class MststylerouteoperationFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststylerouteoperationFormController form;
    private Mststyleroute mststyleroute;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/mststylerouteoperationform");
        request.addParameter("styleId", "ST1022");
        request.addParameter("locationCode", "HO");
        request.addParameter("compCode", "Hamdia");
        request.addParameter("custCode", "KANDY");
        request.addParameter("depCode", "FINAN");
        request.addParameter("componentId", "1");
        request.addParameter("mainColor", "Blue");
        request.addParameter("styleRouteId", "1");
        request.addParameter("targetDate", "2014-06-06");
        mststyleroute = form.showForm(request);
        assertNotNull(mststyleroute);
    }

    @Test
    public void testSave() throws Exception {
    	log.debug("testing Save ");
        request = newGet("/mststylerouteoperationform");
        
        request.addParameter("styleId", "ST1022");
        request.addParameter("locationCode", "HO");
        request.addParameter("compCode", "Hamdia");
        request.addParameter("custCode", "KANDY");
        request.addParameter("depCode", "FINAN");
        request.addParameter("componentId", "1");
        request.addParameter("mainColor", "Blue");
        request.addParameter("styleRouteId", "1");
         
        request.addParameter("delete", "");
        request.setRemoteUser("es");

        mststyleroute = form.showForm(request);
        assertNotNull(mststyleroute);

        //request = newPost("/mststylerouteoperationform");

        mststyleroute = form.showForm(request);
        // update required fields
        request.addParameter("targetDate", "2014-06-06");
        BindingResult errors = new DataBinder(mststyleroute).getBindingResult();
        form.onSubmit(mststyleroute, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
    	log.debug("testing Delete ");
        request = newPost("/mststylerouteoperationform");
        request.addParameter("delete", "true");
        request.addParameter("styleId", "ST1022");
        request.addParameter("locationCode", "HO");
        request.addParameter("compCode", "Hamdia");
        request.addParameter("custCode", "KANDY");
        request.addParameter("depCode", "FINAN");
        request.addParameter("componentId", "1");
        request.addParameter("mainColor", "Blue");
        request.addParameter("styleRouteId", "1");
        mststyleroute = new Mststyleroute();
       // 1 	Hamdia 	KANDY 	FINAN 	HO 	ST1022 	1 	Blue
       // final MststylerouteoperationId id = new MststylerouteoperationId(componentId, mainColor, styleRouteId, styleId, locationCode, custCode, compCode, depCode)
        //final MststylerouteoperationId id = new MststylerouteoperationId("1", "Blue", 1L , "ST1022", "HO", "KANDY", "Hamdia", "FINAN");
        mststyleroute.setStyleRouteId(1L);
        mststyleroute.setRouteStatus("Pending");
       // mststylerouteoperation.setTargetDate("2014-06-06");
        request.addParameter("targetDate", "2014-06-25");
        log.debug(mststyleroute);
        
        BindingResult errors = new DataBinder(mststyleroute).getBindingResult();
        log.debug(errors);
        
        form.onSubmit(mststyleroute, errors, request, new MockHttpServletResponse());
        log.debug(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
