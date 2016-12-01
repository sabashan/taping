package com.excelsoft.webapp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Mercostsheetcountry;
import com.excelsoft.model.MercostsheetcountryId;
import com.excelsoft.model.Mercostsheetcurrency;
import com.excelsoft.model.MercostsheetcurrencyId;
import com.excelsoft.model.Mercostsheetdemmap;
import com.excelsoft.model.MercostsheetdemmapId;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.MercostsheetgroupId;
import com.excelsoft.model.Mercostsheetgroupcolor;
import com.excelsoft.model.MercostsheetgroupcolorId;
import com.excelsoft.model.Mercostsheetgroupdemmap;
import com.excelsoft.model.MercostsheetgroupdemmapId;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.model.MercostsheetgroupsettingId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.model.Mercostsheetrowmaterial;
import com.excelsoft.model.MercostsheetrowmaterialId;
import com.excelsoft.model.Mercostsheetsmv;
import com.excelsoft.model.MercostsheetsmvId;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Merprecostsheetcurrency;
import com.excelsoft.model.MerprecostsheetcurrencyId;
import com.excelsoft.model.Merprecostsheetrowmaterials;
import com.excelsoft.model.MerprecostsheetrowmaterialsId;
import com.excelsoft.model.Merprecostsheetsmv;
import com.excelsoft.model.MerprecostsheetsmvId;
import com.excelsoft.model.Mstcurrency;
import com.excelsoft.model.Mstitemtype;
import com.excelsoft.model.MstnumbersId;
import com.excelsoft.model.Mstparameter;
import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.Mststyledem;
import com.excelsoft.model.Mststyledemmap;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.model.Mstsupplier;
import com.excelsoft.model.MstsupplierId;
import com.excelsoft.service.MercostsheetcountryManager;
import com.excelsoft.service.MercostsheetcurrencyManager;
import com.excelsoft.service.MercostsheetdemmapManager;
import com.excelsoft.service.MercostsheetgroupManager;
import com.excelsoft.service.MercostsheetgroupcolorManager;
import com.excelsoft.service.MercostsheetgroupdemmapManager;
import com.excelsoft.service.MercostsheetgroupsettingManager;
import com.excelsoft.service.MercostsheethdrManager;
import com.excelsoft.service.MercostsheetrowmaterialManager;
import com.excelsoft.service.MercostsheetsmvManager;
import com.excelsoft.service.MerprecostsheetManager;
import com.excelsoft.service.MerprecostsheetcurrencyManager;
import com.excelsoft.service.MerprecostsheetrowmaterialsManager;
import com.excelsoft.service.MerprecostsheetsmvManager;
import com.excelsoft.service.MstcurrencyManager;
import com.excelsoft.service.MstgencodesManager;
import com.excelsoft.service.MstlocationManager;
import com.excelsoft.service.MstnumbersManager;
import com.excelsoft.service.MstparameterManager;
import com.excelsoft.service.MststylecomponentManager;
import com.excelsoft.service.MststyledemManager;
import com.excelsoft.service.MststyledemmapManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.service.MststylerouteManager;
import com.excelsoft.service.MstsupplierManager;
import com.excelsoft.util.ConvertUtil;

@Controller
@RequestMapping("/mercostsheethdrform*")
public class MercostsheethdrFormController extends BaseFormController {
    private MercostsheethdrManager mercostsheethdrManager = null;
    private MercostsheetcurrencyManager mercostsheetcurrencyManager=null;
    private MercostsheetrowmaterialManager mercostsheetrowmaterialManager=null;
	private MercostsheetdemmapManager mercostsheetdemmapManager = null;
    private MercostsheetsmvManager mercostsheetsmvManager=null;
  	private MercostsheetgroupManager mercostsheetgroupManager=null;
  	private MercostsheetgroupsettingManager mercostsheetgroupsettingManager=null;
    private MercostsheetcountryManager mercostsheetcountryManager = null;
    private MercostsheetgroupdemmapManager mercostsheetgroupdemmapManager = null;
	private MercostsheetgroupcolorManager mercostsheetgroupcolorManager = null;
	private Mstparameter mstparameter=new Mstparameter();
	
	private MerprecostsheetManager merprecostsheetManager=null;
	private MerprecostsheetrowmaterialsManager merprecostsheetrowmaterialsManager=null;
	private MerprecostsheetsmvManager merprecostsheetsmvManager =null;
	private MerprecostsheetcurrencyManager merprecostsheetcurrencyManager=null;
	private MstnumbersManager mstnumbersManager=null;
    private MstparameterManager mstparametermanager =null;
    private MstcurrencyManager mstcurrencyManager=null;
    private MstgencodesManager mstgencodesManager =null;
    private MstlocationManager mstlocationManager=null;
    private MstsupplierManager  mstsupplierManager=null;
     
