package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;

import com.excelsoft.model.Mststyledem;
import com.excelsoft.model.MststyledemId;
import com.excelsoft.model.Mststyleheader;

@WebService
public interface MststyledemManager extends
		GenericManager<Mststyledem, MststyledemId> {
	
	public List<Mststyledem> getAll(Mststyleheader mststyleheader);

}