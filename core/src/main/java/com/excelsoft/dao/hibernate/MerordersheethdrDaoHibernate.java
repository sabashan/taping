package com.excelsoft.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.excelsoft.model.Merordersheethdr;
import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.MerordersheethdrDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.apache.cxf.common.util.StringUtils;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

@Repository("merordersheethdrDao")
@SuppressWarnings("unchecked")
public class MerordersheethdrDaoHibernate extends GenericDaoHibernate<Merordersheethdr, MerordersheethdrId> implements MerordersheethdrDao {
			
	String status="Incomplete";
	final String orderby="  ORDER BY o.id.planingOrdersheetNo ASC";
    public MerordersheethdrDaoHibernate() {
        super(Merordersheethdr.class);
    }

	
	@Override
	public List<Merordersheethdr> getAll(String query,
			Mststyleheader mststyleheader) {
		if(query.equals("NOT")){
			return getSession().createQuery("FROM Merordersheethdr o WHERE  o.status!='"+status+"' and o.mststyleheader =:mststyleheader "+orderby).
					setParameter("mststyleheader", mststyleheader).list();
		}
		else{
			return getSession().createQuery("FROM Merordersheethdr o WHERE  o.status!='"+status+"' and o.mststyleheader =:mststyleheader and ("+getLike()+")" +orderby).
				setParameter("mststyleheader", mststyleheader).
				setParameter("query", query).
				setParameter("lquery",ConvertUtil.getlongs(query)).list();
		}
	}

	@Override
	public List<Merordersheethdr> getAll(String query, String status) {
		if(query.equals("NOT")){
			return getSession().createQuery("FROM Merordersheethdr o WHERE o.status =:status" +orderby).
					setParameter("status", status).list();
		}
		else{
			return getSession().createQuery("FROM Merordersheethdr o WHERE o.status =:status and ("+getLike()+")" +orderby).
				setParameter("status", status).
				setParameter("query",query).
				setParameter("lquery",ConvertUtil.getlongs(query)).list();
		}
	}
	
	@Override
	public List<Merordersheethdr> getAll(String query, String status,
			String userid) {
		
		if(query.equals("NOT")){
			return getSession().createQuery("FROM Merordersheethdr o WHERE  o.status=:status and ( o.createdBy =:userid or o.modifiedBy =:userid) " +orderby).
					setParameter("status", status).
					setParameter("userid", userid).list();
		}
		else{
			return getSession().createQuery("FROM Merordersheethdr o WHERE  o.status=:status and ( o.createdBy =:userid or o.modifiedBy =:userid) and ("+getLike()+")" +orderby).
				setParameter("status", status).
				setParameter("query", query).
				setParameter("userid", userid).
				setParameter("lquery",ConvertUtil.getlongs(query)).list();
		}
	}
	@Override
	public List<Merordersheethdr> getAll(String query,
			Mststyleheader mststyleheader, Boolean isProcess) {
		if(query.equals("NOT")){
			return getSession().createQuery("FROM Merordersheethdr o WHERE o.isProcess=:isProcess and  o.status!='"+status+"' and o.mststyleheader =:mststyleheader "+orderby).
					setParameter("mststyleheader", mststyleheader).
					setParameter("isProcess", isProcess).list();
		}
		else{
			return getSession().createQuery("FROM Merordersheethdr o WHERE  o.isProcess=:isProcess and o.status!='"+status+"' and o.mststyleheader =:mststyleheader and ("+getLike()+") "+orderby).
				setParameter("mststyleheader", mststyleheader).
				setParameter("query", query).
				setParameter("isProcess", isProcess).
				setParameter("lquery",ConvertUtil.getlongs(query)).list();
		}
	}


	@Override
	public List<Merordersheethdr> getAll(String query, String status,
			String userid, Boolean isProcess) {
		if(query.equals("NOT")){
			return getSession().createQuery("FROM Merordersheethdr o WHERE o.isProcess=:isProcess and o.status=:status and ( o.createdBy =:userid or o.modifiedBy =:userid) "+orderby).
					setParameter("status", status).
					setParameter("isProcess", isProcess).
					setParameter("userid", userid).list();
		}
		else{
			return getSession().createQuery("FROM Merordersheethdr o WHERE  o.isProcess=:isProcess and o.status=:status and ( o.createdBy =:userid or o.modifiedBy =:userid) and ("+getLike()+") " +orderby).
				setParameter("status", status).
				setParameter("query", query).
				setParameter("userid", userid).
				setParameter("isProcess", isProcess).
				setParameter("lquery",ConvertUtil.getlongs(query)).list();
		}
	}
	


