package com.excelsoft.service.impl;

import com.excelsoft.dao.MstitemtypeDao;
import com.excelsoft.model.Mstitemtype;
import com.excelsoft.service.MstitemtypeManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mstitemtypeManager")
@WebService(serviceName = "MstitemtypeService", endpointInterface = "com.excelsoft.service.MstitemtypeManager")
public class MstitemtypeManagerImpl extends GenericManagerImpl<Mstitemtype, String> implements MstitemtypeManager {
    MstitemtypeDao mstitemtypeDao;

    @Autowired
    public MstitemtypeManagerImpl(MstitemtypeDao mstitemtypeDao) {
        super(mstitemtypeDao);
        this.mstitemtypeDao = mstitemtypeDao;
    }
    
    public List<Mstitemtype> getallsearch(String q){
    	return mstitemtypeDao.getColomnsearch(q, "itemType");//search(q);
    }

	@Override
	public List<String> getAllId(String category) {
	
		return this.mstitemtypeDao.getAllId(category);
	}

	@Override
	public List<Mstitemtype> getAll(String category, String q) {
		return this.mstitemtypeDao.getAll(category,q);
	}
	
	@Override
	public List<Mstitemtype> getAll(String category) {
		return this.mstitemtypeDao.getAll(category);
	}

	@Override
	public List<Mstitemtype> getItems() {
		// TODO Auto-generated method stub
		return this.mstitemtypeDao.getAll();
	}
}