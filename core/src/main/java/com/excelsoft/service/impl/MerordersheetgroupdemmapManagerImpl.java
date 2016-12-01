package com.excelsoft.service.impl;

import com.excelsoft.dao.MerordersheetgroupdemmapDao;
import com.excelsoft.model.Merordersheetgroupdemmap;
import com.excelsoft.model.MerordersheetgroupdemmapId;
import com.excelsoft.service.MerordersheetgroupdemmapManager;
import com.excelsoft.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.jws.WebService;

@Service("merordersheetgroupdemmapManager")
@WebService(serviceName = "MerordersheetgroupdemmapService", endpointInterface = "com.excelsoft.service.MerordersheetgroupdemmapManager")
public class MerordersheetgroupdemmapManagerImpl extends GenericManagerImpl<Merordersheetgroupdemmap, MerordersheetgroupdemmapId> implements MerordersheetgroupdemmapManager {
    MerordersheetgroupdemmapDao merordersheetgroupdemmapDao;

    @Autowired
    public MerordersheetgroupdemmapManagerImpl(MerordersheetgroupdemmapDao merordersheetgroupdemmapDao) {
        super(merordersheetgroupdemmapDao);
        this.merordersheetgroupdemmapDao = merordersheetgroupdemmapDao;
    }
}