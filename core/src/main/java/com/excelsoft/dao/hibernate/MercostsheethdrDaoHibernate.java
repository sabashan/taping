package com.excelsoft.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.MercostsheethdrDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.stereotype.Repository;

@Repository("mercostsheethdrDao")
public class MercostsheethdrDaoHibernate extends GenericDaoHibernate<Mercostsheethdr, MercostsheethdrId> implements MercostsheethdrDao {
	final String  inComplete="Incomplete";
	final String orderby="ORDER BY p.id.costSheetNo ASC, p.id.versionNo ASC, p.id.costSheetType"
			+ " ASC";
    public MercostsheethdrDaoHibernate() {
        super(Mercostsheethdr.class);
    }

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheethdr> getAll(Mststyleheader mststyleheader,
			String season, String query) {
		BigDecimal lquery;
		
		if (StringUtils.isEmpty(query)) {
			return getSession().createQuery("from Mercostsheethdr p INNER JOIN fetch  p.costSheetCurrency c where p.flag != '"+inComplete+"' and p.mststyleheader =:mststyleheader and p.season=:season " + orderby).
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
			log.debug("s - " +lquery);
			return getSession().createQuery("from Mercostsheethdr p  INNER JOIN fetch  p.costSheetCurrency c where  p.flag != '"+inComplete+"' and p.mststyleheader=:mststyleheader and p.season=:season and "+ likeCreator() + " " + orderby)
					.setParameter("mststyleheader", mststyleheader)
					.setParameter("season", season)
					.setParameter("query", "%"+query+"%")
					.setParameter("Lquery", lquery)
					.list();
		}
	}
	
	private String likeCreator(){
		return "( "
			+ "p.id.costSheetType like :query or p.id.costSheetNo  like :query or p.id.versionNo like :Lquery )";
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheethdr> getAlldue(String flag,String UserId) {
		return getSession().createQuery("from Mercostsheethdr p INNER JOIN fetch  p.costSheetCurrency c where p.flag =:flag and "
				+ "( p.createdBy =:UserId or p.modifiedBy =:UserId )" + orderby)
				.setParameter("UserId", UserId)
				.setParameter("flag", flag)
				.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheethdr> getAll(String flag) {
		return getSession().createQuery("from Mercostsheethdr p where p.flag =:flag and "
				 + orderby)
				.setParameter("flag", flag)
				.list();
	}


	@Override
	public Mststyleheader getStyle(MercostsheethdrId id) {
		return (Mststyleheader) getSession().createQuery("select p.mststyleheader from Mercostsheethdr p where p.id=:id ")
				.setParameter("id", id)
				.uniqueResult();
	}


	@Override
	public Merprecostsheet getprecostsheet(MercostsheethdrId id) {
		return (Merprecostsheet) getSession().createQuery("select p.merprecostsheethdr from Mercostsheethdr p where p.id=:id ")
				.setParameter("id", id)
				.uniqueResult();
	}
}
