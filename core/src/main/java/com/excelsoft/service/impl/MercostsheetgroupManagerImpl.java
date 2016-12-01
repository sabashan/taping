package com.excelsoft.service.impl;

import com.excelsoft.dao.MercostsheetgroupDao;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.MercostsheetgroupId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.service.MercostsheetgroupManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

@Service("mercostsheetgroupManager")
@WebService(serviceName = "MercostsheetgroupService", endpointInterface = "com.excelsoft.service.MercostsheetgroupManager")
public class MercostsheetgroupManagerImpl extends GenericManagerImpl<Mercostsheetgroup, MercostsheetgroupId> implements MercostsheetgroupManager {
    MercostsheetgroupDao mercostsheetgroupDao;

    @Autowired
    public MercostsheetgroupManagerImpl(MercostsheetgroupDao mercostsheetgroupDao) {
        super(mercostsheetgroupDao);
        this.mercostsheetgroupDao = mercostsheetgroupDao;
    }

	@Override
	public List<Mercostsheetgroup> getAll(String cosrsheetNo, String version,
			String costsheetType) {
		return this.mercostsheetgroupDao.getAll(cosrsheetNo,version,costsheetType);
	}
	
	@Override
	public List<Mercostsheetgroup> getAll() {
		return this.mercostsheetgroupDao.getAll();
	}

	@Override
	public List<Mercostsheetgroup> getAll(Mercostsheethdr mercostsheethdr) {
		return this.mercostsheetgroupDao.getAll(mercostsheethdr);
	}

	@Override
	public Mercostsheetgroup get(String groupName) {
		return this.mercostsheetgroupDao.get(groupName);
	}

	@Override
	public Mercostsheetgroup get(String costSheetNo, String versionNo,
			String costSheetType, String groupName) {
		return this.mercostsheetgroupDao.get(costSheetNo, versionNo, costSheetType,groupName);
	}

}