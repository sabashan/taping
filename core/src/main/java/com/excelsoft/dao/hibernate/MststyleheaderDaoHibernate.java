package com.excelsoft.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.model.Mstcompany;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.dao.MststyleheaderDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mststyleheaderDao")
@SuppressWarnings("unchecked")

/**
 * 
 * @author Raminda
 *
 */
public class MststyleheaderDaoHibernate extends GenericDaoHibernate<Mststyleheader, MststyleheaderId> implements MststyleheaderDao {

	private String[] ids={"compCode","locationCode","custCode","depCode","styleId"};

	public MststyleheaderDaoHibernate() {
		super(Mststyleheader.class);
	}
	
	/**
	 * @param flag style status
	 * @param User created of modified user
	 * @return List<Mststyleheader> all the style with Incomplete state and created or modified  by logged user 
	 */
	@Override
	public List<Mststyleheader> getPendingStyles(String flag,String User) {
		List<Mststyleheader> mststyleheaders =getSession()
		 .createQuery("from Mststyleheader s where s.flag=:flag and (createdBy=:userId or modifiedBy=:userId)")
		 .setParameter("flag", flag)
		 .setParameter("userId", User).list();
            return mststyleheaders;
	}
	
	/**
	 * @return all the style with conform state
	 */
	@Override
	public List<Mststyleheader> getAll(){ 
		List<Mststyleheader> mststyleheaders =getSession().
				createQuery("from Mststyleheader s where s.flag !='Incomplete'").list();
		return mststyleheaders;
	}

	/**
	 * @param company company name 
	 * @param buyer buyer name (Customer)
	 * @param department department name 
	 * @param location location name 
	 * @param style style id
	 * @return Mststyleheader the style which have corresponding values in given fields
	 */
	@Override
	public Mststyleheader getStyle(String company, String location, String buyer, String department, String style) {
		Mststyleheader mststyleheaders =(Mststyleheader) getSession().
				createQuery("from Mststyleheader s where s.id.compCode=:compCode and s.id.locationCode=:locationCode and s.id.custCode=:custCode and s.id.depCode=:depCode and s.id.styleId=:styleId").
				setParameter("compCode", company).
				setParameter("locationCode", location).
				setParameter("custCode", buyer).
				setParameter("depCode", department).
				setParameter("styleId", style).uniqueResult();
		return mststyleheaders;
	}

	@Override
	public List<String> StylesByparam(String location, String buyer,
			String department, String Style, String company,String need) {
		/* asign all params ant column name to array */

		/* new array list for getting condition */
		String value=getvalues( location,  buyer,  department,  Style,  company);
		
		/* base sql */
		String url = "  from Mststyleheader s "+value;
		if(!need.equals("NOT")){
			url=" select  distinct  s." +need+" "+url;
		}
		try{
			List<String> strings=getSession().createQuery(url).list();
		 return strings;
		}catch (Exception e) {
			log.debug(e);
			return new ArrayList <String>();
		}
	
	}
	
	@Override
	public List<Mstlocation> locationByparam(String location, String buyer,
			String department, String Style, String company,String need,String query) {
		
		String value=getvalues( location,  buyer,  department,  Style,  company)	;
		/* base sql */

		String url = "  from Mststyleheader s "+value;
		if(!need.equals("NOT")){
			url=" select  distinct  s." +need+" "+url ;
			if(!query.equals("NOT")){
				String url2 ="  "
						+ " s."+ need + ".locationCode like '%"+query+ "%' or "
						+ " s."+ need + ".locationName like '%"+query+ "%' or "
						+ " s."+ need + ".locationAddr like '%"+query+ "%' or "
						+ " s."+ need + ".locationType like '%"+query+ "%' or "
						+ " s."+ need + ".contactName like '%"+query+ "%' or "
						+ " s."+ need + ".emailAddr like '%"+query+ "%' ";
				if(value!=""){
					url=url+" and (" +url2 + " ) ";
				}
				else {
					url = url+" where  "+url2;
				}
			}
		}
		log.debug(url);
		try{
			List<Mstlocation> strings=getSession().createQuery(url).list();
		 return strings;
		}catch (Exception e) {
			log.debug(e);
			return new ArrayList <Mstlocation>();
		}
	
	}
	@Override
	public List<Mststyleheader> MststyleheaderByparam(String location, String buyer,
			String department, String Style, String company,String need,String query) {
		
		String value=getvalues( location,  buyer,  department,  Style,  company)	;
		/* base sql */

		String url = "  from Mststyleheader s "+value;
		if(!need.equals("NOT")){
		//	url=" select  distinct  s." +need+" "+url ;
			
			if(!query.equals("NOT")){
				String url2 ="  "
						+ " s.productRange like '%"+query+ "%' or "
						+ " s.packingMethod like '%"+query+ "%' or "
						+ " s.userId like '%"+query+ "%' or "
						+ " s.styleDescription like '%"+query+ "%' or "
						+ " s.id.styleId like '%"+query+ "%' or "
						+ " s.id.locationCode like '%"+query+ "%' or "
						+ " s.id.depCode like '%"+query+ "%' or "
						+ " s.id.custCode like '%"+query+ "%' or "
						+ " s.id.compCode like '%"+query+ "%' ";
				if(value!=""){
					url=url+" and (" +url2 + " ) ";
				}
				else {
					url = url+" where  "+url2;
				}
			}
		}
		log.debug(url);
		try{
			List<Mststyleheader> strings=getSession().createQuery(url).list();
		 return strings;
		}catch (Exception e) {
			log.debug(e);
			return new ArrayList <Mststyleheader>();
		}
	
	}
	@Override
	public List<Mstcustomer> MstcustomerByparam(String location, String buyer,
			String department, String Style, String company,String need,String query) {
		
		String value=getvalues( location,  buyer,  department,  Style,  company)	;
		/* base sql */

		String url = "  from Mststyleheader s "+value;
		if(!need.equals("NOT")){
			url=" select  distinct  s." +need+" "+url ;
			if(!query.equals("NOT")){
				String url2 ="  "
						+ " s."+ need + ".custCode like '%"+query+ "%' or "
						+ " s."+ need + ".boiRegno like '%"+query+ "%' or "
						+ " s."+ need + ".buyerEmail like '%"+query+ "%' or "
						+ " s."+ need + ".crTerm like '%"+query+ "%' or "
						+ " s."+ need + ".custAddress like '%"+query+ "%' or "
						+ " s."+ need + ".contactName like '%"+query+ "%' or "
						+ " s."+ need + ".buyerEmail like '%"+query+ "%' ";
				if(value!=""){
					url=url+" and (" +url2 + " ) ";
				}
				else {
					url = url+" where  "+url2;
				}
			}
		}
		log.debug(url);
		try{
			List<Mstcustomer> strings=getSession().createQuery(url).list();
		 return strings;
		}catch (Exception e) {
			log.debug(e);
			return new ArrayList <Mstcustomer>();
		}
	
	}
	
