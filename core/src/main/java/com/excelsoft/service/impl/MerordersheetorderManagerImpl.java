package com.excelsoft.service.impl;

import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excelsoft.dao.MerordersheetorderDao;
import com.excelsoft.model.Merordersheetorder;
import com.excelsoft.model.MerordersheetorderId;
import com.excelsoft.service.MerordersheetorderManager;

@Service("merordersheetorderManager")
@WebService(serviceName = "MerordersheetorderService", endpointInterface = "com.excelsoft.service.MerordersheetorderManager")
public class MerordersheetorderManagerImpl extends GenericManagerImpl<Merordersheetorder, MerordersheetorderId> implements MerordersheetorderManager {
    MerordersheetorderDao merordersheetorderDao;

    @Autowired
    public MerordersheetorderManagerImpl(MerordersheetorderDao merordersheetorderDao) {
        super(merordersheetorderDao);
        this.merordersheetorderDao = merordersheetorderDao;
    }
}