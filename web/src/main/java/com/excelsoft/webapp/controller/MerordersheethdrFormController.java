package com.excelsoft.webapp.controller;

import org.apache.commons.lang.StringUtils;

import com.excelsoft.service.MerordersheethdrManager;
import com.excelsoft.service.MerordersheetrawmaterialManager;
import com.excelsoft.service.MstgencodesManager;
import com.excelsoft.service.MstnumbersManager;
import com.excelsoft.service.MstparameterManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Merordersheethdr;
import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.model.Merordersheetrawmaterial;
import com.excelsoft.model.MerordersheetrawmaterialId;
import com.excelsoft.model.Mstitemtype;
import com.excelsoft.model.Mstparameter;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
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
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/merordersheethdrform*")
public class MerordersheethdrFormController extends BaseFormController {
    private MerordersheethdrManager merordersheethdrManager = null;
    private MerordersheetrawmaterialManager merordersheetrawmaterialManager=null;
    private MststyleheaderManager mststyleheaderManager;
    
    private MstgencodesManager mstgencodesManager=null;
    private MstnumbersManager mstnumbersManager=null;
    private MstparameterManager mstparametermanager =null;
    
    
    private String location="";
    final short programID=4008;
    final String trntype="ODPS";
    final String trnGroupType="ODPS";
    private String flag ="Incomplete";
    
