package com.excelsoft.webapp.controller;


import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.Mststylepicture;
import com.excelsoft.service.MstpictureManager;
import com.excelsoft.service.MststylechildColorManager;
import com.excelsoft.service.MststylecomponentManager;
import com.excelsoft.service.MststyledemManager;
import com.excelsoft.service.MststyledemmapManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.service.MststylemainColorManager;
import com.excelsoft.service.MststylepictureManager;

@Controller
@RequestMapping("/mststylemasterview*")
@ResponseBody
public class Mststylemasterview extends BaseFormController{
	private MststyleheaderManager mststyleheaderManager = null;
	private MststyledemManager mststyledemManager = null;
	private MststyledemmapManager mststyledemmapManager = null;
	private MststylecomponentManager mststylecomponentManager = null;
	private MststylechildColorManager mststylechildColorManager = null;
	private MststylemainColorManager mststylemainColorManager = null;
	private MststylepictureManager mststylepictureManager = null;
	private MstpictureManager mstpictureManager  = null;
	
	@Autowired
	public void setMstpictureManager(
			MstpictureManager mstpictureManager) {
		this.mstpictureManager = mstpictureManager;
	}
	@Autowired
	public void setMststylechildColorManager(
			MststylechildColorManager mststylechildColorManager) {
		this.mststylechildColorManager = mststylechildColorManager;
	}
	@Autowired
	public void setMststylemainColorManager(
			MststylemainColorManager mststylemainColorManager) {
		this.mststylemainColorManager = mststylemainColorManager;
	}

	@Autowired
	public void setMststyleheaderManager(
			MststyleheaderManager mststyleheaderManager) {
		this.mststyleheaderManager = mststyleheaderManager;
	}

	@Autowired
	public void setMststyledemManager(MststyledemManager mststyledemManager) {
		this.mststyledemManager = mststyledemManager;
	}

	@Autowired
	public void setMststyledemmapManager(
			MststyledemmapManager mststyledemmapManager) {
		this.mststyledemmapManager = mststyledemmapManager;
	}

	@Autowired
	public void setMststylecomponentManager(
			MststylecomponentManager mststylecomponentManager) {
		this.mststylecomponentManager = mststylecomponentManager;
	}

	@Autowired
	public void setMststylepictureManager(MststylepictureManager mststylepictureManager) {
		this.mststylepictureManager = mststylepictureManager;
	}

	public Mststylemasterview() {
		setCancelView("redirect:mststyleheaders");
		setSuccessView("redirect:mststyleheaders");
	}
    
	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Model showForm(HttpServletRequest request) throws Exception {
		Model model = new ExtendedModelMap();
		MststyleheaderId id=null;
		/**
		 * Add params
		 */
		String styleId = request.getParameter("styleId");
		String locationCode = request.getParameter("locationCode");
		String compCode = request.getParameter("compCode");
		String custCode = request.getParameter("custCode");
		String depCode = request.getParameter("depCode");
		
		if (!(StringUtils.isBlank(styleId) || StringUtils.isBlank(locationCode) || StringUtils.isBlank(depCode) || StringUtils.isBlank(compCode) || StringUtils.isBlank(custCode))) {
			log.debug(" using param only ");
			id = new MststyleheaderId(styleId, locationCode, depCode, compCode, custCode);
		}
		try{
			List<Mststyleheader>mststyleheaders=mststyleheaderManager.getAll();
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
        	model.addAttribute("mststyleheaderList", mststyleheaders);

      	}
      	catch (SearchException se) {
        	log.debug("searchError" + se.getMessage());
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute("mststyleheaderList", "[]");
        }
		
		if(id!=null){
			try {
	        	Mststyleheader mststyleheader=mststyleheaderManager.get(id);
	        	model.addAttribute("mststyleheader", mststyleheader);
	        	
	        	List<Mststylepicture> mststylepicture=mststylepictureManager.getAll(mststyleheader);
	    		try {
	            	for(int i=0;i<mststylepicture.size();i++){
	            		//String b64 =javax.xml.bind.DatatypeConverter.printBase64Binary(mstpictureManager.get(mststylepicture.get(i).getId().getPicCode()).getPicture());		
	            		String b64 =javax.xml.bind.DatatypeConverter.printBase64Binary(mstpictureManager.get(mststylepicture.get(i).getId().getPicCode()).getPicture());
	    				mststylepicture.get(i).setMstPicpictures(b64);
	    			}
        		}
				catch(Exception ex){log.debug(ex.getMessage());}
	        	
	    		// mststylepicture=mststylepictureManager.getAll(mststyleheader);	
	    		
	        	model.addAttribute("mststylecomponentList", mststylecomponentManager.getAll(mststyleheader));
				model.addAttribute("mststylemaincolorList", mststylemainColorManager.getAll(mststyleheader));
				model.addAttribute("mststylechildcolorList", mststylechildColorManager.getAll(mststyleheader));
				model.addAttribute("mststylepictureList", mststylepicture);
				model.addAttribute("mststyledemList", mststyledemManager.getAll(mststyleheader));
				model.addAttribute("mststyledemmapList", mststyledemmapManager.getAll(mststyleheader));
	        } 
	        catch (SearchException se) {
	        	log.debug("searchError" + se.getMessage());
	            model.addAttribute("searchError", se.getMessage());
	            model.addAttribute("mststyleheader", new Mststyleheader());
	            model.addAttribute("mststyleheaderList", "[]");
	        }
		}
		else{
			model.addAttribute("mststyleheader", "[]");
		}
        return model;
	}
	/**
	 
	 else if (request.getParameter("conform")!=null) {
			if(!(StringUtils.isBlank(styleId) && StringUtils.isBlank(locationCode) &&  StringUtils.isBlank(depCode) &&  StringUtils.isBlank(compCode) && StringUtils.isBlank(custCode)))	
			mststyleheader=mststyleheaderManager.get(mststyleheaderId);
			mststyleheaderManager.save(mststyleheader);
	          saveMessage(request, getText("mststyleheader deleted", mststyleheader.getId().getStyleId(), locale));
		}
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Mststyleheader mststyleheader, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		log.debug("entering 'onSubmit' method...");

		//boolean isNew = (mststyleheader.getId() == null);
		
		String success = getSuccessView();
		Locale locale = request.getLocale();

		/** get parameters from server */
		String styleId = request.getParameter("id.styleId");
		String locationCode = request.getParameter("id.locationCode");
		String compCode = request.getParameter("id.compCode");
		String custCode = request.getParameter("id.custCode");
		String depCode = request.getParameter("id.depCode");
		
		MststyleheaderId  mststyleheaderId=new  MststyleheaderId(styleId, locationCode, depCode, compCode, custCode);
		log.debug("check perpos ");
		
		if (request.getParameter("confirm")!=null) {
			if(!(StringUtils.isBlank(styleId) && StringUtils.isBlank(locationCode) &&  StringUtils.isBlank(depCode) &&  StringUtils.isBlank(compCode) && StringUtils.isBlank(custCode)))	
			mststyleheader=mststyleheaderManager.get(mststyleheaderId);
			mststyleheader.setFlag("Complete");
			mststyleheaderManager.save(mststyleheader);
	        saveMessage(request, getText("Style master is confirmed successfully!", mststyleheader.getId().getStyleId(), locale));
		}
		return success;
	}
}
