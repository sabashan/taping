package com.excelsoft.service.impl;

import com.excelsoft.dao.MststylerouteoperationDao;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.MststylerouteoperationId;
import com.excelsoft.service.MststylerouteoperationManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

@Service("mststylerouteoperationManager")
@WebService(serviceName = "MststylerouteoperationService", endpointInterface = "com.excelsoft.service.MststylerouteoperationManager")
public class MststylerouteoperationManagerImpl extends
		GenericManagerImpl<Mststylerouteoperation, MststylerouteoperationId>
		implements MststylerouteoperationManager {
	MststylerouteoperationDao mststylerouteoperationDao;

	@Autowired
	public MststylerouteoperationManagerImpl(
			MststylerouteoperationDao mststylerouteoperationDao) {
		super(mststylerouteoperationDao);
		this.mststylerouteoperationDao = mststylerouteoperationDao;
	}

	@Override
	public List<Mststylerouteoperation> getByRoot(
			Mststylerouteoperation mststylerouteoperation) {
		return mststylerouteoperationDao.getByRoot(mststylerouteoperation);
	}

	@Override
	public List<Mststylerouteoperation> getByRootparam( Long RouteId) {
		return mststylerouteoperationDao.getByRootparam(RouteId);
	}
	@Override
	public List<Mststylerouteoperation> getByRootparamQ( Long RouteId,String query) {
		return mststylerouteoperationDao.getByRootparamQ( RouteId,query);
	}
	@Override
	public Mststylerouteoperation get(MststylerouteoperationId id) {
		return mststylerouteoperationDao.get(id);
	}

	@Override
	public List<Mststylerouteoperation> getAll() {
		return mststylerouteoperationDao.getAll();
	}

	@Override
	public Mststylerouteoperation getbyidparam(String opeartionNo, String styleRouteId) {

		try {
			int opNo = Integer.parseInt(opeartionNo);
			Long rotId = Long.parseLong(styleRouteId);
			MststylerouteoperationId id = new MststylerouteoperationId(opNo, rotId);
			return mststylerouteoperationDao.get(id);
		} catch (Exception e) {
			log.debug(e.getMessage());
			return new Mststylerouteoperation();
		}

	}

	@Override
	public int getnextopperation(String StyleComponent, String mainColor,
			Long RouteId, String styleId, String locationCode, String custCode,
			String depCode) {

		return mststylerouteoperationDao.getnextopperation(StyleComponent,
				mainColor, RouteId, styleId, locationCode, custCode, depCode);
	}

	@Override
	public int getnextopperation(Mststylerouteoperation mststylerouteoperation) {

		return mststylerouteoperationDao.getnextopperation(null, null, null,
				null, null, null, null);
	}

	@Override
	public int getnextopperation(Long RouteId) {
		return mststylerouteoperationDao.getnextopperation(RouteId);
	}
	
	@Override
	public List<Mststylerouteoperation> routeopsch(String styleRouteID,
			String styleRouteName, String schmodelBuyerDip,
			String schmodelStyle, String schmodelBuyer) {

		return mststylerouteoperationDao.routeopsch(styleRouteID,
				styleRouteName, schmodelBuyerDip, schmodelStyle, schmodelBuyer);
	}

	@Override
	public List<Mststylerouteoperation> getByRoute(Mststyleroute mststyleroute) {
		// TODO Auto-generated method stub
		return mststylerouteoperationDao.getByRoute(mststyleroute);
	}

	@Override
	public List<BigDecimal> getSMV(String routeId) {
		return this.mststylerouteoperationDao.getSMV(routeId);
	}

	@Override
	public boolean chkoperation(Long RouteId, Long sequenceNo) {
		return this.mststylerouteoperationDao.chkoperation( RouteId,  sequenceNo);
	}

	@Override
	public Long getnextsequenceNo(Long RouteId) {
		return mststylerouteoperationDao.getnextsequenceNo(RouteId);
	}

}