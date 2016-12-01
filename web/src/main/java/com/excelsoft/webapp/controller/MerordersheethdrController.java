package com.excelsoft.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import com.excelsoft.dao.SearchException;
import com.excelsoft.service.MerordersheethdrManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.model.Mststyleheader;

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
@RequestMapping("/merordersheethdrs*")
public class MerordersheethdrController {
	
	protected final transient Log log = LogFactory.getLog(getClass());
	
    private MerordersheethdrManager merordersheethdrManager;
    private MststyleheaderManager mststyleheaderManager;
    @Autowired
    public void setMerordersheethdrManager(MerordersheethdrManager merordersheethdrManager) {
        this.merordersheethdrManager = merordersheethdrManager;
    }
    @Autowired
	public void setMststyleheaderManager(MststyleheaderManager mststyleheaderManager) {
		this.mststyleheaderManager = mststyleheaderManager;
	}
    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query,HttpServletRequest request)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
	        String locationCode = request.getParameter("locationCode") ;
			String custCode = request.getParameter("custCode") ;
			String styleId = request.getParameter("styleId") ;
			String depCode = request.getParameter("depCode") ;
			String compCode = request.getParameter("compCode") ;
			String season = request.getParameter("season") ;
			String dquery = request.getParameter("dquery") ;
			String pquery = request.getParameter("pquery") ;

			
			if(!(StringUtils.isBlank(season) || StringUtils.isBlank(styleId) || StringUtils.isBlank(depCode)|| StringUtils.isBlank(custCode)|| StringUtils.isBlank(compCode)|| StringUtils.isBlank(locationCode))){	        
				Mststyleheader mststyleheader= mststyleheaderManager.getStyle(compCode, locationCode, custCode, depCode, styleId);  		
				if(query==null || query==""){
					query="NOT";
				}
				if(pquery==null || pquery==""){
					pquery="NOT";
				}
				if(mststyleheader==null){
					mststyleheader=new Mststyleheader();
				}
				log.debug("mststyleheader "+mststyleheader);
				model.addAttribute("merordersheethdrList",merordersheethdrManager.getAll(query, mststyleheader,false));
				model.addAttribute("merordersheethdrproList",merordersheethdrManager.getAll(pquery, mststyleheader,true));
			}
			else{
				model.addAttribute("NO","NO");
			}
			if(dquery==null || dquery==""){
				dquery="NOT";
			}
        	model.addAttribute("merordersheethdrdueList",merordersheethdrManager.getAll(dquery, "Incomplete",request.getRemoteUser(),false));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
        }
        return model;
    }
}
