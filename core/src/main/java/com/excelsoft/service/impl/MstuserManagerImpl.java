package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MstuserDao;
import com.excelsoft.model.Mstuser;
import com.excelsoft.service.MstuserManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstuserManager")
@WebService(serviceName = "MstuserService", endpointInterface = "com.excelsoft.service.MstuserManager")
public class MstuserManagerImpl extends GenericManagerImpl<Mstuser, String> implements MstuserManager {
    MstuserDao mstuserDao;

    @Autowired
    public MstuserManagerImpl(MstuserDao mstuserDao) {
        super(mstuserDao);
        this.mstuserDao = mstuserDao;
    }
    
    @Override
	public List<Mstuser> getAll() {
		return mstuserDao.getAll();
	}
    @Override
	public Mstuser get(String id) {
		return mstuserDao.get(id);
	}
	@Override
	public List<String> getAlluserId() {
		return mstuserDao.getAlluserId();
	}

	@Override
	public List<Mstuser> getAllByq(String query) {
		return mstuserDao.getAllByq(query);
	}
}