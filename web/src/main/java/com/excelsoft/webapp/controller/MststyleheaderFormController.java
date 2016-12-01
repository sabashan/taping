package com.excelsoft.webapp.controller;

import org.apache.commons.lang.StringUtils;

import com.excelsoft.service.MstparameterManager;
import com.excelsoft.service.MstpictureManager;
import com.excelsoft.service.MststylechildColorManager;
import com.excelsoft.service.MststylecomponentManager;
import com.excelsoft.service.MststyledemManager;
import com.excelsoft.service.MststyledemmapManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.service.MststylemainColorManager;
import com.excelsoft.service.MststylepictureManager;
import com.excelsoft.model.MststylechildColor;
import com.excelsoft.model.MststylechildColorId;
import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.MststylecomponentId;
import com.excelsoft.model.Mststyledem;
import com.excelsoft.model.MststyledemId;
import com.excelsoft.model.Mststyledemmap;
import com.excelsoft.model.MststyledemmapId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.MststylemainColor;
import com.excelsoft.model.MststylemainColorId;
import com.excelsoft.model.Mststylepicture;
import com.excelsoft.model.MststylepictureId;
import com.excelsoft.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;
import java.util.List;

@Controller
@RequestMapping("/mststyleheaderform*")
public class MststyleheaderFormController extends BaseFormController {
	private MststyleheaderManager mststyleheaderManager = null;
	private MststyledemManager mststyledemManager = null;
	private MststyledemmapManager mststyledemmapManager = null;
	private MststylecomponentManager mststylecomponentManager = null;
	private MststylechildColorManager mststylechildColorManager = null;
	private MststylemainColorManager mststylemainColorManager = null;
	private MststylepictureManager mststylepictureManager = null;
	private MstpictureManager mstpictureManager=null;
	private MstparameterManager mstparametermanager =null;
	private String location="";
	
	
	@Autowired
	public void setMstparameterManager(
			MstparameterManager mstparametermanager) {
		this.mstparametermanager = mstparametermanager;
	}
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

