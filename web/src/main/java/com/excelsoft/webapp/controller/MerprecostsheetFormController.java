package com.excelsoft.webapp.controller;

import org.apache.commons.lang.StringUtils;

import com.excelsoft.service.MerprecostsheetManager;
import com.excelsoft.service.MerprecostsheetcurrencyManager;
import com.excelsoft.service.MerprecostsheetrowmaterialsManager;
import com.excelsoft.service.MerprecostsheetsmvManager;
import com.excelsoft.service.MstcurrencyManager;
import com.excelsoft.service.MstcustomerManager;
import com.excelsoft.service.MstgencodesManager;
import com.excelsoft.service.MstlocationManager;
import com.excelsoft.service.MstnumbersManager;
import com.excelsoft.service.MstparameterManager;
import com.excelsoft.service.MststylecomponentManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.service.MststylerouteManager;
import com.excelsoft.service.MstsupplierManager;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Merprecostsheetcurrency;
import com.excelsoft.model.MerprecostsheetcurrencyId;
import com.excelsoft.model.Merprecostsheetrowmaterials;
import com.excelsoft.model.MerprecostsheetrowmaterialsId;
import com.excelsoft.model.Merprecostsheetsmv;
import com.excelsoft.model.MerprecostsheetsmvId;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.model.Mstitem;
import com.excelsoft.model.MstitemId;
import com.excelsoft.model.Mstnumbers;
import com.excelsoft.model.MstnumbersId;
import com.excelsoft.model.Mstparameter;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/merprecostsheetform*")
@SuppressWarnings("unused")
public class MerprecostsheetFormController extends BaseFormController {
	
    private MerprecostsheetManager merprecostsheetManager = null;
    private MststylerouteManager mststylerouteManager=null;
    private MststylecomponentManager mststylecomponentManager=null;
    private MststyleheaderManager mststyleheaderManager=null;
    private MstlocationManager mstlocationManager=null;
    private MerprecostsheetsmvManager merprecostsheetsmvManager =null;
    private MstnumbersManager mstnumbersManager=null;
    private MstparameterManager mstparametermanager =null;
    private MstcurrencyManager mstcurrencyManager=null;
    private MstgencodesManager mstgencodesManager =null; 
    private MstcustomerManager mstcustomerManager=null; 
	private MstsupplierManager mstsupplierManager=null;
    private MerprecostsheetcurrencyManager merprecostsheetcurrencyManager = null;
    private MerprecostsheetrowmaterialsManager merprecostsheetrowmaterialsManager=null;
    
    private String location="";
    final short programID=4006;
    final String trntype="PCST";
    private String flag ="Incomplete";
	
    
    @Autowired
    public void setMstcustomerManager(MstcustomerManager mstcustomerManager) {
		this.mstcustomerManager = mstcustomerManager;
	}
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
	public void setMstsupplierManager(MstsupplierManager mstsupplierManager) {
		this.mstsupplierManager = mstsupplierManager;
	}
	@Autowired
    public void setMerprecostsheetcurrencyManager(
			MerprecostsheetcurrencyManager merprecostsheetcurrencyManager) {
		this.merprecostsheetcurrencyManager = merprecostsheetcurrencyManager;
	}
	@Autowired
    public void setMstparametermanager(MstparameterManager mstparametermanager) {
		this.mstparametermanager = mstparametermanager;
	}
    @Autowired
	public void setMstcurrencyManager(MstcurrencyManager mstcurrencyManager) {
		this.mstcurrencyManager = mstcurrencyManager;
	}
	
