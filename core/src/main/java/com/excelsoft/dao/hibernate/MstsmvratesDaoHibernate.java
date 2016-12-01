package com.excelsoft.dao.hibernate;

import java.util.Date;
import java.util.List;

import com.excelsoft.model.Mstsmvrates;
import com.excelsoft.model.MstsmvratesId;
import com.excelsoft.util.DateUtil;
import com.excelsoft.dao.MstsmvratesDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mstsmvratesDao")
@SuppressWarnings("unchecked")
public class MstsmvratesDaoHibernate extends GenericDaoHibernate<Mstsmvrates, MstsmvratesId> implements MstsmvratesDao {

    public MstsmvratesDaoHibernate() {
        super(Mstsmvrates.class);
    }

	
	@Override
	public List<Object> getAll(String buyerCode, String d_Dates) {
		Date d_Date= DateUtil.getdate(d_Dates);
		log.debug("select DISTINCT s.id.smvCode,s.smvValue from Mstsmvrates s where s.id.buyerCode='"+buyerCode+"' and  s.id.fromDate<'"+d_Date+"' and  s.id.toDate>'"+d_Date+"'");
		return getSession().createQuery("select DISTINCT s.id.smvCode,s.smvValue from Mstsmvrates s where "
				+ "s.id.buyerCode=:buyerCode and "
				+ "s.id.fromDate<:d_Date and "
				+ "s.id.toDate>:d_Date").
		setParameter("buyerCode", buyerCode).
		setParameter("d_Date", d_Date).list();
		 
	}


	@Override
	public List<Object> getAll(String buyerCode, String d_Date, String fmv) {
		Date d_Dates= DateUtil.getdate(d_Date);
		log.debug("select smvValue from Mstsmvrates s where s.id.buyerCode='"+buyerCode+"' and s.id.smvCode='"+fmv+"' and  s.id.fromDate<'"+d_Date+"' and  s.id.toDate>'"+d_Date+"'");
		return getSession().createQuery("select DISTINCT s.smvValue from Mstsmvrates s where "
				+ "s.id.buyerCode=:buyerCode and "
				+ "s.id.fromDate<:d_Date and "
				+ "s.id.smvCode=:smvCode and "
				+ "s.id.toDate>:d_Date").
		setParameter("buyerCode", buyerCode).
		setParameter("smvCode", fmv).
		setParameter("d_Date", d_Dates).list();
	}
}
