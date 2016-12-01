package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstdepartment;

import javax.jws.WebService;

@WebService
public interface MstdepartmentManager extends GenericManager<Mstdepartment, String> {
    
}