	@Override
	public List<String> GetByid(String custCode, String locationCode,
			String depCode, String styleId, String compCode, String season) {
				return getSession().createQuery("select o.id.planingOrdersheetNo from Merordersheethdr o where o.status != '"+status+"' " 
				+ "and o.mststyleheader.id.styleId=:styleId and o.mststyleheader.id.locationCode=:locationCode "
				+ "and o.mststyleheader.id.compCode=:compCode and o.mststyleheader.id.depCode=:depCode "
				+ "and o.mststyleheader.id.custCode=:custCode "
				+ "and o.season=:season " +orderby)
				.setParameter("locationCode", locationCode)
				.setParameter("compCode", compCode)
				.setParameter("depCode", depCode)
				.setParameter("custCode", custCode)
				.setParameter("styleId", styleId)
				.setParameter("season", season)
				.list();
	}


	@Override
	public List<Merordersheethdr> getAll(String compCode, String locationCode,
			String custCode, String depCode, String styleId, String season,
			String query) {
		
		List<Merordersheethdr> list = new ArrayList<Merordersheethdr>();
		log.debug(compCode);
		log.debug(locationCode);
		log.debug(custCode);
		log.debug(depCode);
		log.debug(styleId);
		log.debug(season);
		
		BigDecimal lquery;
        String sql ="from Merordersheethdr o where o.status !='"+status+"' ";
        
     try{
		if(!compCode.equals("NOT")){
			sql+= " and o.mststyleheader.id.compCode='"+compCode+"'";
			log.debug(sql);
		                           }		
		
		if( !custCode.equals("NOT")){
			sql+=" and o.mststyleheader.id.custCode='"+custCode+"'";
			log.debug(sql);
		}
		
		if(!locationCode.equals("NOT")){
			
			sql+=" and o.mststyleheader.id.locationCode='"+locationCode+"'";
			log.debug(sql);
		}
		
       if(!depCode.equals("NOT")){
			
    	   sql+=" and o.mststyleheader.id.depCode='"+depCode+"'";
    	   log.debug(sql);
		}
        
       
       if(!styleId.equals("NOT")){
			
    	   sql+=" and o.mststyleheader.id.styleId='"+styleId+"'";
    	   log.debug(sql);
		}   
		
					
		if(!season.equals("NOT")){
				sql+=" and o.season='"+season+"'";
				log.debug(sql);
				                 }
							
		if (query.equals("NOT")) {
			log.debug(" from Merordersheethdr o where o.status !='"+status+"' "+ orderby);
			return getSession().createQuery(sql + orderby).list();			
		             }	
		
		else{
			log.debug(sql);
			try{
				lquery= ConvertUtil.getDecimal(query);
				log.debug(sql);
				}
				catch(Exception e){
					log.debug(sql);
					lquery= ConvertUtil.getDecimal("0");
				}
			log.debug(sql+" and ("+getLike()+")"+ orderby);
			return getSession().createQuery(sql+" and ("+getLike()+")"+ orderby)
					.setParameter("query","%"+query+"%")
					.setParameter("lquery",lquery.toString())
					.list();
			
		}	  
}

catch(Exception e){
	log.debug(e);
	log.debug(e.getMessage());
	return list;
	
}

	}	

	
	private String getLike(){
		
		String like="";
		like +=" o.id.planingOrdersheetNo like :lquery or ";	    
		like +=" o.mststyleheader.id.styleId like :query or ";
	    like +=" o.mststyleheader.id.locationCode like :query or ";
	    like +=" o.mststyleheader.id.depCode like :query or ";
	    like +=" o.mststyleheader.id.compCode like :query or ";
	    like +=" o.mststyleheader.id.custCode like :query ";
	    
	    
		return like;
	}
	  	
}
