package com.excelsoft.webapp.controller;

import com.excelsoft.dao.SearchException;
import com.excelsoft.service.MststylewippointsManager;
import com.excelsoft.model.Mststylewippoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mststylewippointss*")
public class MststylewippointsController {
    private MststylewippointsManager mststylewippointsManager;

    @Autowired
    public void setMststylewippointsManager(MststylewippointsManager mststylewippointsManager) {
        this.mststylewippointsManager = mststylewippointsManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(mststylewippointsManager.search(query, Mststylewippoints.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(mststylewippointsManager.getAll());
        }
        model.addAttribute("mststylewippoints", new Mststylewippoints());
        model.addAttribute("mstStyleWippointsForItem", mststylewippointsManager.getAll());
        return model;
    }
}
