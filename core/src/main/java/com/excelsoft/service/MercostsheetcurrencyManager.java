package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;

import com.excelsoft.model.Mercostsheetcurrency;
import com.excelsoft.model.MercostsheetcurrencyId;
import com.excelsoft.model.Mercostsheethdr;

@WebService
public interface MercostsheetcurrencyManager extends GenericManager<Mercostsheetcurrency, MercostsheetcurrencyId> {
    
	public List< Mercostsheetcurrency> getAll(Mercostsheethdr mercostsheethdr);
	
}