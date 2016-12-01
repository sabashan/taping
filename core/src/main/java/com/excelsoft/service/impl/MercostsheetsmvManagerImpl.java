package com.excelsoft.service.impl;

import com.excelsoft.dao.MercostsheetsmvDao;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.Mercostsheetsmv;
import com.excelsoft.model.MercostsheetsmvId;
import com.excelsoft.service.MercostsheetsmvManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mercostsheetsmvManager")
@WebService(serviceName = "MercostsheetsmvService", endpointInterface = "com.excelsoft.service.MercostsheetsmvManager")
public class MercostsheetsmvManagerImpl extends GenericManagerImpl<Mercostsheetsmv, MercostsheetsmvId> implements MercostsheetsmvManager {
    MercostsheetsmvDao mercostsheetsmvDao;

    @Autowired
    public MercostsheetsmvManagerImpl(MercostsheetsmvDao mercostsheetsmvDao) {
        super(mercostsheetsmvDao);
        this.mercostsheetsmvDao = mercostsheetsmvDao;
    }
    
    
    public List<Mercostsheetsmv> getAll(Mercostsheethdr mercostsheethdr){
    	return this.mercostsheetsmvDao.getAll(mercostsheethdr);	
    }
}