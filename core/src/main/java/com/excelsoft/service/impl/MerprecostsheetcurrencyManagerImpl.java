package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MerprecostsheetcurrencyDao;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Merprecostsheetcurrency;
import com.excelsoft.model.MerprecostsheetcurrencyId;
import com.excelsoft.service.MerprecostsheetcurrencyManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("merprecostsheetcurrencyManager")
@WebService(serviceName = "MerprecostsheetcurrencyService", endpointInterface = "com.excelsoft.service.MerprecostsheetcurrencyManager")
public class MerprecostsheetcurrencyManagerImpl extends GenericManagerImpl<Merprecostsheetcurrency, MerprecostsheetcurrencyId> implements MerprecostsheetcurrencyManager {
    MerprecostsheetcurrencyDao merprecostsheetcurrencyDao;

    @Autowired
    public MerprecostsheetcurrencyManagerImpl(MerprecostsheetcurrencyDao merprecostsheetcurrencyDao) {
        super(merprecostsheetcurrencyDao);
        this.merprecostsheetcurrencyDao = merprecostsheetcurrencyDao;
    }
    
    public List< Merprecostsheetcurrency> getAll(Merprecostsheet merprecostsheet ){
    	return this.merprecostsheetcurrencyDao.getAll(merprecostsheet);
    }
}