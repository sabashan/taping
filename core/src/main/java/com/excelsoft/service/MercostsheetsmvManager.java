package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.Mercostsheetsmv;
import com.excelsoft.model.MercostsheetsmvId;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface MercostsheetsmvManager extends GenericManager<Mercostsheetsmv, MercostsheetsmvId> {
	public List<Mercostsheetsmv> getAll(Mercostsheethdr mercostsheethdr);
}