	@Override
	public List<Mstcompany> MstcompanyByparam(String location, String buyer,
			String department, String Style, String company,String need,String query) {
		
		String value=getvalues( location,  buyer,  department,  Style,  company)	;
		/* base sql */
		String url = "  from Mststyleheader s "+value;
		if(!need.equals("NOT")){
			url=" select  distinct  s." +need+" "+url ;
			if(!query.equals("NOT")){
				String url2 ="  "
						+ " s."+ need + ".compCode like '%"+query+ "%' or "
						+ " s."+ need + ".auditCompAddress like '%"+query+ "%' or "
						+ " s."+ need + ".assetIdPrefix like '%"+query+ "%' or "
						+ " s."+ need + ".auditCompName like '%"+query+ "%' or "
						+ " s."+ need + ".compAddress like '%"+query+ "%' or "
						+ " s."+ need + ".emailAddress like '%"+query+ "%' ";
				if(value!=""){
					url=url+" and (" +url2 + " ) ";
				}
				else {
					url = url+" where  "+url2;
				}
			}
		}
		log.debug(url);
		try{
			List<Mstcompany> strings=getSession().createQuery(url).list();
		 return strings;
		}catch (Exception e) {
			log.debug(e);
			return new ArrayList <Mstcompany>();
		}
	
	}
	private String getvalues(String location, String buyer,
			String department, String Style, String company){
		List<String> sqltemp = new ArrayList<String>();
		String value="";
		if (!department.equals("NOT")) {
			sqltemp.add( "s.id."+ids[3]+"='" + department+"'");
		} 
		if (!Style.equals("NOT")) {
			sqltemp.add("s.id."+ids[4]+"='" + Style+"'");
		} 
		if (!buyer.equals("NOT")) {
			sqltemp.add("s.id."+ ids[2]+"='" + buyer+"'");
		}
		if (!location.equals("NOT")) {
			sqltemp.add("s.id."+ ids[1]+"='" + location+"'");
		} 
		if (!company.equals("NOT")) {
			sqltemp.add( "s.id."+ids[0]+"='" + company+"'");
		}
		value=value+"where s.flag !='Incomplete'";
		for(int i=0;i<sqltemp.size();i++){
			if(i==0){
				value=value+" and ";
			}
			value=value+sqltemp.get(i);
			if(i<sqltemp.size()-1){
				value=value+" and ";
			}
		}
		return value;
	}
	
	@Override
	public List<Mststyleheader> getallsearch(String q,String [] ids) {
		q="%"+q+"%";
		String query="from Mststyleheader s where s.flag !='Incomplete' and ("+getLikefilda();
		log.debug(query);
		List<Mststyleheader> obj =getSession()
				 .createQuery(query)
				 .setParameter("filed", q).list();
		
		return obj;
	}
	
	private String getLikefilda(){
		String like="";
		String filed =" like :filed ";
		like+="s.id.custCode "+filed;
		like+="or s.id.styleId "+filed;
		like+="or s.id.depCode "+filed;
		like+="or s.id.locationCode "+filed;
		like+="or s.id.compCode "+filed;
		like+="or s.productRange "+filed;
		like+="or s.flag "+filed;
		like+="or s.packingMethod "+filed;
		like+="or s.userId "+filed;
		like+="or s.styleDescription "+filed;
		like+="or s. costSheetMethod "+filed;
		like+="or s.designReference "+filed;
		like+="or s.svmType "+filed;
		like+="or s.comments "+filed +" )";
		
		return like;
	}
	
}
