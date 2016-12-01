package com.excelsoft.service.impl;

import com.excelsoft.dao.MststylerouteoperationdemmapDao;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.MststylerouteoperationId;
import com.excelsoft.model.Mststylerouteoperationdemmap;
import com.excelsoft.model.MststylerouteoperationdemmapId;
import com.excelsoft.service.MststylerouteoperationdemmapManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mststylerouteoperationdemmapManager")
@WebService(serviceName = "MststylerouteoperationdemmapService", endpointInterface = "com.excelsoft.service.MststylerouteoperationdemmapManager")
public class MststylerouteoperationdemmapManagerImpl
		extends
		GenericManagerImpl<Mststylerouteoperationdemmap, MststylerouteoperationdemmapId>
		implements MststylerouteoperationdemmapManager {
	MststylerouteoperationdemmapDao mststylerouteoperationdemmapDao;

	@Autowired
	public MststylerouteoperationdemmapManagerImpl(
			MststylerouteoperationdemmapDao mststylerouteoperationdemmapDao) {
		super(mststylerouteoperationdemmapDao);
		this.mststylerouteoperationdemmapDao = mststylerouteoperationdemmapDao;
	}

	@Override
	public List<Mststylerouteoperationdemmap> getAllOpDemMaps(
			Mststylerouteoperation mststyleoperation) {
		return this.mststylerouteoperationdemmapDao
				.getAllOpDemMaps(mststyleoperation);
	}

	@Override
	public List<Mststylerouteoperationdemmap> getAllOpDemMaps(
			String opeartionNo, String styleRouteId) {
		Integer opeartionNoInt = Integer.parseInt(opeartionNo);
		Long styleRouteIdLong = Long.parseLong(styleRouteId);
		Mststylerouteoperation mststyleoperation = new Mststylerouteoperation();
		mststyleoperation.setId(new MststylerouteoperationId(opeartionNoInt, styleRouteIdLong));
		return this.mststylerouteoperationdemmapDao.getAllOpDemMaps(mststyleoperation);
	}

}