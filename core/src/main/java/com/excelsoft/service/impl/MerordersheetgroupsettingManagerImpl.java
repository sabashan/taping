package com.excelsoft.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MerordersheetgroupsettingDao;
import com.excelsoft.model.Merordersheetgroupsetting;
import com.excelsoft.model.MerordersheetgroupsettingId;
import com.excelsoft.service.MerordersheetgroupsettingManager;

@Service("merordersheetgroupsettingManager")
@WebService(serviceName = "MerordersheetgroupsettingService", endpointInterface = "com.excelsoft.service.MerordersheetgroupsettingManager")
public class MerordersheetgroupsettingManagerImpl extends GenericManagerImpl<Merordersheetgroupsetting, MerordersheetgroupsettingId> implements MerordersheetgroupsettingManager {
    MerordersheetgroupsettingDao merordersheetgroupsettingDao;

    @Autowired
    public MerordersheetgroupsettingManagerImpl(MerordersheetgroupsettingDao merordersheetgroupsettingDao) {
        super(merordersheetgroupsettingDao);
        this.merordersheetgroupsettingDao = merordersheetgroupsettingDao;
    }
}