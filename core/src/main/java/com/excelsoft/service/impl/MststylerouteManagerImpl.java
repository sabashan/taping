package com.excelsoft.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MststylerouteDao;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.service.MststylerouteManager;

@Service("mststylerouteManager")
@WebService(serviceName = "MststylerouteService", endpointInterface = "com.excelsoft.service.MststylerouteManager")
public class MststylerouteManagerImpl extends
		GenericManagerImpl<Mststyleroute, Long> implements MststylerouteManager {
	MststylerouteDao mststylerouteDao;

	@Autowired
	public MststylerouteManagerImpl(MststylerouteDao mststylerouteDao) {
		super(mststylerouteDao);
		this.mststylerouteDao = mststylerouteDao;
	}

	@Override
	public List<Mststyleroute> getAll() {
		return this.mststylerouteDao.getAll();
	}

	@Override
	public List<Mststyleroute> getAllRoutes(MststyleheaderId mststyleheaderId) {
		return this.mststylerouteDao.getAllRoutes(mststyleheaderId);
	}
	@Override
	public List<Mststyleroute> getAllRoutesQ(MststyleheaderId mststyleheaderId,String query) {
		return this.mststylerouteDao.getAllRoutesQ(mststyleheaderId,query);
	}
	@Override
	public List<Object> getStyleRout(String dep, String sty, String cust,
			String loc, String styr, String main, String compi, String compa,
			String need) {

		return mststylerouteDao.getStyleRout(dep, sty, cust, loc, styr, main,
				compi, compa, need);
	}

	@Override
	public List<Mstlocation> locationByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query) {
		return mststylerouteDao.locationByparam(dep, sty, cust, loc, styr,
				main, compi, compa, need, query);
	}

	@Override
	public List<Mststyleheader> MststyleheaderByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query) {
		return mststylerouteDao.MststyleheaderByparam(dep, sty, cust, loc,
				styr, main, compi, compa, need, query);
	}

	@Override
	public List<Mstcustomer> MstcustomerByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query) {
		return mststylerouteDao.MstcustomerByparam(dep, sty, cust, loc, styr,
				main, compi, compa, need, query);
	}

	@Override
	public List<Mststyleroute> MststylerouteoperationByparam(
			String dep, String sty, String cust, String loc, String styr,
			String main, String compi, String compa, String need, String query) {
		return mststylerouteDao.MststylerouteoperationByparam(dep, sty, cust,
				loc, styr, main, compi, compa, need, query);
	}

	@Override
	public List<Mststylecomponent> MststylecomponentByparam(String dep,
			String sty, String cust, String loc, String styr, String main,
			String compi, String compa, String need, String query) {
		return mststylerouteDao.MststylecomponentByparam(dep, sty, cust, loc,
				styr, main, compi, compa, need, query);
	}

	@Override
	public List<Mststyleroute> routesch(String dep, String sty, String cust) {
		return mststylerouteDao.routesch(dep, sty, cust);
	}

	@Override
	public Mststyleroute routeSearchById(String styleRouteId) {
		return mststylerouteDao.routeSearchById(styleRouteId);
	}

	@Override
	public List<Mststyleroute> MststylerouteoperationByparam(
			String dep, String sty, String cust, String loc, String styr,
			String main, String compi, String compa, String location,
			String need, String query) {
		
		return mststylerouteDao.MststylerouteoperationByparam(dep, sty, cust, loc, styr, main, compi, compa, location, need, query);
	}

}