package com.excelsoft.service.impl;

import com.excelsoft.dao.MstnumbersDao;
import com.excelsoft.model.Mstnumbers;
import com.excelsoft.model.MstnumbersId;
import com.excelsoft.service.MstnumbersManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.jws.WebService;

@Service("mstnumbersManager")
@WebService(serviceName = "MstnumbersService", endpointInterface = "com.excelsoft.service.MstnumbersManager")
public class MstnumbersManagerImpl extends GenericManagerImpl<Mstnumbers, MstnumbersId> implements MstnumbersManager {
    MstnumbersDao mstnumbersDao;

    @Autowired
    public MstnumbersManagerImpl(MstnumbersDao mstnumbersDao) {
        super(mstnumbersDao);
        this.mstnumbersDao = mstnumbersDao;
    }

	@Override
	public String getNextRoute() {
		return this.mstnumbersDao.getNextRoute();
	}

	@Override
	public String setNextRoute() {
		return this.mstnumbersDao.setNextRoute();
	}
	
	@Override
	public Integer getnexttrnNo(String compCode, String programId, String trnType){
		return this.mstnumbersDao.getnexttrnNo(compCode, new Short(programId), trnType);
	}
	
	@Override
	public Integer getnexttrnNo(String compCode, short programId, String trnType){
		return this.mstnumbersDao.getnexttrnNo(compCode, programId, trnType);
	}

	@Override
	public String getNextWIPId() {
		return this.mstnumbersDao.getNextWIPId();
	}

	@Override
	public String setNextWIPId() {
		return this.mstnumbersDao.setNextWIPId();
	}
}