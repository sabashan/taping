package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mstlocation;
import com.excelsoft.dao.MstlocationDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository("mstlocationDao")
public class MstlocationDaoHibernate extends GenericDaoHibernate<Mstlocation, String> implements MstlocationDao {

    public MstlocationDaoHibernate() {
        super(Mstlocation.class);
    }

	
	@Override
	public List<String> getcode() {
		return  getSession().
				createQuery("select distinct  s.locationCode from Mstlocation s").list();
		
	}


	@Override
	public Object get(String Id, String field) {
		return  getSession().
				createQuery("select distinct  s."+field+"  from Mstlocation s where s.locationCode=:locationCode").setParameter("locationCode", Id).uniqueResult();
	}
}
