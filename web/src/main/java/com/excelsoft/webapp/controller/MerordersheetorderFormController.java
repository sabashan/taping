package com.excelsoft.webapp.controller;

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
import com.excelsoft.model.Merordersheetorder;
import com.excelsoft.model.MerordersheetorderId;
import com.excelsoft.service.MerordersheetorderManager;

@Controller
@RequestMapping("/merordersheetorderform*")
public class MerordersheetorderFormController extends BaseFormController {
    private MerordersheetorderManager merordersheetorderManager = null;

    @Autowired
    public void setMerordersheetorderManager(MerordersheetorderManager merordersheetorderManager) {
        this.merordersheetorderManager = merordersheetorderManager;
    }

    public MerordersheetorderFormController() {
        setCancelView("redirect:merordersheetorders");
        setSuccessView("redirect:merordersheetorders");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Merordersheetorder showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("ordersheet_id"); 
        

        if (!StringUtils.isBlank(id)) {
            return merordersheetorderManager.get(new MerordersheetorderId(1L));
        }

        return new Merordersheetorder();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Merordersheetorder merordersheetorder, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(merordersheetorder, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "merordersheetorderform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (merordersheetorder.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            merordersheetorderManager.remove(merordersheetorder.getId());
            saveMessage(request, getText("merordersheetorder.deleted", locale));
        } else {
            merordersheetorderManager.save(merordersheetorder);
            String key = (isNew) ? "merordersheetorder.added" : "merordersheetorder.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:merordersheetorderform?id=" + merordersheetorder.getId();
            }
        }

        return success;
    }
}
