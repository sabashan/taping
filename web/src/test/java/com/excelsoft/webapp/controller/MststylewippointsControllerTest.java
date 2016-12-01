package com.excelsoft.webapp.controller;

import com.excelsoft.service.MststylewippointsManager;
import com.excelsoft.model.Mststylewippoints;

import com.excelsoft.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class MststylewippointsControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststylewippointsController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("mststylewippointsList"));
        assertTrue(((List) m.get("mststylewippointsList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        MststylewippointsManager mststylewippointsManager = (MststylewippointsManager) applicationContext.getBean("mststylewippointsManager");
        mststylewippointsManager.reindex();

        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        List results = (List) m.get("mststylewippointsList");
        assertNotNull(results);
    }
}