package com.excelsoft.service.impl;

import com.excelsoft.dao.MercostsheetcurrencyDao;
import com.excelsoft.model.Mercostsheetcurrency;
import com.excelsoft.model.MercostsheetcurrencyId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.service.MercostsheetcurrencyManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mercostsheetcurrencyManager")
@WebService(serviceName = "MercostsheetcurrencyService", endpointInterface = "com.excelsoft.service.MercostsheetcurrencyManager")
public class MercostsheetcurrencyManagerImpl extends GenericManagerImpl<Mercostsheetcurrency, MercostsheetcurrencyId> implements MercostsheetcurrencyManager {
    MercostsheetcurrencyDao mercostsheetcurrencyDao;

    @Autowired
    public MercostsheetcurrencyManagerImpl(MercostsheetcurrencyDao mercostsheetcurrencyDao) {
        super(mercostsheetcurrencyDao);
        this.mercostsheetcurrencyDao = mercostsheetcurrencyDao;
    }

	@Override
	public List< Mercostsheetcurrency> getAll(Mercostsheethdr mercostsheethdr ){
    	return this.mercostsheetcurrencyDao.getAll(mercostsheethdr);
    }
}