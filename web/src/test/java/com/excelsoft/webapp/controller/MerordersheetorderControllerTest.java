package com.excelsoft.webapp.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class MerordersheetorderControllerTest extends BaseControllerTestCase {
    @Autowired
    private MerordersheetorderController controller;

    @SuppressWarnings("rawtypes")
	@Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("merordersheetorderList"));
        assertTrue(((List) m.get("merordersheetorderList")).size() > 0);
    }

    /*@Test
    public void testSearch() throws Exception {
        // regenerate indexes
        MerordersheetorderManager merordersheetorderManager = (MerordersheetorderManager) applicationContext.getBean("merordersheetorderManager");
        merordersheetorderManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("merordersheetorderList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }*/
}