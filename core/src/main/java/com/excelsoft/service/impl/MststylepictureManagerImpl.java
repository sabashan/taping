package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MststylepictureDao;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.Mststylepicture;
import com.excelsoft.model.MststylepictureId;
import com.excelsoft.service.MststylepictureManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mststylepictureManager")
@WebService(serviceName = "MststylepictureService", endpointInterface = "com.excelsoft.service.MststylepictureManager")
public class MststylepictureManagerImpl extends GenericManagerImpl<Mststylepicture, MststylepictureId> implements MststylepictureManager {
    MststylepictureDao mststylepictureDao;

    @Autowired
    public MststylepictureManagerImpl(MststylepictureDao mststylepictureDao) {
        super(mststylepictureDao);
        this.mststylepictureDao = mststylepictureDao;
    }

	@Override
	public List<Mststylepicture> getZero(Mststyleheader mststyleheader) {
		
		return mststylepictureDao.getAll(mststyleheader);
	}
	
	@Override
	public List<Mststylepicture> getAll(Mststyleheader mststyleheader) {
		
		return mststylepictureDao.getAll(mststyleheader);
	}
}