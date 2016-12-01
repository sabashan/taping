package com.excelsoft.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MststylecomponentDao;
import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.MststylecomponentId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MststylecomponentManager;

@Service("mststylecomponentManager")
@WebService(serviceName = "MststylecomponentService", endpointInterface = "com.excelsoft.service.MststylecomponentManager")
public class MststylecomponentManagerImpl extends
		GenericManagerImpl<Mststylecomponent, MststylecomponentId> implements
		MststylecomponentManager {
	MststylecomponentDao mststylecomponentDao;

	@Autowired
	public MststylecomponentManagerImpl(
			MststylecomponentDao mststylecomponentDao) {
		super(mststylecomponentDao);
		this.mststylecomponentDao = mststylecomponentDao;
	}

	@Override
	public List<Mststylecomponent> getAll(Mststyleheader mststyleheader) {
		return mststylecomponentDao.getAll(mststyleheader);
	}
	
	@Override
	public List<Mststylecomponent> getAll() {
		return mststylecomponentDao.getAll();
	}
	
	@Override
	public Mststylecomponent get(MststylecomponentId id) {
		return mststylecomponentDao.get(id);
	}

	@Override
	public List<String> getAllStrings(String location, String buyer,
			String department, String style, String company) {
		
		return mststylecomponentDao.getAllStrings(style, location, department, company, buyer);
	}

	@Override
	public List<String> getcode() {
		return mststylecomponentDao.getcode();
	}

	@Override
	public Mststylecomponent getbyparamid(String location, String buyer,
			String department, String style, String company, String componentId) {
		MststylecomponentId id=new MststylecomponentId(componentId, style, location, department, company, buyer);
		return mststylecomponentDao.get(id);
	}

	@Override
	public List<Mststylecomponent> getAll(String location, String buyer,
			String department, String style, String company , String query) {
		return mststylecomponentDao.getAll(style, location, department, company, buyer,query);
	}


}