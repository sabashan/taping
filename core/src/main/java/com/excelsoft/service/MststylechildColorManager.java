package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.MststylechildColor;
import com.excelsoft.model.MststylechildColorId;
import com.excelsoft.model.Mststyleheader;

import javax.jws.WebService;

@WebService
public interface MststylechildColorManager extends GenericManager<MststylechildColor, MststylechildColorId> {
	
	
	public List<MststylechildColor> getAll(Mststyleheader mststyleheader);
    
}