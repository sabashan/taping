package com.excelsoft.service.impl;

import com.excelsoft.dao.MstoperationDao;
import com.excelsoft.model.Mstoperation;
import com.excelsoft.service.MstoperationManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mstoperationManager")
@WebService(serviceName = "MstoperationService", endpointInterface = "com.excelsoft.service.MstoperationManager")
public class MstoperationManagerImpl extends GenericManagerImpl<Mstoperation, Integer> implements MstoperationManager {
    MstoperationDao mstoperationDao;

    @Autowired
    public MstoperationManagerImpl(MstoperationDao mstoperationDao) {
        super(mstoperationDao);
        this.mstoperationDao = mstoperationDao;
    }
    
    @Override
    public List<Mstoperation> getAll(){
    	return mstoperationDao.getAll();
    }

	@Override
	public List<Mstoperation> getAllByType(String type) {
		return mstoperationDao.getAllByType(type);
	}
	
	@Override
	public List<String> getAllTypes() {
		return mstoperationDao.getAllTypes();
	}
	@Override
	public List<String> getAllTypes(String type) {
		return mstoperationDao.getAllTypes(type);
	}
	@Override
	public List<Mstoperation> getAllByTypeAnd(String type, String Qary) {
		return mstoperationDao.getAllByTypeAnd(type,Qary);
	}
}