    @Autowired
    public void setMerordersheetrawmaterialManager(
			MerordersheetrawmaterialManager merordersheetrawmaterialManager) {
		this.merordersheetrawmaterialManager = merordersheetrawmaterialManager;
	}
	@Autowired
    public void setMstparametermanager(MstparameterManager mstparametermanager) {
		this.mstparametermanager = mstparametermanager;
	}
    @Autowired
    public void setMstnumbersManager(
			MstnumbersManager mstnumbersManager) {
		this.mstnumbersManager = mstnumbersManager;
	}
    @Autowired
    public void setMerordersheethdrManager(MerordersheethdrManager merordersheethdrManager) {
        this.merordersheethdrManager = merordersheethdrManager;
    }
    @Autowired
    public void setMstgencodesManager(MstgencodesManager mstgencodesManager) {
		this.mstgencodesManager = mstgencodesManager;
	}
    @Autowired
   	public void setMststyleheaderManager(MststyleheaderManager mststyleheaderManager) {
   		this.mststyleheaderManager = mststyleheaderManager;
   	}
    public MerordersheethdrFormController() {
        setCancelView("redirect:merordersheethdrs");
        setSuccessView("redirect:merordersheethdrs");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Model showForm(HttpServletRequest request)
    throws Exception {
    	System.out.println("adsda");
    	Model model = new ExtendedModelMap();
       String planingOrdersheetNo = request.getParameter("planingOrdersheetNo");
       String orderType = request.getParameter("orderType");
       MerordersheethdrId id=new MerordersheethdrId(planingOrdersheetNo, orderType);
       log.debug(id);
       Mststyleheader  mststyleheader=new Mststyleheader();
       Merordersheethdr merordersheethdr=new Merordersheethdr();
       Merordersheetrawmaterial merordersheetrawmaterial=new Merordersheetrawmaterial();
       model.addAttribute(merordersheetrawmaterial);
       try {
	        model.addAttribute("mstitemtypeCatogory",mstgencodesManager.getcode("ITMCAT"));
	        log.debug("mst-item type Catogory : "+ model); 
       }
   		catch (SearchException se) {
	        model.addAttribute("Item Catogory  Error", se.getMessage());
	        log.debug(se.getMessage());  
	    }  
       	if (!StringUtils.isBlank(orderType) && !StringUtils.isBlank(planingOrdersheetNo)) {
       		merordersheethdr= merordersheethdrManager.get(id);
    	   	mststyleheader=merordersheethdr.getMststyleheader();
    	   //	
    	   	
    	   	if(mststyleheader==null){
    	   		MststyleheaderId id2=new MststyleheaderId(null, null,null, null, merordersheethdr.getBuyer()) ;
    	   		mststyleheader=new Mststyleheader();
    	   		mststyleheader.setId(id2);
    	   	}
    	   /*	else{
    	   		merordersheethdr.setMststyleheader(mststyleheader);
    	   	}*/
    	   	model.addAttribute(mststyleheader);
    	   	model.addAttribute(merordersheethdr);
    	   	model.addAttribute("NO"," ");
        }
        else{
        	String locationCode = request.getParameter("locationCode") ;
			String custCode = request.getParameter("custCode") ;
			String styleId = request.getParameter("styleId") ;
			String depCode = request.getParameter("depCode") ;
			String compCode = request.getParameter("compCode") ;
			if(!(StringUtils.isBlank(styleId) || StringUtils.isBlank(depCode)|| StringUtils.isBlank(custCode)|| StringUtils.isBlank(compCode)|| StringUtils.isBlank(locationCode))){	        
				mststyleheader= mststyleheaderManager.getStyle(compCode, locationCode, custCode, depCode, styleId);  		
				if(mststyleheader==null){
					mststyleheader=new Mststyleheader();
				}
				model.addAttribute(mststyleheader);
				model.addAttribute("NO"," ");
        	}
			else{
				if(!StringUtils.isBlank(custCode)){
					model.addAttribute("NO"," ");
				}
				else{
					model.addAttribute("NO","NO");
				}
				
				model.addAttribute(mststyleheader);
			}
        	
        	model.addAttribute(merordersheethdr);
        }
        
       	log.debug(model);  
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Merordersheethdr merordersheethdr, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
    	
    	try{
    		Mstparameter mstparameter=mstparametermanager.getAll().get(0);
    		location=mstparameter.getLocationCode();
		}catch(Exception e){
			log.debug(e.getMessage());
		}
    	
    	
    	merordersheethdr=getBinding(request,response,merordersheethdr);
    	
    	
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
        
        if (validator != null) { // validator is null during testing
            validator.validate(merordersheethdr, errors);
            log.debug(errors);
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "redirect:merordersheethdrs";
            }
        }
        String locationCode = request.getParameter("locationCode") ;
		String custCode = request.getParameter("custCode") ;
		//String styleId = request.getParameter("styleId") ;
		String depCode = request.getParameter("depCode") ;
		String compCode = request.getParameter("compCode") ;
		
        merordersheethdr.setBuyer(custCode);
        merordersheethdr.setCompany(compCode);
        merordersheethdr.setDepartment(depCode);
        merordersheethdr.setLocation(locationCode);
        
        Mststyleheader mststyleheader =new Mststyleheader();
        mststyleheader = getstyle(request);
        if(mststyleheader!=null)
        merordersheethdr.setMststyleheader(mststyleheader);
        log.debug("entering 'onSubmit' method...");
        String success = getSuccessView();
        Locale locale = request.getLocale();
        try{
	        boolean isNew = (merordersheethdr.getId() == null);
	        
	
	        if (request.getParameter("delete") != null) {
	        	if(deleteRawmaterial(merordersheethdr,request)){
	            merordersheethdrManager.remove(merordersheethdr.getId());
	            saveMessage(request, getText("merordersheethdr.deleted", locale));
	            	return success;
	        	}
	        	else{
	        		Cookie cookie=new Cookie("error", "Child key dependancy error");
		        	response.addCookie(cookie);
	        	}
	        } else {
	        	if(request.getParameter("section") != null){
	        		log.debug(request.getParameter("section"));      	
		        	if(request.getParameter("section").equals("section01")){
		        		log.debug(merordersheethdr); 
		        		merordersheethdrManager.save(merordersheethdr);
		        	}
		        	else if (request.getParameter("section").equals("section02")){
		        		 saveRawmaterials(request,response,merordersheethdr);
		        	}
		        	else{
		        		log.debug("NO section");
		        	}
	        	
	        	}	 
	            String key = (isNew) ? "merordersheethdr.added" : "merordersheethdr.updated";
	            saveMessage(request, getText(key, locale));
	
	            if (!isNew) {
	                success = "redirect:merordersheethdrform?planingOrdersheetNo=" + merordersheethdr.getId().getPlaningOrdersheetNo() +"&orderType="+merordersheethdr.getId().getOrderType();
	            }
	        }
		}
		catch(Exception e){
			log.debug(e.getMessage());
		}
        return success;
    }
    
    
    private boolean deleteRawmaterial(Merordersheethdr merordersheethdr,
			HttpServletRequest request) {
    	List<Merordersheetrawmaterial> merordersheetrawmaterials =merordersheetrawmaterialManager.getAll(merordersheethdr.getId());
    	log.debug("merordersheetrawmaterials.size() "+merordersheetrawmaterials.size());
    	for(int i=0;i<merordersheetrawmaterials.size();i++){
    		try{
				merordersheetrawmaterialManager.remove(merordersheetrawmaterials.get(i));
			}catch(Exception e){
				log.debug(e.getMessage());
				
				return false;
			}
    	}
    	return true;
	}
	/**
     * 
     * @param request
     * @param response
     * @param Merordersheethdr
     * @return Merordersheethdr
     */
    private Merordersheethdr getBinding(HttpServletRequest request,
    		HttpServletResponse response ,Merordersheethdr merordersheethdr) {
    	String planingOrdersheetNo="0";
    	MerordersheethdrId id= merordersheethdr.getId();
    	if(id.getPlaningOrdersheetNo().equals("****")){
    		planingOrdersheetNo = mstnumbersManager.getnexttrnNo(location, programID, trntype).toString();
    		id.setPlaningOrdersheetNo(planingOrdersheetNo);
    		merordersheethdr.setId(id);
    		merordersheethdr.setCreatedAt(location);
    		merordersheethdr.setCreatedBy(request.getRemoteUser());
    		merordersheethdr.setCreatedOn(new Date());
    		Cookie cookie=new Cookie("planingOrdersheetNo", planingOrdersheetNo);
        	response.addCookie(cookie);
    	}
    	else{
    		merordersheethdr.setModifiedAt(location);
    		merordersheethdr.setModifiedBy(request.getRemoteUser());
    		merordersheethdr.setModifiedOn(new Date());
    		Merordersheethdr merordersheethdr2=merordersheethdrManager.get(merordersheethdr.getId());
    		merordersheethdr.setCreatedAt(merordersheethdr2.getCreatedAt());
    		merordersheethdr.setCreatedBy(merordersheethdr2.getCreatedBy());
    		merordersheethdr.setCreatedOn(merordersheethdr2.getCreatedOn());
    	}
		return merordersheethdr;
	}
    
