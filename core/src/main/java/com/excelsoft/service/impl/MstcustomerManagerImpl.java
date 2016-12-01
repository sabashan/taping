package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MstcustomerDao;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.service.MstcustomerManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstcustomerManager")
@WebService(serviceName = "MstcustomerService", endpointInterface = "com.excelsoft.service.MstcustomerManager")
public class MstcustomerManagerImpl extends GenericManagerImpl<Mstcustomer, String> implements MstcustomerManager {
    MstcustomerDao mstcustomerDao;

    @Autowired
    public MstcustomerManagerImpl(MstcustomerDao mstcustomerDao) {
        super(mstcustomerDao);
        this.mstcustomerDao = mstcustomerDao;
    }
    
    public Mstcustomer get(String id){
    return	mstcustomerDao.get(id);
    }
    
    public List< Mstcustomer> getAll(){
    	return mstcustomerDao.getAll();
    }

	@Override
	public List<String> getCustomerCode() {
		return mstcustomerDao.getCustomerCode();
	}

	@Override
	public List<Mstcustomer> getCustomerCodeq(String query) {
		
		return mstcustomerDao.getCustomerCodeq(query);
	}
}