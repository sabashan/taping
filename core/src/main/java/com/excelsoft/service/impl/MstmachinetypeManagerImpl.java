package com.excelsoft.service.impl;

import com.excelsoft.dao.MstmachinetypeDao;
import com.excelsoft.model.Mstmachinetype;
import com.excelsoft.service.MstmachinetypeManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mstmachinetypeManager")
@WebService(serviceName = "MstmachinetypeService", endpointInterface = "com.excelsoft.service.MstmachinetypeManager")
public class MstmachinetypeManagerImpl extends GenericManagerImpl<Mstmachinetype, String> implements MstmachinetypeManager {
    MstmachinetypeDao mstmachinetypeDao;

    @Autowired
    public MstmachinetypeManagerImpl(MstmachinetypeDao mstmachinetypeDao) {
        super(mstmachinetypeDao);
        this.mstmachinetypeDao = mstmachinetypeDao;
    }
    @Override
    public List<Mstmachinetype> getAll(){
    	return mstmachinetypeDao.getAll();
    }
    @Override
	public Mstmachinetype get(String id){
		return mstmachinetypeDao.get(id);
	}

	@Override
	public List<Mstmachinetype> getmachintype(String queary) {
		return mstmachinetypeDao.getmachintype(queary);
	}
	@Override
	public List<String> getmachintype() {
		return mstmachinetypeDao.getmachintype();
	}
}