package com.excelsoft.webapp.controller;

import com.excelsoft.service.MststylewippointitemtypeManager;
import com.excelsoft.model.Mststylewippointitemtype;

import com.excelsoft.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class MststylewippointitemtypeControllerTest extends BaseControllerTestCase {
    @Autowired
    private MststylewippointitemtypeController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("mststylewippointitemtypeList"));
        assertTrue(((List) m.get("mststylewippointitemtypeList")).size() > 0);
    }
}