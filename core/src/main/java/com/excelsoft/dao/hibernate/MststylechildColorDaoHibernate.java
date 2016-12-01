package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.MststylechildColor;
import com.excelsoft.model.MststylechildColorId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.dao.MststylechildColorDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mststylechildColorDao")
public class MststylechildColorDaoHibernate extends GenericDaoHibernate<MststylechildColor, MststylechildColorId> implements MststylechildColorDao {

    public MststylechildColorDaoHibernate() {
        super(MststylechildColor.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<MststylechildColor> getAll(Mststyleheader mststyleheader) {
		return getSession()
				.createQuery("from MststylechildColor c where c.mststyleheader =:mststyleheader ")
				.setParameter("mststyleheader", mststyleheader).list();    
	}
    
    
    
}
