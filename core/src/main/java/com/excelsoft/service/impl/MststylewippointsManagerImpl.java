package com.excelsoft.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MststylewippointsDao;
import com.excelsoft.model.Mststylewippoints;
import com.excelsoft.service.MststylewippointsManager;

@Service("mststylewippointsManager")
@WebService(serviceName = "MststylewippointsService", endpointInterface = "com.excelsoft.service.MststylewippointsManager")
public class MststylewippointsManagerImpl extends GenericManagerImpl<Mststylewippoints, String> implements MststylewippointsManager {
    MststylewippointsDao mststylewippointsDao;

    @Autowired
    public MststylewippointsManagerImpl(MststylewippointsDao mststylewippointsDao) {
        super(mststylewippointsDao);
        this.mststylewippointsDao = mststylewippointsDao;
    }

	@Override
	public Mststylewippoints getWipPointById(String wippointCode) {
		return this.mststylewippointsDao.getWipPointById(wippointCode);
	}

	@Override
	public List<Mststylewippoints> getAllActive() {
		return this.mststylewippointsDao.getAllActive();
	}
}