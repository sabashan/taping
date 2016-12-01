package com.excelsoft.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.excelsoft.dao.SearchException;
import com.excelsoft.service.MstpictureManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.service.MststylepictureManager;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.Mststylepicture;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mststyleheaders*")
public class MststyleheaderController {
    private MststyleheaderManager mststyleheaderManager;
    protected final transient Log log = LogFactory.getLog(getClass());
    private MststylepictureManager mststylepictureManager;
    private MstpictureManager mstpictureManager;
    
    @Autowired
    public void setMststyleheaderManager(MststyleheaderManager mststyleheaderManager) {
        this.mststyleheaderManager = mststyleheaderManager;
    }
    
    @Autowired
    public void setMstpictureManager(MstpictureManager mstpictureManager) {
        this.mstpictureManager = mstpictureManager;
    }
    
    @Autowired
	public void setMststylepictureManager(MststylepictureManager mststylepictureManager) {
		this.mststylepictureManager = mststylepictureManager;
	}
    
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(HttpServletRequest request)
    throws Exception {
        Model model = new ExtendedModelMap();
    	String quary = request.getParameter("q");
    	
    	if(!StringUtils.isBlank(quary)){
    		try {
    			String []idStrings={"compCode","custCode","depCode","locationCode","styleId"}; 
    			model.addAttribute("mststyleheaderList",mststyleheaderManager.getallsearch(quary,idStrings));
    		} 
	        catch (SearchException se) {
	            model.addAttribute("searchError", se.getMessage());
	            log.debug(se.getMessage());
	            model.addAttribute("mststyleheaderList",mststyleheaderManager.getAll());      
	        }
        }
        else{
    		try {
    	        List<Mststyleheader> mststyleheaders=mststyleheaderManager.getAll();
	        	for (int i = 0; i < mststyleheaders.size(); i++) {
	        		List<Mststylepicture> mststylepicture=mststylepictureManager.getZero(mststyleheaders.get(i));
		        	if(!mststylepicture.isEmpty()){
		        		try{
		        			String b64 =javax.xml.bind.DatatypeConverter.printBase64Binary(mstpictureManager.get(mststylepicture.get(0).getId().getPicCode()).getPicture());		
		        			mststyleheaders.get(i).setMststylepicture(b64);
		        		}
		        		catch(Exception e){
		        			log.debug(e.getMessage());
		        		}
		        	}
				}
	            model.addAttribute("mststyleheaderList",mststyleheaders);
	        } 
	        catch (SearchException se) {
	            model.addAttribute("Error in common ", se.getMessage());
	            log.debug(se.getMessage());
	            model.addAttribute("mststyleheaderList",mststyleheaderManager.getAll());      
	        }
    	}
    	try{
	    	List<Mststyleheader> mststyleheadersdue= mststyleheaderManager.getPendingStyles("Incomplete",request.getRemoteUser());
	    	for (int i = 0; i < mststyleheadersdue.size(); i++) {
	    		List<Mststylepicture> mststylepicture=mststylepictureManager.getZero(mststyleheadersdue.get(i));
	        	if(!mststylepicture.isEmpty()){
	        		String b64 =javax.xml.bind.DatatypeConverter.printBase64Binary(mstpictureManager.get(mststylepicture.get(0).getId().getPicCode()).getPicture());		
       			 	mststyleheadersdue.get(i).setMststylepicture(b64);
	        	}
			}
	    	model.addAttribute("mststyleheaderdueList",mststyleheadersdue );
	    	log.debug(mststyleheadersdue.toString());
	    }
    	catch(Exception e){
    		model.addAttribute("Error", e.getMessage());
    		log.debug(e.getMessage());
    		model.addAttribute("mststyleheaderdueList", mststyleheaderManager.getAll());
    	}
        return model;
    }
    
  //  mststyleheaderManager.getcollums();
}
