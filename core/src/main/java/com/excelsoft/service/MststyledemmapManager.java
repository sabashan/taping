package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mststyledemmap;
import com.excelsoft.model.MststyledemmapId;
import com.excelsoft.model.Mststyleheader;

import javax.jws.WebService;

@WebService
public interface MststyledemmapManager extends GenericManager<Mststyledemmap, MststyledemmapId> {
	
	public List<Mststyledemmap> getAll(Mststyleheader mststyleheader);

}