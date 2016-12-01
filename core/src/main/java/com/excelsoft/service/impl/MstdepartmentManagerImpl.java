package com.excelsoft.service.impl;

import com.excelsoft.dao.MstdepartmentDao;
import com.excelsoft.model.Mstdepartment;
import com.excelsoft.service.MstdepartmentManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstdepartmentManager")
@WebService(serviceName = "MstdepartmentService", endpointInterface = "com.excelsoft.service.MstdepartmentManager")
public class MstdepartmentManagerImpl extends GenericManagerImpl<Mstdepartment, String> implements MstdepartmentManager {
    MstdepartmentDao mstdepartmentDao;

    @Autowired
    public MstdepartmentManagerImpl(MstdepartmentDao mstdepartmentDao) {
        super(mstdepartmentDao);
        this.mstdepartmentDao = mstdepartmentDao;
    }
}