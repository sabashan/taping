package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mercostsheetcountry;
import com.excelsoft.model.MercostsheetcountryId;
import com.excelsoft.model.Mercostsheethdr;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface MercostsheetcountryManager extends GenericManager<Mercostsheetcountry, MercostsheetcountryId> {
    
	public List<Mercostsheetcountry > getAll(Mercostsheethdr mercostsheethdr);
	
}