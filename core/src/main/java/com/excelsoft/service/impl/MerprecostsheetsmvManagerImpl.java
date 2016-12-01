package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MerprecostsheetsmvDao;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Merprecostsheetsmv;
import com.excelsoft.model.MerprecostsheetsmvId;
import com.excelsoft.service.MerprecostsheetsmvManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("merprecostsheetsmvManager")
@WebService(serviceName = "MerprecostsheetsmvService", endpointInterface = "com.excelsoft.service.MerprecostsheetsmvManager")
public class MerprecostsheetsmvManagerImpl extends GenericManagerImpl<Merprecostsheetsmv, MerprecostsheetsmvId> implements MerprecostsheetsmvManager {
    MerprecostsheetsmvDao merprecostsheetsmvDao;

    @Autowired
    public MerprecostsheetsmvManagerImpl(MerprecostsheetsmvDao merprecostsheetsmvDao) {
        super(merprecostsheetsmvDao);
        this.merprecostsheetsmvDao = merprecostsheetsmvDao;
    }
    
    public List<Merprecostsheetsmv> getAll(Merprecostsheet merprecostsheet){
    	return this.merprecostsheetsmvDao.getAll(merprecostsheet);	
    }
}