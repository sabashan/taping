package com.excelsoft.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MercostsheetgroupcolorDao;
import com.excelsoft.model.Mercostsheetgroupcolor;
import com.excelsoft.model.MercostsheetgroupcolorId;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.service.MercostsheetgroupcolorManager;

@Service("mercostsheetgroupcolorManager")
@WebService(serviceName = "MercostsheetgroupcolorService", endpointInterface = "com.excelsoft.service.MercostsheetgroupcolorManager")
public class MercostsheetgroupcolorManagerImpl extends GenericManagerImpl<Mercostsheetgroupcolor, MercostsheetgroupcolorId> implements MercostsheetgroupcolorManager {
    MercostsheetgroupcolorDao mercostsheetgroupcolorDao;

    @Autowired
    public MercostsheetgroupcolorManagerImpl(MercostsheetgroupcolorDao mercostsheetgroupcolorDao) {
        super(mercostsheetgroupcolorDao);
        this.mercostsheetgroupcolorDao = mercostsheetgroupcolorDao;
    }

	@Override
	public List<Mercostsheetgroupcolor> getAll(
			Mercostsheetgroupsetting mercostsheetgroupsetting) {
		// TODO Auto-generated method stub
		return this.mercostsheetgroupcolorDao.getAll(mercostsheetgroupsetting);
	}
}