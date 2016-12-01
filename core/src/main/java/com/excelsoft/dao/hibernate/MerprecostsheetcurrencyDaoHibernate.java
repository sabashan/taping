package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Merprecostsheetcurrency;
import com.excelsoft.model.MerprecostsheetcurrencyId;
import com.excelsoft.dao.MerprecostsheetcurrencyDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merprecostsheetcurrencyDao")
@SuppressWarnings("unchecked")
public class MerprecostsheetcurrencyDaoHibernate extends GenericDaoHibernate<Merprecostsheetcurrency, MerprecostsheetcurrencyId> implements MerprecostsheetcurrencyDao {

    public MerprecostsheetcurrencyDaoHibernate() {
        super(Merprecostsheetcurrency.class);
    }
    
    
	public List< Merprecostsheetcurrency> getAll(Merprecostsheet merprecostsheet ){
    	return getSession().createQuery("from Merprecostsheetcurrency c where c.merprecostsheet=:merprecostsheet")
    			.setParameter("merprecostsheet", merprecostsheet)
    			.list();
    }
}