	private void saveRawmaterials(HttpServletRequest request,HttpServletResponse response,
			Merordersheethdr merordersheethdr) {
		log.debug("****************");
		if(request.getParameter("deleteRowMat") !=null){
			BigDecimal rowMaterialNo=ConvertUtil.getDecimal(request.getParameter("id.rowMaterialNo"));
			MerordersheethdrId merordersheethdrId =merordersheethdr.getId();
			log.debug(merordersheethdrId);
			String planingOrdersheetNo =merordersheethdrId.getPlaningOrdersheetNo();
			String orderType=merordersheethdrId.getOrderType();
			log.debug(planingOrdersheetNo+" - "+rowMaterialNo+" - "+orderType);
			MerordersheetrawmaterialId id=new MerordersheetrawmaterialId(planingOrdersheetNo, rowMaterialNo, orderType);
			
			try{
				merordersheetrawmaterialManager.remove(id);
				Cookie cookie=new Cookie("removed","removed");
	        	response.addCookie(cookie);
			}catch(Exception e){
				log.debug(e.getMessage());
				Cookie cookie=new Cookie("error", e.getMessage());
	        	response.addCookie(cookie);
				
			}
			
		}
		else{
			MerordersheethdrId merordersheethdrId =merordersheethdr.getId();
			log.debug(merordersheethdrId);
			String planingOrdersheetNo =merordersheethdrId.getPlaningOrdersheetNo();
			BigDecimal rowMaterialNo=new BigDecimal("0");
			if(request.getParameter("id.rowMaterialNo").equals("0"))
				rowMaterialNo=merordersheetrawmaterialManager.getNext(merordersheethdrId).add(ConvertUtil.getDecimal("1"));
			else
				rowMaterialNo=ConvertUtil.getDecimal(request.getParameter("id.rowMaterialNo"));
			
			String orderType=merordersheethdrId.getOrderType();
			log.debug(planingOrdersheetNo+" - "+rowMaterialNo+" - "+orderType);
			MerordersheetrawmaterialId id=new MerordersheetrawmaterialId(planingOrdersheetNo, rowMaterialNo, orderType);
			Merordersheetrawmaterial merordersheetrawmaterial=new Merordersheetrawmaterial();
			merordersheetrawmaterial.setId(id);
			log.debug(id);
			//merordersheetrawmaterial.setAllowance(ConvertUtil.getDecimal(request.getParameter("allowance")));
			//merordersheetrawmaterial.setConsumption(ConvertUtil.getDecimal(request.getParameter("consumption")));
			//merordersheetrawmaterial.setUom(request.getParameter("UMO"));
			//Mstcurrency mstcurrency=mstcurrencyManager.get("request.getParameter('currency')");
			//merordersheetrawmaterial.setMstcurrency(mstcurrency);
			//merordersheetrawmaterial.setExchangeRate(ConvertUtil.getDecimal(request.getParameter("exchangeRate")));
			//merordersheetrawmaterial.setPrice(ConvertUtil.getDecimal(request.getParameter("price")));
			//merordersheetrawmaterial.setFinance(ConvertUtil.getDecimal(request.getParameter("finance")));
			//merordersheetrawmaterial.setItemCatogery(request.getParameter("itemcategory"));
			//MercostsheetgroupId id2=new MercostsheetgroupId(groupId, costSheetNo, versionNo, costSheetType)
			//merordersheetrawmaterial.setShipingType(request.getParameter("shipingType"));
			//MstsupplierId id2=new MstsupplierId(location, request.getParameter("supplierCode"));
			//Mstsupplier mstsupplier=mstsupplierManager.get(id2);
			//merordersheetrawmaterial.setMstsupplier(mstsupplier);
			merordersheetrawmaterial.setItemCode(request.getParameter("itemCode"));
			
			merordersheetrawmaterial.setItemColor(request.getParameter("itemColor"));
	    	merordersheetrawmaterial.setItemDescription(request.getParameter("itemDescription"));
	    	merordersheetrawmaterial.setItemWidth(request.getParameter("itemWidth"));
	    	Boolean isRelease=true;
	    	if(request.getParameter("isRelease")!=null){
	    		isRelease= true;
	    	}
	    	else{
	    		isRelease= false;
	    	}
	    	log.debug("isRel - "+isRelease +"   - " +request.getParameter("isRelease"));
	    	merordersheetrawmaterial.setIsRelease(isRelease);
	    	merordersheetrawmaterial.setAdditionalAttribute1(request.getParameter("additionalAttribute1"));
	    	merordersheetrawmaterial.setAdditionalAttribute2(request.getParameter("additionalAttribute2"));
			Mstitemtype mstitemtype=new Mstitemtype(request.getParameter("itemType"));
			
			merordersheetrawmaterial.setMstitemtype(mstitemtype);
			try{
				merordersheetrawmaterialManager.save(merordersheetrawmaterial);
				Cookie cookie=new Cookie("removed","removed");
	        	response.addCookie(cookie);
			}catch(Exception e){
				log.debug(e.getMessage());
				Cookie cookie=new Cookie("error", e.getMessage());
	        	response.addCookie(cookie);
			}
		}
		
		
		
	}
	private Mststyleheader getstyle(HttpServletRequest request){
    	String locationCode = request.getParameter("locationCode") ;
        String custCode = request.getParameter("custCode") ;
        String styleId = request.getParameter("styleId") ;
        String depCode = request.getParameter("depCode") ;
        String compCode = request.getParameter("compCode") ;
        
        log.debug(compCode+ " - "+custCode+ " - "+depCode +" - "+locationCode +" - "+styleId);
        Mststyleheader mststyleheader=null;
        MststyleheaderId id=new MststyleheaderId(styleId, locationCode, depCode, compCode, custCode);
        if(!StringUtils.isBlank(locationCode) && !StringUtils.isBlank(styleId) && !StringUtils.isBlank(depCode) && !StringUtils.isBlank(compCode) && !StringUtils.isBlank(custCode)){
        	log.debug("**");
        	try{
        	mststyleheader = mststyleheaderManager.get(id);
        	}
        	catch(Exception e){
        		log.debug(e.getMessage());
        		mststyleheader=null;
        	}
        }
        log.debug("**");
        return  mststyleheader;
     
    }
}



