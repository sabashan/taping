package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;

import com.excelsoft.model.Mercostsheetgroupdemmap;
import com.excelsoft.model.MercostsheetgroupdemmapId;
import com.excelsoft.model.Mercostsheetgroupsetting;

@WebService
public interface MercostsheetgroupdemmapManager extends GenericManager<Mercostsheetgroupdemmap, MercostsheetgroupdemmapId> {

	List<Mercostsheetgroupdemmap> getAll(Mercostsheetgroupsetting mercostsheetgroupsetting);
    
}