package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;

import com.excelsoft.model.Mercostsheetdemmap;
import com.excelsoft.model.MercostsheetdemmapId;
import com.excelsoft.model.Mercostsheethdr;

@WebService
public interface MercostsheetdemmapManager extends GenericManager<Mercostsheetdemmap, MercostsheetdemmapId> {

	List<Mercostsheetdemmap> getDemmapsFromCosting(Mercostsheethdr mercostsheethdr);
    
}