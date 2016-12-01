package com.excelsoft.service.impl;

import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excelsoft.dao.MerordersheetdemDao;
import com.excelsoft.model.Merordersheetdem;
import com.excelsoft.model.MerordersheetdemId;
import com.excelsoft.service.MerordersheetdemManager;

@Service("merordersheetdemManager")
@WebService(serviceName = "MerordersheetdemService", endpointInterface = "com.excelsoft.service.MerordersheetdemManager")
public class MerordersheetdemManagerImpl extends GenericManagerImpl<Merordersheetdem, MerordersheetdemId> implements MerordersheetdemManager {
    MerordersheetdemDao merordersheetdemDao;

    @Autowired
    public MerordersheetdemManagerImpl(MerordersheetdemDao merordersheetdemDao) {
        super(merordersheetdemDao);
        this.merordersheetdemDao = merordersheetdemDao;
    }
}