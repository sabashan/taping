package com.excelsoft.dao.hibernate;


import java.util.List;

import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.MststylecomponentId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.dao.MststylecomponentDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository("mststylecomponentDao")
public class MststylecomponentDaoHibernate extends GenericDaoHibernate<Mststylecomponent, MststylecomponentId> implements MststylecomponentDao {
private String orderby="ORDER BY c.id.componentId ASC";
	public MststylecomponentDaoHibernate() {
		super(Mststylecomponent.class);
	}
	
	
	@Override
	public List<Mststylecomponent> getAll(Mststyleheader mststyleheader) {
		
		return getSession()
				.createQuery("from Mststylecomponent c where c.mststyleheader =:mststyleheader "+orderby)
				.setParameter("mststyleheader", mststyleheader).list();     
	}


	@Override
	public List<String> getAllStrings(Mststyleheader mststyleheader) {
		return getSession()
				.createQuery("select distinct c.id.componentId from Mststylecomponent c where c.mststyleheader =:mststyleheader "+orderby)
				.setParameter("mststyleheader", mststyleheader).list(); 
	}
	/*
	 * (non-Javadoc)
	 * @see com.excelsoft.dao.MststylecomponentDao#getAllStrings(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> getAllStrings(String style,String  location,String  department,String  company,String  buyer) {
		return getSession()
				.createQuery("select distinct c.id.componentId from Mststylecomponent c where "
						+ " c.id.styleId =:styleId And"
						+ " c.id.locationCode =:locationCode and"
						+ " c.id.depCode =:depCode and"
						+ " c.id.custCode =:custCode "+orderby)
				.setParameter("styleId", style)
				.setParameter("locationCode", location)
				.setParameter("depCode", department)
				.setParameter("custCode", buyer).list(); 
	}
	
	@Override
	public List<Mststylecomponent> getAll(String style,String  location,String  department,String  company,String  buyer,String query) {
		if(query.equals("NOT")){
			return getSession()
				.createQuery(" from Mststylecomponent c where "
						+ " c.id.styleId =:styleId And"
						+ " c.id.locationCode =:locationCode and"
						+ " c.id.depCode =:depCode and"
						+ " c.id.custCode =:custCode "+orderby)
				.setParameter("styleId", style)
				.setParameter("locationCode", location)
				.setParameter("depCode", department)
				.setParameter("custCode", buyer).list(); 
		}
		else {
			return getSession()
					.createQuery(" from Mststylecomponent c where "
							+ " c.id.styleId =:styleId And"
							+ " c.id.locationCode =:locationCode and"
							+ " c.id.depCode =:depCode and"
							+ " c.id.custCode =:custCode  And ("
								+ " c.id.componentId like:query or "
								+ " c.compRatio like:query or "
								+ " c.productType like:query "
							+ ")" + orderby)
					.setParameter("styleId", style)
					.setParameter("locationCode", location)
					.setParameter("depCode", department)
					.setParameter("custCode", buyer)
					.setParameter("query", "%"+query+"%").list(); 
		}
	}

	@Override
	public List<String> getcode() {
		return getSession()
				.createQuery("select distinct c.id.componentId from Mststylecomponent c "+orderby)
				.list(); 
	}
}
