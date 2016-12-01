package com.excelsoft.service.impl;

import com.excelsoft.dao.MstgencodesDao;
import com.excelsoft.model.Mstgencodes;
import com.excelsoft.model.MstgencodesId;
import com.excelsoft.service.MstgencodesManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mstgencodesManager")
@WebService(serviceName = "MstgencodesService", endpointInterface = "com.excelsoft.service.MstgencodesManager")
public class MstgencodesManagerImpl extends GenericManagerImpl<Mstgencodes, MstgencodesId> implements MstgencodesManager {
    MstgencodesDao mstgencodesDao;

    @Autowired
    public MstgencodesManagerImpl(MstgencodesDao mstgencodesDao) {
        super(mstgencodesDao);
        this.mstgencodesDao = mstgencodesDao;
    }

	@Override
	public Mstgencodes getMstgencode(MstgencodesId id) {
		return mstgencodesDao.get(id);
	}
	
	@Override
	public Mstgencodes findByid(String code, String type) {
		MstgencodesId id=new MstgencodesId(type, code);
		return getMstgencode(id);
	}
	
	@Override
	public List<Mstgencodes> getAllGencodes() {
		return mstgencodesDao.getAll();
	}
	
	@Override
	public List<Mstgencodes> findByType(String type) {
		return mstgencodesDao.findByType(type);
	}
	
	@Override
	public  List<Mstgencodes> findBycode(String code){
		return mstgencodesDao.findBycode(code);
	}

	@Override
	public List<Mstgencodes> type_idlike(String type, String lcode) {
		return mstgencodesDao.type_idlike(type,lcode);
	}

	@Override
	public List<String> getcode(String type) {
		return mstgencodesDao.getcode(type);
	}
	
}