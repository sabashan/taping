package com.excelsoft.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.MerprecostsheetDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.stereotype.Repository;

@Repository("merprecostsheetDao")
@SuppressWarnings("unchecked")
public class MerprecostsheetDaoHibernate extends GenericDaoHibernate<Merprecostsheet, MerprecostsheetId> implements MerprecostsheetDao {
final String  inComplete="Incomplete";
final String orderby="ORDER BY p.id.preCostSheetNo ASC, p.id.versionNo ASC, p.id.costsheetType ASC";
    public MerprecostsheetDaoHibernate() {
        super(Merprecostsheet.class);
    }
    
	
	@Override
	public List<Merprecostsheet> getAll(Mststyleheader mststyleheader,
			String season,String query) {
		BigDecimal lquery;
		log.debug("h "+mststyleheader + " - "+season);
		if (StringUtils.isEmpty(query)) {
			return getSession().createQuery("from Merprecostsheet p INNER JOIN fetch  p.mstcurrencyByCostSheetCurrency c where p.flag != '"+inComplete+"' and p.mststyleheader =:mststyleheader and p.season=:season " + orderby).
					setParameter("mststyleheader", mststyleheader)
					.setParameter("season", season)
					.list();
		}
		else{
			
			lquery= ConvertUtil.getDecimal(query);
				
			return getSession().createQuery("from Merprecostsheet p INNER JOIN fetch  p.mstcurrencyByCostSheetCurrency c where p.flag != '"+inComplete+"' and p.mststyleheader=:mststyleheader  and p.season=:season and "+ likeCreator() + " " + orderby)
					.setParameter("mststyleheader", mststyleheader)
					.setParameter("season", season)
					.setParameter("query", "%"+query+"%")
					.setParameter("Lquery", lquery)
					.list();
		}
	}

	@Override
	public List<Merprecostsheet> getAll(String compCode, String locationCode,
			String custCode, String depCode, String styleId,String season,String costsheetType, String query) {
		BigDecimal lquery;
		
		
		if (StringUtils.isEmpty(query)) {
			return getSession().createQuery("from Merprecostsheet p INNER JOIN fetch  p.mstcurrencyByCostSheetCurrency c where p.flag != '"+inComplete+"' and p.mststyleheader.id.styleId=:styleId and "
					+ "p.mststyleheader.id.locationCode=:locationCode and p.mststyleheader.id.compCode=:compCode "
					+ "and p.mststyleheader.id.depCode=:depCode and p.id.costsheetType =:costsheetType and p.mststyleheader.id.custCode=:custCode and p.season=:season " + orderby)
					.setParameter("locationCode", locationCode)
					.setParameter("compCode", compCode)
					.setParameter("depCode", depCode)
					.setParameter("custCode", custCode)
					.setParameter("styleId", styleId)
					.setParameter("season", season)
					.setParameter("costsheetType", costsheetType)
					.list();
		}
		else{
			try{
				lquery= ConvertUtil.getDecimal(query);
				}
				catch(Exception e){
					lquery= ConvertUtil.getDecimal("0");
				}
			return getSession().createQuery("from Merprecostsheet p  INNER JOIN fetch  p.mstcurrencyByCostSheetCurrency c where p.flag != '"+inComplete+"' and (p.mststyleheader.id.styleId=:styleId and "
					+ "p.mststyleheader.id.locationCode=:locationCode and p.mststyleheader.id.compCode=:compCode "
					+ "and p.mststyleheader.id.depCode=:depCode and p.id.costsheetType =:costsheetType and p.mststyleheader.id.custCode=:custCode )"
					+ "and p.season =:season and  "+ likeCreator() + " " + orderby)
					.setParameter("locationCode", locationCode)
					.setParameter("compCode", compCode)
					.setParameter("depCode", depCode)
					.setParameter("custCode", custCode)
					.setParameter("styleId", styleId)
					.setParameter("query", "%"+query+"%")
					.setParameter("season", season)
					.setParameter("Lquery", lquery)
					.setParameter("costsheetType", costsheetType)
					.list();
		}
	}
	
	@Override
	public List<Merprecostsheet> getAllDue(String flag,String User) {

		return getSession().createQuery("from Merprecostsheet p INNER JOIN fetch  p.mstcurrencyByCostSheetCurrency c where p.flag =:flag and (p.createdBy=:userId or p.modifiedBy=:userId)  " + orderby)
				.setParameter("flag", flag)
				 .setParameter("userId", User).list();
	}
	
	


