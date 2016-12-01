package com.excelsoft.service.impl;

import com.excelsoft.dao.MercostsheetcountryDao;
import com.excelsoft.model.Mercostsheetcountry;
import com.excelsoft.model.MercostsheetcountryId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.service.MercostsheetcountryManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mercostsheetcountryManager")
@WebService(serviceName = "MercostsheetcountryService", endpointInterface = "com.excelsoft.service.MercostsheetcountryManager")
public class MercostsheetcountryManagerImpl extends GenericManagerImpl<Mercostsheetcountry, MercostsheetcountryId> implements MercostsheetcountryManager {
    MercostsheetcountryDao mercostsheetcountryDao;

    @Autowired
    public MercostsheetcountryManagerImpl(MercostsheetcountryDao mercostsheetcountryDao) {
        super(mercostsheetcountryDao);
        this.mercostsheetcountryDao = mercostsheetcountryDao;
    }

	@Override
	public List<Mercostsheetcountry> getAll(Mercostsheethdr mercostsheethdr) {
		// TODO Auto-generated method stub
		return this.mercostsheetcountryDao.getAll(mercostsheethdr);
	}
}