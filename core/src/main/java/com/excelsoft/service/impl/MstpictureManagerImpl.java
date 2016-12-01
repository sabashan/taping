package com.excelsoft.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MstpictureDao;
import com.excelsoft.model.Mstpicture;
import com.excelsoft.service.MstpictureManager;

@Service("mstpictureManager")
@WebService(serviceName = "MstpictureService", endpointInterface = "com.excelsoft.service.MstpictureManager")
public class MstpictureManagerImpl extends
		GenericManagerImpl<Mstpicture, String> implements MstpictureManager {
	MstpictureDao mstpictureDao;

	@Autowired
	public MstpictureManagerImpl(MstpictureDao mstpictureDao) {
		super(mstpictureDao);
		this.mstpictureDao = mstpictureDao;
	}
}