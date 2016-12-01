package com.excelsoft.webapp.controller;

import com.excelsoft.Constants;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import com.excelsoft.service.UserManager;

import static org.junit.Assert.*;

public class UserControllerTest extends BaseControllerTestCase {
    @Autowired
    private UserController c;

    @Test
    public void testHandleRequest() throws Exception {
        ModelAndView mav = c.handleRequest(null);
        Map m = mav.getModel();
        log.debug(m.toString());
        assertNotNull(m.get("mstuserList"));
        assertEquals("admin/userList", mav.getViewName());
    }

    @Test
    public void testSearch() throws Exception {
        // reindex before searching
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        userManager.reindex();

        ModelAndView mav = c.handleRequest("es");
        Map m = mav.getModel();
        List results = (List) m.get("mstuserList");
        assertNotNull(results);
        assertTrue(results.size() >= 1);
        assertEquals("admin/userList", mav.getViewName());
    }
}
