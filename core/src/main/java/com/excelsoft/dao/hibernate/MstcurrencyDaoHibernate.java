package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mstcurrency;
import com.excelsoft.dao.MstcurrencyDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mstcurrencyDao")
@SuppressWarnings("unchecked")
public class MstcurrencyDaoHibernate extends GenericDaoHibernate<Mstcurrency, String> implements MstcurrencyDao {

    public MstcurrencyDaoHibernate() {
        super(Mstcurrency.class);
    }
    
   
	public List<String> getAllid(){
    	return getSession().createQuery("select c.curCode  from Mstcurrency c").list();
    }
    
    
    
    
    
}
