package com.excelsoft.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.model.Merordersheetrawmaterial;
import com.excelsoft.model.MerordersheetrawmaterialId;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.MerordersheetrawmaterialDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merordersheetrawmaterialDao")
@SuppressWarnings("unchecked")
public class MerordersheetrawmaterialDaoHibernate extends GenericDaoHibernate<Merordersheetrawmaterial, MerordersheetrawmaterialId> implements MerordersheetrawmaterialDao {

    public MerordersheetrawmaterialDaoHibernate() {
        super(Merordersheetrawmaterial.class);
    }


	@Override
	public List<Merordersheetrawmaterial> getAll(String planingOrdersheetNo,
			String orderType, String category) {
		return getSession().createQuery("FROM  Merordersheetrawmaterial r INNER JOIN fetch  r.mstitemtype i "
				+ "where r.mstitemtype.category=:category  and r.id.planingOrdersheetNo=:planingOrdersheetNo and r.id.orderType=:orderType")
				.setParameter("planingOrdersheetNo", planingOrdersheetNo)
				.setParameter("orderType", orderType)
				.setParameter("category", category).list();
	}
	
	@Override
	public Merordersheetrawmaterial get(MerordersheetrawmaterialId id) {
		return (Merordersheetrawmaterial) getSession().createQuery("FROM  Merordersheetrawmaterial r INNER JOIN fetch  r.mstitemtype i "
				+ "where  r.id=:id")
				.setParameter("id", id).uniqueResult();
	}
	
	
	@Override
	public BigDecimal getNext(MerordersheethdrId id) {
		 List  <BigDecimal>code = getSession().createQuery("select r.id.rowMaterialNo FROM  "
		 		+ "Merordersheetrawmaterial r WHERE "
		 		+ "r.merordersheethdr.id=:id "
		 		+ "ORDER by r.id.rowMaterialNo ASC")
				.setParameter("id", id)
				.list();
		 if(code.size()>0)
			 return  code.get(code.size()-1);
		 else
			 return ConvertUtil.getDecimal("0"); 
	}


	@Override
	public List<Merordersheetrawmaterial> getAll(MerordersheethdrId id) {
		return getSession().createQuery("FROM  "
		 		+ "Merordersheetrawmaterial r INNER JOIN fetch  r.mstitemtype i WHERE "
		 		+ "r.merordersheethdr.id=:id "
		 		+ "ORDER by r.id.rowMaterialNo ASC")
				.setParameter("id", id)
				.list();
	}


	@Override
	public List<Merordersheetrawmaterial> getAll(String planingOrdersheetNo,
			String orderType, String category, String query) {
		return getSession().createQuery("FROM  Merordersheetrawmaterial r INNER JOIN fetch  r.mstitemtype i "
				+ "where r.mstitemtype.category=:category  and r.id.planingOrdersheetNo=:planingOrdersheetNo and r.id.orderType=:orderType and "+ like())
				.setParameter("planingOrdersheetNo", planingOrdersheetNo)
				.setParameter("orderType", orderType)
				.setParameter("query", query)
				.setParameter("lquery",ConvertUtil.getDecimal(query))
				.setParameter("category", category).list();
	}
	
	
	/*

     r.additionalAttribute1 like :query;
     r.additionalAttribute2 like :query;
	r.itemColor like :query;
     r.itemWidth like :query;
     r.itemDescription like :query;
     r.itemCode like :query;
     r.planingOrdersheetNo like :query;
     r.rowMaterialNo like :query;
     r.String orderType like :query;
     r.mstitemtype.itemType like :query;
	 */
	
	public String like() {
		String string= "( r.additionalAttribute1 like :query ";
		string +=" or r.additionalAttribute2 like :query ";
		string +=" or  r.itemColor like :query ";
		string +=" or r.itemWidth like :query " ;
		string +=" or r.itemDescription like :query ";
		string +=" or r.itemCode like :query ";
		string +=" or r.id.planingOrdersheetNo like :query ";
		string +=" or r.id.rowMaterialNo like :lquery ";
		string +=" or r.id.orderType like :query ";
		string += " or r.mstitemtype.itemType like :query )";
		
		return string;
	}
}
