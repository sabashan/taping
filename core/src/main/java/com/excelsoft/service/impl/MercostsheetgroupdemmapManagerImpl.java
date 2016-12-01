package com.excelsoft.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MercostsheetgroupdemmapDao;
import com.excelsoft.model.Mercostsheetgroupdemmap;
import com.excelsoft.model.MercostsheetgroupdemmapId;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.service.MercostsheetgroupdemmapManager;

@Service("mercostsheetgroupdemmapManager")
@WebService(serviceName = "MercostsheetgroupdemmapService", endpointInterface = "com.excelsoft.service.MercostsheetgroupdemmapManager")
public class MercostsheetgroupdemmapManagerImpl extends GenericManagerImpl<Mercostsheetgroupdemmap, MercostsheetgroupdemmapId> implements MercostsheetgroupdemmapManager {
    MercostsheetgroupdemmapDao mercostsheetgroupdemmapDao;

    @Autowired
    public MercostsheetgroupdemmapManagerImpl(MercostsheetgroupdemmapDao mercostsheetgroupdemmapDao) {
        super(mercostsheetgroupdemmapDao);
        this.mercostsheetgroupdemmapDao = mercostsheetgroupdemmapDao;
    }

	@Override
	public List<Mercostsheetgroupdemmap> getAll(
			Mercostsheetgroupsetting mercostsheetgroupsetting) {
		// TODO Auto-generated method stub
		return this.mercostsheetgroupdemmapDao.getAll(mercostsheetgroupsetting);
	}
}