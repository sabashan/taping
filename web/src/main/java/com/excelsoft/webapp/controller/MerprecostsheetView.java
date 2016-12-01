package com.excelsoft.webapp.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Merprecostsheetcurrency;
import com.excelsoft.model.Merprecostsheetrowmaterials;
import com.excelsoft.model.Merprecostsheetsmv;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MerprecostsheetManager;
import com.excelsoft.service.MerprecostsheetcurrencyManager;
import com.excelsoft.service.MerprecostsheetrowmaterialsManager;
import com.excelsoft.service.MerprecostsheetsmvManager;
import com.excelsoft.service.MstgencodesManager;
import com.excelsoft.service.MstlocationManager;
import com.excelsoft.service.MststylecomponentManager;
import com.excelsoft.util.ConvertUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/merprecostsheetsview*")
public class MerprecostsheetView  extends BaseFormController {
	 private MerprecostsheetManager merprecostsheetManager = null;
	    private MststylecomponentManager mststylecomponentManager=null;
	    private MstlocationManager mstlocationManager=null;
	    private MerprecostsheetsmvManager merprecostsheetsmvManager =null;
	    private MstgencodesManager mstgencodesManager =null; 
	    private MerprecostsheetcurrencyManager merprecostsheetcurrencyManager = null;
	    private MerprecostsheetrowmaterialsManager merprecostsheetrowmaterialsManager=null;
	    
	    final short programID=4006;
	    final String trntype="PCST";
		
		
	    
	    
	    
	    @Autowired
		public void setMerprecostsheetrowmaterialsManager(
				MerprecostsheetrowmaterialsManager merprecostsheetrowmaterialsManager) {
			this.merprecostsheetrowmaterialsManager = merprecostsheetrowmaterialsManager;
		}
		@Autowired
	    public void setMstgencodesManager(MstgencodesManager mstgencodesManager) {
			this.mstgencodesManager = mstgencodesManager;
		}
		@Autowired
	    public void setMerprecostsheetcurrencyManager(
				MerprecostsheetcurrencyManager merprecostsheetcurrencyManager) {
			this.merprecostsheetcurrencyManager = merprecostsheetcurrencyManager;
		}
		
	    @Autowired
	    public void setMerprecostsheetsmvManager(
				MerprecostsheetsmvManager merprecostsheetsmvManager) {
			this.merprecostsheetsmvManager = merprecostsheetsmvManager;
		}
		@Autowired
	    public void setMstlocationManager(MstlocationManager mstlocationManager) {
			this.mstlocationManager = mstlocationManager;
		}

	    @Autowired
	    public void setMststylecomponentManager(MststylecomponentManager mststylecomponentManager) {
	        this.mststylecomponentManager = mststylecomponentManager;
	    }
	    
	    @Autowired
	    public void setMerprecostsheetManager(MerprecostsheetManager merprecostsheetManager) {
	        this.merprecostsheetManager = merprecostsheetManager;
	    }
	    
	    public MerprecostsheetView() {
	        setCancelView("redirect:merprecostsheets");
	        setSuccessView("redirect:merprecostsheets");
	    }

		@ModelAttribute
	    @RequestMapping(method = RequestMethod.GET)
	    protected Model showForm(HttpServletRequest request)
	    throws Exception {
			Model model = new ExtendedModelMap();
			
			// get cost sheet parameters 
	        String preCostSheetNo = request.getParameter("preCostSheetNo");
	        String sversionNo = request.getParameter("versionNo");
	        String costsheetType = request.getParameter("costsheetType");
	        
	        try {
		        model.addAttribute("mstitemtypeCatogory",mstgencodesManager.getcode("ITMCAT"));
		        log.debug("mst-item type Catogory : "+ model); 
	        }
	    	catch (SearchException se) {
		        model.addAttribute("Item Catogory  Error", se.getMessage());
		        log.debug(se.getMessage());  
		    }   
	        Merprecostsheet merprecostsheet =new Merprecostsheet();
	        // check is parameters blank
	        if (!StringUtils.isBlank(preCostSheetNo) && !StringUtils.isBlank(sversionNo) && !StringUtils.isBlank(costsheetType)) {
	        	log.debug("With cost sheet");  
	        	try {
	        		// convert string to long
	        		BigDecimal versionNo=ConvertUtil.getDecimal(sversionNo);
	        		// get precostsheet
	        		merprecostsheet = merprecostsheetManager.get(new MerprecostsheetId(preCostSheetNo, versionNo,costsheetType));
	        		if(merprecostsheet.getId().getPreCostSheetNo().equals(preCostSheetNo)){
		        		
		        		Mststyleheader mststyleheader=merprecostsheet.getMststyleheader();
		        		// add line efficiency using location
		        		model.addAttribute("Lineeff",mstlocationManager.get(mststyleheader.getId().getLocationCode()).getMinuteValue());
		        		// get component list 
		        		model.addAttribute("mststylecomponentList", mststylecomponentManager.getAll(mststyleheader));
		        		// get currency list
		        		model.addAttribute("merprecostsheetcurrencyList",merprecostsheetcurrencyManager.getAll(merprecostsheet));
		        		// get smv list
		        		model.addAttribute("merprecostsheetsmvList",merprecostsheetsmvManager.getAll(merprecostsheet));
		        		//get shell fabrics list
		        		List <Merprecostsheetrowmaterials> merprecostsheetrowmaterials= merprecostsheetrowmaterialsManager.getAllShell(merprecostsheet, "FABRIC");
		        		for(int i=0;i<merprecostsheetrowmaterials.size();i++){
		        			Merprecostsheetrowmaterials	merprecostsheetrowmaterial=merprecostsheetrowmaterials.get(i);
		        			for(int j=i+1;j<merprecostsheetrowmaterials.size()-i;j++){
		        				if(merprecostsheetrowmaterial.getMstitem().equals(merprecostsheetrowmaterials.get(j).getMstitem())){
		        					merprecostsheetrowmaterials.remove(j);
		        				}
		        			}
		        		}
		        		model.addAttribute("rowmaterials",merprecostsheetrowmaterials);
	        		}
	        		 else{
	                	 log.debug("With no Costsheet"); 
	                	 model.addAttribute("NO", "NO");
	                 }
	        	} catch (SearchException se) {
	 	            model.addAttribute("searchError", se.getMessage());
	 	            log.debug(se.getMessage());  
	 	        }
	        }
	        else{ 
	             //model.addAttribute(merprecostsheet);
	        	log.debug("No cost");  
	        }
	        // add cost sheet to model
    		model.addAttribute(merprecostsheet);
	        log.debug(model);
	        return model;
	    }
		