    private MststylecomponentManager mststylecomponentManager=null;
    private MststyleheaderManager mststyleheaderManager=null;
    private MststyledemManager mststyledemManager = null;
    private MststyledemmapManager mststyledemmapManager = null;
    private MststylerouteManager mststylerouteManager=null;
    private String location="";
    final short programID=4007;
    final String trntype="FCST";
    final String trnGroupType="FCSG";
    private String flag ="Incomplete";
    
    
    @Autowired
    public void setMerprecostsheetrowmaterialsManager(
			MerprecostsheetrowmaterialsManager merprecostsheetrowmaterialsManager) {
		this.merprecostsheetrowmaterialsManager = merprecostsheetrowmaterialsManager;
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
    public void setMststylerouteManager(MststylerouteManager mststylerouteManager) {
		this.mststylerouteManager = mststylerouteManager;
	}
    
    @Autowired
	public void setMstsupplierManager(MstsupplierManager mstsupplierManager) {
		this.mstsupplierManager = mstsupplierManager;
	}

	@Autowired
    public void setMerprecostsheetManager(
			MerprecostsheetManager merprecostsheetManager) {
		this.merprecostsheetManager = merprecostsheetManager;
	}
	@Autowired
	public void setMercostsheetgroupsettingManager(
			MercostsheetgroupsettingManager mercostsheetgroupsettingManager) {
		this.mercostsheetgroupsettingManager = mercostsheetgroupsettingManager;
	}
	@Autowired
	public void setMercostsheetgroupManager(
			MercostsheetgroupManager mercostsheetgroupManager) {
		this.mercostsheetgroupManager = mercostsheetgroupManager;
	}
	@Autowired
    public void setMercostsheetcurrencyManager(
			MercostsheetcurrencyManager mercostsheetcurrencyManager) {
		this.mercostsheetcurrencyManager = mercostsheetcurrencyManager;
	}
    @Autowired
	public void setMercostsheetrowmaterialManager(
			MercostsheetrowmaterialManager mercostsheetrowmaterialManager) {
		this.mercostsheetrowmaterialManager = mercostsheetrowmaterialManager;
	}
    @Autowired
	public void setMercostsheetsmvManager(
			MercostsheetsmvManager mercostsheetsmvManager) {
		this.mercostsheetsmvManager = mercostsheetsmvManager;
	}
	@Autowired
    public void setMercostsheethdrManager(MercostsheethdrManager mercostsheethdrManager) {
        this.mercostsheethdrManager = mercostsheethdrManager;
    }
    @Autowired
    public void setMstgencodesManager(MstgencodesManager mstgencodesManager) {
		this.mstgencodesManager = mstgencodesManager;
	}
    @Autowired
	public void setMercostsheetdemmapManager(
			MercostsheetdemmapManager mercostsheetdemmapManager) {
		this.mercostsheetdemmapManager = mercostsheetdemmapManager;
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
    public void setMstlocationManager(MstlocationManager mstlocationManager) {
		this.mstlocationManager = mstlocationManager;
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
	public void setMststyledemManager(MststyledemManager mststyledemManager) {
		this.mststyledemManager = mststyledemManager;
	}
    @Autowired
	public void setMststyledemmapManager(MststyledemmapManager mststyledemmapManager) {
		this.mststyledemmapManager = mststyledemmapManager;
	}
    @Autowired
	public void setMercostsheetcountryManager(MercostsheetcountryManager mercostsheetcountryManager) {
		this.mercostsheetcountryManager = mercostsheetcountryManager;
	}

    @Autowired
	public void setMercostsheetgroupcolorManager(MercostsheetgroupcolorManager mercostsheetgroupcolorManager) {
		this.mercostsheetgroupcolorManager = mercostsheetgroupcolorManager;
	}
    @Autowired
	public void setMercostsheetgroupdemmapManager(MercostsheetgroupdemmapManager mercostsheetgroupdemmapManager) {
		this.mercostsheetgroupdemmapManager = mercostsheetgroupdemmapManager;
	}

    public MercostsheethdrFormController() {
        setCancelView("redirect:mercostsheethdrs");
        setSuccessView("redirect:mercostsheethdrs");
    }
    
    @SuppressWarnings({ "rawtypes", "unused" })
	@ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Model showForm(HttpServletRequest request)
    throws Exception {
    	Model model = new ExtendedModelMap();
    	
    	String costSheetNo = request.getParameter("costSheetNo");
        String costSheetType = request.getParameter("costSheetType");
        String sversionNo = request.getParameter("versionNo");
        
        try {
	        model.addAttribute("mstitemtypeCatogory",mstgencodesManager.getcode("ITMCAT"));
	        log.debug("mst-item type Catogory : "+ model); 
        }
    	catch (SearchException se) {
	        model.addAttribute("Item Catogory  Error", se.getMessage());
	        log.debug(se.getMessage());  
	    }
        Mercostsheethdr mercostsheethdr = new Mercostsheethdr();
        Merprecostsheet merprecostsheet = new Merprecostsheet();
        Mststyleheader mststyleheader = null;
        // check is parameters blank
        if (!StringUtils.isBlank(costSheetNo) && !StringUtils.isBlank(sversionNo) && !StringUtils.isBlank(costSheetType)) {
        	log.debug("With cost sheet");  
        	
        	try {
        		// convert string to long
        		BigDecimal versionNo=ConvertUtil.getDecimal(sversionNo);
        		if(sversionNo.equals("0")){
        		// get costsheethdr
	        		mercostsheethdr = mercostsheethdrManager.get(new MercostsheethdrId(costSheetNo, versionNo,costSheetType));
	        		log.debug("*************");
	    			if(mercostsheethdr.getId().getCostSheetNo().equals(costSheetNo)){
	    				// add cost sheet to model
		        		mststyleheader= mercostsheethdrManager.getStyle(new MercostsheethdrId(costSheetNo, versionNo,costSheetType));
		        		// add line efficiency using location
		        		model.addAttribute("mststyleheader",mststyleheader);
		        		model.addAttribute("Lineeff",mstlocationManager.get(mststyleheader.getId().getLocationCode()).getMinuteValue());
		        		// get component list 
		        		model.addAttribute("mststylecomponentList", mststylecomponentManager.getAll(mststyleheader));
		        		model.addAttribute("mercostsheethdrcurrencyList",mercostsheetcurrencyManager.getAll(mercostsheethdr));
		        		model.addAttribute("mercostsheethdrcountryList",mercostsheetcountryManager.getAll(mercostsheethdr));
		        		// get smv list
	        			model.addAttribute("mercostsheethdrsmvList",mercostsheetsmvManager.getAll(mercostsheethdr));
	        			
	        			try{
	        				model.addAttribute("rowmaterials",mercostsheetrowmaterialManager.getAllShell(mercostsheethdr, "FABRIC"));
	        			}catch(Exception e){
	        				log.debug(e.toString());
	        			}
	        			
	        			try{
	        				model.addAttribute("groups", getGroups(request));
		    			}catch(Exception e){
	        				log.debug(e.toString());
	        			}
	        			merprecostsheet = new Merprecostsheet();
	        			try{
	        			merprecostsheet = mercostsheethdrManager.getprecostsheet(mercostsheethdr.getId());
	        			}catch(Exception e){
	        				log.debug(e);
	        			}
	        		}
	        		 else{
	                	 log.debug("With no Costsheet"); 
	                	 model.addAttribute("NO", "NO");
	                 }
        		}
        		else{
               	 	log.debug("With none editable Costsheet" + versionNo); 
               	 	model.addAttribute("NO", "NO");
                }
        	} catch (SearchException se) {
 	            model.addAttribute("searchError", se.getMessage());
 	            log.debug(se.getMessage());  
 	        }
        	
        	model.addAttribute(mercostsheethdr);
        	log.debug(model);
        	
        	try{
	            List<Mercostsheetdemmap> mercostsheetdemmaps = mercostsheetdemmapManager.getDemmapsFromCosting(mercostsheethdr);
	            log.debug(mercostsheetdemmaps.toString());
        	}
        	catch(Exception e){
        		log.debug(e);
        		
        	}
        	//Add style dimensions and dimension values
        	List<Mststyledem> mststyledems = new ArrayList<Mststyledem>();
        	List<Mststyledemmap> mststyledemmaps = new ArrayList<Mststyledemmap>();
        	
        	if(mststyleheader != null){
        		mststyledems = mststyledemManager.getAll(mststyleheader);
        		mststyledemmaps = mststyledemmapManager.getAll(mststyleheader);
        	}
        	for (Iterator iterator = mststyledemmaps.iterator(); iterator.hasNext();) {
    			Mststyledemmap mststyledemmap = (Mststyledemmap) iterator.next();
    		}
        	for (Iterator iterator = mststyledems.iterator(); iterator.hasNext();) {
    			Mststyledem mststyledem = (Mststyledem) iterator.next();
    		}
        	model.addAttribute("mststyledems", mststyledems);
        	model.addAttribute("mststyledemmaps", mststyledemmaps);
        	/** hard corded precostsheet ** removed */
        	//merprecostsheet = merprecostsheetManager.get(new MerprecostsheetId("1", new BigDecimal(0), "HC"));
        	model.addAttribute("merprecostsheet", merprecostsheet);
        	
        	
        	//model.addAttribute("mercostsheethdrsmvList",mercostsheetsmvManager.getAll(mercostsheethdr));
        	
        	return model;
        }
        else{
        	String preCostSheetNo = request.getParameter("preCostSheetNo");
            String preCostSheetType = request.getParameter("preCostsheetType");
            String preVersionNo = request.getParameter("preVersionNo");
            
        	if(!StringUtils.isBlank(preCostSheetNo) && !StringUtils.isBlank(preCostSheetType) && !StringUtils.isBlank(preVersionNo)){
        		MerprecostsheetId id = new MerprecostsheetId(preCostSheetNo, new BigDecimal(preVersionNo), preCostSheetType);
        		merprecostsheet = new Merprecostsheet();
        		merprecostsheet = merprecostsheetManager.get(id);
        		log.debug(merprecostsheet.toString());
        		mststyleheader = merprecostsheetManager.getStyle(id);
//        		mercostsheethdr.setMerprecostsheethdr(merprecostsheet);
        		mercostsheethdr.setMststyleheader(mststyleheader);
        		Date date = new Date();
        		mercostsheethdr.setCreatedOn(null);
        		mercostsheethdr.setCreateDate(date);
        		log.debug(mststyleheader.toString());
        		try {
        			// add component list 
        			if(mststyleheader!=null){
        				model.addAttribute("mststylecomponentList", mststylecomponentManager.getAll(mststyleheader));  
        			}
 	        		else{
 	        			 model.addAttribute("NO", "NO");
 	        			 log.debug("With no style"); 
 	        		}	
     	        } catch (SearchException se) {
     	            model.addAttribute("searchError", se.getMessage());
     	            log.debug(se.getMessage());  
     	        }
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
     	        		log.debug("With Style"); 
     	        		if(mststyleheader!=null){
     	        			// add component list 
     	        			log.debug("With Style"); 
     	        			model.addAttribute("mststylecomponentList", mststylecomponentManager.getAll(mststyleheader));
     	        			log.debug("With Style"); 
     	        			MercostsheethdrId id=new MercostsheethdrId(null, ConvertUtil.getDecimal("0"), null);
     	        			log.debug("With Style"); 
     	        			mercostsheethdr.setId(id);
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
        	}
        }
        
      //Add style dimensions and dimension values
    	List<Mststyledem> mststyledems = new ArrayList<Mststyledem>();
    	List<Mststyledemmap> mststyledemmaps = new ArrayList<Mststyledemmap>();
    	
    	if(mststyleheader != null){
    		mststyledems = mststyledemManager.getAll(mststyleheader);
    		mststyledemmaps = mststyledemmapManager.getAll(mststyleheader);
    	}
    	for (Iterator iterator = mststyledemmaps.iterator(); iterator.hasNext();) {
			Mststyledemmap mststyledemmap = (Mststyledemmap) iterator.next();
		}
    	for (Iterator iterator = mststyledems.iterator(); iterator.hasNext();) {
			Mststyledem mststyledem = (Mststyledem) iterator.next();
		}
    	model.addAttribute("mststyledems", mststyledems);
    	model.addAttribute("mststyledemmaps", mststyledemmaps);
    	/** hard corded precostsheet ** removed */
    	//merprecostsheet = merprecostsheetManager.get(new MerprecostsheetId("1", new BigDecimal(0), "HC"));
    	model.addAttribute("merprecostsheet", merprecostsheet);
    	
    	log.debug(merprecostsheet.toString());
    	    	
        model.addAttribute(mercostsheethdr);
        //log.debug(model);
        return model;
    	
    	/**    
        String costSheetNo = request.getParameter("costSheetNo");
        String costSheetType = request.getParameter("costSheetType");
        String versionNo = request.getParameter("versionNo");
        if(versionNo == null || versionNo == ""){
        	versionNo = "1";
        }
        MercostsheethdrId id = new MercostsheethdrId();
        id.setCostSheetNo(costSheetNo);
        id.setCostSheetType(costSheetType);
        id.setVersionNo(ConvertUtil.getDecimal(versionNo));
        if (!StringUtils.isBlank(costSheetNo) && !StringUtils.isBlank(costSheetType) && !StringUtils.isBlank(versionNo)) {
            return mercostsheethdrManager.get(id);
        }
    	 */ 
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Mercostsheethdr mercostsheethdr, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
    	
    	
    	try{
    		mstparameter=mstparametermanager.getAll().get(0);
    		location=mstparameter.getLocationCode();
		}catch(Exception e){
			log.debug(e.getMessage());
		}
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
        if (validator != null) { // validator is null during testing
            validator.validate(mercostsheethdr, errors);
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
            	//return "mercostsheethdrform";
            }
        }
/*        //get mst location
 		Mstparameter mstparameter=new Mstparameter();
     	try{
     		mstparameter=mstparametermanager.getAll().get(0);
     		location=mstparameter.getLocationCode();
 		}catch(Exception e){
 			log.debug(e.getMessage());
 		}*/
     	
        Mststyleheader mststyleheader = getstyle(request);
        boolean isNew = (mercostsheethdr.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();
        mercostsheethdr.setMststyleheader(mststyleheader);
        log.debug(mercostsheethdr);
        if (request.getParameter("delete") != null) {
            mercostsheethdrManager.remove(mercostsheethdr.getId());
            saveMessage(request, getText("mercostsheethdr.deleted", locale));
        } else {
        	String section =request.getParameter("section");
        	log.debug(section);
        	if(section.equalsIgnoreCase("section1")){
        		log.debug(mercostsheethdr);
        		Mercostsheethdr mercostsheethdr1 = savePageOne(request, response, mercostsheethdr);
        		Cookie cookie = new Cookie("costSheetNo", mercostsheethdr1.getId().getCostSheetNo().toString());
            	response.addCookie(cookie);
        		log.debug(mercostsheethdr);
        		if(!mercostsheethdr.getCompWiseCost() && mercostsheethdr.getAverageWiseCost()){
        			MercostsheetgroupId mercostsheetgroupId = new MercostsheetgroupId(1L, mercostsheethdr.getId().getCostSheetNo(), ConvertUtil.getDecimal(mercostsheethdr.getId().getVersionNo().toString()), mercostsheethdr.getId().getCostSheetType());
        			
        			/** hard corded precost sheet remove using request params */
        	    	Merprecostsheet merprecostsheet =  mercostsheethdrManager.getprecostsheet(mercostsheethdr1.getId())  ;//mercostsheethdr1.getMerprecostsheethdr();
        	    	//merprecostsheetManager.get(new MerprecostsheetId("1", new BigDecimal(0), "HC"));

        	    	Mercostsheetgroup mercostsheetgroup = new Mercostsheetgroup();
        	    	if(merprecostsheet.getCreatedBy().equalsIgnoreCase("SYSTEM")){
        	    		mercostsheetgroup = new Mercostsheetgroup(mercostsheetgroupId, mercostsheethdr, merprecostsheet, "All", "All",
        	    				 null, null, null, null, null, false, false);
        	    	}
        	    	else{
        	    		mercostsheetgroup = new Mercostsheetgroup(mercostsheetgroupId, mercostsheethdr, merprecostsheet, "All", "All",
        	    				ConvertUtil.getDecimal(merprecostsheet.getTotalCost().toString()), ConvertUtil.getDecimal(merprecostsheet.getSellingPrice().toString()),
    	    				 merprecostsheet.getShipmentMode(), merprecostsheet.getDeliveryTerm(),
    	    				merprecostsheet.getRemarks(), false, false);
        	    	}
    				
    	    		mercostsheetgroupManager.save(mercostsheetgroup);
    	    		Long groupSettingId = 1L;
    	    		List <Mststylecomponent> component= mststylecomponentManager.getAll(mststyleheader);
    	    		log.debug(component.size());
    	    		for(int k=0;k<component.size();k++){
    	    			MercostsheetgroupsettingId id=new MercostsheetgroupsettingId(groupSettingId++, mercostsheetgroup.getId().getGroupId(), mercostsheetgroup.getId().getCostSheetNo(), mercostsheetgroup.getId().getVersionNo(), mercostsheetgroup.getId().getCostSheetType());
    	    			Mercostsheetgroupsetting mercostsheetgroupsetting=new Mercostsheetgroupsetting(id, mercostsheetgroup, component.get(k).getId().getComponentId());
    	    			mercostsheetgroupsettingManager.save(mercostsheetgroupsetting);
    	    		}
        		}
        		
        	}
        	if(section.equalsIgnoreCase("section2")){
        		Mercostsheethdr mercostsheethdr1 = savePageTwo(request, mercostsheethdr);
        	}
        	if(section.equalsIgnoreCase("section3")){
        		String bulkActions=request.getParameter("bulkActions");
            	log.debug(bulkActions);
            	if(bulkActions.equals("AlltoAll")){
            		rawMatialAll( mercostsheethdr, request, response);
            	}else if(bulkActions.equals("AlltoSelct")){
            		rawMaterialSell( mercostsheethdr, request, response);
            	}
            	else if(bulkActions.equals("OneoSelct")){
            		rawMaterialSection( mercostsheethdr, request, response);
            	}
            	/*else if(bulkActions.equals("delete")){
            		rawMaterialSection( mercostsheethdr, request, response);
            	}*/
        	}
        	if(section.equalsIgnoreCase("section4")){
        		savesheelfabric(mercostsheethdr,request,response);
        	}
        	if(section.equalsIgnoreCase("section5")){
        		saveCosting(mercostsheethdr,request,response);
        	}
        	if(section.equalsIgnoreCase("section6")){
        		mercostsheethdr=mercostsheethdrManager.get(mercostsheethdr.getId());
        		mercostsheethdr.setFlag("Complete");
        		try{
        		mercostsheethdrManager.save(mercostsheethdr);
        		}
        		catch(Exception e){
        			log.debug(e.getMessage());
        		}
        	}
           // mercostsheethdrManager.save(mercostsheethdr);
//******  	this should change to section 03
            /*log.debug(section);
            if(section.equals("section2")){
            	String bulkActions=request.getParameter("bulkActions");
            	log.debug(bulkActions);
            	if(bulkActions.equals("AlltoAll")){
            		rawmatAll( mercostsheethdr, request, response);
            	}else if(bulkActions.equals("AlltoSelct")){
            		rawmatSell( mercostsheethdr, request, response);
            	}
            	else{
        			rawmatsection( mercostsheethdr, request, response);
            	}
            }*/
            	
            String key = (isNew) ? "mercostsheethdr.added" : "mercostsheethdr.updated";
            saveMessage(request, getText(key, locale));
            if (!isNew) {
                success = "redirect:mercostsheethdrform?id=" + mercostsheethdr.getId();
            }
        }
        return success;
    }
    
	private void saveCosting(Mercostsheethdr mercostsheethdr,
			HttpServletRequest request, HttpServletResponse response) {
		
		log.debug(mercostsheethdr);
		//log.debug(mercostsheethdr); 
		MercostsheethdrId id=mercostsheethdr.getId();
		// SelectGroup raw_material_cost cm services_cost finance_cost cmt totalCost markupV sellingPrice buyerCommission our_price externalCommission
		String SelectGroup="";
		if(request.getParameter("SelectGroup")!=null && request.getParameter("SelectGroup")!=""){
			SelectGroup=request.getParameter("SelectGroup");
		}
		else{
			SelectGroup=request.getParameter("SelectGroup2");
		}
		log.debug(SelectGroup+ "   **********"); 
		if(SelectGroup!=null && SelectGroup!=""){
			Mercostsheetgroup mercostsheetgroup= mercostsheetgroupManager.get(id.getCostSheetNo(), id.getVersionNo().toString(), id.getCostSheetType(),SelectGroup);
		
			mercostsheetgroup.setSellingPrice(ConvertUtil.getDecimal(request.getParameter("sellingPrice")));
			mercostsheetgroup.setTotalCost(ConvertUtil.getDecimal(request.getParameter("totalCost")));
			mercostsheetgroup.setRowMaterialValue(ConvertUtil.getDecimal(request.getParameter("raw_material_cost")));
			mercostsheetgroup.setCm(ConvertUtil.getDecimal(request.getParameter("cm")));
			mercostsheetgroup.setCmt(ConvertUtil.getDecimal(request.getParameter("cmt")));
			mercostsheetgroup.setServiceValue(ConvertUtil.getDecimal(request.getParameter("services_cost")));
			mercostsheetgroup.setFinanceCost(ConvertUtil.getDecimal(request.getParameter("finance_cost")));
			mercostsheetgroup.setMarkupAmount(ConvertUtil.getDecimal(request.getParameter("markupV")));
			mercostsheetgroup.setBuyerCommission(ConvertUtil.getDecimal(request.getParameter("buyerCommission")));
			mercostsheetgroup.setOurPrice(ConvertUtil.getDecimal(request.getParameter("our_price")));
			mercostsheetgroup.setExternalCommission(ConvertUtil.getDecimal(request.getParameter("externalCommission")));
			log.debug(mercostsheetgroup); 
			try{
			mercostsheetgroupManager.save(mercostsheetgroup);
			}catch(Exception e){
				log.debug(e.getMessage()); 
			}
		}
		else{
			log.debug("Nothing to save "); 
		}
		//mercostsheethdrManager.save(mercostsheethdr);
		
	}
	private void savesheelfabric(Mercostsheethdr mercostsheethdr,
			HttpServletRequest request, HttpServletResponse response) {
		String shellFabrics=request.getParameter("shellFabric");
		
		if(shellFabrics!=null && shellFabrics!=""){
			log.debug(shellFabrics);
			String[] shellFabric= splitArray(shellFabrics,",");
			log.debug(shellFabric.length);
			for(int i=0;i<shellFabric.length;i++){
				if(shellFabric[i]!=null && shellFabric[i]!=""){
					String[] shellFabricitems= splitArray(shellFabric[i],":");
					List<Mercostsheetrowmaterial> mercostsheetrowmaterials=mercostsheetrowmaterialManager.getAll(mercostsheethdr, "FABRIC", shellFabricitems[0], shellFabricitems[1]);
					log.debug(mercostsheetrowmaterials.size());
					for(int k=0;k<mercostsheetrowmaterials.size();k++){
						Mercostsheetrowmaterial mercostsheetrowmaterial=mercostsheetrowmaterials.get(k);
						mercostsheetrowmaterial.setIsShellFabric(true);
						mercostsheetrowmaterialManager.save(mercostsheetrowmaterial);
					}
				}
			}
		} 
		mercostsheethdr=mercostsheethdrManager.get(mercostsheethdr.getId());
		mercostsheethdr.setBaseBody(request.getParameter("baseBody"));
		mercostsheethdr.setBuyerReference(request.getParameter("buyerReference"));
		mercostsheethdrManager.save(mercostsheethdr);
		
	}
	private Mststyleheader getstyle(HttpServletRequest request){
    	String locationCode = request.getParameter("locationCode") ;
        String custCode = request.getParameter("custCode") ;
        String styleId = request.getParameter("styleId") ;
        String depCode = request.getParameter("depCode") ;
        String compCode = request.getParameter("compCode") ;
        
        log.debug(compCode+ " - "+custCode+ " - "+depCode +" - "+locationCode +" - "+styleId);
        Mststyleheader mststyleheader=new Mststyleheader();
        MststyleheaderId id=new MststyleheaderId(styleId, locationCode, depCode, compCode, custCode);
        if(!StringUtils.isBlank(locationCode)){
       		mststyleheader = mststyleheaderManager.get(id);
        }
        log.debug(mststyleheader);
        return  mststyleheader;
    }
    
	private Boolean rawMatialAll(Mercostsheethdr mercostsheethdr, HttpServletRequest request,
	        HttpServletResponse response){
		log.debug("rawmatAll");
		
		MercostsheethdrId mercostsheethdrId=mercostsheethdr.getId();
		mercostsheethdr=mercostsheethdrManager.get(mercostsheethdrId);
		
		Merprecostsheet merprecostsheet=mercostsheethdrManager.getprecostsheet(mercostsheethdrId);
		String preCostSheetNo=merprecostsheet.getId().getPreCostSheetNo();
		String preCostSheetType=merprecostsheet.getId().getCostsheetType();
		BigDecimal preVersion=merprecostsheet.getId().getVersionNo();
		
		
		//List<Mercostsheetgroup> mercostsheetgroups=mercostsheetgroupManager.getAll(mercostsheethdr);
		List<Mercostsheetgroupsetting> mercostsheetgroupsettings=mercostsheetgroupsettingManager.getAll(mercostsheethdr);
		
		
		//MerprecostsheetId merprecostsheetId=new MerprecostsheetId(preCostSheetNo, preVersion, preCostSheetType);
		//List<Merprecostsheetrowmaterials> merprecostsheetrowmaterials =merprecostsheetrowmaterialsManager.getAll(merprecostsheet);
		String dataid=request.getParameter("dataid");
		String[] dataids= splitArray(dataid,",");
		MerprecostsheetrowmaterialsId id=new MerprecostsheetrowmaterialsId(preCostSheetNo, preVersion, preCostSheetType, null, null);
		log.debug("data id length: "+ dataids.length);
		log.debug("Group settings length  : "+mercostsheetgroupsettings.size());
		
		for(int i=0;i<dataids.length;i++){
			log.debug("data id "+dataids[i]+" - "+ i);
			String[] ids= splitArray(dataids[i],":");
			id.setComponent(ids[1]);
			id.setPrecostsheetRowMatCode(ConvertUtil.getDecimal(ids[0]));
			log.debug("Precostsheet rawmat Id : "+ id);
			Merprecostsheetrowmaterials merprecostsheetrowmaterial =merprecostsheetrowmaterialsManager.get(id);// merprecostsheetrowmaterials.get(i);
			log.debug( "Precostsheet rawmat  : " + merprecostsheetrowmaterial);
			for(int j=0;j<mercostsheetgroupsettings.size();j++){
				log.debug(j);
				Mercostsheetgroupsetting mercostsheetgroupsetting = mercostsheetgroupsettings.get(j);
				log.debug("compering components  "+merprecostsheetrowmaterial.getId().getComponent() + " = "+mercostsheetgroupsetting.getComponent() );
				if(merprecostsheetrowmaterial.getId().getComponent().equals(mercostsheetgroupsetting.getComponent())){
					Mercostsheetgroup mercostsheetgroup=mercostsheetgroupsetting.getMercostsheetgroup();
					copyRowmaterials(mercostsheetgroup,merprecostsheetrowmaterial);
				}
				else{
					log.debug(" Not aaded");
				}
			} 
		}
		
		
		return false;
	}
	
	private Boolean rawMaterialSell(Mercostsheethdr mercostsheethdr, HttpServletRequest request,
	        HttpServletResponse response){
		log.debug("rawmatAll");

		String costSheetNo=mercostsheethdr.getId().getCostSheetNo();
		BigDecimal versionNo=mercostsheethdr.getId().getVersionNo();
		String costsheetType=mercostsheethdr.getId().getCostSheetType();
		
		Merprecostsheet merprecostsheet=mercostsheethdrManager.getprecostsheet(mercostsheethdr.getId());
		String preCostSheetNo=merprecostsheet.getId().getPreCostSheetNo();
		String preCostSheetType=merprecostsheet.getId().getCostsheetType();
		BigDecimal preVersion=merprecostsheet.getId().getVersionNo();
		
	
		MerprecostsheetrowmaterialsId id=new MerprecostsheetrowmaterialsId(preCostSheetNo, preVersion, preCostSheetType, null, null);
		
		//List<Mercostsheetgroupsetting> mercostsheetgroupsettings=mercostsheetgroupsettingManager.getAll(mercostsheethdr);
		List<Mercostsheetrowmaterial> mercostsheetrowmaterials=mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo.toString(), costsheetType); 
		//String groupid=request.getParameter("groupid");
		String consmptions=request.getParameter("consmptions");
		String[] comVsConsmptions = splitArray(consmptions ,",");
		String dataid=request.getParameter("dataid");
		String[] selectedRawmats= splitArray(dataid,",");

		for(int k=0;k<mercostsheetrowmaterials.size();k++){
			log.debug("Removed "+mercostsheetrowmaterials.get(k).getId().getGroupId());
			mercostsheetrowmaterialManager.remove(mercostsheetrowmaterials.get(k));
		}
	
		
		//MerprecostsheetId merprecostsheetId=new MerprecostsheetId(preCostSheetNo, preVersion, preCostSheetType);
		//Merprecostsheet merprecostsheet=merprecostsheetManager.get(merprecostsheetId);
		
		log.debug("selectedRawmats id length: "+ selectedRawmats.length);
		//log.debug("Group settings length  : "+mercostsheetgroupsettings.size());
		
		for(int i=0;i<selectedRawmats.length;i++){
			String[] ids= splitArray(selectedRawmats[i],":");
			id.setComponent(ids[1]);
			id.setPrecostsheetRowMatCode(ConvertUtil.getDecimal(ids[0]));
			Merprecostsheetrowmaterials merprecostsheetrowmaterial =merprecostsheetrowmaterialsManager.get(id);// merprecostsheetrowmaterials.get(i);
			for(int k=0;k<comVsConsmptions.length;k++){
				String[] comVsConsmption= splitArray(comVsConsmptions[k],":");
				log.debug("componet comper :  : "+merprecostsheetrowmaterial.getId().getComponent()+" - "+ comVsConsmption[0]);
				if(merprecostsheetrowmaterial.getId().getComponent().equals(comVsConsmption[0])){
					log.debug(" groups  "+comVsConsmption[1]);
					String[] groups= splitArray(comVsConsmption[1],";");
					log.debug("Number of groups  "+groups.length);
					for(int j=0;j<groups.length;j++){
						//MercostsheetgroupId mercostsheetgroupId=new MercostsheetgroupId( ConvertUtil.getlongs(groups[j]), costSheetNo, versionNo, costsheetType);
						Mercostsheetgroup mercostsheetgroup = mercostsheetgroupManager.get(costSheetNo, versionNo.toString(), costsheetType, groups[j]);	
						log.debug("groupid : "+mercostsheetgroup);
						copyRowmaterials(mercostsheetgroup,merprecostsheetrowmaterial);
					}
				}
				else{
					log.debug("Not Equal ");
				}
			}
		}
		
		
		/*for(int i=0;i<dataids.length;i++){
			String[] ids= splitArray(selectedRawmats[i],":");
			id.setComponent(ids[1]);
			id.setPrecostsheetRowMatCode(ConvertUtil.getDecimal(ids[0]));
			Merprecostsheetrowmaterials merprecostsheetrowmaterial =merprecostsheetrowmaterialsManager.get(id);// merprecostsheetrowmaterials.get(i);
			for(int j=0;j<mercostsheetgroupsettings.size();j++){
				Mercostsheetgroupsetting mercostsheetgroupsetting = mercostsheetgroupsettings.get(j);
				if(merprecostsheetrowmaterial.getId().getComponent().equals(mercostsheetgroupsetting.getComponent()) && ){
					Mercostsheetgroup mercostsheetgroup=mercostsheetgroupsetting.getMercostsheetgroup();
					copyRowmaterials(mercostsheetgroup,merprecostsheetrowmaterial);
				}
				else{
					log.debug(" "+merprecostsheetrowmaterial.getId().getComponent()+" = "+mercostsheetgroupsetting.getComponent());
				}
			} 
		} */
		
		return false;
	}
	
    private Boolean copyRowmaterials(Mercostsheetgroup mercostsheetgroup, Merprecostsheetrowmaterials merprecostsheetrowmaterial) {
    	log.debug("copyRowmaterials");
    	Long groupId=mercostsheetgroup.getId().getGroupId(); 
    	String costSheetNo=mercostsheetgroup.getId().getCostSheetNo(); 
    	BigDecimal versionNo=mercostsheetgroup.getId().getVersionNo(); 
    	String costSheetType=mercostsheetgroup.getId().getCostSheetType(); 
    	BigDecimal costSheetRowMatCode =mercostsheetrowmaterialManager.getNext(mercostsheetgroup).add(ConvertUtil.getDecimal("1"));
    	String component=merprecostsheetrowmaterial.getId().getComponent();
    	//Mercostsheethdr mercostsheethdr=mercostsheethdrManager.get(new MercostsheethdrId(costSheetNo, versionNo, costSheetType));
    	MercostsheetrowmaterialId mercostsheetrowmaterialId=new MercostsheetrowmaterialId(groupId, costSheetNo, versionNo, costSheetType, costSheetRowMatCode, component);
    	Mercostsheetrowmaterial mercostsheetrowmaterial=new Mercostsheetrowmaterial(mercostsheetrowmaterialId);

    	mercostsheetrowmaterial.setShipingType(merprecostsheetrowmaterial.getShipingType());
    	mercostsheetrowmaterial.setItemColor(merprecostsheetrowmaterial.getItemColor());
    	mercostsheetrowmaterial.setItemWidth(merprecostsheetrowmaterial.getItemWidth());
    	mercostsheetrowmaterial.setIsShellFabric(merprecostsheetrowmaterial.getIsshellfabric());
    	
    	Mstitemtype mstitemtype=new Mstitemtype(merprecostsheetrowmaterial.getMstitem().getId().getItemType());
    	mercostsheetrowmaterial.setMstitemtype(mstitemtype);
    	
    	mercostsheetrowmaterial.setItemCode(merprecostsheetrowmaterial.getMstitem().getId().getItemCode());
    	mercostsheetrowmaterial.setAllowance(merprecostsheetrowmaterial.getAllowance());
    	mercostsheetrowmaterial.setConsumption(merprecostsheetrowmaterial.getConsumption());
    	
    	Mstcurrency mstcurrency=mstcurrencyManager.get(merprecostsheetrowmaterial.getCurrency());
		mercostsheetrowmaterial.setMstcurrency(mstcurrency);
    	mercostsheetrowmaterial.setMstcurrency(mstcurrency);
    	
    	mercostsheetrowmaterial.setExchangeRate(merprecostsheetrowmaterial.getExchangeRate());
    	mercostsheetrowmaterial.setFinance(merprecostsheetrowmaterial.getFinance());
    	mercostsheetrowmaterial.setItemCatogery(merprecostsheetrowmaterial.getItemCatogery());
    	mercostsheetrowmaterial.setItemDecription(merprecostsheetrowmaterial.getItemDecription());
    	mercostsheetrowmaterial.setMercostsheetgroup(mercostsheetgroup);
    	mercostsheetrowmaterial.setPrice(merprecostsheetrowmaterial.getPrice());
    	
    	MstsupplierId id2=new MstsupplierId(merprecostsheetrowmaterial.getSupplierCompCode(), merprecostsheetrowmaterial.getSupplierCode());
		Mstsupplier mstsupplier=mstsupplierManager.get(id2);
		mercostsheetrowmaterial.setMstsupplier(mstsupplier);
		
    	mercostsheetrowmaterial.setUom(merprecostsheetrowmaterial.getUom());
    	log.debug(mercostsheetrowmaterial);
    	mercostsheetrowmaterialManager.save(mercostsheetrowmaterial);
    	return false;
	
		
	}
	
    private Boolean rawMaterialSection(Mercostsheethdr mercostsheethdr, HttpServletRequest request,
        HttpServletResponse response){
    	// get id parameters 
    	log.debug(mercostsheethdr);
    	String consmption = request.getParameter("consmptions");
		String costSheetNo=mercostsheethdr.getId().getCostSheetNo();
		String costSheetType=mercostsheethdr.getId().getCostSheetType();
		BigDecimal version=mercostsheethdr.getId().getVersionNo();

		String costsheetRowMatCode=request.getParameter("costsheetRowMatCode");
		String component=request.getParameter("component");
		String groupId=request.getParameter("groupId");
		
		if(request.getParameter("deleteRowMat") != null){
			MercostsheetrowmaterialId id=new MercostsheetrowmaterialId(ConvertUtil.getlongs(groupId),costSheetNo, version, costSheetType,ConvertUtil.getDecimal(costsheetRowMatCode), component) ;
			try{
				mercostsheetrowmaterialManager.remove(id);
			}catch(Exception e){
    			log.debug(e.getMessage());
    			
    		}
		}
		else if(request.getParameter("editRowMat") != null){
			MercostsheetrowmaterialId id=new MercostsheetrowmaterialId(ConvertUtil.getlongs(groupId),costSheetNo, version, costSheetType,ConvertUtil.getDecimal(costsheetRowMatCode), component) ;
			Mercostsheetrowmaterial mercostsheetrowmaterial=new Mercostsheetrowmaterial();
			mercostsheetrowmaterial.setId(id);
			mercostsheetrowmaterial.setAllowance(ConvertUtil.getDecimal(request.getParameter("allowance")));
			mercostsheetrowmaterial.setConsumption(ConvertUtil.getDecimal(request.getParameter("consumption")));
			mercostsheetrowmaterial.setUom(request.getParameter("UMO"));
			Mstcurrency mstcurrency=mstcurrencyManager.get(request.getParameter("currency"));
			mercostsheetrowmaterial.setMstcurrency(mstcurrency);
			mercostsheetrowmaterial.setExchangeRate(ConvertUtil.getDecimal(request.getParameter("exchangeRate")));
			mercostsheetrowmaterial.setPrice(ConvertUtil.getDecimal(request.getParameter("price")));
			mercostsheetrowmaterial.setFinance(ConvertUtil.getDecimal(request.getParameter("finance")));
			mercostsheetrowmaterial.setItemCatogery(request.getParameter("itemcategory"));
        	mercostsheetrowmaterial.setItemColor(request.getParameter("itemColor"));
        	mercostsheetrowmaterial.setItemDecription(request.getParameter("itemDecription"));
			mercostsheetrowmaterial.setItemWidth(request.getParameter("itemWidth"));
			//MercostsheetgroupId id2=new MercostsheetgroupId(groupId, costSheetNo, versionNo, costSheetType)
			String groupName=request.getParameter("groupid");
			String versionNo=request.getParameter("id.versionNo");
			Mercostsheetgroup mercostsheetgroup2=mercostsheetgroupManager.get(mercostsheethdr.getId().getCostSheetNo(),versionNo , mercostsheethdr.getId().getCostSheetType(), groupName);
			mercostsheetrowmaterial.setMercostsheetgroup(mercostsheetgroup2);
			Mstitemtype mstitemtype=new Mstitemtype(request.getParameter("itemType"));
			
			mercostsheetrowmaterial.setItemCode(request.getParameter("itemCode"));
			mercostsheetrowmaterial.setMstitemtype(mstitemtype);
			mercostsheetrowmaterial.setShipingType(request.getParameter("shipingType"));
			MstsupplierId id2=new MstsupplierId(location, request.getParameter("supplierCode"));
			Mstsupplier mstsupplier=mstsupplierManager.get(id2);
			mercostsheetrowmaterial.setMstsupplier(mstsupplier);
			try{
				mercostsheetrowmaterialManager.save(mercostsheetrowmaterial);
			}catch(Exception e){
    			log.debug(e.getMessage());
    			
    		}
		}
		else{
			if(consmption!="" && consmption!=null){
    			String[] consmptions= splitArray(consmption,",");
        		for(int i=0;i<consmptions.length;i++){ 
        			 Mercostsheetrowmaterial mercostsheetrowmaterial=new Mercostsheetrowmaterial();
        			 MercostsheetrowmaterialId id=new MercostsheetrowmaterialId();
                	 Mercostsheetgroup mercostsheetgroup = new Mercostsheetgroup();
                	 
                	// String averageWiseCost= ; 
                	 //String compWiseCost=; 
                	 if(request.getParameter("compWiseCost") ==null && request.getParameter("averageWiseCost") !=null){//request.getParameter("averageWiseCost").equalsIgnoreCase("on")
                		// consumption  allowance UMO
                		 log.debug(mercostsheethdr.getId().getCostSheetNo()+ " "+mercostsheethdr.getId().getVersionNo().toString()+" "+ mercostsheethdr.getId().getCostSheetType()+" " + "All");
                		 mercostsheetgroup = mercostsheetgroupManager.get(mercostsheethdr.getId().getCostSheetNo(), mercostsheethdr.getId().getVersionNo().toString(), mercostsheethdr.getId().getCostSheetType(), "All");
                		 log.debug(mercostsheetgroup);
                		 BigDecimal  costsheetRowMatCodes=mercostsheetrowmaterialManager.getNext(mercostsheetgroup).add(ConvertUtil.getDecimal("1"));
	                 	log.debug(costsheetRowMatCodes);
	                 	log.debug(mercostsheetgroup);
                		 id =new MercostsheetrowmaterialId(mercostsheetgroup.getId().getGroupId(),mercostsheethdr.getId().getCostSheetNo(), mercostsheethdr.getId().getVersionNo(), mercostsheethdr.getId().getCostSheetType(), costsheetRowMatCodes, consmptions[i]);
	                	 mercostsheetrowmaterial.setAllowance(ConvertUtil.getDecimal(request.getParameter("allowance")));
	                	 mercostsheetrowmaterial.setConsumption(ConvertUtil.getDecimal(request.getParameter("consumption")));
	                	 mercostsheetrowmaterial.setUom(request.getParameter("UMO"));
	                	 
	                	 log.debug(id);
	                	 mercostsheetrowmaterial.setId(id);
	                	 log.debug(mercostsheetrowmaterial.getId());
	                	 Mstcurrency mstcurrency=mstcurrencyManager.get(request.getParameter("currency"));
	                	 mercostsheetrowmaterial.setMstcurrency(mstcurrency);
	                	 mercostsheetrowmaterial.setExchangeRate(ConvertUtil.getDecimal(request.getParameter("exchangeRate")));
	                	 mercostsheetrowmaterial.setPrice(ConvertUtil.getDecimal(request.getParameter("price")));
	                	 mercostsheetrowmaterial.setFinance(ConvertUtil.getDecimal(request.getParameter("finance")));
	                	 
	                	 mercostsheetrowmaterial.setIsShellFabric(false);
	                	 mercostsheetrowmaterial.setItemCatogery(request.getParameter("itemcategory"));
	                	 mercostsheetrowmaterial.setItemColor(request.getParameter("itemColor"));
	                	 mercostsheetrowmaterial.setItemDecription(request.getParameter("itemDecription"));
	                	 mercostsheetrowmaterial.setItemWidth(request.getParameter("itemWidth"));
	                	 mercostsheetrowmaterial.setMercostsheetgroup(mercostsheetgroup);
	                	 Mstitemtype mstitemtype=new Mstitemtype(request.getParameter("itemType"));
	         			
	         			mercostsheetrowmaterial.setItemCode(request.getParameter("itemCode"));
	         			mercostsheetrowmaterial.setMstitemtype(mstitemtype);
	         			mercostsheetrowmaterial.setShipingType(request.getParameter("shipingType"));
	         			MstsupplierId id2=new MstsupplierId(location, request.getParameter("supplierCode"));
	         			Mstsupplier mstsupplier=mstsupplierManager.get(id2);
	         			mercostsheetrowmaterial.setMstsupplier(mstsupplier);
	         			log.debug(mercostsheetrowmaterial);
	         			try{
	                	mercostsheetrowmaterialManager.save(mercostsheetrowmaterial);
	         			}
	         			catch(Exception exception){
	         				log.debug(exception.getMessage());
	         			}
                	 }
                	 else{
                		 String[] group=null;
            		 	String[] consmptions_details= splitArray(consmptions[i],":");
        	 			if(request.getParameter("compWiseCost") ==null ){
        	 				String groupid=request.getParameter("groupid");
        	 				group=splitArray(groupid,","); 
            	 		}
            	 		else{
            	 			log.debug( " Groups : " +consmptions_details[1]);
            	 			group=splitArray(consmptions_details[1],";");
                	 	}
	                	 for(int m=0;m<group.length;m++){
	                		 log.debug( " Group : " +group[m]);
	                		 mercostsheetgroup = mercostsheetgroupManager.get(mercostsheethdr.getId().getCostSheetNo(), mercostsheethdr.getId().getVersionNo().toString(), mercostsheethdr.getId().getCostSheetType(), group[m]);
	                		 BigDecimal  costsheetRowMatCodes=mercostsheetrowmaterialManager.getNext(mercostsheetgroup).add(ConvertUtil.getDecimal("1"));
		                 	log.debug(costsheetRowMatCodes);
		                 	log.debug(mercostsheetgroup);
	                		 if(mercostsheethdr.getCompWiseCost()!=null){
	                			 id =new MercostsheetrowmaterialId(mercostsheetgroup.getId().getGroupId(),mercostsheethdr.getId().getCostSheetNo(), mercostsheethdr.getId().getVersionNo(), mercostsheethdr.getId().getCostSheetType(), costsheetRowMatCodes, consmptions_details[0]);
			                	 mercostsheetrowmaterial.setAllowance(ConvertUtil.getDecimal(consmptions_details[4]));
			                	 mercostsheetrowmaterial.setConsumption(ConvertUtil.getDecimal(consmptions_details[2]));
			                	 mercostsheetrowmaterial.setUom(consmptions_details[3]);
			                	 
		                	 }
		                	 else{
		            			id =new MercostsheetrowmaterialId(mercostsheetgroup.getId().getGroupId(),mercostsheethdr.getId().getCostSheetNo(), mercostsheethdr.getId().getVersionNo(), mercostsheethdr.getId().getCostSheetType(), costsheetRowMatCodes, consmptions[i]);
			                	mercostsheetrowmaterial.setAllowance(ConvertUtil.getDecimal(request.getParameter("allowance")));
			                	mercostsheetrowmaterial.setConsumption(ConvertUtil.getDecimal(request.getParameter("consumption")));
			                	mercostsheetrowmaterial.setUom(request.getParameter("UMO"));
		                	 }
		                	 log.debug(id);
		                	 mercostsheetrowmaterial.setId(id);
		                	 log.debug(mercostsheetrowmaterial.getId());
		                	 Mstcurrency mstcurrency=mstcurrencyManager.get(request.getParameter("currency"));
		                	 mercostsheetrowmaterial.setMstcurrency(mstcurrency);
		                	 mercostsheetrowmaterial.setExchangeRate(ConvertUtil.getDecimal(request.getParameter("exchangeRate")));
		                	 mercostsheetrowmaterial.setPrice(ConvertUtil.getDecimal(request.getParameter("price")));
		                	 mercostsheetrowmaterial.setFinance(ConvertUtil.getDecimal(request.getParameter("finance")));
		                	 
		                	 mercostsheetrowmaterial.setIsShellFabric(false);
		                	 mercostsheetrowmaterial.setItemCatogery(request.getParameter("itemcategory"));
		                	 mercostsheetrowmaterial.setItemColor(request.getParameter("itemColor"));
		                	 mercostsheetrowmaterial.setItemDecription(request.getParameter("itemDecription"));
		                	 mercostsheetrowmaterial.setItemWidth(request.getParameter("itemWidth"));
		                	 mercostsheetrowmaterial.setMercostsheetgroup(mercostsheetgroup);
		                	 Mstitemtype mstitemtype=new Mstitemtype(request.getParameter("itemType"));
		         			
		         			mercostsheetrowmaterial.setItemCode(request.getParameter("itemCode"));
		         			mercostsheetrowmaterial.setMstitemtype(mstitemtype);
		         			mercostsheetrowmaterial.setShipingType(request.getParameter("shipingType"));
		         			MstsupplierId id2=new MstsupplierId(location, request.getParameter("supplierCode"));
		         			Mstsupplier mstsupplier=mstsupplierManager.get(id2);
		         			mercostsheetrowmaterial.setMstsupplier(mstsupplier);
		         			log.debug(mercostsheetrowmaterial);
		                	mercostsheetrowmaterialManager.save(mercostsheetrowmaterial);
	                	 }
                	 }
        		}
			}
			else{
    			log.debug("No consmptions");
    		}
		}
		return null;
		
		
    	
	} 
	
    private Boolean saveNewVersion(HttpServletRequest request){
		return null;
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
    
	private String[] splitArray(String string) {
		String[] array = {""};
		if(string != null && string != ""){
			try{
				array = string.split(",");
			}catch(Exception e){
				log.debug("Error split : "+e.getMessage());
			}
		}
		return array;
	}
	
    private Mercostsheethdr savePageOne(HttpServletRequest request, HttpServletResponse response, Mercostsheethdr mercostsheethdr){
    	Mststyleheader mststyleheader = getstyle(request);
    	log.debug(mercostsheethdr);
    	if(mercostsheethdr.getIsCurrencyLocked() == null)
    		mercostsheethdr.setIsCurrencyLocked(false);
    	if(mercostsheethdr.getIsHeaderLoced() == null)
    		mercostsheethdr.setIsHeaderLoced(false);
    	if(mercostsheethdr.getSizeWiseCost() == null)
    		mercostsheethdr.setSizeWiseCost(false);
        if(mercostsheethdr.getCountryWiseCost() == null)
        	mercostsheethdr.setCountryWiseCost(false);
        if(mercostsheethdr.getAverageWiseCost() == null)
        	mercostsheethdr.setAverageWiseCost(false);
        if(mercostsheethdr.getCompWiseCost() == null)
        	mercostsheethdr.setCompWiseCost(false);
        
        String costSheetType="";
        BigDecimal versionNo=null;
        String costSheetNo="";
    	//Add cost sheet
    	log.debug(mercostsheethdr.toString());
    	if(StringUtils.isBlank(mercostsheethdr.getId().getCostSheetNo())){
    		log.debug("New ");
    		costSheetNo = mstnumbersManager.getnexttrnNo(location, programID, trntype).toString();
    		versionNo=ConvertUtil.getDecimal("0");
    		costSheetType= mercostsheethdr.getId().getCostSheetType();
    		Cookie cookie = new Cookie("costSheetNo", costSheetNo);
    		response.addCookie(cookie);
    		
    		
    		MercostsheethdrId id = new MercostsheethdrId(costSheetNo, versionNo, mercostsheethdr.getId().getCostSheetType());
    		mercostsheethdr.setId(id);
    		mercostsheethdr.setFlag(flag);
    		Date date = new Date();
        	mercostsheethdr.setCreateDate(date);
    		mercostsheethdr.setMststyleheader(mststyleheader);
    		//mercostsheethdr.setBuyerReference(mststyleheader.getId().getCustCode());
        	mercostsheethdr.setCreatedAt(location);
    		mercostsheethdr.setCreatedBy(request.getRemoteUser());
    		mercostsheethdr.setCreatedOn(date);
    		
    		String preCostSheetNo = request.getParameter("preCostSheetNo");
            String preCostSheetType = request.getParameter("preCostsheetType");
            String preVersionNo = request.getParameter("preVersionNo");
            
            Merprecostsheet merprecostsheet = new Merprecostsheet();
        	if(!StringUtils.isBlank(preCostSheetNo) && !StringUtils.isBlank(preCostSheetType) && !StringUtils.isBlank(preVersionNo)){
        		MerprecostsheetId merprecostsheetId = new MerprecostsheetId(preCostSheetNo, new BigDecimal(preVersionNo), preCostSheetType);
        		merprecostsheet = merprecostsheetManager.get(merprecostsheetId);
        	}
        	else{
        		short programID=4006;
        	    String trntype="PCST";
        	    preCostSheetNo = mstnumbersManager.getnexttrnNo(location, programID, trntype).toString();
        	    MerprecostsheetId merprecostsheetId = new MerprecostsheetId(preCostSheetNo, versionNo, mercostsheethdr.getId().getCostSheetType());
    			merprecostsheet.setId(merprecostsheetId);
    			//merprecostsheet.set
    			merprecostsheet.setFlag("Complete");
	            merprecostsheet.setMststyleheader(mststyleheader);
	            merprecostsheet.setCreatedAt(location);
	            merprecostsheet.setCreatedBy("SYSTEM");
	            merprecostsheet.setCreatedOn(new Date());
	            merprecostsheet.setSeason(mercostsheethdr.getSeason());
	            log.debug(merprecostsheet);
	            try{
	            	merprecostsheet = merprecostsheetManager.save(merprecostsheet);
	            }
	            catch(Exception e){
        			log.debug(e.getMessage());
        		}
	            String smvvalues =request.getParameter("smvarr");
	            if(smvvalues!="" && smvvalues!=null){
	                String[] itemsmv = splitArray(smvvalues,",");
                 	for(int i=0;i< itemsmv.length;i++){
                 		String smv_value =itemsmv[i]; 
                 		if(smv_value !="" && smv_value !=null) {
                 			log.debug(smv_value);
	                 		String[] items = splitArray(smv_value ,":");
	                 		try{
		                 		MerprecostsheetsmvId merprecostsheetsmvId=new MerprecostsheetsmvId(ConvertUtil.getDecimal(items[0]), merprecostsheet.getId().getPreCostSheetNo(), merprecostsheet.getId().getVersionNo(), merprecostsheet.getId().getCostsheetType());
		                 		log.debug(merprecostsheetsmvId);
		                 		//styleRouteName + ":" + location + ":"+ritio +":"+linedff+":"+fmvCat+":"+fmv;
		                 		Mststyleroute mststyleroute=mststylerouteManager.get(ConvertUtil.getlongs(items[0]));
		                 		log.debug(mststyleroute);
		                 		Merprecostsheetsmv merprecostsheetsmv=new Merprecostsheetsmv(merprecostsheetsmvId, merprecostsheet,  items[1], mststyleroute, ConvertUtil.getDecimal(items[2]), items[4],ConvertUtil.getDecimal( items[5]), ConvertUtil.getDecimal(items[3]));
		                 		log.debug(merprecostsheetsmv);
		                 		merprecostsheetsmvManager.save(merprecostsheetsmv);
	                 		}
	                		catch(Exception e){
	                			log.debug(e.getMessage());
	                		}
                 		}
                 	}
                 } 
	            String currency=request.getParameter("currency");
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
			                 		log.debug(merprecostsheetcurrency);
			                 		merprecostsheetcurrencyManager.save(merprecostsheetcurrency);
		                 		}
		                		catch(Exception e){
		                			log.debug(e.getMessage());
		                		}
	                 		}
	                 	}
	                 } 
                 }
	            
    			
    			try{
    			merprecostsheet = merprecostsheetManager.save(merprecostsheet);
    			log.debug(merprecostsheet.toString());
    			}
    			catch(Exception e){
    				log.debug(e);
    			}
        	}
        	log.debug(mercostsheethdr.toString());
        	mercostsheethdr.setMerprecostsheethdr(merprecostsheet);
        	log.debug(mercostsheethdr.toString());
    	}
    	else{
    		log.debug("not New ");
    		Date date = new Date();
    		MercostsheethdrId  mercostsheethdrId=mercostsheethdr.getId();
    		// get working cost sheet
        	Mercostsheethdr mercostsheethdr2 = mercostsheethdrManager.get(mercostsheethdrId);
    		mercostsheethdr.setModifiedOn(date);
    		mercostsheethdr.setModifiedAt(location);
        	mercostsheethdr.setModifiedBy(request.getRemoteUser());
        	mercostsheethdr.setCreatedOn(mercostsheethdr2.getCreatedOn());
        	mercostsheethdr.setCreatedBy(mercostsheethdr2.getCreatedBy());
        	mercostsheethdr.setCreateDate(mercostsheethdr2.getCreateDate());
        	mercostsheethdr.setMerprecostsheethdr(mercostsheethdr2.getMerprecostsheethdr());
        	removeCurrencies( request);
			removeSmv(request);
    	}
    	
