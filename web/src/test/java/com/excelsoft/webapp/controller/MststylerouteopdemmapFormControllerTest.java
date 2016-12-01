package com.excelsoft.webapp.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.excelsoft.model.Mststylerouteoperationdemmap;
import com.excelsoft.model.MststylerouteoperationdemmapId;

public class MststylerouteopdemmapFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststylerouteopdemmapFormController form;
    private Mststylerouteoperationdemmap mststylerouteoperationdemmap;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/mststylerouteopdemmapform");
        request.addParameter("smvV","300");
		/*<value description="opeartion_no">1</value>
		<value description="style_route_id">1</value>
		<value description="smv_value">12</value>
		<value description="vertical_value">12</value>
		<value description="vertical_dem"></value>
		<value description="horizontal_value"></value>
		<value description="horizontal_dem"></value>
		<value description="main_color">Blue</value>*/
        //Size,Fit,Blue:AA:12,6161616, [FIT,INSEAM,Blue:AA:12,300];
        
        request.addParameter("horizontalDem", "FIT");
        request.addParameter("locationCode", "HO");
        request.addParameter("verticalDem", "INSEAM");
        request.addParameter("horizontalValue", "AA");
        request.addParameter("verticalValue", "12");
        request.addParameter("mainColor", "Blue");
        request.addParameter("styleRouteId", "1");
        request.addParameter("opeartionNo","1");
        
        //request.addParameter("smvValueArr","[FIT,INSEAM,Blue:AA:12,300]");
        /*request.addParameter("horizontalDem", "");
        request.addParameter("verticalDem", "");
        request.addParameter("horizontalValue", "");
        request.addParameter("verticalValue", "");*/
        
        mststylerouteoperationdemmap = form.showForm(request);
        log.debug(mststylerouteoperationdemmap.toString());
        
        assertNotNull(mststylerouteoperationdemmap);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/mststylerouteopdemmapform");
        /*MststylerouteopdemmapId id = new MststylerouteopdemmapId(2L, "1", "Blue", 1L, "ST1022", "HO", "KANDY", "Hamdia", "FINAN",
        		"FIT", "INSEAM", "AA", "12");
        Long opeartionNo, String componentId,
		String mainColor, Long styleRouteId, String styleId,
		String locationCode, String custCode, String compCode,
		String depCode, String horizontalDem, String verticalDem,
		String horizontalValue, String verticalValue*/
		
        request.addParameter("styleId", "ST1022");
        request.addParameter("locationCode", "HO");
        request.addParameter("compCode", "Hamdia");
        request.addParameter("custCode", "KANDY");
        request.addParameter("depCode", "FINAN");
        request.addParameter("componentId", "1");
        request.addParameter("mainColor", "Blue");
        request.addParameter("styleRouteId", "1");
        request.addParameter("opeartionNo","2");
        request.addParameter("horizontalDem", "FIT");
        request.addParameter("verticalDem", "INSEAM");
        request.addParameter("horizontalValue", "AA");
        request.addParameter("verticalValue", "12");

        request.addParameter("smvValueArr","'FIT','INSEAM','Blue:AA:12',300");
        mststylerouteoperationdemmap = form.showForm(request);
        assertNotNull(mststylerouteoperationdemmap);

        //request = newPost("/mststylerouteopdemmapform");

        //mststylerouteopdemmap = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(mststylerouteoperationdemmap).getBindingResult();
        form.onSubmit(mststylerouteoperationdemmap, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/mststylerouteopdemmapform");
        request.addParameter("delete", "");
        mststylerouteoperationdemmap = new Mststylerouteoperationdemmap();
        MststylerouteoperationdemmapId id = new MststylerouteoperationdemmapId(2, 1L, "INSEAM", "FIT", "AA", "12", "Blue");
        //2L, "1", "Blue", 1L, "ST1022", "HO", "KANDY", "Hamdia", "FINAN",, , , );
        mststylerouteoperationdemmap.setId(id);
        BindingResult errors = new DataBinder(mststylerouteoperationdemmap).getBindingResult();
        form.onSubmit(mststylerouteoperationdemmap, errors, request, new MockHttpServletResponse());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
