package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Merprecostsheetsmv;
import com.excelsoft.model.MerprecostsheetsmvId;

import javax.jws.WebService;

@WebService
public interface MerprecostsheetsmvManager extends GenericManager<Merprecostsheetsmv, MerprecostsheetsmvId> {
    
	public List<Merprecostsheetsmv> getAll(Merprecostsheet merprecostsheet);
}