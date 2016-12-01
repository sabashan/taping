package com.excelsoft.service.impl;

import com.excelsoft.dao.MerordersheetgroupbomDao;
import com.excelsoft.model.Merordersheetgroupbom;
import com.excelsoft.model.MerordersheetgroupbomId;
import com.excelsoft.service.MerordersheetgroupbomManager;
import com.excelsoft.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.jws.WebService;

@Service("merordersheetgroupbomManager")
@WebService(serviceName = "MerordersheetgroupbomService", endpointInterface = "com.excelsoft.service.MerordersheetgroupbomManager")
public class MerordersheetgroupbomManagerImpl extends GenericManagerImpl<Merordersheetgroupbom, MerordersheetgroupbomId> implements MerordersheetgroupbomManager {
    MerordersheetgroupbomDao merordersheetgroupbomDao;

    @Autowired
    public MerordersheetgroupbomManagerImpl(MerordersheetgroupbomDao merordersheetgroupbomDao) {
        super(merordersheetgroupbomDao);
        this.merordersheetgroupbomDao = merordersheetgroupbomDao;
    }
}