    @Autowired
    public void setMstnumbersManager(
			MstnumbersManager mstnumbersManager) {
		this.mstnumbersManager = mstnumbersManager;
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
	public void setMststylerouteManager(MststylerouteManager mststylerouteManager) {
		this.mststylerouteManager = mststylerouteManager;
	}
	@Autowired
	public void setMststyleheaderManager(MststyleheaderManager mststyleheaderManager) {
		this.mststyleheaderManager = mststyleheaderManager;
	}

    @Autowired
    public void setMststylecomponentManager(MststylecomponentManager mststylecomponentManager) {
        this.mststylecomponentManager = mststylecomponentManager;
    }
    
    @Autowired
    public void setMerprecostsheetManager(MerprecostsheetManager merprecostsheetManager) {
        this.merprecostsheetManager = merprecostsheetManager;
    }
    
    public MerprecostsheetFormController() {
        setCancelView("redirect:merprecostsheets");
        setSuccessView("redirect:merprecostsheets");
    }

	@SuppressWarnings("deprecation")
	@ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Model showForm(HttpServletRequest request)
    throws Exception {
		Model model = new ExtendedModelMap();
		Mstparameter mstparameter=new Mstparameter();
    	try{
    		mstparameter=mstparametermanager.getAll().get(0);
    		location=mstparameter.getLocationCode();
		}catch(Exception e){
			log.debug(e.getMessage());
		}
		// get cost sheet parameters 
        String preCostSheetNo = request.getParameter("preCostSheetNo");
        String sversionNo = request.getParameter("versionNo");
        String costsheetType = request.getParameter("costsheetType");
        Mststyleheader mststyleheader=new Mststyleheader();
        try {
	        model.addAttribute("mstitemtypeCatogory",mstgencodesManager.getcode("ITMCAT"));
	        log.debug("mst-item type Catogory : "+ model); 
        }
    	catch (SearchException se) {
	        model.addAttribute("Item Catogory  Error", se.getMessage());
	        log.debug(se.getMessage());  
	    }   
        Merprecostsheet merprecostsheet =new Merprecostsheet();
        MerprecostsheetId id=new MerprecostsheetId("",ConvertUtil.getDecimal("0"), location);
        merprecostsheet.setId(id);
        // check is parameters blank
        if (!StringUtils.isBlank(preCostSheetNo) && !StringUtils.isBlank(sversionNo) && !StringUtils.isBlank(costsheetType)) {
        	log.debug("With cost sheet");  
        	try {
        		// convert string to long
        		BigDecimal versionNo=ConvertUtil.getDecimal(sversionNo);
        		if(sversionNo.equals("0")){
        			// get precostsheet
	        		merprecostsheet = merprecostsheetManager.get(new MerprecostsheetId(preCostSheetNo, versionNo,costsheetType));
	        		if(merprecostsheet.getId().getPreCostSheetNo().equals(preCostSheetNo)){
		        		// add cost sheet to model
	        			log.debug("With  Costsheet");
	        			mststyleheader=merprecostsheet.getMststyleheader();
		        		// add line efficiency using location        		
		        		model.addAttribute("Lineeff",mstlocationManager.get(mststyleheader.getId().getLocationCode()).getMinuteValue());
		        		// get component list 	        		
		        		model.addAttribute("mststylecomponentList", mststylecomponentManager.getAll(mststyleheader));
		        		// get currency list
		        		model.addAttribute("merprecostsheetcurrencyList",merprecostsheetcurrencyManager.getAll(merprecostsheet));
		        		// get smv list
		        			model.addAttribute("merprecostsheetsmvList",merprecostsheetsmvManager.getAll(merprecostsheet));
		        		//get shell fabrics list
		        		model.addAttribute("rowmaterials",merprecostsheetrowmaterialsManager.getAllShell(merprecostsheet, "FABRIC"));
	        		}
	        		 else{
	                	 log.debug("With no Costsheet"); 
	                	 model.addAttribute("NO", "NO");
	                 }
        		}
        		 else{
                	 log.debug("With none editable  Costsheet " +versionNo); 
                	 model.addAttribute("NO", "NO");
                 }
        	} catch (SearchException se) {
 	            model.addAttribute("searchError", se.getMessage());
 	            log.debug(se.getMessage());  
 	        }
        	model.addAttribute(merprecostsheet);
        	return model;
        }
        else{
        	log.debug("Without cost sheet");  
        	// get style content to new cost sheet 
        	 String locationCode = request.getParameter("locationCode") ;
             String custCode = request.getParameter("custCode") ;
             String styleId = request.getParameter("styleId") ;
             String depCode = request.getParameter("depCode") ;
             String compCode = request.getParameter("compCode") ;
             String season = request.getParameter("season") ;
             if(!(StringUtils.isBlank(season) || StringUtils.isBlank(styleId) || StringUtils.isBlank(depCode)|| StringUtils.isBlank(custCode)|| StringUtils.isBlank(compCode)|| StringUtils.isBlank(locationCode))){
            	 log.debug("With Style");  
            	 try {
 	        		mststyleheader= mststyleheaderManager.getStyle(compCode, locationCode, custCode, depCode, styleId);
 	        		if(mststyleheader!=null){
 	        			// add component list 
 	        			model.addAttribute("mststyleheaderid",mststyleheader.getId());
 	        			model.addAttribute("mststylecomponentList", mststylecomponentManager.getAll(mststyleheader));
 	        			Date date=new Date();
 	        			 log.debug("date : "+date);
 	        			int valid = mstcustomerManager.get(custCode).getCostsheetValidDays();
 	        			log.debug("valid : "+valid);  
 	        			date.setDate(date.getDate()+valid);
 	        			 log.debug("date : "+date);
 	        			//DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
 	        			//merprecostsheet.setValidTill();
 	        			String day =date.getMonth()+"/"+date.getDate()+"/"+(1900+date.getYear());
 	        			log.debug("date : "+day);
 	        			model.addAttribute("validTill",day);
 	        		}
 	        		else{
 	        			 log.debug("With no style"); 
 	                	 model.addAttribute("NO", "NO");
 	        		}	        		   
     	        } catch (SearchException se) {
     	            model.addAttribute("searchError", se.getMessage());
     	            log.debug(se.getMessage());  
     	        }
             }
             else{
            	 log.debug("With no params"); 
            	 model.addAttribute("NO", "NO");
             }
             //MerprecostsheetId id=new MerprecostsheetId();
             // set 0 version for new cost sheet 
            // id.setVersionNo(ConvertUtil.getDecimal("0"));
            // merprecostsheet.setId(id);
             model.addAttribute(merprecostsheet);
        }
        log.debug(model);
        return model;
    }


	@RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Merprecostsheet merprecostsheet, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
    	
		// get mst location
		Mstparameter mstparameter=new Mstparameter();
    	try{
    		mstparameter=mstparametermanager.getAll().get(0);
    		location=mstparameter.getLocationCode();
		}catch(Exception e){
			log.debug(e.getMessage());
		}	
    	
    	
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
        // get coverable details
        String mstcurrencyByCostSheetCur=request.getParameter("mstcurrencyByCostSheetCur.curCode") ;
        String mstcurrencyByDftRmCurrenc=request.getParameter("mstcurrencyByDftRmCurrenc.curCode") ;
       
        //if CostSheet currency not null then 
        if(!StringUtils.isBlank(mstcurrencyByCostSheetCur)){
        	merprecostsheet.setMstcurrencyByCostSheetCurrency( mstcurrencyManager.get(mstcurrencyByCostSheetCur));
        }
        //if Default row material  currency not null then 
        if(!StringUtils.isBlank(mstcurrencyByDftRmCurrenc)){
        	merprecostsheet.setMstcurrencyByDftRmCurrency( mstcurrencyManager.get(mstcurrencyByCostSheetCur));
        }
        if (validator != null) { // validator is null during testing
            validator.validate(merprecostsheet, errors);
            log.debug(errors);
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "merprecostsheetform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (merprecostsheet.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	log.debug("deleted ");
            merprecostsheetManager.remove(merprecostsheet.getId());
            saveMessage(request, getText("merprecostsheet.deleted", locale));
        } 
        else {
        	String section =request.getParameter("section");
        	log.debug(section);
        	//merprecostsheet.setFlag("Completed");
        	Mststyleheader mststyleheader = getstyle(request);
        	merprecostsheet.setMststyleheader(mststyleheader);
        	Integer integer=0;
        	String preCostSheetNo = request.getParameter("id.preCostSheetNo") ;
            String costsheetType = request.getParameter("id.costsheetType") ;
        	if(section.equals("section1")){
				log.debug(section +" Enterd ");
				// get style
				
        		 
        		// main version number 
        		BigDecimal versionNo=ConvertUtil.getDecimal("0");
	        	// get id parameters 
	           
	            String smvvalues =request.getParameter("smvvalues");
           	 	String currency =request.getParameter("currency");
	            // set mstNumber Id
	        	MstnumbersId mstnumbersI =new MstnumbersId(location, programID, trntype);
	        	Mstnumbers mstnumbers=new Mstnumbers();
	        	//if new precostsheet 
	            if(StringUtils.isBlank(preCostSheetNo)){
	            	log.debug("blank cost sheet ");
	            	try{
		    			versionNo=ConvertUtil.getDecimal("0");
		    			preCostSheetNo= mstnumbersManager.getnexttrnNo(location, programID, trntype).toString();
	            	}catch(Exception e){
		    			log.debug(e.getMessage());
		    			return "merprecostsheetform";
		    		}
	            	Cookie cookie=new Cookie("preCostSheetNo", preCostSheetNo);
	            	response.addCookie(cookie);
    				//log.debug("Costsheet No : "+preCostSheetNo);
//    				
//    				try{
//    					integer=new Integer(preCostSheetNo);
//    					
//	            	}catch(Exception e){
//	            		//integer=1;
//		    			log.debug(e.getMessage());
//		    			return "merprecostsheetform";
//		    		}
//    				
//    				mstnumbers=new Mstnumbers(mstnumbersI, (integer+1), 'Y') ;
//    				log.debug("saving version " );
//    				mstnumbersManager.save(mstnumbers);
//	    			

	    			
	    			MerprecostsheetId id=new MerprecostsheetId(preCostSheetNo, versionNo, costsheetType);
	    			merprecostsheet.setId(id);
	    			
	    			
		            merprecostsheet.setFlag(flag);
		            merprecostsheet.setMststyleheader(mststyleheader);
		            merprecostsheet.setCreatedAt(location);
		            merprecostsheet.setCreatedBy(request.getRemoteUser());
		            merprecostsheet.setCreatedOn(new Date());
		            log.debug(preCostSheetNo+ " "+ versionNo+ " "+costsheetType);
	            }
	            else{
	            	// costsheet in edit mode
	            	log.debug("not a blank cost sheet ");  
	            	
	            	log.debug(preCostSheetNo+ " "+ versionNo+ " "+costsheetType);
	            	MerprecostsheetId  merprecostsheetId=new MerprecostsheetId(preCostSheetNo, ConvertUtil.getDecimal("0"), costsheetType);
	        		// get working cost sheet 
	            	Merprecostsheet merprecostsheet2 = merprecostsheetManager.get(merprecostsheetId);
	            	
	            	Boolean checkchanger=false;
	            	if(merprecostsheet2.equals(merprecostsheet) ){
	            		checkchanger=true;
	            		log.debug("Same cost sheet");
	            	}
	            	else{
	            		checkchanger=false;
	            		log.debug("Not a Same Cost sheet");
	            	}
	            	
	            	
            		if(merprecostsheet2.getFlag().equals("Completed") && !checkchanger){
            			//create new version
            			log.debug("Creating new version");
            			log.debug(save_new_version(request));
        				
            			
            		}

    	            merprecostsheet.setModifiedAt(location);
    	            merprecostsheet.setModifiedBy(request.getRemoteUser());
    	            merprecostsheet.setModifiedOn(new Date());
    	            merprecostsheet.setFlag(flag);
            		remove_currencies( request);
    				remove_smv(request);
	            }
	            
				
	            
	            MerprecostsheetId  idMerprecostsheetId=merprecostsheet.getId();
	            idMerprecostsheetId.setVersionNo(ConvertUtil.getDecimal("0"));
	            merprecostsheet.setId(idMerprecostsheetId);
	            // save new version
	            log.debug("save new version");
	            log.debug(merprecostsheet);
	            try{
	            	merprecostsheetManager.save(merprecostsheet);
	        	}catch(Exception e){
	        		preCostSheetNo="0";
	    			log.debug(e.getMessage());
	    		}	 
        		 String key = (isNew) ? "merprecostsheet.added" : "merprecostsheet.updated";
                 saveMessage(request, getText(key, locale));
                 
                 if(smvvalues!="" && smvvalues!=null){
	                String[] itemsmv = splitArray(smvvalues,",");
                 	for(int i=0;i< itemsmv.length;i++){
                 		String smv_value =itemsmv[i]; 
                 		if(smv_value !="" && smv_value !=null) {
	                 		String[] items = splitArray(smv_value ,":");
	                 		try{
		                 		MerprecostsheetsmvId merprecostsheetsmvId=new MerprecostsheetsmvId(ConvertUtil.getDecimal(items[0]), merprecostsheet.getId().getPreCostSheetNo(), merprecostsheet.getId().getVersionNo(), merprecostsheet.getId().getCostsheetType());
		                 		//styleRouteName + ":" + location + ":"+ritio +":"+linedff+":"+fmvCat+":"+fmv;
		                 		//merprecostsheetsmvId, merprecostsheet, items[1],mststyleroute ,ConvertUtil.getDecimal(items[2]), items[4], ConvertUtil.getDecimal(items[5]),ConvertUtil.getDecimal(items[6]), ConvertUtil.getDecimal(items[3])
		                 		Mststyleroute mststyleroute=mststylerouteManager.get(ConvertUtil.getlongs(items[0]));
		                 		Merprecostsheetsmv merprecostsheetsmv=new Merprecostsheetsmv(merprecostsheetsmvId, merprecostsheet,  items[1], mststyleroute, ConvertUtil.getDecimal(items[2]), items[4],ConvertUtil.getDecimal( items[5]), ConvertUtil.getDecimal(items[3]));
		                 		merprecostsheetsmvManager.save(merprecostsheetsmv);
	                 		}
	                		catch(Exception e){
	                			log.debug(e.getMessage());
	                		}
                 		}
                 	}
                 } 
                 
                 if(mstparameter.getCurrencyMethod().equalsIgnoreCase("Static")){
	                 if(currency!="" && currency!=null){
		                String[] itemcurrency = splitArray(currency,",");
	                 	for(int i=0;i< itemcurrency.length;i++){
	                 		String currency_value =itemcurrency[i]; 
	                 		if(currency_value !="" && currency_value !=null) {
		                 		String[] items = splitArray(currency_value ,":");
		                 		try{
			                 		mstcurrencyManager.get(items[0]);
			                 		MerprecostsheetcurrencyId merprecostsheetcurrencyId=new MerprecostsheetcurrencyId( merprecostsheet.getId().getPreCostSheetNo(), merprecostsheet.getId().getVersionNo(),items[0], merprecostsheet.getId().getCostsheetType());
			                 		Merprecostsheetcurrency merprecostsheetcurrency=new Merprecostsheetcurrency(merprecostsheetcurrencyId, merprecostsheet, mstcurrencyManager.get(items[0]), ConvertUtil.getDecimal(items[1]));
			                 		merprecostsheetcurrencyManager.save(merprecostsheetcurrency);
		                 		}
		                		catch(Exception e){
		                			log.debug(e.getMessage());
		                		}
	                 		}
	                 	}
	                 } 
                 }
        	}
        	else if(section.equals("section2")){
	        	// get id parameters 

        		String consmption = request.getParameter("consmptions");

        		
        		MerprecostsheetId  merprecostsheetId=new MerprecostsheetId(preCostSheetNo, ConvertUtil.getDecimal("0"), costsheetType);
        		// get working cost sheet 
            	Merprecostsheet merprecostsheet2 = merprecostsheetManager.get(merprecostsheetId);
        		if(merprecostsheet2.getFlag().equals("Completed")){
        			//create new version
        			log.debug(save_new_version(request));
        			
        		}
        		//modify merprecostsheet  
        		merprecostsheet.setFlag(flag);
        		
        		/*merprecostsheet.setMststyleheader(mststyleheader);
        		merprecostsheet.setModifiedAt(location);
 	            merprecostsheet.setModifiedBy(request.getRemoteUser());
 	            merprecostsheet.setModifiedOn(new Date());*/
        		try{
            	 merprecostsheetManager.save(merprecostsheet);
        		}catch(Exception e){
        			log.debug(e.getMessage());
        			
        		}
        		
    			if(request.getParameter("deleteRowMat") != null){
    				String precostsheetRowMatCode=request.getParameter("precostsheetRowMatCode");
					String component=request.getParameter("component");
    				MerprecostsheetrowmaterialsId id=new MerprecostsheetrowmaterialsId(preCostSheetNo, ConvertUtil.getDecimal("0"), costsheetType,ConvertUtil.getDecimal(precostsheetRowMatCode), component) ;
    				try{
    					merprecostsheetrowmaterialsManager.remove(id);
        			}catch(Exception e){
            			log.debug(e.getMessage());
            			
            		}
    			}
    			else if(request.getParameter("editRowMat") != null){
    				String precostsheetRowMatCode=request.getParameter("precostsheetRowMatCode");
					String component=request.getParameter("component");
					
    				MerprecostsheetrowmaterialsId id=new MerprecostsheetrowmaterialsId(preCostSheetNo, ConvertUtil.getDecimal("0"), costsheetType,ConvertUtil.getDecimal(precostsheetRowMatCode), component) ;
    				Merprecostsheetrowmaterials merprecostsheetrowmaterials=new Merprecostsheetrowmaterials(id);
    				merprecostsheetrowmaterials.setId(id);
    				merprecostsheetrowmaterials.setAllowance(ConvertUtil.getDecimal(request.getParameter("allowance")));
               	 	merprecostsheetrowmaterials.setConsumption(ConvertUtil.getDecimal(request.getParameter("consumption")));
               	 	merprecostsheetrowmaterials.setUom(request.getParameter("UMO"));
               	 	 merprecostsheetrowmaterials.setCurrency(request.getParameter("currency"));
                	 merprecostsheetrowmaterials.setExchangeRate(ConvertUtil.getDecimal(request.getParameter("exchangeRate")));
                	 merprecostsheetrowmaterials.setPrice(ConvertUtil.getDecimal(request.getParameter("price")));
                	 merprecostsheetrowmaterials.setFinance(ConvertUtil.getDecimal(request.getParameter("finance")));
                	 
                	 merprecostsheetrowmaterials.setIsshellfabric(false);
                	 merprecostsheetrowmaterials.setItemCatogery(request.getParameter("itemcategory"));
                	 merprecostsheetrowmaterials.setItemColor(request.getParameter("itemColor"));
                	 merprecostsheetrowmaterials.setItemDecription(request.getParameter("itemDecription"));
                	 merprecostsheetrowmaterials.setItemWidth(request.getParameter("itemWidth"));
                	 merprecostsheetrowmaterials.setMerprecostsheet(merprecostsheet);
                	 MstitemId mstitemId=new MstitemId(request.getParameter("itemType"), request.getParameter("itemCode"));
                	 Mstitem mstitem=new Mstitem(mstitemId);
                	 merprecostsheetrowmaterials.setMstitem(mstitem);
                	
                	 merprecostsheetrowmaterials.setShipingType(request.getParameter("shipingType"));
                	 merprecostsheetrowmaterials.setSupplierCode(request.getParameter("supplierCode")); 
                	 merprecostsheetrowmaterials.setSupplierCompCode(location);
    				try{
    					merprecostsheetrowmaterialsManager.save(merprecostsheetrowmaterials);
        			}catch(Exception e){
            			log.debug(e.getMessage());
            			
            		}
    			}
    			else{
    				if(consmption!="" && consmption!=null){
    	    			String[] consmptions= splitArray(consmption,",");
		        		for(int i=0;i<consmptions.length;i++){ 
		        			log.debug(merprecostsheet);
		        			 Merprecostsheetrowmaterials merprecostsheetrowmaterials=new Merprecostsheetrowmaterials();
		                	 BigDecimal precostsheetRowMatCode=merprecostsheetrowmaterialsManager.getNext(merprecostsheet).add(ConvertUtil.getDecimal("1"));
		                	 MstitemId mstitemId=new MstitemId(request.getParameter("itemType"), request.getParameter("itemCode"));
		                	 Mstitem mstitem=new Mstitem(mstitemId);
		                	 MerprecostsheetrowmaterialsId id=new MerprecostsheetrowmaterialsId();
		                	 if(merprecostsheet.getCompWiseCost()){
			                	 String[] consmptions_details= splitArray(consmptions[i],":");
			                	 id =new MerprecostsheetrowmaterialsId(merprecostsheet.getId().getPreCostSheetNo(), merprecostsheet.getId().getVersionNo(), merprecostsheet.getId().getCostsheetType(), precostsheetRowMatCode.add(ConvertUtil.getDecimal("1")), consmptions_details[0]);
			                	 merprecostsheetrowmaterials.setAllowance(ConvertUtil.getDecimal(consmptions_details[3]));
			                	 merprecostsheetrowmaterials.setConsumption(ConvertUtil.getDecimal(consmptions_details[1]));
			                	 merprecostsheetrowmaterials.setUom(consmptions_details[2]);
		                	 }
		                	 else{
		                		 id =new MerprecostsheetrowmaterialsId(merprecostsheet.getId().getPreCostSheetNo(), merprecostsheet.getId().getVersionNo(), merprecostsheet.getId().getCostsheetType(), precostsheetRowMatCode.add(ConvertUtil.getDecimal("1")), consmptions[0]);
			                	 merprecostsheetrowmaterials.setAllowance(ConvertUtil.getDecimal(request.getParameter("allowance")));
			                	 merprecostsheetrowmaterials.setConsumption(ConvertUtil.getDecimal(request.getParameter("consumption")));
			                	 merprecostsheetrowmaterials.setUom(request.getParameter("UMO"));
		                	 }
		                	 merprecostsheetrowmaterials.setId(id);
		                	 
		                	// Mstcurrency mstcurrency=mstcurrencyManager.get(request.getParameter("currency"));
		                	 merprecostsheetrowmaterials.setCurrency(request.getParameter("currency"));
		                	 merprecostsheetrowmaterials.setExchangeRate(ConvertUtil.getDecimal(request.getParameter("exchangeRate")));
		                	 merprecostsheetrowmaterials.setPrice(ConvertUtil.getDecimal(request.getParameter("price")));
		                	 merprecostsheetrowmaterials.setFinance(ConvertUtil.getDecimal(request.getParameter("finance")));
		                	 
		                	 merprecostsheetrowmaterials.setIsshellfabric(false);
		                	 merprecostsheetrowmaterials.setItemCatogery(request.getParameter("itemcategory"));
		                	 merprecostsheetrowmaterials.setItemColor(request.getParameter("itemColor"));
		                	 merprecostsheetrowmaterials.setItemDecription(request.getParameter("itemDecription"));
		                	 merprecostsheetrowmaterials.setItemWidth(request.getParameter("itemWidth"));
		                	 merprecostsheetrowmaterials.setMerprecostsheet(merprecostsheet);
		                	 merprecostsheetrowmaterials.setMstitem(mstitem);
		                	
		                	 merprecostsheetrowmaterials.setShipingType(request.getParameter("shipingType"));
		                	 merprecostsheetrowmaterials.setSupplierCode(request.getParameter("supplierCode")); 
		                	 merprecostsheetrowmaterials.setSupplierCompCode(location);	
		                	 merprecostsheetrowmaterialsManager.save(merprecostsheetrowmaterials);
		        		}
	    			}
    				else{
            			log.debug("No consmptions");
            		}
        		}
        		
        		
            	
        	}
        	else if(section.equals("section3")){
        		BigDecimal versionNo=ConvertUtil.getDecimal("0");
        		log.debug(preCostSheetNo+ " "+ versionNo+ " "+costsheetType);
            	MerprecostsheetId  merprecostsheetId=new MerprecostsheetId(preCostSheetNo, ConvertUtil.getDecimal("0"), costsheetType);
        		// get working cost sheet 
            	Merprecostsheet merprecostsheet2 = merprecostsheetManager.get(merprecostsheetId);
        		if(merprecostsheet2.getFlag().equals("Completed") && !merprecostsheet2.equals(merprecostsheet)){
        			log.debug(save_new_version(request));
        			//remove_rowmaterial(request);
        		}
				String shellFabrics=request.getParameter("shellFabric");
				
				if(shellFabrics!=null && shellFabrics!=""){
					log.debug(shellFabrics);
					String[] shellFabric= splitArray(shellFabrics,",");
					log.debug(shellFabric.length);
					for(int i=0;i<shellFabric.length;i++){
						if(shellFabric[i]!=null && shellFabric[i]!=""){
							String[] shellFabricitems= splitArray(shellFabric[i],":");
							List<Merprecostsheetrowmaterials> merprecostsheetrowmaterials=merprecostsheetrowmaterialsManager.getAll(merprecostsheet2, "FABRIC", shellFabricitems[0], shellFabricitems[1]);
							log.debug(merprecostsheetrowmaterials.size());
							for(int k=0;k<merprecostsheetrowmaterials.size();k++){
								Merprecostsheetrowmaterials merprecostsheetrowmaterials2=merprecostsheetrowmaterials.get(k);
								merprecostsheetrowmaterials2.setIsshellfabric(true);
								merprecostsheetrowmaterialsManager.save(merprecostsheetrowmaterials2);
							}
						}
					}
        		}
        		merprecostsheet.setFlag(flag);
        		
        		/*merprecostsheet.setMststyleheader(mststyleheader);
        		merprecostsheet.setModifiedAt(location);
 	            merprecostsheet.setModifiedBy(request.getRemoteUser());
 	            merprecostsheet.setModifiedOn(new Date());*/
        		try{
            	 merprecostsheetManager.save(merprecostsheet);
        		}catch(Exception e){
        			log.debug(e.getMessage());
        			
        		}
        	} 
        	
        	if (!isNew) {
                success = "redirect:merprecostsheetform?preCostSheetNo="+ merprecostsheet.getId()+"&versionNo="+ merprecostsheet.getId()+"&costsheetType="+ merprecostsheet.getId()+"" ;
            }
           
        }
        log.debug(success);
        return success;
    }
    private String[] splitArray(String string,String c) {
    	String[] array = null;
    	if(string != null && string != ""){
    		try{
    			array = string.split(c);
    		}catch(Exception e){
    			log.debug("Error split : "+e.getMessage());
    		}
    	}
    	return array;

    }
    private Mststyleheader getstyle(HttpServletRequest request){
    	String locationCode = request.getParameter("locationCode") ;
        String custCode = request.getParameter("custCode") ;
        String styleId = request.getParameter("styleId") ;
        String depCode = request.getParameter("depCode") ;
        String compCode = request.getParameter("compCode") ;
        
        log.debug( " l "+locationCode+ " =c "+custCode+ " =s " +styleId+ " =d " +depCode+ " =c "+compCode );
        Mststyleheader mststyleheader=new Mststyleheader();
        if(!StringUtils.isBlank(styleId) && !StringUtils.isBlank(custCode)  && !StringUtils.isBlank(depCode)  && !StringUtils.isBlank(compCode)  && !StringUtils.isBlank(locationCode) ){
       	 mststyleheader = mststyleheaderManager.getStyle(compCode, locationCode, custCode, depCode, styleId);
        }
        else{
        	log.debug( " notihng" );
        }
        log.debug(mststyleheader);
      return  mststyleheader;
    }
   
    
    private Boolean remove_currencies(HttpServletRequest request){ 
    	// get id parameters 
        String preCostSheetNo = request.getParameter("id.preCostSheetNo") ;
        String costsheetType = request.getParameter("id.costsheetType") ;
        
    	Merprecostsheet  merprecostsheet2=new Merprecostsheet();
    	MerprecostsheetId  merprecostsheetId=new MerprecostsheetId(preCostSheetNo, ConvertUtil.getDecimal("0"), costsheetType);
		// get working cost sheet 
		merprecostsheet2 = merprecostsheetManager.get(merprecostsheetId);
		// get costsheet currency list
	    List<Merprecostsheetcurrency> merprecostsheetcurrencies = merprecostsheetcurrencyManager.getAll(merprecostsheet2);
	    for(int i=0;i<merprecostsheetcurrencies.size();i++){
			Merprecostsheetcurrency merprecostsheetcurrencie= merprecostsheetcurrencies.get(i);
			try{
				log.debug(merprecostsheetcurrencie.getId().getCurrencyCode());
				merprecostsheetcurrencyManager.remove(merprecostsheetcurrencie);
			}
	   		catch(Exception e){
	   			log.debug(e.getMessage());
	   			return false;
	   		}
		}
	    return true;
	       
    }
    private Boolean remove_smv(HttpServletRequest request){ 
    	// get id parameters 
        String preCostSheetNo = request.getParameter("id.preCostSheetNo") ;
        String costsheetType = request.getParameter("id.costsheetType") ;
        
    	Merprecostsheet  merprecostsheet2=new Merprecostsheet();
    	MerprecostsheetId  merprecostsheetId=new MerprecostsheetId(preCostSheetNo, ConvertUtil.getDecimal("0"), costsheetType);
		// get working cost sheet 
		merprecostsheet2 = merprecostsheetManager.get(merprecostsheetId);
		// get smv list
		List<Merprecostsheetsmv> merprecostsheetsmvs = merprecostsheetsmvManager.getAll(merprecostsheet2);
		for(int i=0;i<merprecostsheetsmvs.size();i++){
			Merprecostsheetsmv merprecostsheetsmv= merprecostsheetsmvs.get(i);
			try{
				log.debug(merprecostsheetsmv.getId().getStyleRouteId());
				merprecostsheetsmvManager.remove(merprecostsheetsmv);
			}
	   		catch(Exception e){
	   			log.debug(e.getMessage());
	   			return false;
	   		}
		}
	    return true;
	       
    }
    
