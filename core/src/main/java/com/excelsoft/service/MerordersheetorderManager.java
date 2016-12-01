package com.excelsoft.service;

import javax.jws.WebService;
import com.excelsoft.model.Merordersheetorder;
import com.excelsoft.model.MerordersheetorderId;

@WebService
public interface MerordersheetorderManager extends GenericManager<Merordersheetorder, MerordersheetorderId> {
    
}