	@Override
	public List<MerprecostsheetId> getAllids(Mststyleheader mststyleheader,
			String season, String query) {
		BigDecimal lquery;
		
		if (StringUtils.isEmpty(query)) {
			return getSession().createQuery("select p.id from Merprecostsheet p where p.flag != '"+inComplete+"' and p.mststyleheader =:mststyleheader and p.season=:season  " + orderby).
					setParameter("mststyleheader", mststyleheader)
					.setParameter("season", season)
					.list();
		}
		else{
			try{
				lquery= ConvertUtil.getDecimal(query);
				}
				catch(Exception e){
					lquery= ConvertUtil.getDecimal("0");
				}
			return getSession().createQuery("select p.id from Merprecostsheet p where p.flag != '"+inComplete+"' and p.mststyleheader=:mststyleheader  and p.season=:season and "+ likeCreator() +"  " + orderby)
					.setParameter("mststyleheader", mststyleheader)
					.setParameter("season", season)
					.setParameter("query", "%"+query+"%")
					.setParameter("Lquery", lquery)
					.list();
		}
	}
	
	@Override
	public List<BigDecimal> getAllVersion(String costSheetTytpe,String costsheetNO) {
		return getSession().createQuery("select p.id.versionNo from Merprecostsheet p where p.flag != '"+inComplete+"' and p.id.preCostSheetNo =:preCostSheetNo and p.id.costsheetType=:costsheetType  ORDER BY p.id.versionNo ASC" ).
				setParameter("preCostSheetNo", costsheetNO)
				.setParameter("costsheetType", costSheetTytpe)
				.list();
	}
	
	@Override
	public List<String> getAllids(String compCode, String locationCode,
			String custCode, String depCode, String styleId, String season,String costsheetType) {
		return getSession().createQuery("select p.id.preCostSheetNo from Merprecostsheet p where p.flag != '"+inComplete+"' "
				+ "and p.mststyleheader.id.styleId=:styleId and p.mststyleheader.id.locationCode=:locationCode "
				+ "and p.mststyleheader.id.compCode=:compCode and p.mststyleheader.id.depCode=:depCode "
				+ "and p.id.costsheetType=:costsheetType and p.mststyleheader.id.custCode=:custCode "
				+ "and p.season=:season " + orderby)
				.setParameter("locationCode", locationCode)
				.setParameter("compCode", compCode)
				.setParameter("depCode", depCode)
				.setParameter("custCode", custCode)
				.setParameter("styleId", styleId)
				.setParameter("season", season)
				.setParameter("costsheetType", costsheetType)
				.list();

		
	}
	private String likeCreator(){
		return "( p.mststyleheader.id.styleId like :query  or "
			+ "p.mststyleheader.id.locationCode like :query  or p.mststyleheader.id.compCode like :query  or "
			+ "p.mststyleheader.id.depCode like :query  or p.mststyleheader.id.custCode like :query  or "
			+ "p.season like :query or p.id.costsheetType like :query or  p.merchandiser like :query or "
			+ "p.baseBody like :query or p.buyerReference like :query  or p.destinationCountry like :query or "
			+ "p.shipmentMode like :query or p.deliveryTerm like :query or  p.validTill like :query or "
			+ "p.mstcurrencyByDftRmCurrency.curCode like :query or p.mstcurrencyByDftRmCurrency.curName like :query or "
			+ "p.mstcurrencyByCostSheetCurrency.curCode like :query or p.mstcurrencyByCostSheetCurrency.curName like :query or "
			+ "p.id.preCostSheetNo  like :query or p.id.versionNo like :Lquery )";
	}


	@Override
	public List<Merprecostsheet> getAll(String flag) {
		return getSession().createQuery("from Merprecostsheet p where p.flag =:flag " + orderby)
				.setParameter("flag", flag).list();
	}

	@Override
	public Mststyleheader getStyle(MerprecostsheetId id) {
		return (Mststyleheader) getSession().createQuery("select p.mststyleheader from Merprecostsheet p where p.id=:id ")
				.setParameter("id", id)
				.uniqueResult();
	}
	
}
