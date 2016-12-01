package com.excelsoft.webapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Mststyledem;
import com.excelsoft.model.Mststyledemmap;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.MststylemainColor;
import com.excelsoft.model.MststylemainColorId;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.service.MststylecomponentManager;
import com.excelsoft.service.MststyledemManager;
import com.excelsoft.service.MststyledemmapManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.service.MststylemainColorManager;
import com.excelsoft.service.MststylepictureManager;
import com.excelsoft.service.MststylerouteManager;
import com.excelsoft.service.MststylerouteoperationManager;
import com.excelsoft.service.MststylerouteoperationdemmapManager;
import com.excelsoft.service.MststylewippointsManager;

/**
 * 
 * @author User
 * 
 */
@Controller
@RequestMapping("/mststylerouteoperations*")
@SuppressWarnings("rawtypes")
public class MststylerouteoperationController extends BaseFormController {
	protected final transient Log log = LogFactory.getLog(getClass());
	private MststylerouteManager mststylerouteManager;
	private MststylemainColorManager mststylemainColorManager;
	private MststylerouteoperationManager mststyleoperationManager;
	private MststylewippointsManager mststylewippointsManager;
	private MststyledemManager mststyledemManager;
	private MststyledemmapManager mststyledemmapManager;
	private MststylepictureManager mststylepictureManager;

	@Autowired
	public void setMststylerouteManager(
			MststylerouteManager mststylerouteManager) {
		this.mststylerouteManager = mststylerouteManager;
	}

	@Autowired
	public void setMststylepictureManager(
			MststylepictureManager mststylepictureManager) {
		this.mststylepictureManager = mststylepictureManager;
	}

	@Autowired
	public void setMststyleoperationManager(
			MststylerouteoperationManager mststyleoperationManager) {
		this.mststyleoperationManager = mststyleoperationManager;
	}

	@Autowired
	public void setMststyleheaderManager(
			MststyleheaderManager mststyleheaderManager) {
	}

	@Autowired
	public void setMststylecomponentManager(
			MststylecomponentManager mststylecomponentManager) {
	}

	@Autowired
	public void setMststylemainColorManager(
			MststylemainColorManager mststylemainColorManager) {
		this.mststylemainColorManager = mststylemainColorManager;
	}

