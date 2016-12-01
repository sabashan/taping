package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MstsmvvoulmeratesDao;
import com.excelsoft.model.Mstsmvvoulmerates;
import com.excelsoft.model.MstsmvvoulmeratesId;
import com.excelsoft.service.MstsmvvoulmeratesManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import javax.jws.WebService;

@Service("mstsmvvoulmeratesManager")
@WebService(serviceName = "MstsmvvoulmeratesService", endpointInterface = "com.excelsoft.service.MstsmvvoulmeratesManager")
public class MstsmvvoulmeratesManagerImpl extends GenericManagerImpl<Mstsmvvoulmerates, MstsmvvoulmeratesId> implements MstsmvvoulmeratesManager {
    MstsmvvoulmeratesDao mstsmvvoulmeratesDao;

    @Autowired
    public MstsmvvoulmeratesManagerImpl(MstsmvvoulmeratesDao mstsmvvoulmeratesDao) {
        super(mstsmvvoulmeratesDao);
        this.mstsmvvoulmeratesDao = mstsmvvoulmeratesDao;
    }

    @Override
	public List<Mstsmvvoulmerates> getAll() {
		return this.mstsmvvoulmeratesDao.getAll();
	}
    
	

	@Override
	public List<Object> getAll(String buyerCode, String month,
			String date, String year, String smvCode, String Volume) {
		return this.mstsmvvoulmeratesDao.getAll(buyerCode, year+"-"+month+"-"+date, smvCode, Volume);
	}
}