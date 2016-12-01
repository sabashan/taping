package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MstcompanyDao;
import com.excelsoft.model.Mstcompany;
import com.excelsoft.service.MstcompanyManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstcompanyManager")
@WebService(serviceName = "MstcompanyService", endpointInterface = "com.excelsoft.service.MstcompanyManager")
public class MstcompanyManagerImpl extends GenericManagerImpl<Mstcompany, String> implements MstcompanyManager {
    MstcompanyDao mstcompanyDao;

    @Autowired
    public MstcompanyManagerImpl(MstcompanyDao mstcompanyDao) {
        super(mstcompanyDao);
        this.mstcompanyDao = mstcompanyDao;
    }
    

	public List< Mstcompany>getAll(){
		return mstcompanyDao.getAll();
	}
	 

	public Mstcompany get(String id){
		return mstcompanyDao.get(id);
	}
	@Override
	public List<String> getCompanycode() {
		return mstcompanyDao.getCompanycode();
	}

	@Override
	public List<Mstcompany> getAllbyquery(String query) {
		return mstcompanyDao.getAllbyquery( query);
	}
}