    	try{
    		try{
    			mercostsheethdrManager.save(mercostsheethdr);
    		}catch(Exception e){
    			log.debug(e);
    		}
    		try{
//			if(mstparameter.getCurrencyMethod().equalsIgnoreCase("Static")){
				if(request.getParameter("currency") != null && request.getParameter("currency") != ""){
					String[] currency = splitArray(ServletRequestUtils.getStringParameter(request, "currency",""));
					for (int i = 0; i < currency.length; i++) {
						String[] currn = currency[i].split(":");
						MercostsheetcurrencyId mercostsheetcurrencyId = new MercostsheetcurrencyId(currn[0], costSheetNo, new Long(versionNo.toString()), costSheetType);
						Mercostsheetcurrency mercostsheetcurrency = new Mercostsheetcurrency(mercostsheetcurrencyId, mercostsheethdr, new Long(currn[1]), false);
						mercostsheetcurrencyManager.save(mercostsheetcurrency);
					}
				}
//			}
    		}catch(Exception e){
    			log.debug(e);
    		}
			String demtypeVerti = ServletRequestUtils.getStringParameter(request, "demtypeVerti","");
			String demtypeHori = ServletRequestUtils.getStringParameter(request, "demtypeHori","");
            try{
            	if(request.getParameter("templateDemmap") != null && request.getParameter("templateDemmap") != ""){
        			//Shert:GCOLOR:AA:22
	        		String[] templateDemmap = splitArray(ServletRequestUtils.getStringParameter(request, "templateDemmap",""));
	            	for (int i = 0; i < templateDemmap.length; i++) {
	            		String[] demmap = templateDemmap[i].split(":");
						MercostsheetdemmapId mercostsheetdemmapId = new MercostsheetdemmapId
	            				(costSheetNo, versionNo, costSheetType, demmap[0], demmap[1], demtypeVerti, demtypeHori, demmap[2], demmap[3]);
	            		Mercostsheetdemmap mercostsheetdemmap = new Mercostsheetdemmap(mercostsheetdemmapId, mercostsheethdr, new Boolean(demmap[4]));
	        			mercostsheetdemmapManager.save(mercostsheetdemmap);
	        		}
        		}
        	}
        	catch(Exception e){
        		log.debug(e);
        	}
            
            try{
        		log.debug(request.getParameter("country"));
        		if(request.getParameter("country") != null && request.getParameter("country") != ""){
        			String[] country = splitArray(ServletRequestUtils.getStringParameter(request, "country",""));
                	for (int i = 0; i < country.length; i++) {
                		MercostsheetcountryId mercostsheetcountryId = new MercostsheetcountryId(country[i], costSheetNo, new Long(versionNo.toString()), costSheetType);
                		Mercostsheetcountry mercostsheetcountry = new Mercostsheetcountry();
                		mercostsheetcountry.setId(mercostsheetcountryId);
                		mercostsheetcountry.setMercostsheethdr(mercostsheethdr);
                		mercostsheetcountryManager.save(mercostsheetcountry);
            		}
        		}
        	}
        	catch(Exception e){
        		log.debug(e);
        	}
            
        	log.debug(request.getParameter("smvarr"));
    		//12:HAK:1:0:01:10,11:WEE:10:0:01:10
    		//styleRouteName + ":" + location + ":"+ratio +":"+linedff+":"+fmvCat+":"+fmv

        	if(request.getParameter("smvarr") != null && request.getParameter("smvarr") != ""){
        		//log.debug( smvarr[i]);
        		String[] smvarr = splitArray(ServletRequestUtils.getStringParameter(request, "smvarr",""));
        		for (int i = 0; i < smvarr.length; i++) {
    				log.debug( smvarr[i]);
    				String[] smv=splitArray(smvarr[i] ,":");
    				// = smvarr[i].split(":");
    				log.debug( smv[0]);
    				//styleRouteName + ":" + location + ":"+ritio +":"+linedff+":"+fmvCat+":"+fmv+":"+smv;
    				Mststyleroute mststyleroute = mststylerouteManager.get(ConvertUtil.getlongs(smv[0]));
    				MercostsheetsmvId mercostsheetsmvId = new MercostsheetsmvId(new BigDecimal(smv[0]), mercostsheethdr.getId().getCostSheetNo(), mercostsheethdr.getId().getVersionNo(), mercostsheethdr.getId().getCostSheetType());
    				Mercostsheetsmv mercostsheetsmv = new Mercostsheetsmv(mercostsheetsmvId, mercostsheethdr, smv[1], mststyleroute, ConvertUtil.getDecimal(smv[2]), smv[4], ConvertUtil.getlongs(smv[5]), ConvertUtil.getDecimal(smv[3]));
    				log.debug(mercostsheetsmv.toString());
    				mercostsheetsmvManager.save(mercostsheetsmv);
				}
    		}
        	log.debug("*********************");
    	}
    	catch(Exception e){
    		log.debug(e);
    		log.debug(e.getMessage());
    	}
    	//Add currency list 
    	

//    	String[] componets = splitArray(ServletRequestUtils.getStringParameter(request, "componets",""));
//    	for (int i = 0; i < componets.length; i++) {
//    		log.debug(componets[i]);
//			log.debug("***************");
//		}
//    	
//    	String[] demVerti = splitArray(ServletRequestUtils.getStringParameter(request, "demVerti",""));
//    	for (int i = 0; i < demVerti.length; i++) {
//    		log.debug(demVerti[i]);
//			log.debug("***************");
//		}
//    	String[] demHori = splitArray(ServletRequestUtils.getStringParameter(request, "demHori",""));
//    	for (int i = 0; i < demHori.length; i++) {
//    		log.debug(demHori[i]);
//			log.debug("***************");
//		}
//    	String demtypeVerti = ServletRequestUtils.getStringParameter(request, "demtypeVerti","");
//    	log.debug(demtypeVerti);
//		log.debug("***************");
//		
//    	String demtypeHori = ServletRequestUtils.getStringParameter(request, "demtypeHori","");
//    	log.debug(demtypeHori);
//    	log.debug(mercostsheethdr.getMststyleheader().toString());
    	return mercostsheethdr;
    }

    private Mercostsheethdr savePageTwo(HttpServletRequest request, Mercostsheethdr mercostsheethdr) {
		
    	String costSheetNo = mercostsheethdr.getId().getCostSheetNo();
    	BigDecimal versionNo = mercostsheethdr.getId().getVersionNo();
    	String costSheetType = mercostsheethdr.getId().getCostSheetType();
    	log.debug(costSheetNo);
        log.debug(versionNo);
        if(versionNo == null){
    		versionNo=ConvertUtil.getDecimal("0");
        }
        log.debug(costSheetType);
    	//String[] addedGroups = ServletRequestUtils.getStringParameter(request, "addedGroups","").split("-");
    	Long groupSettingId = new Long(1);
    	String demtypeVerti = ServletRequestUtils.getStringParameter(request, "demtypeVerti","");
    	String demtypeHori = ServletRequestUtils.getStringParameter(request, "demtypeHori","");
    	
    	/** hard corded precost sheet remove using request params */
    	//Merprecostsheet merprecostsheet = merprecostsheetManager.get(new MerprecostsheetId("1", new BigDecimal(0), "HC"));
    	String preCostSheetNo = request.getParameter("preCostSheetNo");
        String preCostSheetType = request.getParameter("preCostsheetType");
        String preVersionNo = request.getParameter("preVersionNo");
        
        log.debug(preCostSheetNo);
        log.debug(preCostSheetType);
        log.debug(preVersionNo);
        Merprecostsheet merprecostsheet = new Merprecostsheet();
    	if(!StringUtils.isBlank(preCostSheetNo) && !StringUtils.isBlank(preCostSheetType) && !StringUtils.isBlank(preVersionNo)){
    		MerprecostsheetId merprecostsheetId = new MerprecostsheetId(preCostSheetNo, new BigDecimal(preVersionNo), preCostSheetType);
    		merprecostsheet = merprecostsheetManager.get(merprecostsheetId);
    	}
    	else{
    		merprecostsheet = mercostsheethdrManager.getprecostsheet(mercostsheethdr.getId());
    	}
    	
    	log.debug(merprecostsheet.toString());
    	try {
    		Long groupId = 1L;
			JSONArray array = new JSONArray(request.getParameter("addedGroups"));
			log.debug(array.toString());
			for (int i = 0; i < array.length(); i++) {
				JSONArray group = new JSONArray((array.get(i)).toString());
				MercostsheetgroupId mercostsheetgroupId = new MercostsheetgroupId(groupId, costSheetNo, versionNo, costSheetType);
				Mercostsheetgroup mercostsheetgroup = new Mercostsheetgroup();
				mercostsheetgroup.setId(mercostsheetgroupId);
				mercostsheetgroup.setMercostsheethdr(mercostsheethdr);
				mercostsheetgroup.setMerprecostsheethdr(merprecostsheet);
				mercostsheetgroup.setGroupName(group.getString(1));
				mercostsheetgroup.setCountry(group.getString(2));
				mercostsheetgroup.setIsCostingLocked(false);
				mercostsheetgroup.setIsGroupLocked(false);
				try{
				mercostsheetgroup = new Mercostsheetgroup(mercostsheetgroupId, mercostsheethdr, merprecostsheet, group.getString(1), group.getString(2),
						ConvertUtil.getDecimal(merprecostsheet.getTotalCost().toString()), ConvertUtil.getDecimal(merprecostsheet.getSellingPrice().toString()), merprecostsheet.getShipmentMode(), merprecostsheet.getDeliveryTerm(),
						merprecostsheet.getRemarks(), false, false);
				}
				catch (Exception e){
					log.debug(e);
				}
				try{
					mercostsheetgroupManager.save(mercostsheetgroup);
				}
				catch (Exception e){
					log.debug(e);
				}
				
				log.debug((group.get(3)).toString());
	    		JSONArray settings = new JSONArray((group.get(3)).toString());
	    		for (int j = 0; j < settings.length(); j++) {
	    			log.debug(settings.get(j).toString());
	    			JSONArray setting = new JSONArray(settings.get(j).toString());

	    			//for (int k = 0; k < setting.length(); k++) {
    				MercostsheetgroupsettingId mercostsheetgroupsettingId = 
    	    				new MercostsheetgroupsettingId(groupSettingId, groupId, costSheetNo, ConvertUtil.getDecimal(versionNo.toString()), costSheetType);
    	    		Mercostsheetgroupsetting mercostsheetgroupsetting = new Mercostsheetgroupsetting(mercostsheetgroupsettingId, mercostsheetgroup, setting.getString(1), setting.getInt(0));
    	    		mercostsheetgroupsettingManager.save(mercostsheetgroupsetting);

    	    		JSONArray colors = new JSONArray(setting.get(2).toString());
    	    		for (int a = 0; a < colors.length(); a++) {
    	    			MercostsheetgroupcolorId mercostsheetgroupcolorId = new MercostsheetgroupcolorId
    	    					(groupSettingId, groupId, costSheetNo, versionNo, costSheetType, colors.getString(a));
    	        		Mercostsheetgroupcolor mercostsheetgroupcolor = new Mercostsheetgroupcolor(mercostsheetgroupcolorId, mercostsheetgroupsetting);
    	        		mercostsheetgroupcolorManager.save(mercostsheetgroupcolor);
    				}
    	    		
    	    		JSONArray dems = new JSONArray(setting.get(3).toString());
    	    		for (int a = 0; a < dems.length(); a++) {
    	    			String[] demmap = dems.getString(a).split(":");
    	    			log.debug(demmap);
    	    			log.debug(dems.getString(a));
		        		MercostsheetgroupdemmapId mercostsheetgroupdemmapId = 
		        				new MercostsheetgroupdemmapId(groupSettingId, groupId, costSheetNo, versionNo, costSheetType,
		        						demtypeHori, demmap[4], demtypeVerti, demmap[3]);
		        		
		        		Mercostsheetgroupdemmap mercostsheetgroupdemmap = new Mercostsheetgroupdemmap(mercostsheetgroupdemmapId, mercostsheetgroupsetting, demmap[2], true, false);
		        		//(mercostsheetgroupdemmapId, mercostsheetgroupsetting, true, false);
		        		mercostsheetgroupdemmapManager.save(mercostsheetgroupdemmap);
					}
    	    		groupSettingId += 1L;
				}
	    		groupId += 1L;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			log.debug(e);
			e.printStackTrace();
		}
		return mercostsheethdr;
	}

	private Boolean removeCurrencies(HttpServletRequest request){ 
    	// get id parameters 
		/*
		 * id.costsheetType	OGL
			id.preCostSheetNo	30
			id.versionNo
		 */
        String costSheetNo = request.getParameter("id.costSheetNo") ;
        String costsheetType = request.getParameter("id.costSheetType") ;
        
    	Mercostsheethdr  mercostsheethdr=new Mercostsheethdr();
    	MercostsheethdrId  merprecostsheetId=new MercostsheethdrId(costSheetNo, ConvertUtil.getDecimal("0"), costsheetType);
		// get working cost sheet 
		mercostsheethdr = mercostsheethdrManager.get(merprecostsheetId);
		// get costsheet currency list		
	    List<Mercostsheetcurrency> mercostsheetcurrencies = mercostsheetcurrencyManager.getAll(mercostsheethdr);
	    log.debug(" *"+ mercostsheetcurrencies.size());
	    log.debug(" *"+ mercostsheetcurrencies);
	    for(int i=0;i<mercostsheetcurrencies.size();i++){
			Mercostsheetcurrency mercostsheetcurrencie= mercostsheetcurrencies.get(i);
			try{
				log.debug(mercostsheetcurrencie.getId().getCurrencyCode());
				mercostsheetcurrencyManager.remove(mercostsheetcurrencie);
			}
	   		catch(Exception e){
	   			log.debug(e.getMessage());
	   			return false;
	   		}
		}
	    return true;
	       
    }
    
	private Boolean removeSmv(HttpServletRequest request){ 
    	// get id parameters 
    	String costSheetNo = request.getParameter("id.costSheetNo") ;
        String costsheetType = request.getParameter("id.costSheetType") ;
        
        Mercostsheethdr  mercostsheethdr=new Mercostsheethdr();
    	MercostsheethdrId  merprecostsheetId=new MercostsheethdrId(costSheetNo, ConvertUtil.getDecimal("0"), costsheetType);
		// get working cost sheet 
    	mercostsheethdr = mercostsheethdrManager.get(merprecostsheetId);
		// get smv list
		List<Mercostsheetsmv> mercostsheetsmvs = mercostsheetsmvManager.getAll(mercostsheethdr);
		for(int i=0;i<mercostsheetsmvs.size();i++){
			Mercostsheetsmv mercostsheetsmv= mercostsheetsmvs.get(i);
			try{
				log.debug(mercostsheetsmv.getId().getStyleRouteId());
				mercostsheetsmvManager.remove(mercostsheetsmv);
			}
	   		catch(Exception e){
	   			log.debug(e.getMessage());
	   			return false;
	   		}
		}
	    return true;
    }
    
    private Mercostsheetgroup createPCSUsingFCS(Mercostsheetgroup mercostsheetgroup){

        Mstcurrency mstcurrencyByDftRmCurrency = null;
        Mststyleheader mststyleheader = null;
        Mstcurrency mstcurrencyByCostSheetCurrency = null;

        BigDecimal rowMaterialValue = null;
        BigDecimal serviceValue = null;
        BigDecimal cm = null;
        BigDecimal cmt = null;
        BigDecimal financeCost = null;
        
        //Mstuser merchandiser = new Mstuser(mercostsheetgroup.getMerchandiser());
        
        final short programID = 4006;
        final String trntype = "PCST";
        MstnumbersId pcsId = new MstnumbersId(location, programID, trntype);
        
    	/*MerprecostsheetId merprecostsheetId = new MerprecostsheetId(pcsId.toString(),
    			mercostsheetgroup.getId().getVersionNo(), mercostsheetgroup.getId().getCostSheetType());
    	/*Merprecostsheet merprecostsheet = new Merprecostsheet
    			(merprecostsheetId, mstcurrencyByDftRmCurrency, mststyleheader, mstcurrencyByCostSheetCurrency, mercostsheethdr.getSeason(),
    					mercostsheethdr.getCompWiseCost(), new BigDecimal(mercostsheethdr.getTotalCost()), "Completed",
    					mercostsheethdr.getDftRmExchangeRate(), new BigDecimal(mercostsheethdr.getCostSheetExchangeRate()), rowMaterialValue,
    					serviceValue, cm, cmt, financeCost, new BigDecimal(mercostsheethdr.getTotalCost()), mercostsheethdr.getMarkupAmount(),
    					mercostsheethdr.getBuyerCommission(), mercostsheethdr.getOurPrice(), mercostsheethdr.getExternalCommission(),
    					new BigDecimal(mercostsheethdr.getSellingPrice()), merchandiser, mercostsheethdr.getBaseBody(),
    					mercostsheethdr.getBuyerReference(), mercostsheethdr.getDestinationCountry(),mercostsheethdr.getShipmentMode(),
    					mercostsheethdr.getDeliveryTerm(), mercostsheethdr.getValidTill(), mercostsheethdr.getRemarks()+" ~System Generated Pre-Cost Sheet",
    					mercostsheethdr.getOrderQty());
    	merprecostsheetManager.save(merprecostsheet);*/
    	
    	//mercostsheethdr.setMerprecostsheethdr(merprecostsheet);
		return mercostsheetgroup;
    }
    
    private Mercostsheetgroup updatePCSusingFCS(Mercostsheetgroup mercostsheetgroup){
    	/* get pre cost sheet using final cost sheet
    	 * update costing feilds using final cost sheet
    	*/
    	/**Merprecostsheet merprecostsheet = new Merprecostsheet();
    	if(mercostsheetgroup.getMerprecostsheethdr() == null){
    		//get pre cost sheet from DB    		
    	}
    	else{
    		merprecostsheet = mercostsheetgroup.getMerprecostsheethdr();
    	}*/

    	return mercostsheetgroup;
    }
    
    
	private String getGroups(HttpServletRequest request) throws Exception {
		String costSheetNo = request.getParameter("costSheetNo");
        String costSheetType = request.getParameter("costSheetType");
        String versionNo = request.getParameter("versionNo");
        Mercostsheethdr mercostsheethdr = new Mercostsheethdr();
        
        String groups = new String();
        if (!StringUtils.isBlank(costSheetNo) && !StringUtils.isBlank(versionNo) && !StringUtils.isBlank(costSheetType)) {
        	try {
        		BigDecimal bversionNo=ConvertUtil.getDecimal(versionNo);
        		//get cost sheet using params
        		mercostsheethdr = mercostsheethdrManager.get(new MercostsheethdrId(costSheetNo, bversionNo, costSheetType));
        		log.debug(mercostsheethdr.toString());
        		if(mercostsheethdr.getId().getCostSheetNo().equalsIgnoreCase(costSheetNo)){
        			//get cost sheet groups using cost sheet
        			List<Mercostsheetgroup> mercostsheetgroups = mercostsheetgroupManager.getAll(costSheetNo, versionNo, costSheetType);
        			int groupId = mercostsheetgroups.size();
        			for (Iterator iterator = mercostsheetgroups.iterator(); iterator.hasNext();) {
						Mercostsheetgroup mercostsheetgroup = (Mercostsheetgroup) iterator.next();

						//get cost sheet group settings using cost sheet groups
						List<Mercostsheetgroupsetting> mercostsheetgroupsettings = mercostsheetgroupsettingManager.getAll(mercostsheetgroup);
						
						int SettingId = mercostsheetgroupsettings.size();
						String groupSetting = "";
						for (Iterator iterator2 = mercostsheetgroupsettings.iterator(); iterator2.hasNext();) {
							Mercostsheetgroupsetting mercostsheetgroupsetting = (Mercostsheetgroupsetting) iterator2.next();
							
							List<Mercostsheetgroupdemmap> mercostsheetgroupdemmaps = mercostsheetgroupdemmapManager.getAll(mercostsheetgroupsetting);
							String demmaps = "";
							//get cost sheet group demmaps using cost sheet group settings
							int i = mercostsheetgroupdemmaps.size();
							for (Iterator iterator3 = mercostsheetgroupdemmaps.iterator(); iterator3.hasNext();) {
								Mercostsheetgroupdemmap mercostsheetgroupdemmap = (Mercostsheetgroupdemmap) iterator3.next();

								demmaps += mercostsheetgroup.getCountry()+":"+mercostsheetgroupsetting.getComponent()+":"+mercostsheetgroupdemmap.getColor()+":"+
										mercostsheetgroupdemmap.getId().getVerticalDem()+":"+mercostsheetgroupdemmap.getId().getHorizontalDem();
								i--;
								if(i != 0){
									demmaps += ",";
								}
							}
							//get cost sheet group colors using cost sheet group settings
							List<Mercostsheetgroupcolor> mercostsheetgroupcolors = mercostsheetgroupcolorManager.getAll(mercostsheetgroupsetting);
							String colors = "";
							i = mercostsheetgroupcolors.size();
							for (Iterator iterator3 = mercostsheetgroupcolors.iterator(); iterator3.hasNext();) {
								Mercostsheetgroupcolor mercostsheetgroupcolor = (Mercostsheetgroupcolor) iterator3.next();
								colors += ""+mercostsheetgroupcolor.getId().getColor()+"";
								i--;
								if(i != 0){
									colors += ",";
								}
							}
							
							groupSetting += mercostsheetgroupsetting.getLineNo()+","+mercostsheetgroupsetting.getComponent()+"_"+
									colors+"_"+demmaps;
							SettingId--;
							if(SettingId != 0){
								groupSetting += "*";
							}
						}
						log.debug(groupSetting);
												
						if(groupId != 0){
							groups += mercostsheetgroup.getId().getGroupId()+","+mercostsheetgroup.getGroupName()+","+mercostsheetgroup.getCountry()
									+","+mercostsheetgroup.getMerprecostsheethdr().getId().getPreCostSheetNo()+"+"+groupSetting;
						}
						groupId--;
						if(groupId != 0){
							groups += "-";
						}
						log.debug(groups);
					}
        		}
        	}catch(Exception e){
        		log.debug(e);
        		log.debug(e.getMessage());
        	}
        }
        return groups;
	}
	
}


