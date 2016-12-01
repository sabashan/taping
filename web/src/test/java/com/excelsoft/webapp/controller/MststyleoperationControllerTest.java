package com.excelsoft.webapp.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class MststyleoperationControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststyleoperationController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("mststylerouteoperationList"));
        assertTrue(((List) m.get("mststylerouteoperationList")).size() > 0);
    }

    
}