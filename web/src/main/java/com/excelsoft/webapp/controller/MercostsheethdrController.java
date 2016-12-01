package com.excelsoft.webapp.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MercostsheethdrManager;
import com.excelsoft.service.MerprecostsheetManager;
import com.excelsoft.service.MststyleheaderManager;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mercostsheethdrs*")
public class MercostsheethdrController {
	protected final transient Log log = LogFactory.getLog(getClass());
    private MercostsheethdrManager mercostsheethdrManager;
    private MerprecostsheetManager merprecostsheetManager;
    private MststyleheaderManager mststyleheaderManager;

    
    @Autowired
    public void setMercostsheethdrManager(
			MercostsheethdrManager mercostsheethdrManager) {
		this.mercostsheethdrManager = mercostsheethdrManager;
	}

	@Autowired
	public void setMststyleheaderManager(MststyleheaderManager mststyleheaderManager) {
		this.mststyleheaderManager = mststyleheaderManager;
	}

	@Autowired
    public void setMerprecostsheetManager(MerprecostsheetManager merprecostsheetManager) {
        this.merprecostsheetManager = merprecostsheetManager;
    }

    @SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query,HttpServletRequest request)
    throws Exception {
    	Model model = new ExtendedModelMap();
    	String locationCode = request.getParameter("locationCode") ;
		String custCode = request.getParameter("custCode") ;
		String styleId = request.getParameter("styleId") ;
		String depCode = request.getParameter("depCode") ;
		String compCode = request.getParameter("compCode") ;
		String season = request.getParameter("season") ;
		if(!(StringUtils.isBlank(season) || StringUtils.isBlank(styleId) || StringUtils.isBlank(depCode)|| StringUtils.isBlank(custCode)|| StringUtils.isBlank(compCode)|| StringUtils.isBlank(locationCode))){	        
			Mststyleheader mststyleheader= mststyleheaderManager.getStyle(compCode, locationCode, custCode, depCode, styleId);  		
			if(request.getParameter("precostsheet") != null){ 
	    		log.debug("Sch Pre cost sheet");
	        	try {
	        		model.addAttribute("merprecostsheethdrList",merprecostsheetManager.getAll(mststyleheader, season, query));   
	        		model.addAttribute("page","Precostsheet");  
		        } catch (SearchException se) {
		            model.addAttribute("searchError", se.getMessage());
		            log.debug(se.getMessage());  
		        }
	        } 
	    	if(request.getParameter("costsheet") != null){ 
	    		log.debug("Sch cost sheet");
		    	try {
		    		log.debug("12321");
	        		model.addAttribute("mercostsheethdrList",mercostsheethdrManager.getAll(mststyleheader, season, query));
	        		log.debug("12321");
	        		model.addAttribute("page","Costsheet");  
	        		log.debug("12321");
	        		List<Mercostsheethdr> mercostsheethdrs = mercostsheethdrManager.getAll(mststyleheader, season, query);
	        		for (Iterator iterator = mercostsheethdrs.iterator(); iterator.hasNext();) {
						Mercostsheethdr mercostsheethdr = (Mercostsheethdr) iterator.next();
						log.debug(mercostsheethdr.toString());
					}
	        		log.debug("12321");
		        } catch (SearchException se) {
		            model.addAttribute("searchError", se.getMessage());
		            log.debug(se.getMessage());  
		        }
	    	}
    	}
	    	
    	try {
    		model.addAttribute("mercostsheethdrdueList",mercostsheethdrManager.getAlldue("Incomplete", request.getRemoteUser()));   
    		     
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            log.debug(se.getMessage());  
        }
    	
    	try {
    		model.addAttribute("merprecostsheethdrAppList",merprecostsheetManager.getAll("Approved"));   
              
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            log.debug(se.getMessage());  
        }
    	if(request.getParameter("fcsmain2") != null || request.getParameter("fcsmain2") != ""){
    		model.addAttribute("fcsmain2",request.getParameter("fcsmain2"));
    	}
        return model;
    }
}
