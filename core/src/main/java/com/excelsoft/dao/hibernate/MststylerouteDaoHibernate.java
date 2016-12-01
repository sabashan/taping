package com.excelsoft.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.excelsoft.dao.MststylerouteDao;
import com.excelsoft.model.Mstcompany;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.model.Mstdepartment;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.util.ConvertUtil;

@Repository("mststylerouteDao")
@SuppressWarnings("unchecked")
public class MststylerouteDaoHibernate extends
		GenericDaoHibernate<Mststyleroute, Long> implements MststylerouteDao {

	private String[] ids = { "compCode", "locationCode", "custCode", "depCode",
			"styleId", "componentId", "mainColor", "styleRouteId" };

	public MststylerouteDaoHibernate() {
		super(Mststyleroute.class);
	}

	@Override
	public List<Mststyleroute> getAllRoutes(MststyleheaderId mststyleheaderId) {
		List<Mststyleroute> mststylerouteoperations = new ArrayList<Mststyleroute>();

		try {
			mststylerouteoperations = getSession()
					.createQuery(
							"FROM Mststyleroute r WHERE  r.mststyleheader.id.styleId=:styleId AND r.mststyleheader.id.locationCode=:locationCode "
							+ "AND r.mststyleheader.id.custCode=:custCode AND r.mststyleheader.id.compCode=:compCode "
							+ "AND r.mststyleheader.id.depCode=:depCode ")
					.setParameter("styleId", mststyleheaderId.getStyleId())
					.setParameter("locationCode",mststyleheaderId.getLocationCode())
					.setParameter("custCode", mststyleheaderId.getCustCode())
					.setParameter("compCode", mststyleheaderId.getCompCode())
					.setParameter("depCode", mststyleheaderId.getDepCode())
					.list();
		} catch (Exception e) {
			log.debug("in manager "+ e);
			log.debug(mststylerouteoperations.toString());
		}
		return mststylerouteoperations;
	}

	@Override
	public List<Object> getStyleRout(String dep, String sty, String cust,
			String loc, String styr, String main, String compi, String compa,
			String need) {

		String value = getvalue(dep, sty, cust, loc, styr, main, compi, compa);
		/* base sql */
		String url = "  from Mststyleroute r " + value;
		if (!need.equals("NOT")) {
			url = " select  distinct r." + need + " " + url;
		}
		log.debug(url);
		return getSession().createQuery(url).list();
	}


	@Override
	public List<Mstlocation> locationByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query) {

		String value = getvalue(dep, sty, cust, loc, styr, main, compi, compa);
		/* base sql */

		String url = "  from Mststyleroute r " + value;
		if (!need.equals("NOT")) {
			url = " select  distinct  r.mststyleheader." + need + " " + url;
			if (!query.equals("NOT")) {
				String url2 = "  " + " r.mststyleheader." + need
						+ ".locationCode like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".locationName like '%"
						+ query + "%' or " + " r.mststyleheader." + need
						+ ".locationAddr like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".locationType like '%"
						+ query + "%' or " + " r.mststyleheader." + need
						+ ".contactName like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".emailAddr like '%"
						+ query + "%' ";
				if (value != "") {
					url = url + " and (" + url2 + " ) ";
				} else {
					url = url + " where  " + url2;
				}
			}
		}
		log.debug(url);
		try {
			List<Mstlocation> strings = getSession().createQuery(url).list();
			return strings;
		} catch (Exception e) {
			log.debug(e);
			return new ArrayList<Mstlocation>();
		}

	}

	@Override
	public List<Mstdepartment> MstdepartmentByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query) {

		String value = getvalue(dep, sty, cust, loc, styr, main, compi, compa);
		/* base sql */

		String url = "  from Mststyleroute r " + value;
		if (!need.equals("NOT")) {
			url = " select  distinct  r.mststyleheader." + need + " " + url;
			if (!query.equals("NOT")) {
				String url2 = "  " + " r.mststyleheader." + need
						+ ".locationCode like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".locationName like '%"
						+ query + "%' or " + " r.mststyleheader." + need
						+ ".locationAddr like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".locationType like '%"
						+ query + "%' or " + " r.mststyleheader." + need
						+ ".contactName like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".emailAddr like '%"
						+ query + "%' ";
				if (value != "") {
					url = url + " and (" + url2 + " ) ";
				} else {
					url = url + " where  " + url2;
				}
			}
		}
		log.debug(url);
		try {
			List<Mstdepartment> strings = getSession().createQuery(url).list();
			return strings;
		} catch (Exception e) {
			log.debug(e);
			return new ArrayList<Mstdepartment>();
		}

	}

	@Override
	public List<Mststyleheader> MststyleheaderByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query) {

		String value = getvalue(dep, sty, cust, loc, styr, main, compi, compa);
		/* base sql */

		String url = "  from Mststyleroute r " + value;
		if (!need.equals("NOT")) {
			url = " select  distinct  r.mststyleheader " + url;
			if (!query.equals("NOT")) {
				String url2 = "  " + " r.mststyleheader.productRange like '%"
						+ query + "%' or "
						+ " r.mststyleheader.packingMethod like '%" + query
						+ "%' or " + " r.mststyleheader.userId like '%" + query
						+ "%' or "
						+ " r.mststyleheader.styleDescription like '%" + query
						+ "%' or " + " r.mststyleheader.id.styleId like '%"
						+ query + "%' or "
						+ " r.mststyleheader.id.compCode like '%" + query
						+ "%' or "
						+ " r.mststyleheader.styleDescription like '%" + query
						+ "%' or " + " r.mststyleheader.id.depCode like '%"
						+ query + "%' or "
						+ " r.mststyleheader.id.locationCode like '%" + query
						+ "%' or " + " r.mststyleheader.id.custCode like '%"
						+ query + "%' ";

				if (value != "") {
					url = url + " and (" + url2 + " ) ";
				} else {
					url = url + " where  " + url2;
				}
			}
		}
		log.debug(url);
		try {
			List<Mststyleheader> strings = getSession().createQuery(url).list();
			return strings;
		} catch (Exception e) {
			log.debug(e);
			return new ArrayList<Mststyleheader>();
		}

	}

	@Override
	public List<Mstcustomer> MstcustomerByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query) {

		String value = getvalue(dep, sty, cust, loc, styr, main, compi, compa);
		/* base sql */

		String url = "  from Mststyleroute r " + value;
		if (!need.equals("NOT")) {
			url = " select  distinct  r.mststyleheader." + need + " " + url;
			if (!query.equals("NOT")) {
				String url2 = "  " + " r.mststyleheader." + need
						+ ".buyerEmail like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".contactName like '%"
						+ query + "%' or " + " r.mststyleheader." + need
						+ ".crTerm like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".custAddress like '%"
						+ query + "%' or " + " r.mststyleheader." + need
						+ ".contactName like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".telNo like '%"
						+ query + "%' ";
				if (value != "") {
					url = url + " and (" + url2 + " ) ";
				} else {
					url = url + " where  " + url2;
				}
			}
		}
		log.debug(url);
		try {
			List<Mstcustomer> strings = getSession().createQuery(url).list();
			return strings;
		} catch (Exception e) {
			log.debug(e);
			return new ArrayList<Mstcustomer>();
		}

	}

	@Override
	public List<Mststyleroute> MststylerouteoperationByparam(
			String dep, String sty, String cust, String loc, String styr,
			String main, String compi, String compa, String need, String query) {

		String value = getvalue(dep, sty, cust, loc, styr, main, compi, compa);
		/* base sql */

		String url = "  from Mststyleroute r " + value;
		if (!query.equals("NOT")) {
			url+=" and ("+getlike();
			try {
				log.debug(url);
					return getSession()
							.createQuery(url).
							setParameter("query", "%"+query+"%").
							setParameter("lquery", ConvertUtil.getlongs(query)).list();
				} catch (Exception e) {
					log.debug(e);
					return new ArrayList<Mststyleroute>();
				}
		}
		else{
			try {
				log.debug(url);
					return getSession()
							.createQuery(url).list();
				} catch (Exception e) {
					log.debug(e);
					return new ArrayList<Mststyleroute>();
				}
		}
		
		

	}

	@Override
	public List<Mststylecomponent> MststylecomponentByparam(String dep,
			String sty, String cust, String loc, String styr, String main,
			String compi, String compa, String need, String query) {

		String value = getvalue(dep, sty, cust, loc, styr, main, compi, compa);
		/* base sql */
		List<Mststylecomponent> strings = new ArrayList<Mststylecomponent>();
		String url = "  from Mststyleroute r " + value;
		if (!need.equals("NOT")) {

			url = " select  distinct  r.mststyleheader " + url;
			List<Mststyleheader> string = getSession().createQuery(url).list();
			for (int i = 0; i < string.size(); i++) {
				String url2 = "";
				if (!query.equals("NOT")) {
					url2 = "  " + " r.productType like '%" + query + "%' or "
							+ " r.compRatio like '%" + query + "%' ";
				}
				if (url2 != "") {
					url = "from Mststylecomponent c where c.mststyleheader=:mststyleheader and ( "
							+ url2 + ")";
				}
				strings.addAll(getSession()
						.createQuery(
								"from Mststylecomponent c where c.mststyleheader =:mststyleheader ")
						.setParameter("mststyleheader", string.get(i)).list());
			}
		}
		log.debug(url);
		try {
			// strings=getSession().createQuery(url).list();
			return strings;
		} catch (Exception e) {
			log.debug(e);
			return new ArrayList<Mststylecomponent>();
		}
	}

	@Override
	public List<Mstcompany> MstcompanyByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query) {

		String value = getvalue(dep, sty, cust, loc, styr, main, compi, compa);
		/* base sql */

		String url = "  from Mststyleroute r " + value;
		if (!need.equals("NOT")) {
			url = " select  distinct  r.mststyleheader." + need + " " + url;
			if (!query.equals("NOT")) {
				String url2 = "  " + " r.mststyleheader." + need
						+ ".buyerEmail like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".crTerm like '%"
						+ query + "%' or " + " r.mststyleheader." + need
						+ ".custAddress like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".contactName like '%"
						+ query + "%' or " + " r.mststyleheader." + need
						+ ".telNo like '%" + query + "%' or "
						+ " r.mststyleheader." + need + ".buyerEmail like '%"
						+ query + "%' ";
				if (value != "") {
					url = url + " and (" + url2 + " ) ";
				} else {
					url = url + " where  " + url2;
				}
			}
		}
		log.debug(url);
		try {
			List<Mstcompany> strings = getSession().createQuery(url).list();
			return strings;
		} catch (Exception e) {
			log.debug(e);
			return new ArrayList<Mstcompany>();
		}
	}

	private String getvalue(String dep, String sty, String cust, String loc,
			String styr, String main, String compi, String compa) {
		List<String> sqltemp = new ArrayList<String>();

		String value = "";
		if (!dep.equals("NOT")) {
			sqltemp.add("r.mststyleheader.id." + ids[3] + "='" + dep + "'");
		}
		if (!sty.equals("NOT")) {
			sqltemp.add("r.mststyleheader.id." + ids[4] + "='" + sty + "'");
		}
		if (!cust.equals("NOT")) {
			sqltemp.add("r.mststyleheader.id." + ids[2] + "='" + cust + "'");
		}
		if (!loc.equals("NOT")) {
			sqltemp.add("r.mststyleheader.id." + ids[1] + "='" + loc + "'");
		}
		if (!styr.equals("NOT")) {
			sqltemp.add("r." + ids[7] + "='" + styr + "'");
		}
		if (!main.equals("NOT")) {
			sqltemp.add("r." + ids[6] + "='" + main + "'");
		}
		if (!compi.equals("NOT")) {
			sqltemp.add("r." + ids[5] + "='" + compi + "'");
		}
		for (int i = 0; i < sqltemp.size(); i++) {
			if (i == 0) {
				value = value + " where ";
			}
			value = value + sqltemp.get(i);
			if (i < sqltemp.size() - 1) {
				value = value + " and ";
			}
		}
		return value;
	}


	@Override
	public List<Mststyleroute> routesch(String dep, String sty, String cust) {
		// ****************** Must change
		return getSession()
				.createQuery(
						"FROM Mststyleroute r "
								+ "WHERE  r.mststyleheader.id.styleId=:styleId "
								+ "AND r.mststyleheader.id.custCode=:custCode "
								+ "AND r.mststyleheader.id.depCode=:depCode ")
				.setParameter("styleId", sty).setParameter("custCode", cust)
				.setParameter("depCode", dep).list();
	}

	@Override
	public Mststyleroute routeSearchById(String styleRouteId) {
		try{
			return this.get(Long.parseLong(styleRouteId));
		}catch(Exception e){
			log.debug(e);
		}
		return null;
	}

	@Override
	public List<Mststyleroute> getAllRoutesQ(MststyleheaderId mststyleheaderId,
			String query) {
		List<Mststyleroute> mststylerouteoperations= new ArrayList<Mststyleroute>();
		Long lquery=0l;
		try {
			lquery=new  Long(query);
		} catch (Exception e) {
			lquery=0l;
		}
		try {
			mststylerouteoperations = getSession()
					.createQuery(
							"FROM Mststyleroute r WHERE  r.mststyleheader.id.styleId=:styleId AND r.mststyleheader.id.locationCode=:locationCode "
							+ "AND r.mststyleheader.id.custCode=:custCode AND r.mststyleheader.id.compCode=:compCode "
							+ "AND r.mststyleheader.id.depCode=:depCode AND ( "+getlike())
					.setParameter("styleId", mststyleheaderId.getStyleId())
					.setParameter("locationCode",mststyleheaderId.getLocationCode())
					.setParameter("custCode", mststyleheaderId.getCustCode())
					.setParameter("compCode", mststyleheaderId.getCompCode())
					.setParameter("depCode", mststyleheaderId.getDepCode())
					.setParameter("query", "%"+query+"%")
					.setParameter("lquery", lquery)
					.list();
		} catch (Exception e) {
			log.debug("in manager "+ e);
			log.debug(mststylerouteoperations.toString());
		}
		return mststylerouteoperations;
	}
	
	public List<Mststyleroute> MststylerouteoperationByparam(
			String dep, String sty, String cust, String loc, String styr,
			String main, String compi, String compa, String location,
			String need, String query){
		String value = getvalue(dep, sty, cust, loc, styr, main, compi, compa);
		/* base sql */
		String url = "  from Mststyleroute r " + value +" and r.assignLocation='"+location+"'" ;	
			List<Mststyleroute> string =new  ArrayList<Mststyleroute>();
			string = getSession().createQuery(url).list();
			
		log.debug(url);
		return string;
	}
	
	private String getlike(){
		String like="";
		like+= " r.styleRouteId like :lquery OR ";
		like+= " r.mststyleheader.id.custCode like :query OR ";
		like+= " r.mststyleheader.id.depCode like :query OR ";
		like+= " r.mststyleheader.id.compCode like :query OR ";
		like+= " r.mststyleheader.id.locationCode like :query OR ";
		like+= " r.mststyleheader.id.styleId like :query OR ";
		like+= " r.componentId like :query OR ";
		like+= " r.mainColor like :query OR ";
		like+= " r.styleRouteName like :query OR ";
		like+= " r.assignLocation like :query OR ";
		like+= " r.buyerDept like :query OR ";
		like+= " r.productType like :query OR ";
		like+= " r.noOfPcs like :lquery OR ";
		like+= " r.orderQty like :lquery OR ";
		like+= " r.noOfMachines like :query OR ";
		like+= " r.noOfWokers like :lquery OR ";
		like+= " r.noOfHealpers like :lquery OR ";
		like+= " r.workMins like :lquery OR ";
		like+= " r.cycleTime like :lquery OR ";
		like+= " r.targetDate like :query OR ";
		like+= " r.remarks like :query OR ";
		like+= " r.approvedBy like :query OR ";
		like+= " r.approvedOn like :query  ";
		//like+= "r.routeStatus like :query OR ";
		like+= "  )";
		return like;
	}
}
