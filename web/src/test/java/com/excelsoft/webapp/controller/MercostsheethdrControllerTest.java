package com.excelsoft.webapp.controller;

import java.util.Map;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.Model;
@SuppressWarnings("rawtypes")
public class MercostsheethdrControllerTest extends BaseControllerTestCase {
    @Autowired
    private MercostsheethdrController controller;
    private MockHttpServletRequest request;
    
	@Test
    public void testHandleRequest() throws Exception {
    	 log.debug("View mode");
 		request = newGet("/mercostsheethdrs");
 		request.addParameter("styleId", "ST1022");
         request.addParameter("locationCode", "HO");
         request.addParameter("compCode", "Hamdia");
         request.addParameter("custCode", "KANDY");
         request.addParameter("depCode", "FINAN");
         request.addParameter("season", "PS");
         request.addParameter("costsheet", "PS");
         request.setRemoteUser("es");
        Model model = controller.handleRequest(null,request);
        
		@SuppressWarnings("unused")
		Map m = model.asMap();
        log.debug(model);
       // assertNotNull(m.get("mercostsheethdrList"));
       // assertTrue(((List) m.get("mercostsheethdrList")).size() > 0);
    }

   /* @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        //MercostsheethdrManager mercostsheethdrManager = (MercostsheethdrManager) applicationContext.getBean("mercostsheethdrManager");
        //mercostsheethdrManager.reindex();
    	 log.debug("View mode");
 		request = newGet("/merprecostsheets");
 		request.addParameter("styleId", "ST1022");
         request.addParameter("locationCode", "HO");
         request.addParameter("compCode", "Hamdia");
         request.addParameter("custCode", "KANDY");
         request.addParameter("depCode", "FINAN");
         request.addParameter("season", "PS");
         request.setRemoteUser("es");
        Model model = controller.handleRequest("S1",request);
        Map m = model.asMap();
        List results = (List) m.get("mercostsheethdrList");
        assertNotNull(results);
        assertTrue(results.size() > 0);
    }*/
}