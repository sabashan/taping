package com.excelsoft.dao;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.model.Mststyleroute;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.MststylerouteoperationId;

/**
 */
public interface MststylerouteoperationDao extends
		GenericDao<Mststylerouteoperation, MststylerouteoperationId> {

	public List<Mststylerouteoperation> getByRoot(
			Mststylerouteoperation mststylerouteoperation);

	public int getnextopperation(String StyleComponent, String mainColor,
			Long RouteId, String styleId, String locationCode, String custCode,
			String depCode);
	
	public int getnextopperation(Long RouteId);

	public List<Mststylerouteoperation> getByRootparam(Long RouteId);
	

	public List<Mststylerouteoperation> routeopsch(String styleRouteID,
			String styleRouteName, String schmodelBuyerDip,
			String schmodelStyle, String schmodelBuyer);

	public List<Mststylerouteoperation> getByRoute(Mststyleroute mststyleroute);
	
	public List<BigDecimal> getSMV(String routeId);

	public List<Mststylerouteoperation> getByRootparamQ(Long RouteId, String query);
	
	public boolean chkoperation(Long RouteId, Long sequenceNo);

	public Long getnextsequenceNo(Long RouteId);
	
}