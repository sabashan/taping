package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.Mercostsheetsmv;
import com.excelsoft.model.MercostsheetsmvId;
import com.excelsoft.dao.MercostsheetsmvDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mercostsheetsmvDao")
@SuppressWarnings("unchecked")
public class MercostsheetsmvDaoHibernate extends GenericDaoHibernate<Mercostsheetsmv, MercostsheetsmvId> implements MercostsheetsmvDao {
	private String orderby=" ORDER BY s.styleRouteId.componentId ASC";
    public MercostsheetsmvDaoHibernate() {
        super(Mercostsheetsmv.class);
    }
    

public List<Mercostsheetsmv> getAll(Mercostsheethdr mercostsheethdr){
    	
    	return getSession().createQuery("from Mercostsheetsmv s INNER JOIN fetch  s.styleRouteId r where s.mercostsheethdr=:mercostsheethdr " +orderby)
    			.setParameter("mercostsheethdr", mercostsheethdr)
    			.list();
    }
}
