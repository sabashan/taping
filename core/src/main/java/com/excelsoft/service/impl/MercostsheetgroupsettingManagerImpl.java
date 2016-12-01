package com.excelsoft.service.impl;

import com.excelsoft.dao.MercostsheetgroupsettingDao;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.model.MercostsheetgroupsettingId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.service.MercostsheetgroupsettingManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mercostsheetgroupsettingManager")
@WebService(serviceName = "MercostsheetgroupsettingService", endpointInterface = "com.excelsoft.service.MercostsheetgroupsettingManager")
public class MercostsheetgroupsettingManagerImpl extends GenericManagerImpl<Mercostsheetgroupsetting, MercostsheetgroupsettingId> implements MercostsheetgroupsettingManager {
    MercostsheetgroupsettingDao mercostsheetgroupsettingDao;

    @Autowired
    public MercostsheetgroupsettingManagerImpl(MercostsheetgroupsettingDao mercostsheetgroupsettingDao) {
        super(mercostsheetgroupsettingDao);
        this.mercostsheetgroupsettingDao = mercostsheetgroupsettingDao;
    }

	@Override
	public List<Mercostsheetgroupsetting> getAll(
			Mercostsheetgroup mercostsheetgroup) {
		return this.mercostsheetgroupsettingDao.getAll(mercostsheetgroup);
	}

	@Override
	public List<Mercostsheetgroupsetting> getAll(Mercostsheethdr mercostsheethdr) {
		return this.mercostsheetgroupsettingDao.getAll(mercostsheethdr);
	}
	
	@Override
	public List<Mercostsheetgroupsetting> getAll() {
		return this.mercostsheetgroupsettingDao.getAll();
	}
}