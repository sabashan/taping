package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;

import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.model.MercostsheetgroupsettingId;
import com.excelsoft.model.Mercostsheethdr;

@WebService
public interface MercostsheetgroupsettingManager extends GenericManager<Mercostsheetgroupsetting, MercostsheetgroupsettingId> {
    
    public List<Mercostsheetgroupsetting>  getAll(Mercostsheetgroup mercostsheetgroup);
    
    public List<Mercostsheetgroupsetting>  getAll();
    
    public List<Mercostsheetgroupsetting>  getAll(Mercostsheethdr mercostsheethdr);
    
}