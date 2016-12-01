package com.excelsoft.webapp.controller;


import com.excelsoft.webapp.controller.BaseControllerTestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;

public class MststyleheaderControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststyleheaderController controller;
    private MockHttpServletRequest request;

    @SuppressWarnings("rawtypes")
	@Test
    public void testHandleRequest() throws Exception {
    	
    	request = newGet("/mststyleheaders");
    	request.setRemoteUser("es");
        Model model = controller.handleRequest(request);
        
        Map m = model.asMap();
        assertNotNull(m.get("mststyleheaderList"));
        assertTrue(((List) m.get("mststyleheaderList")).size() > 0);
    }

   /* @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        MststyleheaderManager mststyleheaderManager = (MststyleheaderManager) applicationContext.getBean("mststyleheaderManager");
        mststyleheaderManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("mststyleheaderList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }*/
}