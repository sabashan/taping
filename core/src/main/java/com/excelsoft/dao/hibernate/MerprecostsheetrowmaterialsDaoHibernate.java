package com.excelsoft.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Merprecostsheetrowmaterials;
import com.excelsoft.model.MerprecostsheetrowmaterialsId;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.MerprecostsheetrowmaterialsDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merprecostsheetrowmaterialsDao")
@SuppressWarnings("unchecked")
public class MerprecostsheetrowmaterialsDaoHibernate extends GenericDaoHibernate<Merprecostsheetrowmaterials, MerprecostsheetrowmaterialsId> implements MerprecostsheetrowmaterialsDao {

    public MerprecostsheetrowmaterialsDaoHibernate() {
        super(Merprecostsheetrowmaterials.class);
    }

	
	@Override
	public List<Merprecostsheetrowmaterials> getAll(
			Merprecostsheet merprecostsheet) {
		return getSession().createQuery("FROM  Merprecostsheetrowmaterials r WHERE r.merprecostsheet=:merprecostsheet")
			.setParameter("merprecostsheet", merprecostsheet).list();
	}
	
	@Override
	public List<Merprecostsheetrowmaterials> getAll(
			Merprecostsheet merprecostsheet,String category) {
		return getSession().createQuery("FROM  Merprecostsheetrowmaterials r "
				+ "INNER JOIN fetch  Mstitemtype i  WHERE "
				+ "r.merprecostsheet=:merprecostsheet  and i.category=:category")
			.setParameter("merprecostsheet", merprecostsheet)
			.setParameter("category", category).list();
	}

	@Override
	public List<Merprecostsheetrowmaterials> getAll(
			MerprecostsheetId merprecostsheetid, String category) {
		return getSession().createQuery("FROM  Merprecostsheetrowmaterials r INNER JOIN fetch  r.mstitem i "
				+ "where r.mstitem.mstitemtype.category=:category  and r.id.costsheetType=:costsheetType and r.id.preCostSheetNo=:preCostSheetNo and r.id.versionNo=:versionNo")
				.setParameter("preCostSheetNo", merprecostsheetid.getPreCostSheetNo())
				.setParameter("versionNo", merprecostsheetid.getVersionNo())
				.setParameter("costsheetType", merprecostsheetid.getCostsheetType())
				.setParameter("category", category).list();
	}
	@Override
	public Merprecostsheetrowmaterials get(MerprecostsheetrowmaterialsId id) {
		return (Merprecostsheetrowmaterials) getSession().createQuery("FROM  Merprecostsheetrowmaterials r INNER JOIN fetch  r.mstitem i "
				+ "where r.id=:id ")
				.setParameter("id", id).uniqueResult();
	}
	@Override
	public List<Object> getAllCost(
			MerprecostsheetId merprecostsheetid, String category,String fld) {
		String string=""; 
		if(fld.equals("NOT")){
			fld="";
			string="INNER JOIN fetch  r.mstitem i ";
		}
		else{
			fld="select  r."+fld;
		}
		log.debug(""+fld+" FROM  Merprecostsheetrowmaterials r "+string
					+ "where  r.id.costsheetType=:"+ merprecostsheetid.getCostsheetType()+" and r.id.preCostSheetNo=:"+merprecostsheetid.getPreCostSheetNo()+" and r.id.versionNo=:"+merprecostsheetid.getVersionNo());
		if(category.equals("NOT")){
			return getSession().createQuery(""+fld+" FROM  Merprecostsheetrowmaterials r "+string
					+ "where  r.id.costsheetType=:costsheetType and r.id.preCostSheetNo=:preCostSheetNo and r.id.versionNo=:versionNo")
					.setParameter("preCostSheetNo", merprecostsheetid.getPreCostSheetNo())
					.setParameter("versionNo", merprecostsheetid.getVersionNo())
					.setParameter("costsheetType", merprecostsheetid.getCostsheetType())
					.list();
		}
		else{
			return getSession().createQuery(""+fld+" FROM  Merprecostsheetrowmaterials r "+string
					+ "where r.mstitem.mstitemtype.category=:category  and r.id.costsheetType=:costsheetType and r.id.preCostSheetNo=:preCostSheetNo and r.id.versionNo=:versionNo")
					.setParameter("preCostSheetNo", merprecostsheetid.getPreCostSheetNo())
					.setParameter("versionNo", merprecostsheetid.getVersionNo())
					.setParameter("costsheetType", merprecostsheetid.getCostsheetType())
					.setParameter("category", category).list();
		}
		
	}

	@Override
	public BigDecimal getNext(Merprecostsheet merprecostsheet) {
		 List  <BigDecimal>code = getSession().createQuery("select id.precostsheetRowMatCode FROM  Merprecostsheetrowmaterials r WHERE r.merprecostsheet=:merprecostsheet")
				.setParameter("merprecostsheet", merprecostsheet).list();
		 if(code.size()>0)
			 return  code.get(code.size()-1);
		 else
			 return ConvertUtil.getDecimal("0"); 
	}

	
	@Override
	public List<Merprecostsheetrowmaterials> getAllShell(
			Merprecostsheet merprecostsheet, String category) {
		return getSession().createQuery(" FROM  Merprecostsheetrowmaterials r INNER JOIN fetch  r.mstitem i"
				+ " WHERE r.merprecostsheet=:merprecostsheet and r.isshellfabric=true and r.mstitem.mstitemtype.category=:category ")
			.setParameter("merprecostsheet", merprecostsheet)
			.setParameter("category", category).list();
	}


	@Override
	public List<Merprecostsheetrowmaterials> getAll(
			Merprecostsheet merprecostsheet, String category, String Itemtype,
			String Itemcode) {
		return getSession().createQuery("FROM  Merprecostsheetrowmaterials r INNER JOIN fetch  r.mstitem i"
				+ " WHERE r.merprecostsheet=:merprecostsheet and r.mstitem.mstitemtype.category=:category "
				+ "and r.mstitem.id.itemType=:itemType and r.mstitem.id.itemCode=:itemCode ")
			.setParameter("merprecostsheet", merprecostsheet)
			.setParameter("category", category)
			.setParameter("itemType", Itemtype)
			.setParameter("itemCode", Itemcode).list();
	}
}
