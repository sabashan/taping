package com.excelsoft.webapp.controller;

import org.apache.commons.lang.StringUtils;

import com.excelsoft.service.MstitemtypeManager;
import com.excelsoft.service.MststylewippointitemtypeManager;
import com.excelsoft.model.Mststylewippointitemtype;
import com.excelsoft.model.MststylewippointitemtypeId;
import com.excelsoft.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/mststylewippointitemtypeform*")
public class MststylewippointitemtypeFormController extends BaseFormController {
    private MststylewippointitemtypeManager mststylewippointitemtypeManager = null;
    private MstitemtypeManager mstitemtypeManager = null;

    @Autowired
    public void setMststylewippointitemtypeManager(MststylewippointitemtypeManager mststylewippointitemtypeManager) {
        this.mststylewippointitemtypeManager = mststylewippointitemtypeManager;
    }

    @Autowired
	public void setMstitemtypeManager(MstitemtypeManager mstitemtypeManager) {
		this.mstitemtypeManager = mstitemtypeManager;
	}

	public MststylewippointitemtypeFormController() {
        setCancelView("redirect:mststylewippointitemtypes");
        setSuccessView("redirect:mststylewippointitemtypes");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Mststylewippointitemtype showForm(HttpServletRequest request)
    throws Exception {
        String wippointCode = request.getParameter("wippointCode");
        String itemType = request.getParameter("itemType");
        
        if (!StringUtils.isBlank(wippointCode) && !StringUtils.isBlank(itemType)) {
            return mststylewippointitemtypeManager.get(new MststylewippointitemtypeId(wippointCode, itemType));
        }

        return new Mststylewippointitemtype();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Mststylewippointitemtype mststylewippointitemtype, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(mststylewippointitemtype, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "mststylewippointitemtypeform";
            }
        }

        try{
        	String wipPoint = request.getParameter("wipPoint");
        	log.debug(wipPoint);
        	String itemType = request.getParameter("itemType");
        	log.debug(itemType);
        	String attach = request.getParameter("attach");
        	log.debug(attach);
        	MststylewippointitemtypeId id = new MststylewippointitemtypeId(wipPoint, itemType);
        	log.debug(id);
        	mststylewippointitemtype.setId(id);
        	log.debug("error1");
        	mststylewippointitemtype.setMstitemtype(mstitemtypeManager.get(itemType));
        	log.debug(mststylewippointitemtype);
        	if(attach != null){
        		mststylewippointitemtype.setAttached(Short.parseShort(attach));
        	}
        	log.debug(mststylewippointitemtype);
        }catch(Exception e){
        	log.debug(e);
        }
        boolean isNew = (mststylewippointitemtype.getId() == null);
        String success = getSuccessView();
        success = "redirect:mststylewippointss";
        log.debug(success);
        Locale locale = request.getLocale();
        if (request.getParameter("delete") != null) {//
        	List<Mststylewippointitemtype> list = mststylewippointitemtypeManager.getAllWippointitemtype(request.getParameter("itemType"));
        	log.debug(list.toString());
        	log.debug(list.size());
        	if(list.size() > 1){
                mststylewippointitemtypeManager.remove(mststylewippointitemtype.getId());
        	}
        	else{
        		if(request.getParameter("permenent") != null){
        			mststylewippointitemtypeManager.remove(mststylewippointitemtype.getId());
        		}
        		else{
	        		mststylewippointitemtype.setAttached(new Short("0"));
	        		mststylewippointitemtype.setId(new MststylewippointitemtypeId("0", request.getParameter("itemType")));
	        		mststylewippointitemtypeManager.save(mststylewippointitemtype);
        		}
        	}
            saveMessage(request, getText("mststylewippointitemtype.deleted", locale));
        } else {
            mststylewippointitemtypeManager.save(mststylewippointitemtype);
            log.debug("error1");
            String key = (isNew) ? "mststylewippointitemtype.added" : "mststylewippointitemtype.updated";
            log.debug("error2");
            saveMessage(request, getText(key, locale));
            if (!isNew) {
            	log.debug("error3");
                success = "redirect:mststylewippointss";
            }
        }

        return success;
    }
}
