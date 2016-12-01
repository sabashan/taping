package com.excelsoft.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.excelsoft.model.Mststyleheader;

public class MststyleheaderDaoTest extends BaseDaoTestCase {
	@Autowired
	private MststyleheaderDao mststyleheaderDao;

	@Test(expected = DataAccessException.class)
	public void testAddAndRemoveMststyleheader() {
		Mststyleheader mststyleheader = new Mststyleheader();

		// enter all required fields
		mststyleheader.setFlag("GeSmQxKqHhGu");
		mststyleheader.setProductRange("VjRpVz");
		mststyleheader.setUserId("FnNuMoOzNc");

		log.debug("adding mststyleheader...");
		mststyleheader = mststyleheaderDao.save(mststyleheader);

		mststyleheader = mststyleheaderDao.get(mststyleheader.getId());

		assertNotNull(mststyleheader.getId());

		log.debug("removing mststyleheader...");

		mststyleheaderDao.remove(mststyleheader.getId());

		// should throw DataAccessException
		mststyleheaderDao.get(mststyleheader.getId());
	}
}