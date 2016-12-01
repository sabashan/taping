package com.excelsoft.dao.hibernate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.model.Mercostsheetrowmaterial;
import com.excelsoft.model.MercostsheetrowmaterialId;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.MercostsheetrowmaterialDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mercostsheetrowmaterialDao")
public class MercostsheetrowmaterialDaoHibernate extends GenericDaoHibernate<Mercostsheetrowmaterial, MercostsheetrowmaterialId> implements MercostsheetrowmaterialDao {

    public MercostsheetrowmaterialDaoHibernate() {
        super(Mercostsheetrowmaterial.class);
    }
    
    @Override
    public Mercostsheetrowmaterial get(MercostsheetrowmaterialId id) {
    	return (Mercostsheetrowmaterial) getSession().createQuery("FROM  Mercostsheetrowmaterial r INNER JOIN fetch  r.mstitemtype i "
				+ "where r.id=:id  ")
				.setParameter("id", id).uniqueResult();
	}
    
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetrowmaterial> getAll(
			MercostsheethdrId mercostsheethdrId, String category) {
		return getSession().createQuery("FROM  Mercostsheetrowmaterial r INNER JOIN fetch  r.mstitemtype i "
				+ "where r.mstitemtype.category=:category  and r.id.costSheetType=:costsheetType and r.id.costSheetNo=:costSheetNo and r.id.versionNo=:versionNo")
				.setParameter("costSheetNo", mercostsheethdrId.getCostSheetNo())
				.setParameter("versionNo", mercostsheethdrId.getVersionNo())
				.setParameter("costsheetType", mercostsheethdrId.getCostSheetType())
				.setParameter("category", category).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetrowmaterial> getAll(
			MercostsheethdrId mercostsheethdrId) {
		return getSession().createQuery("FROM  Mercostsheetrowmaterial r INNER JOIN fetch  r.mstitemtype i "
				+ "where r.id.costSheetType=:costsheetType and r.id.costSheetNo=:costSheetNo and r.id.versionNo=:versionNo")
				.setParameter("costSheetNo", mercostsheethdrId.getCostSheetNo())
				.setParameter("versionNo", mercostsheethdrId.getVersionNo())
				.setParameter("costsheetType", mercostsheethdrId.getCostSheetType())
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetrowmaterial> getAllShell(
			Mercostsheethdr mercostsheethdr, String category) {
		return getSession().createQuery(" FROM  Mercostsheetrowmaterial r INNER JOIN fetch  r.mstitemtype i"
				+ " WHERE r.mercostsheetgroup.mercostsheethdr=:mercostsheethdr and r.isShellFabric=true and r.mstitemtype.category=:category ")
			.setParameter("mercostsheethdr", mercostsheethdr)
			.setParameter("category", category).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal getNext(Mercostsheetgroup mercostsheetgroup) {
		 List  <BigDecimal>code = getSession().createQuery("select r.id.costSheetRowMatCode FROM  "
		 		+ "Mercostsheetrowmaterial r WHERE "
		 		+ "r.id.groupId=:groupId and "
		 		+ "r.id.costSheetNo=:costSheetNo and "
		 		+ "r.id.costSheetType=:costSheetType and "
		 		+ "r.id.versionNo=:versionNo  ORDER by r.id.costSheetRowMatCode ASC")
				.setParameter("groupId", mercostsheetgroup.getId().getGroupId())
				.setParameter("costSheetNo", mercostsheetgroup.getId().getCostSheetNo())
				.setParameter("costSheetType", mercostsheetgroup.getId().getCostSheetType())
				.setParameter("versionNo", mercostsheetgroup.getId().getVersionNo()).list();
		 if(code.size()>0)
			 return  code.get(code.size()-1);
		 else
			 return ConvertUtil.getDecimal("0"); 
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetrowmaterial> getAllCost(String costSheetNo, BigDecimal versionNo,
			String costsheetType, String category, String groupName) {
		String string="INNER JOIN fetch  r.mstitemtype i ";
		try{
			log.debug("FROM  Mercostsheetrowmaterial r "+string
					+ "where r.mstitemtype.category=:category  and r.id.costSheetType=:costsheetType and r.mercostsheetgroup.groupName=:groupName and r.id.costSheetNo=:costSheetNo and r.id.versionNo=:versionNo   ****/n ");
			log.debug("FROM  Mercostsheetrowmaterial r "+string
					+ "where r.mstitemtype.category="+category+"  and r.id.costSheetType="+costsheetType+" and r.mercostsheetgroup.groupName="+groupName+" and r.id.costSheetNo=:"+costSheetNo+" and r.id.versionNo="+versionNo+"   ****/n ");
			return getSession().createQuery(" FROM  Mercostsheetrowmaterial r "+string
					+ "where r.mstitemtype.category=:category and r.mercostsheetgroup.groupName=:groupName and r.id.costSheetType=:costsheetType and r.id.costSheetNo=:costSheetNo and r.id.versionNo=:versionNo ")
					.setParameter("costSheetNo", costSheetNo)
					.setParameter("versionNo", versionNo)
					.setParameter("groupName", groupName)
					.setParameter("costsheetType", costsheetType)
					.setParameter("category", category).list();
		}catch(Exception e){
			log.debug(e.getMessage());
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetrowmaterial> getAll(
			MercostsheethdrId mercostsheethdrId, String[] types,String[] values) {
		
		log.debug(Arrays.toString(types));
		log.debug(Arrays.toString(values));
		log.debug(2);
		String [] sql=new String[values.length];
		String []tables=new String[values.length];
		String []tableswhere=new String[values.length];
		Boolean sts=false;
		for(int i=0;i<types.length;i++){
			log.debug(i);
			if(types[i].equals("country")){
				sql[i]=" and  g.country ='"+values[i]+"'";
				sts=true;
				
			}
			else if(types[i].equals("colours")){
				sql[i]="";
				tables[i]="Mercostsheetgroupcolor gc ";
				tableswhere[i]=" and gc.id.color ='"+values[i]+"' "
						+ " and gc.id.groupId=gr.id.groupId "
						+ " and gc.id.costSheetNo=gr.id.costSheetNo "
						+ " and gc.id.versionNo=gr.id.versionNo "
						+ " and gc.id.costSheetType=gr.id.costSheetType ";
			}
			else if(types[i].equals("components")){
				sql[i]="";
				tables[i]="Mercostsheetgroupsetting gs ";	
				tableswhere[i]=" and gs.component ='"+values[i]+"'"
						+ " and gs.id.groupId=gr.id.groupId "
						+ " and gs.id.costSheetNo=gr.id.costSheetNo "
						+ " and gs.id.versionNo=gr.id.versionNo "
						+ " and gs.id.costSheetType=gr.id.costSheetType ";
			}
			else if(types[i].equals("group")){
				sql[i]=" and  g.groupName ='"+values[i]+"'";
				sts=true;
			}
		}
		if(sts){
			tables[values.length-1]=" Mercostsheetgroup g ";
			tableswhere[values.length-1]=" and  g.id.groupId=gr.id.groupId "
					+ " and g.id.costSheetNo=gr.id.costSheetNo "
					+ " and g.id.versionNo=gr.id.versionNo "
					+ " and g.id.costSheetType=gr.id.costSheetType ";
		}
		
		String Query="";
		String QueryWhere=" WHERE "
				+ " gr.id.costSheetNo='"+mercostsheethdrId.getCostSheetNo()+"' "
				+ " and gr.id.versionNo="+mercostsheethdrId.getVersionNo()+" "
				+ " and gr.id.costSheetType='"+mercostsheethdrId.getCostSheetType()+"' ";
		String QueryFrom=" FROM Mercostsheetrowmaterial gr ,";
		String QuerySELECT = "SELECT  gr";
		log.debug(Arrays.toString(tables));
		for(int i=0;i<tables.length;i++){
				if(tables[i]!=null){
				QueryFrom+=" " +tables[i] +" ";
				if(tables.length-1>i){
					QueryFrom+=" , ";
				}
			}
		}
		for(int i=0;i<tableswhere.length;i++){
			if(tableswhere[i]!=null){
				QueryWhere=QueryWhere+ " " + tableswhere[i] +" ";
			}
		}
		Query=QuerySELECT+QueryFrom+QueryWhere;
		log.debug(Query);
		return getSession().createQuery(Query)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAll(String costSheetNo, String versionno,
			String costsheetType, String category, String fld) {
		String string=""; 
		BigDecimal versionNo=ConvertUtil.getDecimal(versionno);
		if(fld.equals("NOT")){
			fld="";
			string="INNER JOIN fetch  r.mstitemtype i ";
		}
		else{
			fld="select  r."+fld;
		}
		log.debug(""+fld+" FROM  Mercostsheetrowmaterial r "+string
					+ "where  r.id.costsheetType=:"+ costsheetType +" and r.id.preCostSheetNo=:"+costSheetNo+" and r.id.versionNo=:"+versionNo);
		if(category.equals("NOT")){
			return getSession().createQuery(""+fld+" FROM  Mercostsheetrowmaterial r "+string
					+ "where  r.id.costSheetType=:costSheetType and r.id.costSheetNo=:costSheetNo and r.id.versionNo=:versionNo")
					.setParameter("costSheetNo", costSheetNo)
					.setParameter("versionNo", versionNo)
					.setParameter("costSheetType", costsheetType)
					.list();
		}
		else{
			return getSession().createQuery(""+fld+" FROM  Mercostsheetrowmaterial r "+string
					+ "where r.mstitemtype.category=:category  and r.id.costSheetType=:costSheetType and r.id.costSheetNo=:costSheetNo and r.id.versionNo=:versionNo")
					.setParameter("costSheetNo", costSheetNo)
					.setParameter("versionNo", versionNo)
					.setParameter("costSheetType", costsheetType)
					.setParameter("category", category).list();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetrowmaterial> getAll(
			Mercostsheethdr Mercostsheethdr, String category, String Itemtype,
			String Itemcode) {
		return getSession().createQuery("FROM  Mercostsheetrowmaterial r INNER JOIN fetch  r.mstitemtype i"
				+ " WHERE r.id.versionNo=:versionNo and r.id.costSheetType=:costSheetType and r.id.costSheetNo=:costSheetNo and r.mstitemtype.category=:category "
				+ "and r.mstitemtype.itemType=:itemType and r.itemCode=:itemCode ")
			.setParameter("costSheetNo", Mercostsheethdr.getId().getCostSheetNo())
			.setParameter("versionNo", Mercostsheethdr.getId().getVersionNo())
			.setParameter("costSheetType", Mercostsheethdr.getId().getCostSheetType())
			.setParameter("category", category)
			.setParameter("itemType", Itemtype)
			.setParameter("itemCode", Itemcode).list();
	}
}
