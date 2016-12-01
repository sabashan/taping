package com.excelsoft.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.model.Mststyleroute;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.MststylerouteoperationId;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.MststylerouteoperationDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository("mststylerouteoperationDao")
public class MststylerouteoperationDaoHibernate extends
		GenericDaoHibernate<Mststylerouteoperation, MststylerouteoperationId>
		implements MststylerouteoperationDao {

	public MststylerouteoperationDaoHibernate() {
		super(Mststylerouteoperation.class);
	}

	
	@Override
	public List<Mststylerouteoperation> getByRootparam(Long RouteId) {
log.debug(RouteId);
		return getSession()
				.createQuery(
						"FROM Mststylerouteoperation o WHERE "
								+ " o.id.styleRouteId=:styleRouteId ")
				.setParameter("styleRouteId", RouteId).list();
	}
	@Override
	public List<Mststylerouteoperation> getByRootparamQ(Long RouteId, String query) {
		log.debug(RouteId + " - " +query);
		return getSession()
				.createQuery(
						"FROM Mststylerouteoperation o WHERE "
								+ " o.id.styleRouteId=:styleRouteId AND ("+getlike())
				.setParameter("styleRouteId", RouteId)
				.setParameter("query", "%"+query+"%")
				.setParameter("Iquery", ConvertUtil.getINT(query))
				.setParameter("lquery", ConvertUtil.getlongs(query)).list();
	}
	
	@Override
	public int getnextopperation(String StyleComponent, String mainColor,
			Long RouteId, String styleId, String locationCode, String custCode,
			String depCode) {

		List<Mststylerouteoperation> mststyleoperation = getSession()
				.createQuery(
						"FROM Mststylerouteoperation r "
								+ "WHERE  r.id.styleId=:styleId AND r.mststyleroute.mststyleheader.id.locationCode=:locationCode "
								+ "AND r.mststyleroute.mststyleheader.id.custCode=:custCode AND r.mststyleroute.componentId=:componentId AND r.mststyleroute.mainColor=:mainColor "
								+ "AND r.mststyleroute.mststyleheader.id.depCode=:depCode AND r.id.styleRouteId=:styleRouteId "
								+ "ORDER BY r.id.opeartionNo DESC")
				.setParameter("componentId", StyleComponent)
				.setParameter("mainColor", mainColor)
				.setParameter("styleRouteId", RouteId)
				.setParameter("styleId", styleId)
				.setParameter("locationCode", locationCode)
				.setParameter("custCode", custCode)
				.setParameter("depCode", depCode).list();

		int opId = 1;
		if (mststyleoperation.size() > 0) {
			opId = mststyleoperation.get(0).getId().getOpeartionNo() + 1;
		}
		return opId;
	}

	
	@Override
	public int getnextopperation(Long RouteId) {

		List<Integer> mststyleoperation = getSession()
				.createQuery(
						"select r.id.opeartionNo FROM Mststylerouteoperation r "
								+ "WHERE  r.id.styleRouteId=:styleRouteId "
								+ "ORDER BY r.id.opeartionNo DESC")
				.setParameter("styleRouteId", RouteId).list();

		int opId = 1;
		if (mststyleoperation.size() > 0) {
			opId = mststyleoperation.get(0);
		}
		return opId;
	}

	
	@Override
	public List<Mststylerouteoperation> routeopsch(String styleRouteID,
			String styleRouteName, String schmodelBuyerDip,
			String schmodelStyle, String schmodelBuyer) {
		Long styleRouteIDLong = new Long(styleRouteID);
		return getSession()
				.createQuery(
						"FROM Mststylerouteoperation r "
								+ "WHERE  r.mststyleroute.mststyleheader.id.styleId =:styleId "
								+ "AND r.mststyleroute.mststyleheader.id.custCode =:custCode "
								+ "AND r.mststyleroute.mststyleheader.id.depCode =:depCode "
								+ "AND r.id.styleRouteId =:styleRouteId ")
				// +
				// "AND r.mststylerouteoperation.styleRouteName =:styleRouteName ")
				.setParameter("styleRouteId", styleRouteIDLong)
				// .setParameter("styleRouteName", styleRouteName)
				.setParameter("depCode", schmodelBuyerDip)
				.setParameter("custCode", schmodelBuyer)
				.setParameter("styleId", schmodelStyle).list();

	}

	
	@Override
	public List<Mststylerouteoperation> getByRoot(
			Mststylerouteoperation mststylerouteoperation) {
		return getSession()
				.createQuery(
						"FROM Mststylerouteoperation m WHERE m.mststylerouteoperation =:mststylerouteoperation")
				.setParameter("mststylerouteoperation", mststylerouteoperation)
				.list();
	}

	
	@Override
	public List<Mststylerouteoperation> getByRoute(Mststyleroute mststyleroute) {
		return getSession()
				.createQuery(
						"FROM Mststylerouteoperation m WHERE m.mststyleroute =:mststyleroute")
				.setParameter("mststyleroute", mststyleroute).list();
	}

	@Override
	public List<BigDecimal> getSMV(String routeId) {
		long rt=0;
		try{
			rt=new Long(routeId);
		}
		catch(Exception e){
			log.debug(e.getMessage());
			rt=0;
		}
		return  getSession()
		.createQuery(
				"select m.defaultSmv FROM Mststylerouteoperation m WHERE m.mststyleroute.styleRouteId =:routeId")
		.setParameter("routeId",rt ).list();
	}
	
	private String getlike(){
		String like="";
		like+="o.id.opeartionNo like :Iquery OR ";
		like+="o.id.styleRouteId like :lquery OR ";
		like+="o.operationDesc like :query OR ";
		like+="o.operationDescBref like :query OR ";
		like+="o.operationType like :query OR ";
		like+="o.machineTypeDefault like :query OR ";
		like+="o.sewingOperation like :query OR ";
		like+="o.operation like :query OR ";
		like+="o.process like :query OR ";
		like+="o.grade like :query OR ";
		like+="o.averageSmv like :query OR ";
		like+="o.revision1 like :lquery OR ";
		like+="o.revision2 like :lquery OR ";
		like+="o.revision3 like :lquery OR ";
		like+="o.revision4 like :lquery OR ";
		like+="o.revision5 like :lquery OR ";
	//	private Boolean calc like : query OR";
		like+="o.workAid like :query OR ";
		//private Boolean manual like : query OR";
		like+="o.wipPoints like :query OR ";
		//private Boolean printBundleTicket like : query OR";
		like+="o.defaultSmv like :lquery OR ";
		like+="o.sizeWiseSmvMatrix like :lquery OR ";
		like+="o.sequenceNo like :lquery )";
		
		return like;
	}


	@Override
	public boolean chkoperation(Long RouteId, Long sequenceNo) {
		log.debug("select m.sequenceNo FROM Mststylerouteoperation m WHERE m.id.styleRouteId =:"+RouteId+" and m.sequenceNo=:"+sequenceNo+"");
		Long sequenceNoT =-1L;
		sequenceNoT= (Long) getSession()
		.createQuery(
				"select m.sequenceNo FROM Mststylerouteoperation m WHERE m.id.styleRouteId =:styleRouteId and m.sequenceNo =:sequenceNo")
		.setParameter("styleRouteId", RouteId)
		.setParameter("sequenceNo", sequenceNo).uniqueResult();
		log.debug(sequenceNoT);
		if(sequenceNoT !=null && sequenceNoT>0){
			return false;
		}
		else{
			return true;
		}
		
		
		
	}


	@Override
	public Long getnextsequenceNo(Long RouteId) {
		log.debug("select r.sequenceNo FROM Mststylerouteoperation r "
								+ "WHERE  r.id.styleRouteId=:" +RouteId
								+ " ORDER BY r.id.opeartionNo DESC");
		List<Long> mststyleoperation = getSession()
				.createQuery(
						"select r.sequenceNo FROM Mststylerouteoperation r "
								+ "WHERE  r.id.styleRouteId=:styleRouteId "
								+ "ORDER BY r.sequenceNo DESC")
				.setParameter("styleRouteId", RouteId).list();

		Long opId = 1l;
		if (mststyleoperation.size() > 0) {
			opId = mststyleoperation.get(0);
		}
		return opId;
	}

}
