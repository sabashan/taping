package com.excelsoft.webapp.controller;


import com.excelsoft.webapp.controller.BaseControllerTestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;
@SuppressWarnings("rawtypes")
public class MerprecostsheetControllerTest extends BaseControllerTestCase {
    @Autowired
    private MerprecostsheetController controller;
    private MockHttpServletRequest request;
   
	@Test
    public void testHandleRequest() throws Exception {
        log.debug("View mode");
		request = newGet("/merprecostsheets");
		request.addParameter("styleId", "ST1022");
        request.addParameter("locationCode", "HO");
        request.addParameter("compCode", "Hamdia");
        request.addParameter("custCode", "KANDY");
        request.addParameter("depCode", "FINAN");
        request.addParameter("season", "PS");
        request.setRemoteUser("es");

        Model model = controller.handleRequest(null,request);
        Map m = model.asMap();
        assertNotNull(m.get("merprecostsheetList"));
        assertTrue(((List) m.get("merprecostsheetList")).size() > 0);
    }

//    @Test
//    public void testSearch() throws Exception {
//        // regenerate indexes
//        MerprecostsheetManager merprecostsheetManager = (MerprecostsheetManager) applicationContext.getBean("merprecostsheetManager");
//        merprecostsheetManager.reindex();
//
//        Model model = controller.handleRequest("*");
//        Map m = model.asMap();
//        List results = (List) m.get("merprecostsheetList");
//        assertNotNull(results);
//        assertEquals(3, results.size());
//    }
}