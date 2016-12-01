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
public class MerordersheethdrControllerTest extends BaseControllerTestCase {
    @Autowired
    private MerordersheethdrController controller;
    private MockHttpServletRequest request;
    
	@Test
    public void testHandleRequest() throws Exception {
		log.debug("testing testHandleRequest...");
        request = newGet("/merordersheethdrform");
        request.addParameter("styleId", "STX022");
        request.addParameter("locationCode", "HC");
        request.addParameter("compCode", "Redln");
        request.addParameter("custCode", "THILAK");
        request.addParameter("depCode", "TRANS");
        request.addParameter("season", "PS");
        
		Model model = controller.handleRequest(null,request);
        Map m = model.asMap();
        assertNotNull(m.get("merordersheethdrList"));
        assertTrue(((List) m.get("merordersheethdrList")).size() > 0);
    }

   /* @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        MerordersheethdrManager merordersheethdrManager = (MerordersheethdrManager) applicationContext.getBean("merordersheethdrManager");
        merordersheethdrManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("merordersheethdrList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }*/
}