package com.excelsoft.webapp.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.Model;

public class MststylerouteoperationControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststylerouteoperationController controller;
    private MockHttpServletRequest request;

    @Test
    public void testHandleRequest() throws Exception {
       
        request = newGet("/mststylerouteoperations");
        request.addParameter("styleId", "ST1022");
        request.addParameter("locationCode", "HO");
        request.addParameter("custCode", "KANDY");
        request.addParameter("compCode", "Hamdia");
        request.addParameter("depCode", "FINAN");
        request.setRemoteUser("es");
        Model model = controller.handleRequest(null, request);

        Map m = model.asMap();
        assertNotNull(m.get("mststylerouteoperationList"));
        assertTrue(((List) m.get("mststylerouteoperationList")).size() > 0);
    }

}