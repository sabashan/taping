package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MstlocationDao;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.service.MstlocationManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstlocationManager")
@WebService(serviceName = "MstlocationService", endpointInterface = "com.excelsoft.service.MstlocationManager")
public class MstlocationManagerImpl extends GenericManagerImpl<Mstlocation, String> implements MstlocationManager {
    MstlocationDao mstlocationDao;

    @Autowired
    public MstlocationManagerImpl(MstlocationDao mstlocationDao) {
        super(mstlocationDao);
        this.mstlocationDao = mstlocationDao;
    }

	@Override
	public List<String> getcode() {
		return mstlocationDao.getcode();
	}
	@Override
	public List<Mstlocation> getallsearch(String query){
		return mstlocationDao.getFildsearch(query);
	}

    public List<Mstlocation>getAll(){
    	return mstlocationDao.getAll();
    }
    
    public Mstlocation get(String id){
    	return mstlocationDao.get(id);
    }

	@Override
	public Object get(String Id, String field) {
		return mstlocationDao.get(Id,field);
	}
}