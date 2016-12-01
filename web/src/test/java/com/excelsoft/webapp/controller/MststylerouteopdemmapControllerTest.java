package com.excelsoft.webapp.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class MststylerouteopdemmapControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststylerouteopdemmapController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("mststylerouteoperationdemmapList"));
        assertTrue(((List) m.get("mststylerouteoperationdemmapList")).size() > 0);
    }

}