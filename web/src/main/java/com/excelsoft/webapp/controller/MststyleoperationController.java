package com.excelsoft.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.service.MststylerouteoperationManager;

@Controller
@RequestMapping("/mststyleoperations*")
public class MststyleoperationController {
    private MststylerouteoperationManager mststylerouteoperationManager;

    @Autowired
    public void setMststyleoperationManager(MststylerouteoperationManager mststylerouteoperationManager) {
        this.mststylerouteoperationManager = mststylerouteoperationManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(mststylerouteoperationManager.search(query, Mststylerouteoperation.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(mststylerouteoperationManager.getAll());
        }
        return model;
    }
}
