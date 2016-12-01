package com.excelsoft.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springmodules.validation.util.date.DefaultDateParser;

import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.service.MstnumbersManager;
import com.excelsoft.service.MstparameterManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.service.MststylerouteManager;

@Controller
@RequestMapping("/mststylerouteoperationform*")
public class MststylerouteoperationFormController extends BaseFormController {
	private MststylerouteManager mststylerouteManager = null;
	private MstparameterManager mstparametermanager = null;
	private String location = "";
	private MstnumbersManager mstnumbersManager = null;
	private MststyleheaderManager mststyleheaderManager = null;

	@Autowired
	public void setMstnumbersManager(MstnumbersManager mstnumbersManager) {
		this.mstnumbersManager = mstnumbersManager;
	}

	@Autowired
	public void setMstparameterManager(MstparameterManager mstparametermanager) {
		this.mstparametermanager = mstparametermanager;
	}

	@Autowired
	public void setMststylerouteManager(
			MststylerouteManager mststylerouteoperationManager) {
		this.mststylerouteManager = mststylerouteoperationManager;
	}

	@Autowired
	public void setMststyleheaderManager(
			MststyleheaderManager mststyleheaderManager) {
		this.mststyleheaderManager = mststyleheaderManager;
	}

	public MststylerouteoperationFormController() {
		setCancelView("redirect:mststylerouteoperations");
		setSuccessView("redirect:mststylerouteoperations");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Mststyleroute showForm(HttpServletRequest request)
			throws Exception {
		try {
			location = mstparametermanager.getAll().get(0).getLocationCode();
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		String styleId = request.getParameter("styleId");
		String locationCode = request.getParameter("locationCode");
		String compCode = request.getParameter("compCode");
		String custCode = request.getParameter("custCode");
		String depCode = request.getParameter("depCode");
		Long styleRouteId = new Long(request.getParameter("styleRouteId"));

		Mststyleroute mststylerouteoperation = null;
		if (!(StringUtils.isBlank(styleId) || StringUtils.isBlank(locationCode)
				|| StringUtils.isBlank(depCode)
				|| StringUtils.isBlank(compCode) || StringUtils
					.isBlank(custCode))) {

			try {
				mststylerouteoperation = mststylerouteManager.get(styleRouteId);
			} catch (Exception e) {
				log.debug(e.getMessage());
				mststylerouteoperation = new Mststyleroute();
			}

			return mststylerouteoperation;
		}
		return new Mststyleroute();
	}

	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(getText(
				"date.format", request.getLocale()));
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "targetDate",
				new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Mststyleroute mststyleroute, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (validator != null) {
			// validator is null during testing
			validator.validate(mststyleroute, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) {
				// don't validate when deleting
				log.debug("entering validation method in Mststyleroute...");
				log.debug(errors.hasErrors());
				// return "mststylerouteoperationform";
			}
		}

		boolean isNew = request.getParameter("styleRouteId") == "";

		String styleId = request.getParameter("styleId");
		String locationCode = request.getParameter("locationCode");
		String custCode = request.getParameter("custCode");
		String compCode = request.getParameter("compCode");
		String depCode = request.getParameter("depCode");
		String targetDate = request.getParameter("targetDate");
		Long styleRouteId = 1L;
		DefaultDateParser parser = new DefaultDateParser();

		String componentId = request.getParameter("componentId");
		if (request.getParameter("componentId") == "") {
			componentId = mststyleroute.getComponentId();
		}
		mststyleroute.setComponentId(componentId);

		String mainColor = request.getParameter("mainColor");
		if (request.getParameter("mainColor") == "") {
			mainColor = mststyleroute.getMainColor();
		}
		mststyleroute.setMainColor(mainColor);

		mststyleroute.setMststyleheader(mststyleheaderManager
				.get(new MststyleheaderId(styleId, locationCode, depCode,
						compCode, custCode)));
		try {
			mststyleroute.setTargetDate(parser.parse(targetDate));
		} catch (Exception e) {
			log.debug(e.toString());
		}

		if (isNew) {
			try {
				log.debug(styleRouteId);
				String l = this.mstnumbersManager.getNextRoute();
				log.debug(new Long(l));
				styleRouteId = new Long(l);
				log.debug(styleRouteId);
				
				mststyleroute.setStyleRouteId(styleRouteId);
			} catch (Exception e) {
				log.debug(e.getMessage());
			}
			Date now = new Date();
			mststyleroute.setCreatedOn(now);
			mststyleroute.setCreatedBy(request.getRemoteUser());
			mststyleroute.setCreatedAt(location);
			mststyleroute.setModifiedOn(null);
			mststyleroute.setRouteStatus("Pending");
		} else {
			try {
				styleRouteId = Long.parseLong(request
						.getParameter("styleRouteId"));
			} catch (Exception e) {
				log.debug(e.getMessage());
			}
			Date now = new Date();
			mststyleroute.setModifiedOn(now);
			mststyleroute.setModifiedAt(location);
			mststyleroute.setModifiedBy(request.getRemoteUser());
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				now = sdf.parse(request.getParameter("createdOn").toString());
				mststyleroute.setCreatedOn(now);
			} catch (Exception e) {
				log.debug(e.toString());
			}
		}

		String success = getSuccessView();
		Locale locale = request.getLocale();
		log.debug(mststyleroute.toString());
		if (request.getParameter("delete") != null) {
			mststylerouteManager.remove(mststyleroute);
			saveMessage(request,
					getText("mststylerouteoperation.deleted", locale));
			log.debug(mststyleroute.toString());
		} else {
			log.debug(mststyleroute.toString());
			try{
			mststylerouteManager.save(mststyleroute);
			}catch(Exception e){
				log.debug(e);
			}
			if (isNew) {
				this.mstnumbersManager.setNextRoute();
				log.debug(mststyleroute.toString());
			}
			String key = (isNew) ? "mststylerouteoperation.added"
					: "mststylerouteoperation.updated";
			saveMessage(request, getText(key, locale));
			log.debug(mststyleroute.toString());

			if (!isNew) {
				log.debug("In response....");
			}
			log.debug(mststyleroute.toString());
		}
		return success;
	}
}
