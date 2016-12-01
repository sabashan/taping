package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Merordersheetgroup;
import com.excelsoft.model.MerordersheetgroupId;
import javax.jws.WebService;

@WebService
public interface MerordersheetgroupManager extends GenericManager<Merordersheetgroup, MerordersheetgroupId> {
    
}