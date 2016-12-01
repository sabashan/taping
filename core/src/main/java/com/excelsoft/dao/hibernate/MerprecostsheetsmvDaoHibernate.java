package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Merprecostsheetsmv;
import com.excelsoft.model.MerprecostsheetsmvId;
import com.excelsoft.dao.MerprecostsheetsmvDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merprecostsheetsmvDao")
@SuppressWarnings("unchecked")
public class MerprecostsheetsmvDaoHibernate extends GenericDaoHibernate<Merprecostsheetsmv, MerprecostsheetsmvId> implements MerprecostsheetsmvDao {

    public MerprecostsheetsmvDaoHibernate() {
        super(Merprecostsheetsmv.class);
    }
    
  
	public List<Merprecostsheetsmv> getAll(Merprecostsheet merprecostsheet){
    	
    	return getSession().createQuery("from Merprecostsheetsmv s INNER JOIN fetch  s.styleRouteId r where s.merprecostsheet=:merprecostsheet")
    			.setParameter("merprecostsheet", merprecostsheet)
    			.list();
    }
}
