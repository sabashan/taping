package com.excelsoft.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.excelsoft.service.MstnumbersManager;
import com.excelsoft.service.MststylewippointsManager;
import com.excelsoft.model.Mststylewippoints;
import com.excelsoft.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/mststylewippointsform*")
public class MststylewippointsFormController extends BaseFormController {
    private MststylewippointsManager mststylewippointsManager = null;
	private MstnumbersManager mstnumbersManager = null;
	
	@Autowired
	public void setMstnumbersManager(MstnumbersManager mstnumbersManager) {
		this.mstnumbersManager = mstnumbersManager;
	}
	
    @Autowired
    public void setMststylewippointsManager(MststylewippointsManager mststylewippointsManager) {
        this.mststylewippointsManager = mststylewippointsManager;
    }

    public MststylewippointsFormController() {
        setCancelView("redirect:mststylewippointss");
        setSuccessView("redirect:mststylewippointss");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Mststylewippoints showForm(HttpServletRequest request)
    throws Exception {
        String wippointCode = request.getParameter("wippointCode");

        if (!StringUtils.isBlank(wippointCode)) {
            return mststylewippointsManager.get(new String(wippointCode));
        }

        return new Mststylewippoints();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Mststylewippoints mststylewippoints, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
        	log.debug("in test***"+mststylewippoints.toString());
            validator.validate(mststylewippoints, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "mststylewippointsform";
            }
        }

        log.debug("entering 'onSubmit' method...");
        log.debug("in test***"+mststylewippoints.toString());
        
        boolean isNew = (mststylewippoints.getWippointCode() == null || mststylewippoints.getWippointCode() == "");
        if(isNew){
        	try{
        	mststylewippoints.setWippointCode(mstnumbersManager.getNextWIPId());//(mststylewippointsManager.getGeneratedId());
        	log.debug(mststylewippoints.getWippointCode());
        	}catch(Exception e){}
        }
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	mststylewippoints.setWippointCode(request.getParameter("wippointCode"));
            mststylewippointsManager.remove(mststylewippoints.getWippointCode());
            saveMessage(request, getText("mststylewippoints.deleted", locale));
        } else {
        	String key = "";
        	try{
        		mststylewippointsManager.save(mststylewippoints);
        		if(isNew){
        			mstnumbersManager.setNextWIPId();
        		}
        		key = (isNew) ? "mststylewippoints.added" : "mststylewippoints.updated";
        	}
        	catch(Exception e){
        		key = "mststylewippoints.error";
        		log.debug(e.getMessage());
        	}
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:mststylewippointss";
            }
        }

        return success;
    }
}
