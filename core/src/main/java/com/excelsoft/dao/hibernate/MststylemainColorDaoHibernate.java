package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.MststylemainColor;
import com.excelsoft.model.MststylemainColorId;
import com.excelsoft.dao.MststylemainColorDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository("mststylemainColorDao")
public class MststylemainColorDaoHibernate extends
		GenericDaoHibernate<MststylemainColor, MststylemainColorId> implements
		MststylemainColorDao {

	public MststylemainColorDaoHibernate() {
		super(MststylemainColor.class);
	}

	
	@Override
	public List<MststylemainColor> getAll(Mststyleheader mststyleheader) {
	
		return getSession()
				.createQuery("from MststylemainColor c where c.mststyleheader =:mststyleheader ")
				.setParameter("mststyleheader", mststyleheader).list();     
	}

	@Override
	public List<String> getAllStrings(Mststyleheader mststyleheader) {
		return getSession()
				.createQuery("select distinct c.id.mainColor from MststylemainColor c where c.mststyleheader =:mststyleheader ")
				.setParameter("mststyleheader", mststyleheader).list(); 
	}
	
	@Override
	public List<String> getcode() {
		return getSession()
				.createQuery("select distinct c.id.mainColor from MststylemainColor c ")
				.list(); 
	}


	@Override
	public List<String> getAllStrings(String location, String buyer,
			String department, String style, String company) {
		return getSession()
				.createQuery("select distinct c.id.mainColor from MststylemainColor c where "
						+ "c.id.styleId =:styleId and"
						+ " c.id.locationCode =:locationCode and"
						+ " c.id.custCode =:custCode and "
						+ " c.id.depCode =:depCode ")
				.setParameter("styleId", style)
				.setParameter("locationCode", location)
				.setParameter("custCode", buyer)
				.setParameter("depCode", department).list(); 
		
	}


	@Override
	public List<MststylemainColor> getAll(MststyleheaderId id) {
		return getSession()
				.createQuery("from MststylemainColor c where c.mststyleheader.id =:id ")
				.setParameter("id", id).list();  
	}
	
	@Override
	public List<MststylemainColor> getAll(String location, String buyer,
	String department, String style, String company, String query) {
		if(query.equals("NOT")){
		return getSession()
				.createQuery("from MststylemainColor c where "
						+ "c.id.styleId =:styleId and"
						+ " c.id.locationCode =:locationCode and"
						+ " c.id.custCode =:custCode and "
						+ " c.id.depCode =:depCode ")
				.setParameter("styleId", style)
				.setParameter("locationCode", location)
				.setParameter("custCode", buyer)
				.setParameter("depCode", department).list();  
		}
		else{
			Long longquery=(long) 0;
			try {
				longquery=new Long(query);
			} catch (Exception e) {
				longquery=(long) 0;
			}
			return getSession()
					.createQuery("from MststylemainColor c where "
							+ "c.id.styleId =:styleId and"
							+ " c.id.locationCode =:locationCode and"
							+ " c.id.custCode =:custCode and "
							+ " c.id.depCode =:depCode And ("
							+ " c.packQty like:longquery or"
							+ " c.id.styleId like:query and"
							+ " c.id.locationCode like:query and"
							+ " c.id.custCode like:query and "
							+ " c.id.depCode like:query or "
							+ " c.id.mainColor like:query "
							+ ")")
					.setParameter("styleId", style)
					.setParameter("locationCode", location)
					.setParameter("custCode", buyer)
					.setParameter("depCode", department)
					.setParameter("query", "%"+query+"%")
					.setParameter("longquery", longquery).list(); 
		}
	}
	
}
