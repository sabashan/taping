package com.excelsoft.service.impl;

import com.excelsoft.dao.MststylewippointitemtypeDao;
import com.excelsoft.model.Mststylewippointitemtype;
import com.excelsoft.model.MststylewippointitemtypeId;
import com.excelsoft.service.MststylewippointitemtypeManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mststylewippointitemtypeManager")
@WebService(serviceName = "MststylewippointitemtypeService", endpointInterface = "com.excelsoft.service.MststylewippointitemtypeManager")
public class MststylewippointitemtypeManagerImpl extends GenericManagerImpl<Mststylewippointitemtype, MststylewippointitemtypeId> implements MststylewippointitemtypeManager {
    MststylewippointitemtypeDao mststylewippointitemtypeDao;

    @Autowired
    public MststylewippointitemtypeManagerImpl(MststylewippointitemtypeDao mststylewippointitemtypeDao) {
        super(mststylewippointitemtypeDao);
        this.mststylewippointitemtypeDao = mststylewippointitemtypeDao;
    }

	@Override
	public List<Mststylewippointitemtype> getAllWippointitemtype() {
		// TODO Auto-generated method stub
		return this.mststylewippointitemtypeDao.getAll();
	}

	@Override
	public List<Mststylewippointitemtype> getAllWippointitemtype(String itemType) {
		// TODO Auto-generated method stub
		return this.mststylewippointitemtypeDao.getAllWippointitemtype(itemType);
	}

}