package com.excelsoft.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.excelsoft.dao.MstsmvratesDao;
import com.excelsoft.model.Mstsmvrates;
import com.excelsoft.model.MstsmvratesId;
import com.excelsoft.service.MstsmvratesManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstsmvratesManager")
@WebService(serviceName = "MstsmvratesService", endpointInterface = "com.excelsoft.service.MstsmvratesManager")
public class MstsmvratesManagerImpl extends GenericManagerImpl<Mstsmvrates, MstsmvratesId> implements MstsmvratesManager {
    MstsmvratesDao mstsmvratesDao;

    @Autowired
    public MstsmvratesManagerImpl(MstsmvratesDao mstsmvratesDao) {
        super(mstsmvratesDao);
        this.mstsmvratesDao = mstsmvratesDao;
    }
    
    @Override
    public Mstsmvrates get(MstsmvratesId id){
    	return  this.mstsmvratesDao.get(id);
    }
    @Override
	public Mstsmvrates get(String buyerCode, String smvCode, Date fromDate,Date toDate ){
		MstsmvratesId id=new MstsmvratesId(buyerCode, smvCode, fromDate, toDate);
		return  this.mstsmvratesDao.get(id);
	}
	
    @Override
	public Mstsmvrates get(String buyerCode, String smvCode, String tmonth,
			String tdate, String tyear, String fmonth, String fdate,
			String fyear){
		Date dtoDate = new Date();
		Date dfromDate = new Date();
		try {
			dtoDate = new SimpleDateFormat("yyyy/mm/dd").parse(tyear+"/"+tmonth+"/"+tdate);
			dfromDate = new SimpleDateFormat("yyyy/mm/dd").parse(fyear+"/"+fmonth+"/"+fdate);
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		
		MstsmvratesId id=new MstsmvratesId(buyerCode, smvCode, dfromDate, dtoDate);
		return  this.mstsmvratesDao.get(id);
	}
    @Override
	public List<Mstsmvrates>getAll(){
		return  this.mstsmvratesDao.getAll();
	}
	
    @Override
	public List<Object> getAll(String buyerCode, String month,
			String date, String year){
		return  this.mstsmvratesDao.getAll(buyerCode, year+"-"+month+"-"+date);
	}

	@Override
	public List<Object> getAll(String buyerCode, String month, String date,
			String year, String fmv) {
		return  this.mstsmvratesDao.getAll(buyerCode, year+"-"+month+"-"+date,fmv);
	}

	
}