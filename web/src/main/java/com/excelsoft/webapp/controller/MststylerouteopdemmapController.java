package com.excelsoft.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.excelsoft.dao.SearchException;
import com.excelsoft.service.MststylerouteoperationdemmapManager;

@Controller
@RequestMapping("/mststylerouteopdemmaps*")
public class MststylerouteopdemmapController {
	private MststylerouteoperationdemmapManager mststylerouteoperationdemmapManager;

	@Autowired
	public void setMststylerouteopdemmapManager(
			MststylerouteoperationdemmapManager mststylerouteoperationdemmapManager) {
		this.mststylerouteoperationdemmapManager = mststylerouteoperationdemmapManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Model handleRequest(
			@RequestParam(required = false, value = "q") String query)
			throws Exception {
		Model model = new ExtendedModelMap();
		try {
			model.addAttribute(mststylerouteoperationdemmapManager.search(
					query, MststylerouteoperationdemmapManager.class));
		} catch (SearchException se) {
			model.addAttribute("searchError", se.getMessage());
			model.addAttribute(mststylerouteoperationdemmapManager.getAll());
		}
		return model;
	}
}
