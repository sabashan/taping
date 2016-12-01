package com.excelsoft.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Merordersheetorder;
import com.excelsoft.service.MerordersheetorderManager;

@Controller
@RequestMapping("/merordersheetorders*")
public class MerordersheetorderController {
    private MerordersheetorderManager merordersheetorderManager;

    @Autowired
    public void setMerordersheetorderManager(MerordersheetorderManager merordersheetorderManager) {
        this.merordersheetorderManager = merordersheetorderManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(merordersheetorderManager.search(query, Merordersheetorder.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(merordersheetorderManager.getAll());
        }
        return model;
    }
}
