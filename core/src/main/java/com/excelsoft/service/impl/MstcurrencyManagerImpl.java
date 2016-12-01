package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MstcurrencyDao;
import com.excelsoft.model.Mstcurrency;
import com.excelsoft.service.MstcurrencyManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstcurrencyManager")
@WebService(serviceName = "MstcurrencyService", endpointInterface = "com.excelsoft.service.MstcurrencyManager")
public class MstcurrencyManagerImpl extends GenericManagerImpl<Mstcurrency, String> implements MstcurrencyManager {
    MstcurrencyDao mstcurrencyDao;

    @Autowired
    public MstcurrencyManagerImpl(MstcurrencyDao mstcurrencyDao) {
        super(mstcurrencyDao);
        this.mstcurrencyDao = mstcurrencyDao;
    }
    
   
    @Override
    public Mstcurrency get(String id){
    	return  this.mstcurrencyDao.get(id);
    }
    
    
    @Override
    public List<Mstcurrency> getAll(){
    	return  this.mstcurrencyDao.getAll();
    }

    public List<String> getAllid(){
    	return  this.mstcurrencyDao.getAllid();
    }
    
  
    public List<Mstcurrency> getAll(String Query){
    	return  this.mstcurrencyDao.getFildsearch(Query);
    }
}