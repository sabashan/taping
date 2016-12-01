package com.excelsoft.service.impl;

import com.excelsoft.dao.MerordersheetgroupcolorDao;
import com.excelsoft.model.Merordersheetgroupcolor;
import com.excelsoft.model.MerordersheetgroupcolorId;
import com.excelsoft.service.MerordersheetgroupcolorManager;
import com.excelsoft.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.jws.WebService;

@Service("merordersheetgroupcolorManager")
@WebService(serviceName = "MerordersheetgroupcolorService", endpointInterface = "com.excelsoft.service.MerordersheetgroupcolorManager")
public class MerordersheetgroupcolorManagerImpl extends GenericManagerImpl<Merordersheetgroupcolor, MerordersheetgroupcolorId> implements MerordersheetgroupcolorManager {
    MerordersheetgroupcolorDao merordersheetgroupcolorDao;

    @Autowired
    public MerordersheetgroupcolorManagerImpl(MerordersheetgroupcolorDao merordersheetgroupcolorDao) {
        super(merordersheetgroupcolorDao);
        this.merordersheetgroupcolorDao = merordersheetgroupcolorDao;
    }
}