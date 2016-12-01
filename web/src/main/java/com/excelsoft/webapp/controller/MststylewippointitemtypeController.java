package com.excelsoft.webapp.controller;

import com.excelsoft.dao.SearchException;
import com.excelsoft.service.MststylewippointitemtypeManager;
import com.excelsoft.model.Mststylewippointitemtype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mststylewippointitemtypes*")
public class MststylewippointitemtypeController {
    private MststylewippointitemtypeManager mststylewippointitemtypeManager;

    @Autowired
    public void setMststylewippointitemtypeManager(MststylewippointitemtypeManager mststylewippointitemtypeManager) {
        this.mststylewippointitemtypeManager = mststylewippointitemtypeManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(mststylewippointitemtypeManager.search(query, Mststylewippointitemtype.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(mststylewippointitemtypeManager.getAll());
        }
        return model;
    }
}
