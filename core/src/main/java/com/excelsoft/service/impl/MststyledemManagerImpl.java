package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MststyledemDao;
import com.excelsoft.model.Mststyledem;
import com.excelsoft.model.MststyledemId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MststyledemManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mststyledemManager")
@WebService(serviceName = "MststyledemService", endpointInterface = "com.excelsoft.service.MststyledemManager")
public class MststyledemManagerImpl extends
		GenericManagerImpl<Mststyledem, MststyledemId> implements
		MststyledemManager {
	MststyledemDao mststyledemDao;

	@Autowired
	public MststyledemManagerImpl(MststyledemDao mststyledemDao) {
		super(mststyledemDao);
		this.mststyledemDao = mststyledemDao;
	}

	@Override
	public List<Mststyledem> getAll(Mststyleheader mststyleheader) {
		
		return mststyledemDao.getAll(mststyleheader);
	}
}