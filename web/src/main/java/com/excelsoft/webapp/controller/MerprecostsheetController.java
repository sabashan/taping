package com.excelsoft.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Mststyleheader;
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
@RequestMapping("/merprecostsheets*")
public class MerprecostsheetController {
	protected final transient Log log = LogFactory.getLog(getClass());
    private MerprecostsheetManager merprecostsheetManager;
    private MststyleheaderManager mststyleheaderManager;

    
    @Autowired
	public void setMststyleheaderManager(MststyleheaderManager mststyleheaderManager) {
		this.mststyleheaderManager = mststyleheaderManager;
	}

	@Autowired
    public void setMerprecostsheetManager(MerprecostsheetManager merprecostsheetManager) {
        this.merprecostsheetManager = merprecostsheetManager;
    }

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
        Mststyleheader mststyleheader = null;
        if(!(StringUtils.isBlank(season) || StringUtils.isBlank(styleId) || StringUtils.isBlank(depCode)|| StringUtils.isBlank(custCode)|| StringUtils.isBlank(compCode)|| StringUtils.isBlank(locationCode))){
        	try {
	        		mststyleheader= mststyleheaderManager.getStyle(compCode, locationCode, custCode, depCode, styleId);
					if(mststyleheader!=null){
						model.addAttribute("added","added");
						
						model.addAttribute(merprecostsheetManager.getAll(mststyleheader, season, query)); 
					}
	              
	        } catch (SearchException se) {
	            model.addAttribute("searchError", se.getMessage());
	            log.debug(se.getMessage());  
	        }
        	 
        }
        try {
        	model.addAttribute("merprecostsheetListdue",merprecostsheetManager.getAllDue("incomplete", request.getRemoteUser()));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
           log.debug(se.getMessage());
        
        }
        return model;
    }
}