    private Boolean save_new_version(HttpServletRequest request){
    	BigDecimal versionNo=ConvertUtil.getDecimal("0");
    	// get id parameters 
        String preCostSheetNo = request.getParameter("id.preCostSheetNo") ;
        String costsheetType = request.getParameter("id.costsheetType") ;
        
    	Merprecostsheet  merprecostsheet2=new Merprecostsheet();
    	MerprecostsheetId  merprecostsheetId=new MerprecostsheetId(preCostSheetNo, ConvertUtil.getDecimal("0"), costsheetType);
		// get working cost sheet 
		merprecostsheet2 = merprecostsheetManager.get(merprecostsheetId);
		
		// get costsheet currency list
       List<Merprecostsheetcurrency> merprecostsheetcurrencies = merprecostsheetcurrencyManager.getAll(merprecostsheet2);
       
		// get smv list
		List<Merprecostsheetsmv> merprecostsheetsmvs = merprecostsheetsmvManager.getAll(merprecostsheet2);
		
		//get shell fabrics list
		List< Merprecostsheetrowmaterials>merprecostsheetrowmaterials = merprecostsheetrowmaterialsManager.getAll(merprecostsheet2);
		
		//get version list
		List<BigDecimal> versionNos=merprecostsheetManager.getAllVersion(costsheetType,preCostSheetNo);
		//get last version 
		versionNo=versionNos.get(versionNos.size()-1);
		log.debug(versionNos.size() + " - "+versionNos.get(versionNos.size()-1));
		//update cost sheet to last version
		MerprecostsheetId id=new MerprecostsheetId(preCostSheetNo, (versionNo), costsheetType); 
		versionNo.add(ConvertUtil.getDecimal("1"));
		merprecostsheet2.setId(id);
		merprecostsheet2.setModifiedAt(location);
		merprecostsheet2.setModifiedBy(request.getRemoteUser());
		merprecostsheet2.setModifiedOn(new Date());
       
       
       try{
			log.debug("save old  version : " + versionNo);
			merprecostsheetManager.save(merprecostsheet2);
		}
		catch(Exception e){
			log.debug(e.getMessage());
			return false;
		}
		// save relationships
		for(int i=0;i<merprecostsheetcurrencies.size();i++){
			Merprecostsheetcurrency merprecostsheetcurrencie= merprecostsheetcurrencies.get(i);
			MerprecostsheetcurrencyId  id1 =merprecostsheetcurrencie.getId();
			id1.setCostsheetType(costsheetType);
			id1.setPreCostSheetNo(preCostSheetNo);
			id1.setVersionNo(versionNo);
			merprecostsheetcurrencie.setId(id1);
			merprecostsheetcurrencie.setMerprecostsheet(merprecostsheet2);
			try{
				log.debug(merprecostsheetcurrencie.getId().getCurrencyCode());
				merprecostsheetcurrencyManager.save(merprecostsheetcurrencie);
			}
	   		catch(Exception e){
	   			log.debug(e.getMessage());
	   			return false;
	   		}
		}
		for(int i=0;i<merprecostsheetsmvs.size();i++){
			Merprecostsheetsmv merprecostsheetsmv= merprecostsheetsmvs.get(i);
			MerprecostsheetsmvId  id1 =merprecostsheetsmv.getId();
			id1.setCostsheetType(costsheetType);
			id1.setPreCostSheetNo(preCostSheetNo);
			id1.setVersionNo(versionNo);
			merprecostsheetsmv.setId(id1);
			merprecostsheetsmv.setMerprecostsheet(merprecostsheet2);
			try{
				log.debug(merprecostsheetsmv.getId().getStyleRouteId());
				merprecostsheetsmvManager.save(merprecostsheetsmv);		
			}
	   		catch(Exception e){
	   			log.debug(e.getMessage());
	   			return false;
	   		}
		}
		for(int i=0;i<merprecostsheetrowmaterials.size();i++){
			Merprecostsheetrowmaterials merprecostsheetrowmaterial= merprecostsheetrowmaterials.get(i);
			MerprecostsheetrowmaterialsId  id1 =merprecostsheetrowmaterial.getId();
			id1.setCostsheetType(costsheetType);
			id1.setPreCostSheetNo(preCostSheetNo);
			id1.setVersionNo(versionNo);
			merprecostsheetrowmaterial.setId(id1);
			merprecostsheetrowmaterial.setMerprecostsheet(merprecostsheet2);
			try{
				log.debug(merprecostsheetrowmaterial.getId().getPrecostsheetRowMatCode());
				merprecostsheetrowmaterialsManager.save(merprecostsheetrowmaterial);	
			}
	   		catch(Exception e){
	   			log.debug(e.getMessage());
	   			return false;
	   		}
		}
		return true;
   }
}


