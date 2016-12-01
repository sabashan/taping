package com.excelsoft.dao.hibernate;

import java.util.Date;
import java.util.List;

import com.excelsoft.model.Mstsmvvoulmerates;
import com.excelsoft.model.MstsmvvoulmeratesId;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.util.DateUtil;
import com.excelsoft.dao.MstsmvvoulmeratesDao;

import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository("mstsmvvoulmeratesDao")
public class MstsmvvoulmeratesDaoHibernate extends GenericDaoHibernate<Mstsmvvoulmerates, MstsmvvoulmeratesId> implements MstsmvvoulmeratesDao {

    public MstsmvvoulmeratesDaoHibernate() {
        super(Mstsmvvoulmerates.class);
    }
    
	@Override
	public List<Object> getAll(String buyerCode, String d_Dates,String smvCode,String Volume) {
		Date d_Date= DateUtil.getdate(d_Dates); 
		log.debug("select DISTINCT s.smvValue from Mstsmvvoulmerates s where s.id.smvCode='"+smvCode+"' and s.id.fromVolume< "+Volume+" and s.toVolume> "+Volume+" and   s.id.buyerCode='"+buyerCode+"' and  s.id.fromDate<'"+d_Date+"' and  s.id.toDate>'"+d_Date+"'");
		return getSession().createQuery("from Mstsmvvoulmerates s where "
				+ "s.id.smvCode=:smvCode and  "
				+ "s.id.fromVolume< :Volume and "
				+ "s.id.toVolume> :Volume and "
				+ "s.id.buyerCode=:buyerCode and "
				+ "s.id.fromDate<:d_Date and "
				+ "s.id.toDate>:d_Date").
		setParameter("buyerCode", buyerCode).
		setParameter("smvCode", smvCode).
		setParameter("Volume", ConvertUtil.getDecimal(Volume)).
		setParameter("d_Date", d_Date).list();
		 
	}
}
