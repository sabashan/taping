package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;

import com.excelsoft.model.Mercostsheetgroupcolor;
import com.excelsoft.model.MercostsheetgroupcolorId;
import com.excelsoft.model.Mercostsheetgroupsetting;

@WebService
public interface MercostsheetgroupcolorManager extends GenericManager<Mercostsheetgroupcolor, MercostsheetgroupcolorId> {

	List<Mercostsheetgroupcolor> getAll(Mercostsheetgroupsetting mercostsheetgroupsetting);
    
}