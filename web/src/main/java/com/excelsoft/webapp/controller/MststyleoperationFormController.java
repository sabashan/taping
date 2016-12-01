package com.excelsoft.webapp.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.MststylerouteoperationId;
import com.excelsoft.model.Mststylerouteoperationdemmap;
import com.excelsoft.model.MststylerouteoperationdemmapId;
import com.excelsoft.service.MstparameterManager;
import com.excelsoft.service.MststylerouteoperationManager;
import com.excelsoft.service.MststylerouteoperationdemmapManager;

@Controller
@RequestMapping("/mststyleoperationform*")
public class MststyleoperationFormController extends BaseFormController {
    private MststylerouteoperationManager mststylerouteoperationManager = null;
//    private MstnumbersManager mstnumbersManager = null;
    private String location="";
    private MststylerouteoperationdemmapManager mststylerouteoperationdemmapManager = null;
    private MstparameterManager mstparametermanager =null;

    @Autowired
    public void setMststyleoperationManager(MststylerouteoperationManager mststylerouteoperationManager) {
        this.mststylerouteoperationManager = mststylerouteoperationManager;
    }

    @Autowired
	public void setMststylerouteopdemmapManager(
			MststylerouteoperationdemmapManager mststylerouteoperationdemmapManager) {
		this.mststylerouteoperationdemmapManager = mststylerouteoperationdemmapManager;
	}
//    @Autowired
//	public void setMstnumbersManager(MstnumbersManager mstnumbersManager) {
//		this.mstnumbersManager = mstnumbersManager;
//	}
	
    @Autowired
	public void setMstparameterManager(MstparameterManager mstparametermanager) {
		this.mstparametermanager = mstparametermanager;
	}
    
    @Autowired
    private MststylerouteopdemmapFormController form;
    /*public MststyleoperationFormController() {
        setCancelView("redirect:mststyleoperations");
        setSuccessView("redirect:mststyleoperations");
    }*/
    
