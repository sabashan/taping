package com.excelsoft.service.impl;

import com.excelsoft.dao.MstparameterDao;
import com.excelsoft.model.Mstparameter;
import com.excelsoft.service.MstparameterManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstparameterManager")
@WebService(serviceName = "MstparameterService", endpointInterface = "com.excelsoft.service.MstparameterManager")
public class MstparameterManagerImpl extends GenericManagerImpl<Mstparameter, String> implements MstparameterManager {
    MstparameterDao mstparameterDao;

    @Autowired
    public MstparameterManagerImpl(MstparameterDao mstparameterDao) {
        super(mstparameterDao);
        this.mstparameterDao = mstparameterDao;
    }
}