		@RequestMapping(method = RequestMethod.POST)
	    public String onSubmit(Merprecostsheet merprecostsheet, BindingResult errors, HttpServletRequest request,
	                           HttpServletResponse response)
	    throws Exception {
		  String success = getSuccessView();
		  Locale locale = request.getLocale();
		  String preCostSheetNo = request.getParameter("preCostSheetNo");
		  String sversionNo = request.getParameter("versionNo");
		  BigDecimal versionNo=ConvertUtil.getDecimal(sversionNo);
		  String costsheetType = request.getParameter("costsheetType");
		  merprecostsheet = merprecostsheetManager.get(new MerprecostsheetId(preCostSheetNo, versionNo,costsheetType));
		  
		  log.debug(preCostSheetNo+sversionNo +costsheetType);
		  if (!StringUtils.isBlank(preCostSheetNo) && !StringUtils.isBlank(sversionNo) && !StringUtils.isBlank(costsheetType)) {
			  if (request.getParameter("delete") != null) {

				  log.debug("deleted ");
	        	if(deletecostsheet( merprecostsheet )){
	        		merprecostsheetManager.remove(merprecostsheet);
	        		 saveMessage(request, getText("merprecostsheet.deleted", locale));
	        		 log.debug("deleted ");
	        	}
	        	else {
	        		log.debug("not deleted ");
	        		 saveMessage(request, getText("merprecostsheet.error", locale));
				}
	           
			  } 
			  else if(request.getParameter("conform") != null){
				  merprecostsheet.setFlag("Completed");
				  merprecostsheetManager.save(merprecostsheet);
			  }
			  else if(request.getParameter("Approved") != null){
				  merprecostsheet.setFlag("Approved");
				  merprecostsheetManager.save(merprecostsheet);
			  }
			  else if(request.getParameter("UnApproved") != null){
				 merprecostsheet.setFlag("Completed");
				  merprecostsheetManager.save(merprecostsheet);
			  }
			  else{
				  log.debug("deleted");
			  }
		  }
		  
			  return success;
		}
		private Boolean deletecostsheet(Merprecostsheet merprecostsheet ){
			List<Merprecostsheetcurrency> merprecostsheetcurrency=merprecostsheetcurrencyManager.getAll(merprecostsheet);
			List<Merprecostsheetsmv> merprecostsheetsmv=merprecostsheetsmvManager.getAll(merprecostsheet);		
    		List <Merprecostsheetrowmaterials> merprecostsheetrowmaterials= merprecostsheetrowmaterialsManager.getAll(merprecostsheet);
    		log.debug(merprecostsheetrowmaterials.size()+" - "+merprecostsheetcurrency.size()+" "+merprecostsheetsmv.size());
    		
    		Boolean sts=true;
    		for(int i=0;i<merprecostsheetcurrency.size();i++){
    			try{
    				merprecostsheetcurrencyManager.remove(merprecostsheetcurrency.get(i));
    			}catch(Exception e){
    				log.debug(e.getMessage());
    				sts=false;
    			}
			}
			for(int i=0;i<merprecostsheetsmv.size();i++){
				try{
					merprecostsheetsmvManager.remove(merprecostsheetsmv.get(i));
				}catch(Exception e){
					log.debug(e.getMessage());
    				sts=false;
    			}
			}
			for(int i=0;i<merprecostsheetrowmaterials.size();i++){
				try{
					merprecostsheetrowmaterialsManager.remove(merprecostsheetrowmaterials.get(i));
				}catch(Exception e){
					log.debug(e.getMessage());
    				sts=false;
    			}
			}
			log.debug(sts);
    		return sts;
    		
		}
}
