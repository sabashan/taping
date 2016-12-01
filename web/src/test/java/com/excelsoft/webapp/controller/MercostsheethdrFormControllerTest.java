package com.excelsoft.webapp.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.util.ConvertUtil;


public class MercostsheethdrFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private MercostsheethdrFormController form;
    private Mercostsheethdr mercostsheethdr;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/mercostsheethdrform");
//        request.addParameter("id", "-1");
        request.addParameter("costSheetNo", "S1");
        request.addParameter("costSheetType", "ST1");
        request.addParameter("versionNo", "1");
        request.addParameter("section", "section01");
        
        Model model = form.showForm(request);
        assertNotNull(model);
    }

    @SuppressWarnings("unused")
	@Test
    public void testSave() throws Exception {
    	log.debug("Testing save ");
        request = newGet("/mercostsheethdrform");
//        request.addParameter("id", "-1");
        request.addParameter("costSheetNo", "S1");
        request.addParameter("costSheetType", "ST1");
        request.addParameter("versionNo", "1");
        request.addParameter("pageNumber", "page1");
        request.addParameter("section", "section02");
        
        log.debug("**");
        Model model = form.showForm(request);
        log.debug(model);
        assertNotNull(model);
       
        request = newPost("/mercostsheethdrform");
        mercostsheethdr =new Mercostsheethdr();
        
        request.addParameter("locationCode","HC") ;
        request.addParameter("custCode","THILAK") ;
        request.addParameter("styleId","STX022") ;
        request.addParameter("depCode","TRANS") ;
        request.addParameter("compCode","Redln") ;
 		request.addParameter("pageNumber", "page1");
        request.addParameter("section","section0") ;
        
        MercostsheethdrId id = new MercostsheethdrId();
        id.setCostSheetNo("S1");
        id.setCostSheetType("ST1");
        id.setVersionNo(ConvertUtil.getDecimal("1"));
        mercostsheethdr.setId(id);
      //  MerprecostsheetId id2=new MerprecostsheetId("2", ConvertUtil.getDecimal("O"),"HO");
     //   Merprecostsheet merprecostsheet=new Merprecostsheet(id2);
      //  log.debug(mercostsheethdr.toString());
        // update required fields
        mercostsheethdr.setSeason("Season");
//        mercostsheethdr.setMerprecostsheethdr(merprecostsheet);
        mercostsheethdr.getId().setCostSheetNo("S4");
        BindingResult errors = new DataBinder(mercostsheethdr).getBindingResult();
        form.onSubmit(mercostsheethdr, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
    	log.debug("Testing Edit ");
        request = newPost("/mercostsheethdrform");
        request.addParameter("delete", "");
        mercostsheethdr = new Mercostsheethdr();
        MercostsheethdrId id = new MercostsheethdrId();
        id.setCostSheetNo("S1");
        id.setCostSheetType("ST1");
        id.setVersionNo(ConvertUtil.getDecimal("1"));
        mercostsheethdr.setId(id);

        BindingResult errors = new DataBinder(mercostsheethdr).getBindingResult();
        form.onSubmit(mercostsheethdr, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