	public MststyleheaderFormController() {
		setCancelView("redirect:mststyleheaders");
		setSuccessView("redirect:mststyleheaders");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Model showForm(HttpServletRequest request) throws Exception {
		//Orient Garments PLC
		try{
			location=mstparametermanager.getAll().get(0).getLocationCode();
		}catch(Exception e){
			log.debug(e.getMessage());
		}
		Mststyleheader mststyleheader = new Mststyleheader();
		Model model = new ExtendedModelMap();

		/**
		 * Add params
		 */
		String styleId = request.getParameter("styleId");
		String locationCode = request.getParameter("locationCode");
		String compCode = request.getParameter("compCode");
		String custCode = request.getParameter("custCode");
		String depCode = request.getParameter("depCode");
		String OpenAS=request.getParameter("OpenAS");
		
		if (!(StringUtils.isBlank(styleId) || StringUtils.isBlank(locationCode)
				|| StringUtils.isBlank(depCode)
				|| StringUtils.isBlank(compCode) || StringUtils
					.isBlank(custCode))) {
			log.debug(" using param only ");

			MststyleheaderId id = new MststyleheaderId(styleId, locationCode,
					depCode, compCode, custCode);
			mststyleheader = mststyleheaderManager.get(id);
			if (!StringUtils.isBlank(OpenAS)){
				Mststyleheader mststyleheader2=new Mststyleheader();
				MststyleheaderId i=new MststyleheaderId();
				mststyleheader2.setId(i);
				
				mststyleheader2.setComments(mststyleheader.getComments());
				mststyleheader2.setCostSheetMethod(mststyleheader.getCostSheetMethod());
				mststyleheader2.setDesignReference(mststyleheader.getDesignReference());
				mststyleheader2.setFlag(mststyleheader.getFlag());
				mststyleheader2.setPackingMethod(mststyleheader.getPackingMethod());
				mststyleheader2.setProductRange(mststyleheader.getProductRange());
				mststyleheader2.setStyleDescription(mststyleheader.getStyleDescription());
				mststyleheader2.setSvmType(mststyleheader.getSvmType());
				mststyleheader2.setUserId(mststyleheader.getUserId());
				
				model.addAttribute(mststyleheader2);
				log.debug(model);
			}	
			else{
				log.debug("Edit");
				model.addAttribute(mststyleheader);
			}
			log.debug(model);
			
		}
		else {
			log.debug("NO parm ");
			mststyleheader = new Mststyleheader();
			model.addAttribute(mststyleheader);
			mststyleheader=null;
		}
		List<Mststylepicture> mststylepicture=mststylepictureManager.getAll(mststyleheader);	
		try {
        	for(int i=0;i<mststylepicture.size();i++){
        		//String b64 =javax.xml.bind.DatatypeConverter.printBase64Binary(mstpictureManager.get(mststylepicture.get(i).getId().getPicCode()).getPicture());		
        		String b64 =javax.xml.bind.DatatypeConverter.printBase64Binary(mstpictureManager.get(mststylepicture.get(i).getId().getPicCode()).getPicture());
				mststylepicture.get(i).setMstPicpictures(b64);
			}
		} 
		catch (Exception e) {
			log.debug(e.getMessage());
			model.addAttribute("Error", e.getMessage());
		}	
		
		try {
			if(mststyleheader!=null){
				model.addAttribute("mststylecomponentList", mststylecomponentManager.getAll(mststyleheader));
				model.addAttribute("mststylemaincolorList", mststylemainColorManager.getAll(mststyleheader));
				model.addAttribute("mststylechildcolorList", mststylechildColorManager.getAll(mststyleheader));
				model.addAttribute("mststyledemList", mststyledemManager.getAll(mststyleheader));
				model.addAttribute("mststyledemmapList", mststyledemmapManager.getAll(mststyleheader));
				model.addAttribute("mststylepictureList", mststylepicture);
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
			model.addAttribute("Error", e.getMessage());
		}
		try{
			log.debug(mststylepicture.toString());
			
			}
		 catch (Exception e) {
				log.debug(e.getMessage());
				model.addAttribute("Error", e.getMessage());
			}
		//log.debug();
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Mststyleheader mststyleheader, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			location=mstparametermanager.getAll().get(0).getLocationCode();
		}
		catch(Exception e){
			log.debug(e.getMessage());
		}
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}
		
		String StyleStatus = "Incomplete";
		mststyleheader.setFlag(StyleStatus);
		
		log.debug("In action onSubmit.....");
		if (validator != null) { 
			// validator is null during testing
			validator.validate(mststyleheader, errors);

			System.out.println("In validator......");
			if (errors.hasErrors() && request.getParameter("delete") == null) { 
				// don't validate when deleting
				log.debug("In validator with erros : "+ errors.toString());
				return "mststyleheaderform";
			}
		}

		
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
		
		
		log.debug("check perpos ");
		
		/** delete conform or pending_save */
		
		
		if (request.getParameter("delete")!=null) {
			if(request.getParameter("deletePic")!=null){
				String picCode=request.getParameter("picCode");
				MststylepictureId  mststylepictureId=new MststylepictureId(picCode, styleId, locationCode, compCode, custCode, depCode) ;
				mststylepictureManager.remove(mststylepictureId);
				mstpictureManager.remove(picCode);
			}
			else{
				if(!(StringUtils.isBlank(styleId) && StringUtils.isBlank(locationCode) &&  StringUtils.isBlank(depCode) &&  StringUtils.isBlank(compCode) && StringUtils.isBlank(custCode))){
					log.debug("entering  remove for get ids");
					MststyleheaderId  mststyleheaderId=new  MststyleheaderId(styleId, locationCode, depCode, compCode, custCode);
					mststyleheader=mststyleheaderManager.get(mststyleheaderId);
				}
				log.debug("entering  remove...");
				
				Removestyles(mststyleheader);
				mststyleheaderManager.remove(mststyleheader);
				saveMessage(request, getText("mststyleheader deleted", mststyleheader.getId().getStyleId(), locale));
			}
	         
		}
		
		else{
			log.debug(mststyleheader.getUserId());
			Date date=new Date();
			MststyleheaderId sid=mststyleheader.getId();
			try{
				Mststyleheader mststyleheader2 =mststyleheaderManager.get(sid);
				if(StringUtils.equals(mststyleheader.getId().getStyleId(), mststyleheader2.getId().getStyleId())){
					
					mststyleheader.setModifiedAt(location);
					mststyleheader.setModifiedBy(request.getRemoteUser());
					mststyleheader.setModifiedOn(date);	
					mststyleheader.setCreatedAt(mststyleheader2.getCreatedAt());
					mststyleheader.setCreatedBy(mststyleheader2.getCreatedBy());
					mststyleheader.setCreatedOn(mststyleheader2.getCreatedOn());
				}
				else{
					mststyleheader.setCreatedAt(location);
					mststyleheader.setCreatedBy(request.getRemoteUser());
					mststyleheader.setCreatedOn(date);		
				}
			}catch(Exception e){
					mststyleheader.setCreatedAt(location);
					mststyleheader.setCreatedBy(request.getRemoteUser());
					mststyleheader.setCreatedOn(date);		
			}
			
			log.debug("entering 'onSubmit' save...");
			try {
				mststyleheaderManager.save(mststyleheader);
				saveMessage(request, getText("mststyleheader added", mststyleheader.getId().getStyleId(), locale));
			} 
			catch (Exception e) {
				log.debug(" error in style :" + e.getMessage());
			}
			
			
			
			/**
			 * Create component, image, color, grid template and grid if any
			 * exception is raised, style status goes to Incomplete otherwise style
			 * status is complete. Each set hold objects data String StyleStatus
			 * hold Incomplete/complete status
			 */
			
			
			// Create image array
			String[] mstimg = splitArray(request.getParameter("dataImg"));
			if(mstimg[0]!=""){
				for (int i = 0; i < mstimg.length; i++) {
					String[] selected = mstimg[i].split(":");
					try{
						MststylepictureId mststylepictureId = new MststylepictureId(selected[0], styleId, locationCode, compCode, custCode, depCode);
						Mststylepicture mststylepicture = new Mststylepicture(mststylepictureId);
						mststylepicture.setMststyleheader(mststyleheader);
						mststylepicture.setSequenceNo(i);
						mststylepictureManager.save(mststylepicture);
					}
					catch(Exception e){
						log.debug(" error of Component " + e.getMessage());
						StyleStatus = "Incomplete";
					}
				}
			}
			
			if(request.getParameter("section").toString().equalsIgnoreCase("Section02")){
				// Create component array using request
				mststyleheader.setUserId(request.getRemoteUser());//getParameter("userId"));
				log.debug("Section02 ** ");
				String[] components = splitArray(request.getParameter("dataComponent"));
				List <Mststylecomponent> mststylecomponent =mststylecomponentManager.getAll(mststyleheader);
				for(int i=0;i<mststylecomponent.size();i++){
					try{
						mststylecomponentManager.remove(mststylecomponent.get(i));
					} catch (Exception e) {
						log.debug(" error of Component " + e.getMessage());
						StyleStatus = "Incomplete";
					}
				}
				for (int i = 0; i < components.length; i++) {
					String[] selected = components[i].split(":");
					//log.debug(components);
					try {
						MststylecomponentId mststylecomponentId = new MststylecomponentId(
								selected[0], styleId, locationCode, depCode, compCode,
								custCode);
						//System.out.println(mststylecomponentId.toString());
						Mststylecomponent mststylecomponents = new Mststylecomponent(
								mststylecomponentId, mststyleheader, selected[1],
								BigDecimal.valueOf(Double.parseDouble(selected[2])));
						mststylecomponentManager.save(mststylecomponents);
					} catch (Exception e) {
						log.debug(" error of Component " + e.getMessage());
						StyleStatus = "Incomplete";
					}
				}
		
				// Create color array using request
				
				String[] mainColors = splitArray(request.getParameter("colors"));
				String[] childColors = splitArray(request.getParameter("dataCcolor"));
				if(StringUtils.isBlank(request.getParameter("colors"))){
					log.debug(mainColors);
					mainColors =new String[0];
				}
				else{
					log.debug(mainColors);
				}
				if(StringUtils.isBlank(request.getParameter("dataCcolor"))){
					childColors=new String[0];
				}
				else{
					log.debug(childColors);
				}
				log.debug(childColors.length +" + "+ mainColors.length);
				List<MststylechildColor> mststylechildColors=    mststylechildColorManager.getAll(mststyleheader);
				for(int i=0;i<mststylechildColors.size();i++){
					try {
						mststylechildColorManager.remove(mststylechildColors.get(i));
					} catch (Exception e) {
						log.debug(" error of child Color " + e.getMessage());
						StyleStatus = "Incomplete";
					}
				}
				List<MststylemainColor> mststylemainColors=   mststylemainColorManager.getAll(mststyleheader);
				for(int i=0;i<mststylemainColors.size();i++){
					try {
						mststylemainColorManager.remove(mststylemainColors.get(i));
					} catch (Exception e) {
						log.debug(" error of Main Color " + e.getMessage());
						StyleStatus = "Incomplete";
					}
				}
				
				for (int i = 0; i < mainColors.length; i++) {
					MststylemainColorId id = new MststylemainColorId(mainColors[i],
							styleId, locationCode, compCode, custCode, depCode);
					Long pqtmain=1L;
					MststylemainColor mststylemainColor = new MststylemainColor(id,mststyleheader, pqtmain);
					try {
						mststylemainColorManager.save(mststylemainColor);
		
						for (int j = 0; j < childColors.length; j++) {
							String[] selected = childColors[j].split(":");
							if (selected[0].equalsIgnoreCase(mainColors[i])) {
								//log.debug("C cl : " + selected[1] + "**** pqty : " + selected[2]);
								Long pqty = new Long(selected[2]);
								MststylechildColorId id2 = new MststylechildColorId(
										selected[1], mainColors[i], styleId,
										locationCode, compCode, custCode, depCode);
								MststylechildColor mststylechildColor = new MststylechildColor(id2, mststyleheader, pqty);
								
								mststylechildColorManager.save(mststylechildColor);
								pqtmain+=pqty;
							}
						}
						pqtmain--;
						if(pqtmain==0){
							pqtmain=1L;
						}
						mststylemainColor.setPackQty(pqtmain);
						mststylemainColorManager.save(mststylemainColor);
					} catch (Exception ex) {
						log.debug(" error of color " + ex.getMessage());
						StyleStatus = "Incomplete";
					}
				}
			}
			
			if(request.getParameter("section").toString().equalsIgnoreCase("Section03")){
				log.debug("Section03 ****");
				
				// generate matrix template to view the styledemmap data
				//Remove part
				String[] dimension = null;
				String[] vertical = null;
				dimension = splitArray(request.getParameter("dimensionRemove"));
				vertical = splitArray(request.getParameter("verticalRemove"));
				for (int i = 0; i < vertical.length; i++) {
					try {
						MststyledemId mststyledemId = new MststyledemId(dimension[0],
								styleId, locationCode, compCode, custCode, depCode,
								vertical[i]);
						Mststyledem mststyledem = new Mststyledem(mststyledemId,
								mststyleheader, "Vertical");
						// add vertical dimension
						// mststyledems.add(mststyledem);
						mststyledemManager.remove(mststyledem);
					} catch (Exception ex) {
						log.debug("vertical : " + ex.getMessage());
						StyleStatus = "Incomplete";
					}
				}
				//add part
				dimension = null;
				vertical = null;
				dimension = splitArray(request.getParameter("dimension"));
				vertical = splitArray(request.getParameter("vertical"));
				for (int i = 0; i < vertical.length; i++) {
					//log.debug("*****vertical " + vertical.length);
					try {
						MststyledemId mststyledemId = new MststyledemId(dimension[0],
								styleId, locationCode, compCode, custCode, depCode,
								vertical[i]);
						Mststyledem mststyledem = new Mststyledem(mststyledemId,
								mststyleheader, "Vertical");
						// add vertical dimension
						// mststyledems.add(mststyledem);
						mststyledemManager.save(mststyledem);
					} catch (Exception ex) {
						log.debug("vertical : " + ex.getMessage());
						StyleStatus = "Incomplete";
					}
				}
				
				//horizontal remove
				dimension = splitArray(request.getParameter("dimensionRemove"));
				String[] horizontal = splitArray(request.getParameter("horizontalRemove"));
				for (int i = 0; i < horizontal.length; i++) {
					try {
						MststyledemId mststyledemId = new MststyledemId(dimension[1],
								styleId, locationCode, compCode, custCode, depCode,
								horizontal[i]);
						Mststyledem mststyledem = new Mststyledem(mststyledemId,
								mststyleheader, "Horizontal");
						// save horizontal dimension
						// mststyledems.add(mststyledem);
						mststyledemManager.remove(mststyledem);
					} catch (Exception ex) {
						log.debug(" horizontal " + ex.getMessage());
						StyleStatus = "Incomplete";
					}
				}
				//add part
				dimension = splitArray(request.getParameter("dimension"));
				horizontal = splitArray(request.getParameter("horizontal"));
				for (int i = 0; i < horizontal.length; i++) {
					//log.debug("*****horizontal " + horizontal.length);
					try {
						MststyledemId mststyledemId = new MststyledemId(dimension[1],
								styleId, locationCode, compCode, custCode, depCode,
								horizontal[i]);
						Mststyledem mststyledem = new Mststyledem(mststyledemId,
								mststyleheader, "Horizontal");
						// save horizontal dimension
						// mststyledems.add(mststyledem);
						mststyledemManager.save(mststyledem);
					} catch (Exception ex) {
						log.debug(" horizontal " + ex.getMessage());
						StyleStatus = "Incomplete";
					}
				}
				
//				General:12:BB,General:14:BB,General:14:GR,AMCTYP:12:BB,AMCTYP:12:GR,BNKPAY:14:BB,BNKPAY:16:GR,EFFPAR:14:GR,EFFPAR:16:BB
				// get matrix string and split. then create dimension matrix and save it on mststyledemmap
				
				//remove part
				String[] matrix = splitArray(request.getParameter("matrixRemove"));
				log.debug(matrix.length);
				if(matrix != null){
					for (int i = 0; i < matrix.length; i++) {
						//log.debug("matrix "+matrix[i]);
						String[] selected = matrix[i].split(":");
						try {
							//log.debug(styleId+" "+ locationCode+" "+ compCode+" "+ custCode+" "+ depCode+" "+selected[1]+" "+ selected[2]+" "+ dimension[0]+" "+ dimension[1]+" "+selected[0]);
							//MststyledemmapId id = new MststyledemmapId(styleId, locationCode, compCode, custCode, depCode, demType1, demType2, demValue1, demValue2, mainColor)
							MststyledemmapId mststyledemmapId = new MststyledemmapId(
									styleId, locationCode, compCode, custCode, depCode,
									dimension[0], dimension[1], selected[1], selected[2],
									selected[0]);
							Mststyledemmap mststyledemmap = new Mststyledemmap(
									mststyledemmapId, mststyleheader);
							// add dimension map data
							mststyledemmapManager.remove(mststyledemmap);
							//log.debug("Error in style demmap removed: "+mststyledemmap.toString());
						} catch (Exception ex) {
							log.debug("Error in style demmap : "+ex.getMessage());
							StyleStatus = "Incomplete";
						}
					}
				}
				
				//add part
				matrix = splitArray(request.getParameter("matrix"));
				for (int i = 0; i < matrix.length; i++) {
					String[] selected = matrix[i].split(":");
					try {
						
						log.debug(styleId+" "+ locationCode+" "+ compCode+" "+ custCode+" "+ depCode+" "+selected[1]+" "+ selected[2]+" "+ dimension[0]+" "+ dimension[1]+" "+selected[0]);
						//MststyledemmapId id = new MststyledemmapId(styleId, locationCode, compCode, custCode, depCode, demType1, demType2, demValue1, demValue2, mainColor)
						MststyledemmapId mststyledemmapId = new MststyledemmapId(
								styleId, locationCode, compCode, custCode, depCode,
								dimension[0], dimension[1], selected[1], selected[2],
								selected[0]);
						Mststyledemmap mststyledemmap = new Mststyledemmap(
								mststyledemmapId, mststyleheader);
						// add dimension map data
						mststyledemmapManager.save(mststyledemmap);
					} catch (Exception ex) {
						log.debug("Error in style demmap : "+ex.getMessage());
						StyleStatus = "Incomplete";
					}
				}
			}
			/**
			 * Create component, image, color, grid template and grid if any
			 * exception is raised, style status goes to Incomplete otherwise style
			 * status is complete. Each set hold objects data String StyleStatus
			 * hold Incomplete/complete status
			 */

		}
		

		return success;
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
	
	
public void Removestyles(Mststyleheader mststyleheader) {
		
		//log.debug("enter Remove Style ");
		log.debug("Style is :" + mststyleheader.getId().getStyleId());
		
			/** remove Child Color*/
		
		List< MststylechildColor> mststylechildColors=mststylechildColorManager.getAll(mststyleheader);
		if(mststylechildColors!=null){	
			if(!mststylechildColors.isEmpty()){	
				log.debug("enter Remove childColor  ");
				for(int i=0;i<mststylechildColors.size();i++){
					try{
						mststylechildColorManager.remove(mststylechildColors.get(i));
					//log.debug("enter Remove Style "+ mststylechildColors.size());
					}
					catch(Exception e){
						log.debug(e.getMessage());
					}
				}
			}
		}
		
		
		List< Mststylecomponent> mststylecomponents=mststylecomponentManager.getAll(mststyleheader);
		if(mststylecomponents!=null){	
			if(!mststylecomponents.isEmpty()){	
				log.debug("enter Remove Component ");
				for(int i=0;i<mststylecomponents.size();i++){
					try{
					mststylecomponentManager.remove(mststylecomponents.get(i));
					//log.debug("Removed Component :" +mststylecomponents.get(i).getId().getCompCode() );
					}
					catch(Exception e){
						log.debug(e.getMessage());
					}
				}
			}
		}
		/** remove Demmap*/
		
		List< Mststyledemmap> mststyledemmaps=mststyledemmapManager.getAll(mststyleheader);
		if(mststyledemmaps!=null){	
			if(!mststyledemmaps.isEmpty()){	
				log.debug("enter Remove Dem  ");
				for(int i=0;i<mststyledemmaps.size();i++){
					try{
						mststyledemmapManager.remove(mststyledemmaps.get(i));
						//log.debug("Removed Demmap :" +mststyledemmaps.get(i).getId().getDemType1()+ " " +mststyledemmaps.get(i).getId().getDemType2());
					}
					catch(Exception e){
						log.debug(e.getMessage());
					}
				}
			}
		}
		/** remove Dem*/
		
		
		List< Mststyledem> mststyledems=mststyledemManager.getAll(mststyleheader);
		if(mststyledems!=null){
			log.debug("enter Remove dem  ");
			if(!mststyledemmaps.isEmpty()){	
				for(int i=0;i<mststyledems.size();i++){
					try{
						mststyledemManager.remove(mststyledems.get(i));
					//log.debug("Removed Dem :" +mststyledems.get(i).getId().getDemType());
					}catch(Exception e){
						log.debug(e.getMessage());
					}
				}
			}
		}	
		/** remove Pictur*/
		
		
		List< Mststylepicture> mststylepictures=mststylepictureManager.getAll(mststyleheader);
		if(mststylepictures!=null){	
			if(!mststylepictures.isEmpty()){	
				log.debug("enter Remove Pic  ");
				for(int i=0;i<mststylepictures.size();i++){
					try{
						mststylepictureManager.remove(mststylepictures.get(i));
						mstpictureManager.remove(mstpictureManager.get(mststylepictures.get(i).getId().getPicCode()));
						//log.debug("Removed Picture :" +mststylepictures.get(i).getId().getPicCode());
					}
					catch(Exception e){
						log.debug(e.getMessage());
					}
				}
			}
		}
		/** remove Main Color*/
		
		List< MststylemainColor> mststylemainColors=mststylemainColorManager.getAll(mststyleheader);
		if(mststylemainColors!=null){	
			if(!mststylemainColors.isEmpty()){	
				log.debug("enter Remove main Color  ");
				for(int i=0;i<mststylemainColors.size();i++){
					try{
						mststylemainColorManager.remove(mststylemainColors.get(i));
						//log.debug("Removed Main Color :" +mststylemainColors.get(i).getId().getMainColor());
					}
					catch(Exception e){
						log.debug(e.getMessage());
					}
				}
			}
		}
	}
	
}
