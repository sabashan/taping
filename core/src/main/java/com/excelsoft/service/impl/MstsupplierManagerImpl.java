package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MstsupplierDao;
import com.excelsoft.model.Mstsupplier;
import com.excelsoft.model.MstsupplierId;
import com.excelsoft.service.MstsupplierManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstsupplierManager")
@WebService(serviceName = "MstsupplierService", endpointInterface = "com.excelsoft.service.MstsupplierManager")
public class MstsupplierManagerImpl extends GenericManagerImpl<Mstsupplier, MstsupplierId> implements MstsupplierManager {
    MstsupplierDao mstsupplierDao;

    @Autowired
    public MstsupplierManagerImpl(MstsupplierDao mstsupplierDao) {
        super(mstsupplierDao);
        this.mstsupplierDao = mstsupplierDao;
    }

	@Override
	public List<String> getAllid(String location) {
		return this.mstsupplierDao.getAllid(location);
	}
	@Override
	public List<Mstsupplier> getAll() {
		return this.mstsupplierDao.getAll();
	}
	@Override
	public Mstsupplier get(String compCode, String suppCode) {
		MstsupplierId id=new MstsupplierId(compCode, suppCode);
		return this.mstsupplierDao.get(id);
	}
	@Override
	public Mstsupplier get(MstsupplierId id) {
		return this.mstsupplierDao.get(id);
	}

	@Override
	public List<Mstsupplier> getAllq(String location,String q) {
		return  this.mstsupplierDao.getAllq(location,q);
	}


	@Override
	public List<Mstsupplier> getAll(String location) {
		return this.mstsupplierDao.getAll(location);
	}
}