package com.excelsoft.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MststyleheaderDao;
import com.excelsoft.model.Mstcompany;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.service.MststyleheaderManager;

@Service("mststyleheaderManager")
@WebService(serviceName = "MststyleheaderService", endpointInterface = "com.excelsoft.service.MststyleheaderManager")
public class MststyleheaderManagerImpl extends
		GenericManagerImpl<Mststyleheader, MststyleheaderId> implements
		MststyleheaderManager {
	MststyleheaderDao mststyleheaderDao;

	@Autowired
	public MststyleheaderManagerImpl(MststyleheaderDao mststyleheaderDao) {
		super(mststyleheaderDao);
		this.mststyleheaderDao = mststyleheaderDao;
	}

	/**
	 * @param flag
	 *            style status
	 * @param User
	 *            created of modified user
	 * @return List<Mststyleheader> all the style with Pending state and created
	 *         or modified by logged user
	 */
	@Override
	public List<Mststyleheader> getPendingStyles(String flag, String user) {
		return this.mststyleheaderDao.getPendingStyles(flag, user);
	}

	/**
	 * @return all the style with conform state
	 */
	public List<Mststyleheader> getAll() {

		return this.mststyleheaderDao.getAll();
	}

	/**
	 * @param company
	 *            company name
	 * @param buyer
	 *            buyer name (Customer)
	 * @param department
	 *            department name
	 * @param location
	 *            location name
	 * @param style
	 *            style id
	 * @return Mststyleheader the style which have corresponding values in given
	 *         fields
	 */
	@Override
	public Mststyleheader getStyle(String company, String location,
			String buyer, String department, String style) {
		return mststyleheaderDao.getStyle(company, location, buyer, department,
				style);
	}

	/**
	 * 
	 */
	@Override
	public List<String> StylesByparam(String location, String buyer,
			String department, String Style, String company,String need) {
		
		return mststyleheaderDao.StylesByparam(location, buyer, department, Style, company,need);
	}

	@Override
	public List<Mstlocation> locationByparam(String location, String buyer,
			String department, String Style, String company, String need,String query) {
		return mststyleheaderDao.locationByparam(location, buyer, department, Style, company,need,query);
	}
	@Override
	public List<Mstcompany> MstcompanyByparam(String location, String buyer,
			String department, String Style, String company, String need,String query) {
		return mststyleheaderDao.MstcompanyByparam(location, buyer, department, Style, company,need,query);
	}
	
	@Override
	public List<Mstcustomer> MstcustomerByparam(String location, String buyer,
			String department, String Style, String company, String need,String query) {
		return mststyleheaderDao.MstcustomerByparam(location, buyer, department, Style, company,need,query);
	}
	@Override
	public List<Mststyleheader> MststyleheaderByparam(String location, String buyer,
			String department, String Style, String company, String need,String query) {
		return mststyleheaderDao.MststyleheaderByparam(location, buyer, department, Style, company,need,query);
	}
	@Override
	 public List<Mststyleheader> getallsearch(String q,String []ids) {
		return mststyleheaderDao.getallsearch(q,ids);
	 }

}