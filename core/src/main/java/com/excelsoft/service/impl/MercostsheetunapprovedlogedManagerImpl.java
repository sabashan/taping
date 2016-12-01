package com.excelsoft.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MercostsheetunapprovedlogedDao;
import com.excelsoft.model.Mercostsheetunapprovedloged;
import com.excelsoft.model.MercostsheetunapprovedlogedId;
import com.excelsoft.service.MercostsheetunapprovedlogedManager;

@Service("mercostsheetunapprovedlogedManager")
@WebService(serviceName = "MercostsheetunapprovedlogedService", endpointInterface = "com.excelsoft.service.MercostsheetunapprovedlogedManager")
public class MercostsheetunapprovedlogedManagerImpl extends GenericManagerImpl<Mercostsheetunapprovedloged, MercostsheetunapprovedlogedId> implements MercostsheetunapprovedlogedManager {
    MercostsheetunapprovedlogedDao mercostsheetunapprovedlogedDao;

    @Autowired
    public MercostsheetunapprovedlogedManagerImpl(MercostsheetunapprovedlogedDao mercostsheetunapprovedlogedDao) {
        super(mercostsheetunapprovedlogedDao);
        this.mercostsheetunapprovedlogedDao = mercostsheetunapprovedlogedDao;
    }
}