	@Autowired
	public void setMststylewippointsManager(
			MststylewippointsManager mststylewippointsManager) {
		this.mststylewippointsManager = mststylewippointsManager;
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
	public void setMststylerouteopdemmapManager(
			MststylerouteoperationdemmapManager mststylerouteoperationdemmapManager) {
	}

	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(method = RequestMethod.GET)
	public Model handleRequest(
			@RequestParam(required = false, value = "q") String query,
			HttpServletRequest request) throws Exception {

		Model model = new ExtendedModelMap();
		Mststylerouteoperation mststylerouteoperation = new Mststylerouteoperation();
		String ropsearch = request.getParameter("rop_id_search");
		String wipsearch = request.getParameter("wipsearch");
		String roplocationCode = request.getParameter("rop_locationCode");
		String ropcustCode = request.getParameter("rop_custCode");
		String ropstyleId = request.getParameter("rop_styleId");
		String ropcompCode = request.getParameter("rop_compCode");
		String ropdepCode = request.getParameter("rop_depCode");
		String ropstyleRouteId = request.getParameter("rop_styleRouteId");
		String ropmainColor = request.getParameter("rop_mainColor");
		String ropStyleComponent = request.getParameter("rop_Style_Component");
		String ropStyleDescription = request.getParameter("rop_Style_Description");		
		String locationCode = request.getParameter("locationCode");
		String custCode = request.getParameter("custCode");
		String styleId = request.getParameter("styleId");
		String compCode = request.getParameter("compCode");
		String depCode = request.getParameter("depCode");
		String styleDescription = request.getParameter("styleDescription");
		
		Mststyleroute mststyleroute = new Mststyleroute();
		Mststyleheader mststyleheader = new Mststyleheader();
		List<Mststylerouteoperation> mststyleoperations = new ArrayList<Mststylerouteoperation>();
		Long RouteId = null;
		if (!StringUtils.isBlank(ropsearch) || !StringUtils.isBlank(wipsearch)) {
			if (!(StringUtils.isBlank(ropStyleComponent)
					|| StringUtils.isBlank(ropmainColor)
					|| StringUtils.isBlank(ropcustCode)
					|| StringUtils.isBlank(ropstyleId)
					|| StringUtils.isBlank(roplocationCode)
					|| StringUtils.isBlank(ropstyleRouteId) || StringUtils
						.isBlank(ropdepCode))) {

				try {
					RouteId = new Long(ropstyleRouteId);
					if(query!=null ){
						log.debug("sch");
						mststyleoperations = mststyleoperationManager
								.getByRootparamQ(RouteId,query);
					}
					else{
						log.debug("No sch");
						mststyleoperations = mststyleoperationManager
							.getByRootparam(RouteId);
					
					/** **/ 
					}
					log.debug(mststyleoperations);
					model.addAttribute("mststyleoperationLists",
							mststyleoperations);
					mststyleroute = mststylerouteManager.get(RouteId);
				} catch (Exception e) {
					log.error(e.getMessage());
					model.addAttribute("mststyleoperationLists",
							new ArrayList<Mststyleroute>());
					mststyleroute = mststylerouteManager.get(RouteId);
				}

				locationCode = roplocationCode;
				custCode = ropcustCode;
				styleId = ropstyleId;
				compCode = ropcompCode;
				depCode = ropdepCode;
			} else {
				log.debug("no route operations");
			}
			if(!StringUtils.isBlank(ropsearch)){
				model.addAttribute("ropsearch", "true");
				model.addAttribute("wipsearch", "false");
			}
			else if(!StringUtils.isBlank(wipsearch)){
				model.addAttribute("wipsearch", "true");
				model.addAttribute("ropsearch", "false");
			}
			MststyleheaderId id = new MststyleheaderId(ropstyleId, roplocationCode,
					ropdepCode, ropcompCode, ropcustCode);
			mststyleheader.setId(id);
			mststyleheader.setStyleDescription(ropStyleDescription);
		} else {
			model.addAttribute("ropsearch", "false");
			MststyleheaderId id = new MststyleheaderId(styleId, locationCode,
					depCode, compCode, custCode);
			mststyleheader.setId(id);
			mststyleheader.setStyleDescription(styleDescription);
		}

		List<MststylemainColor> mststylemainColors = new ArrayList<MststylemainColor>();
		List<Mststyleroute> mststyleroutes = new ArrayList<Mststyleroute>();
		
		if (styleId != null) {
			try {
				try {
					List<MststylemainColor> mstColors = mststylemainColorManager
							.getAll(mststyleheader);
					if (!mstColors.isEmpty()) {
						try {
							mststylemainColors.add(new MststylemainColor(
									new MststylemainColorId("General", styleId,
											locationCode, compCode, custCode,
											depCode), mststyleheader, 0L));
							mststylemainColors.addAll(mstColors);
						} catch (Exception e) {
							log.debug(e);
						}
					}
					if(query!=null && ( StringUtils.isBlank(ropsearch) && StringUtils.isBlank(wipsearch) ) ){
						log.debug("sch");
						List<Mststyleroute> mstOperations = mststylerouteManager
								.getAllRoutesQ(mststyleheader.getId(),query);
						if (!mstOperations.isEmpty()) {
							try {
								mststyleroutes.addAll(mstOperations);
							} catch (Exception e) {
								log.debug(e);
							}
						}
					}
					else{
						log.debug("No sch");
						List<Mststyleroute> mstOperations = mststylerouteManager
								.getAllRoutes(mststyleheader.getId());
						if (!mstOperations.isEmpty()) {
							try {
								mststyleroutes.addAll(mstOperations);
							} catch (Exception e) {
								log.debug(e);
							}
						}
					}
				} catch (Exception se) {
					log.debug(se);
				}

				if (mststyleroutes.size() > 0) {
					mststyleroute.setMststyleheader(mststyleroutes.get(0)
							.getMststyleheader());
				} else {
					// mststylerouteoperation.setMststyleheader(mststyleheaders.get(0));
				}
				Long picNo = (long) mststylepictureManager.getAll(
						mststyleheader).size();

				mststyleroute.setNoOfPcs(picNo);
				mststyleroute.setModifiedOn(null);

			} catch (SearchException se) {
				model.addAttribute("searchError", se.getMessage());
				log.debug(se.getMessage());
			}
		} else {
			log.debug("else part in rout");
		}
		try {
			String edit = request.getParameter("edit");
			if (edit.equalsIgnoreCase("editmode")) {
				locationCode = request.getParameter("locationCode");
				custCode = request.getParameter("custCode");
				styleId = request.getParameter("styleId");
				compCode = request.getParameter("compCode");
				depCode = request.getParameter("depCode");
				styleDescription = request.getParameter("styleDescription");
				Long styleRouteId = Long.parseLong(request
						.getParameter("styleRouteId"));
				mststyleroute = mststylerouteManager.get(styleRouteId);
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		String smvVertical = "";
		String smvHorizontal = "";
		String[] smvVerDemValue = null;
		String[] smvHorDemValue = null;
		String[] smvSelected = null;

		try {
			if (mststyleroutes.size() > 0) {
				List<Mststyledem> mststyledems = null;
				try {
					mststyledems = mststyledemManager.getAll(mststyleroutes
							.get(0).getMststyleheader());
				} catch (Exception e) {
					mststyledems = mststyledemManager.getAll(mststyleroute
							.getMststyleheader());
				}
				String[] smvVerDemValuetest = new String[mststyledems.size()];
				int smvVertest = 0;
				String[] smvHorDemValuetest = new String[mststyledems.size()];
				int smvHoritest = 0;
				if (mststyledems != null) {
					for (Iterator iterator = mststyledems.iterator(); iterator
							.hasNext();) {
						Mststyledem mststyledem = (Mststyledem) iterator.next();
						if (mststyledem.getDimention().equalsIgnoreCase(
								"Vertical")) {
							smvVertical = mststyledem.getId().getDemType();
							smvVerDemValuetest[smvVertest] = mststyledem
									.getId().getDemValue();
							smvVertest++;
						} else {
							smvHorizontal = mststyledem.getId().getDemType();
							smvHorDemValuetest[smvHoritest] = mststyledem
									.getId().getDemValue();
							smvHoritest++;
						}
					}
					smvVerDemValue = new String[smvVertest];
					smvHorDemValue = new String[smvHoritest];
					for (int i = 0; i < smvVertest; i++) {
						smvVerDemValue[i] = smvVerDemValuetest[i];
					}
					for (int i = 0; i < smvHoritest; i++) {
						smvHorDemValue[i] = smvHorDemValuetest[i];
					}
				}
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		try {
			if (mststyleroutes.size() > 0) {
				List<Mststyledemmap> mststyledemmaps = mststyledemmapManager
						.getAll(mststyleroutes.get(0).getMststyleheader());
				smvSelected = new String[mststyledemmaps.size()];
				int i = 0;
				if (mststyledemmaps != null) {
					for (Iterator iterator = mststyledemmaps.iterator(); iterator
							.hasNext();) {
						Mststyledemmap mststyledemmap = (Mststyledemmap) iterator
								.next();
						smvSelected[i] = mststyledemmap.getId().getMainColor()
								+ ":" + mststyledemmap.getId().getDemValue1()
								+ ":" + mststyledemmap.getId().getDemValue2();
						i++;
					}
				}
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		// Hold search criteria
		model.addAttribute("mststyleheader", mststyleheader);
		model.addAttribute("mststylerouteoperationList", mststyleroutes);
		model.addAttribute("mststylemainColors", mststylemainColors);
		model.addAttribute("mststylewippoints",mststylewippointsManager.getAllActive());
		model.addAttribute("smvVertical", smvVertical);
		model.addAttribute("smvHorizontal", smvHorizontal);
		model.addAttribute("smvVerDemValue", smvVerDemValue);
		model.addAttribute("smvHorDemValue", smvHorDemValue);
		model.addAttribute("smvSelected", smvSelected);
		model.addAttribute("mststylerouteoperation", mststyleroute);
		model.addAttribute("mststyleoperation", mststylerouteoperation);
		log.debug(model);
		return model;
	}

}
