package com.excelsoft.webapp.controller;

import java.math.BigDecimal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.excelsoft.model.Mststylerouteoperationdemmap;
import com.excelsoft.model.MststylerouteoperationdemmapId;
import com.excelsoft.service.MststylerouteoperationManager;
import com.excelsoft.service.MststylerouteoperationdemmapManager;

@Controller
@RequestMapping("/mststylerouteopdemmapform*")
public class MststylerouteopdemmapFormController extends BaseFormController {
	private MststylerouteoperationdemmapManager mststylerouteoperationdemmapManager = null;

	@Autowired
	public void setMststyleoperationManager(
			MststylerouteoperationManager mststylerouteoperationManager) {
	}

	@Autowired
	public void setMststylerouteopdemmapManager(
			MststylerouteoperationdemmapManager mststylerouteoperationdemmapManager) {
		this.mststylerouteoperationdemmapManager = mststylerouteoperationdemmapManager;
	}

	public MststylerouteopdemmapFormController() {
		setCancelView("redirect:mststylerouteopdemmaps");
		setSuccessView("redirect:mststylerouteopdemmaps");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Mststylerouteoperationdemmap showForm(HttpServletRequest request)
			throws Exception {
		Long styleRouteId = Long
				.parseLong(request.getParameter("styleRouteId"));
		int opeartionNo = Integer.parseInt(request.getParameter("opeartionNo"));
		String mainColor = request.getParameter("mainColor");
		String horizontalDem = request.getParameter("horizontalDem");
		String verticalDem = request.getParameter("verticalDem");
		String horizontalValue = request.getParameter("horizontalValue");
		String verticalValue = request.getParameter("verticalValue");
		return mststylerouteoperationdemmapManager
				.get(new MststylerouteoperationdemmapId(opeartionNo,
						styleRouteId, verticalDem, horizontalDem,
						horizontalValue, verticalValue, mainColor));
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			Mststylerouteoperationdemmap mststylerouteoperationdemmap,
			BindingResult errors, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (validator != null) {
			// validator is null during testing
			validator.validate(mststylerouteoperationdemmap, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) {
				// don't validate when deleting
				return "mststylerouteopdemmapform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (mststylerouteoperationdemmap.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			try {
				mststylerouteoperationdemmapManager
						.remove(mststylerouteoperationdemmap.getId());
				saveMessage(request,
						getText("mststylerouteopdemmap.deleted", locale));
			} catch (Exception e) {
				log.debug(e);
			}
		} else {
			try {
				Long styleRouteId = Long.parseLong(request
						.getParameter("styleRouteId"));
				int opeartionNo = Integer.parseInt(request
						.getParameter("opeartionNo"));
				String[] smvValueArr = request.getParameter("smvValueArr")
						.split(",");

				for (int i = 0; i < smvValueArr.length; i += 4) {
					// Size,Fit,Blue:LA:10,6161616, [smvHorizontal, smvVertical,
					// smvSelected[j],textVal];
					try {
						String horizontalDem = smvValueArr[i];
						String verticalDem = smvValueArr[i + 1];
						String[] Assignvalue = smvValueArr[i + 2].split(":");
						String horizontalValue = Assignvalue[2];
						String verticalValue = Assignvalue[1];
						String mainColor = Assignvalue[0];
						mststylerouteoperationdemmap.setId(new MststylerouteoperationdemmapId(
							opeartionNo, styleRouteId, verticalDem,horizontalDem, horizontalValue,verticalValue, mainColor));
						mststylerouteoperationdemmap.setSmvValue(BigDecimal.valueOf(Double.parseDouble(smvValueArr[i + 3])));
						mststylerouteoperationdemmapManager.save(mststylerouteoperationdemmap);
					} catch (Exception e) {
						log.debug(e.toString());
					}
				}
			} catch (Exception e) {
				log.debug(e.toString());
			}

			String key = (isNew) ? "mststylerouteopdemmap.added"
					: "mststylerouteopdemmap.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:mststylerouteopdemmapform?id="
						+ mststylerouteoperationdemmap.getId();
			}
		}
		return success;
	}
}
