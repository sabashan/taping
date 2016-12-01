package com.excelsoft.webapp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.excelsoft.model.Mststyleroute;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.Mststylerouteoperationdemmap;
import com.excelsoft.service.MststylerouteManager;
import com.excelsoft.service.MststylerouteoperationManager;
import com.excelsoft.service.MststylerouteoperationdemmapManager;

/**
 * 
 * @author User
 * 
 */
@Controller
@RequestMapping("/mststylerouteview*")
public class MststylerouteView extends BaseFormController {
	protected final transient Log log = LogFactory.getLog(getClass());
	
	private MststylerouteManager mststylerouteManager;
	private MststylerouteoperationManager mststylerouteoperationManager;
	private MststylerouteoperationdemmapManager mststylerouteoperationdemmapManager;

	@Autowired
	public void setMststylerouteManager(MststylerouteManager mststylerouteoperationManager) {
		this.mststylerouteManager = mststylerouteoperationManager;
	}
	@Autowired
	public void setMststyleoperationManager(MststylerouteoperationManager mststyleoperationManager) {
		this.mststylerouteoperationManager = mststyleoperationManager;
	}
	@Autowired
	public void setMststylerouteopdemmapManager(MststylerouteoperationdemmapManager mststylerouteoperationdemmapManager) {
		this.mststylerouteoperationdemmapManager = mststylerouteoperationdemmapManager;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.GET)
	public Model handleRequest(
			@RequestParam(required = false, value = "q") String query,
			HttpServletRequest request) throws Exception {
		Model model = new ExtendedModelMap();
		log.debug("***");
		String styleRouteId = request.getParameter("styleRouteId");
		String routeDelete = request.getParameter("delete");
		Mststyleroute mststyleroute = new Mststyleroute();
		List<Mststylerouteoperation> mststylerouteoperations = new ArrayList<Mststylerouteoperation>();
		
		log.debug(styleRouteId + "**" + routeDelete);
		Long RouteId = null;
			if(styleRouteId != null){
				RouteId = new Long(styleRouteId);
				log.debug(RouteId);
				try{
					mststyleroute = mststylerouteManager.get(RouteId);
					log.debug(mststyleroute.toString());
					mststylerouteoperations = mststylerouteoperationManager.getByRoute(mststyleroute);//getByRootparam(styleComponent, mainColors, RouteId, styleId, locationCode, custCode, compCode, depCode);
					log.debug(mststylerouteoperations.toString());
					model.addAttribute("mststyleoperationLists",mststylerouteoperations);
					BigDecimal totalSMV = new BigDecimal(0);
					for (Iterator iterator = mststylerouteoperations.iterator(); iterator.hasNext();) {
						Mststylerouteoperation mststylerouteoperation = (Mststylerouteoperation) iterator.next();
						if(mststylerouteoperation.getCalc())
							totalSMV.add(mststylerouteoperation.getAverageSmv());// += ;
					}
					mststyleroute.setTotalSMV(totalSMV);
					log.debug("/****/**/*/*/*/*/");
					model.addAttribute("rederect","false");
					log.debug("/****/**/*/*/*/*/");
				}
				catch(Exception e){
					log.error(e.getMessage());
					model.addAttribute("rederect","[]");
					model.addAttribute("mststyleoperationLists",new ArrayList<Mststylerouteoperation>());
					mststyleroute = mststylerouteManager.get(RouteId);
				}
				
			}else{
				log.debug("nothing");
			}
			model.addAttribute("ropsearch","true");
			model.addAttribute("mststylerouteoperation", mststyleroute);
		
		if(!StringUtils.isBlank(routeDelete)){
			model.addAttribute("routeDelete","true");
		}else{
			model.addAttribute("routeDelete","");
		}
		log.debug(model);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	    public String onSubmit(Mststyleroute mststyleroute, BindingResult errors, HttpServletRequest request, HttpServletResponse response){
		 if (request.getParameter("cancel") != null) {
	            return getCancelView();
	        }
		String success = getSuccessView();
	    //Locale locale = request.getLocale();
	    
	    /*String locationCode = request.getParameter("id.locationCode");
		String custCode = request.getParameter("id.custCode");
		String styleId = request.getParameter("id.styleId");
		String compCode = request.getParameter("id.compCode");
		String depCode = request.getParameter("id.depCode");
		String mainColor = request.getParameter("id.mainColor");
		String componentId = request.getParameter("id.componentId");*/
		String styleRouteIds = request.getParameter("id.styleRouteId");
		String routeDelete = request.getParameter("delete");
		
		if(routeDelete != null){
			if(!(StringUtils.isBlank(styleRouteIds))){
				Long styleRouteId = new Long(styleRouteIds);
				//MststylerouteId  id=new MststylerouteId(componentId, mainColor, styleRouteId, styleId, locationCode, custCode, compCode, depCode);
				//log.debug(id.toString());
				mststyleroute = mststylerouteManager.get(styleRouteId);
				log.debug(mststyleroute.toString());
				List<Mststylerouteoperation> mststyleoperation=mststylerouteoperationManager.getByRoute(mststyleroute);
				try{
					for (int i =0;i<mststyleoperation.size();i++){
						List<Mststylerouteoperationdemmap> mststylerouteopdemmap= mststylerouteoperationdemmapManager.getAllOpDemMaps(mststyleoperation.get(i));
						
						for (int j=0;j<mststylerouteopdemmap.size();j++){
							mststylerouteoperationdemmapManager.remove(mststylerouteopdemmap.get(j));
						}
						mststylerouteoperationManager.remove(mststyleoperation.get(i));
					}
					mststylerouteManager.remove(mststyleroute);
				}catch(Exception e){
					log.error(e.getMessage());
				}
			}
		}
	     
		 return success;
	 }
}
