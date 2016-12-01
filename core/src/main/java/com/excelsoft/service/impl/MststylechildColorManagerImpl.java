package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MststylechildColorDao;
import com.excelsoft.model.MststylechildColor;
import com.excelsoft.model.MststylechildColorId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MststylechildColorManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mststylechildColorManager")
@WebService(serviceName = "MststylechildColorService", endpointInterface = "com.excelsoft.service.MststylechildColorManager")
public class MststylechildColorManagerImpl extends GenericManagerImpl<MststylechildColor, MststylechildColorId> implements MststylechildColorManager {
    MststylechildColorDao mststylechildColorDao;

    @Autowired
    public MststylechildColorManagerImpl(MststylechildColorDao mststylechildColorDao) {
        super(mststylechildColorDao);
        this.mststylechildColorDao = mststylechildColorDao;
    }

	@Override
	public List<MststylechildColor> getAll(Mststyleheader mststyleheader) {
		
		return mststylechildColorDao.getAll(mststyleheader);
	}
}