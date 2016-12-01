package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MststylemainColorDao;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststylemainColor;
import com.excelsoft.model.MststylemainColorId;
import com.excelsoft.service.MststylemainColorManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mststylemainColorManager")
@WebService(serviceName = "MststylemainColorService", endpointInterface = "com.excelsoft.service.MststylemainColorManager")
public class MststylemainColorManagerImpl extends
		GenericManagerImpl<MststylemainColor, MststylemainColorId> implements
		MststylemainColorManager {
	MststylemainColorDao mststylemainColorDao;

	@Autowired
	public MststylemainColorManagerImpl(
			MststylemainColorDao mststylemainColorDao) {
		super(mststylemainColorDao);
		this.mststylemainColorDao = mststylemainColorDao;
	}

	@Override
	public List<MststylemainColor> getAll(Mststyleheader mststyleheader) {
		
		return mststylemainColorDao.getAll(mststyleheader);
	}

	@Override
	public List<String> getAllStrings( String location,
			String buyer, String department, String style,String company) {
		
		return mststylemainColorDao.getAllStrings( location, buyer, department, style,company);
	}

	@Override
	public List<String> getcode() {
		
		return mststylemainColorDao.getcode();
	}

	@Override
	public List<MststylemainColor> getAll(String location, String buyer,
			String department, String style, String company,String query) {
		return mststylemainColorDao.getAll(location, buyer, department, style, company,query);
	}
	
	
}