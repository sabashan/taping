package com.excelsoft.service.impl;

import com.excelsoft.dao.MerordersheetgroupDao;
import com.excelsoft.model.Merordersheetgroup;
import com.excelsoft.model.MerordersheetgroupId;
import com.excelsoft.service.MerordersheetgroupManager;
import com.excelsoft.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.jws.WebService;

@Service("merordersheetgroupManager")
@WebService(serviceName = "MerordersheetgroupService", endpointInterface = "com.excelsoft.service.MerordersheetgroupManager")
public class MerordersheetgroupManagerImpl extends GenericManagerImpl<Merordersheetgroup, MerordersheetgroupId> implements MerordersheetgroupManager {
    MerordersheetgroupDao merordersheetgroupDao;

    @Autowired
    public MerordersheetgroupManagerImpl(MerordersheetgroupDao merordersheetgroupDao) {
        super(merordersheetgroupDao);
        this.merordersheetgroupDao = merordersheetgroupDao;
    }
}