    public MststyleoperationFormController() {
        setCancelView("redirect:mststylerouteoperations");
        setSuccessView("redirect:mststylerouteoperations");
        try{
        	location = mstparametermanager.getAll().get(0).getLocationCode();
        }
        catch(Exception e){
        	log.debug(e);
        	location = "Loc";
        }
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Mststylerouteoperation showForm(HttpServletRequest request)
    throws Exception {
    	String styleId = request.getParameter("styleId");
		String locationCode = request.getParameter("locationCode");
		String compCode = request.getParameter("compCode");
		String custCode = request.getParameter("custCode");
		String depCode = request.getParameter("depCode");
		String componentId = request.getParameter("componentId");
		String mainColor = request.getParameter("mainColor");
		String op=request.getParameter("opeartionNo");
		String sr=request.getParameter("styleRouteId");
		int opeartionNo=0;
		Long styleRouteId=null;
		if (!(StringUtils.isBlank(styleId)||StringUtils.isBlank(locationCode)||StringUtils.isBlank(compCode)
				||StringUtils.isBlank(custCode)||StringUtils.isBlank(depCode)||StringUtils.isBlank(componentId)
				||StringUtils.isBlank(mainColor)||StringUtils.isBlank(sr)||StringUtils.isBlank(op))) {
			opeartionNo = new Integer(op);
			styleRouteId = new Long(sr);
			MststylerouteoperationId id=new MststylerouteoperationId(opeartionNo, styleRouteId);//opeartionNo, componentId, mainColor, styleRouteId, styleId, locationCode, custCode, compCode, depCode);

            return mststylerouteoperationManager.get(id);
        }

        return new Mststylerouteoperation();
    }

    @SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Mststylerouteoperation mststylerouteoperation, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
    	if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
        String success = getSuccessView();
		Locale locale = request.getLocale();
        if(request.getParameter("AssignWIPPoints") == null){

	        if (validator != null) { // validator is null during testing
	            validator.validate(mststylerouteoperation, errors);
	
	            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
	            	log.debug(errors);
	                return "mststyleoperationform";
	            }
	        }
	
	        log.debug("entering 'onSubmit' method...");
	
	        boolean isNew = (request.getParameter("id.opeartionNo") == null || request.getParameter("id.opeartionNo") == "");
	        isNew = (request.getParameter("id.opeartionNo") == "");
     		int opeartionNo = 1;
	        MststylerouteoperationId id=mststylerouteoperation.getId();
	        
	        try{
	        	Date now = new Date();
	        	if(isNew){
	        		opeartionNo = mststylerouteoperationManager.getnextopperation(id.getStyleRouteId());
	        		id.setOpeartionNo(++opeartionNo);
	        		mststylerouteoperation.setCreatedAt(location);
	        		mststylerouteoperation.setCreatedBy(request.getRemoteUser());
	        		mststylerouteoperation.setCreatedOn(now);
	        		mststylerouteoperation.setModifiedAt(null);
	        		mststylerouteoperation.setModifiedBy(null);
	        		mststylerouteoperation.setModifiedOn(null);
	        	}
	        	else{
	        		@SuppressWarnings("deprecation")
					Date date = new Date(request.getParameter("createdOnOperation"));
	        		mststylerouteoperation.setCreatedAt(request.getParameter("createdAtOperation"));
	        		mststylerouteoperation.setCreatedBy(request.getParameter("createdByOperation"));
	        		mststylerouteoperation.setCreatedOn(date);
	        		mststylerouteoperation.setModifiedAt(location);
	        		mststylerouteoperation.setModifiedBy(request.getRemoteUser());
	        		mststylerouteoperation.setModifiedOn(now);
	        		String operId = String.valueOf(mststylerouteoperation.getId().getOpeartionNo());
		        	String routeId = String.valueOf(mststylerouteoperation.getId().getStyleRouteId());
	        		Mststylerouteoperation oldROP = mststylerouteoperationManager.getbyidparam(operId, routeId);
	        		if(oldROP.getAverageSmv() != mststylerouteoperation.getAverageSmv().setScale(4,BigDecimal.ROUND_UP)){
		        		mststylerouteoperation.setRevision5(oldROP.getRevision4());
		        		mststylerouteoperation.setRevision4(oldROP.getRevision3());
		        		mststylerouteoperation.setRevision3(oldROP.getRevision2());
		        		mststylerouteoperation.setRevision2(oldROP.getRevision1());
		        		mststylerouteoperation.setRevision1(oldROP.getAverageSmv());
	        		}
	        	}
	        	if(mststylerouteoperation.getDefaultSmv()==null){
	        		mststylerouteoperation.setDefaultSmv(mststylerouteoperation.getAverageSmv());
	        	}
	        	else if(mststylerouteoperation.getAverageSmv()==null){
	        		mststylerouteoperation.setAverageSmv(mststylerouteoperation.getDefaultSmv());
	        	}
	        	
	        }catch(Exception e){}
	        
	       
	        if (request.getParameter("delete") != null) {
	        	String routeId = String.valueOf(mststylerouteoperation.getId().getStyleRouteId());
	        	String operId = String.valueOf(mststylerouteoperation.getId().getOpeartionNo());
	        	List<Mststylerouteoperationdemmap> demmaps = mststylerouteoperationdemmapManager.getAllOpDemMaps(operId, routeId);
	        	for (Iterator iterator = demmaps.iterator(); iterator.hasNext();) {
					Mststylerouteoperationdemmap demmap = (Mststylerouteoperationdemmap) iterator.next();
					mststylerouteoperationdemmapManager.remove(demmap);
				}
	            mststylerouteoperationManager.remove(mststylerouteoperation.getId());
	            saveMessage(request, getText("mststyleoperation.deleted", locale));
	        } else {
	        	
	            mststylerouteoperation.setId(id);
	            mststylerouteoperationManager.save(mststylerouteoperation);
	            /*if(isNew){
	            	//mstnumbersManager.setNextRouteOperation();
	            	}*/
	            String key = (isNew) ? "mststyleoperation.added" : "mststyleoperation.updated";
	            saveMessage(request, getText(key, locale));
	            
	            try {
					String[] smvValueArr = request.getParameter("smvValueArr").split(",");

					for (int i = 0; i < smvValueArr.length; i += 4) {
						Mststylerouteoperationdemmap mststylerouteoperationdemmap = new Mststylerouteoperationdemmap();
						try {
							String horizontalDem = smvValueArr[i];
							String verticalDem = smvValueArr[i + 1];
							String[] Assignvalue = smvValueArr[i + 2].split(":");
							String horizontalValue = Assignvalue[2];
							String verticalValue = Assignvalue[1];
							String mainColor = Assignvalue[0];
							mststylerouteoperationdemmap.setId(new MststylerouteoperationdemmapId(
								id.getOpeartionNo(), id.getStyleRouteId(), verticalDem,horizontalDem, horizontalValue,verticalValue, mainColor));
							mststylerouteoperationdemmap.setSmvValue(BigDecimal.valueOf(Double.parseDouble(smvValueArr[i + 3])));
							mststylerouteoperationdemmapManager.save(mststylerouteoperationdemmap);
						} catch (Exception e) {
							log.debug(e.toString());
						}
					}
				} catch (Exception e) {
					log.debug(e.toString());
				}
	        }
	        try{
		        String url="rop_locationCode="+request.getParameter("locationCode");//mststylerouteoperation.getMststyleroute().getMststyleheader().getId().getLocationCode();
	            url=url +"&rop_custCode="+ request.getParameter("custCode");//mststylerouteoperation.getMststyleroute().getMststyleheader().getId().getCustCode();
	            url=url +"&rop_depCode="+ request.getParameter("depCode");//mststylerouteoperation.getMststyleroute().getMststyleheader().getId().getDepCode();
	            url=url +"&rop_styleId="+ request.getParameter("id.styleId");//mststylerouteoperation.getMststyleroute().getMststyleheader().getId().getStyleId();
	            url=url +"&rop_compCode="+ request.getParameter("compCode");
	            url=url +"&rop_Style_Description=&rop_Style_Component="+ request.getParameter("componentId");//mststylerouteoperation.getMststyleroute().getComponentId();
	            url=url +"&rop_mainColor="+mststylerouteoperation.getMststyleroute().getMainColor();
	            url=url +"&rop_styleRouteId="+ request.getParameter("styleRouteId");//mststylerouteoperation.getId().getStyleRouteId();
	            success = "redirect:mststylerouteoperations?" + url + "&rop_id_search=true";
	        }catch(Exception e){
	        	log.debug(e);
	        }
        }
        else{
        	String AssignWIPPointsRemove = request.getParameter("AssignWIPPointsRemove");
        	if(AssignWIPPointsRemove != ""){
        		updateWipPoint(AssignWIPPointsRemove, false);
        	}
        	String AssignWIPPoints = request.getParameter("AssignWIPPoints");
        	updateWipPoint(AssignWIPPoints, true);
        }
		return success;
    }

    private void updateWipPoint(String dataSet, boolean isUpdate){
    	String[] AssignWIPPoints = (dataSet).split(":");
    	//AssignWIPPoints [sequenceNo, WipPointSquence, WIP ID, OperationId, styleRouteId]
		for (int i = 0; i < AssignWIPPoints.length; i++) {
			log.debug(AssignWIPPoints[i]);
			String[] selected = AssignWIPPoints[i].split(",");
			String opeartionNo = selected[3];//3 OperationId
			String styleRouteId = selected[4];//4 styleRouteId
			Mststylerouteoperation mststyleoperation = mststylerouteoperationManager.getbyidparam(opeartionNo, styleRouteId);
			try {
				if(isUpdate){
					mststyleoperation.setWipPoints(selected[2]);//2 WIP ID
				}
				else{
					mststyleoperation.setWipPoints(null);
				}
				mststylerouteoperationManager.save(mststyleoperation);
			} catch (Exception e) {
				log.debug(" error of Component " + e.getMessage());
			}
			//2
			//for (int j = 0; j < selected.length; j++) {
				/*if(j==3){
					try{
						String ss = selected[j].substring(selected[j].indexOf("opeartionNo"));
						selected[j] = ss;
					}catch(Exception e){
						log.debug(" error of Component " + e.getMessage());
					}
				}
				if(i==AssignWIPPoints.length-1 && j== selected.length-1){
					String ss = selected[j].replaceAll("]", "");
					selected[j] = ss;
				}*/
				//log.debug(selected[j]);
			//}
				/*
			try {
				String opeartionNo = selected[3].split("=")[1];
				String componentId = selected[4].split("=")[1];
				String mainColor = selected[5].split("=")[1];
				String styleRouteId = selected[6].split("=")[1];
				String styleId = selected[7].split("=")[1];
				String locationCode = selected[8].split("=")[1];
				String custCode = selected[9].split("=")[1];
				String compCode = selected[10].split("=")[1];
				String depCode = selected[11].split("=")[1];
				Mststylerouteoperation mststyleoperation = mststylerouteoperationManager.getbyidparam(opeartionNo, styleRouteId);
				log.debug(mststyleoperation.toString());
				if(isUpdate){
					mststyleoperation.setWipPoints(selected[2]);
				}
				else{
					mststyleoperation.setWipPoints(null);
				}
				log.debug(mststyleoperation.toString());
				mststylerouteoperationManager.save(mststyleoperation);
			} catch (Exception e) {
				log.debug(" error of Component " + e.getMessage());
			}*/
		}
    }

}
