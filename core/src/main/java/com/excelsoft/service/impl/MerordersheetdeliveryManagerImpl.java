package com.excelsoft.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MerordersheetdeliveryDao;
import com.excelsoft.model.Merordersheetdelivery;
import com.excelsoft.model.MerordersheetdeliveryId;
import com.excelsoft.service.MerordersheetdeliveryManager;

@Service("merordersheetdeliveryManager")
@WebService(serviceName = "MerordersheetdeliveryService", endpointInterface = "com.excelsoft.service.MerordersheetdeliveryManager")
public class MerordersheetdeliveryManagerImpl extends GenericManagerImpl<Merordersheetdelivery, MerordersheetdeliveryId> implements MerordersheetdeliveryManager {
    MerordersheetdeliveryDao merordersheetdeliveryDao;

    @Autowired
    public MerordersheetdeliveryManagerImpl(MerordersheetdeliveryDao merordersheetdeliveryDao) {
        super(merordersheetdeliveryDao);
        this.merordersheetdeliveryDao = merordersheetdeliveryDao;
    }
}