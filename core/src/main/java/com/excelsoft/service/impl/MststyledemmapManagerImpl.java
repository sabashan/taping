package com.excelsoft.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MststyledemmapDao;
import com.excelsoft.model.Mststyledemmap;
import com.excelsoft.model.MststyledemmapId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MststyledemmapManager;

@Service("mststyledemmapManager")
@WebService(serviceName = "MststyledemmapService", endpointInterface = "com.excelsoft.service.MststyledemmapManager")
public class MststyledemmapManagerImpl extends
		GenericManagerImpl<Mststyledemmap, MststyledemmapId> implements
		MststyledemmapManager {
	MststyledemmapDao mststyledemmapDao;

	@Autowired
	public MststyledemmapManagerImpl(MststyledemmapDao mststyledemmapDao) {
		super(mststyledemmapDao);
		this.mststyledemmapDao = mststyledemmapDao;
	}

	@Override
	public List<Mststyledemmap> getAll(Mststyleheader mststyleheader) {
		
		return mststyledemmapDao.getAll(mststyleheader);
	}
}