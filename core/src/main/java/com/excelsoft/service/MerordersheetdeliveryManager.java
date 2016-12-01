package com.excelsoft.service;

import javax.jws.WebService;
import com.excelsoft.model.Merordersheetdelivery;
import com.excelsoft.model.MerordersheetdeliveryId;

@WebService
public interface MerordersheetdeliveryManager extends GenericManager<Merordersheetdelivery, MerordersheetdeliveryId> {
    
}