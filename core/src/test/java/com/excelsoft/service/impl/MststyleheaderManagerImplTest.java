package com.excelsoft.service.impl;

import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.excelsoft.dao.MststyleheaderDao;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststyleheaderManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private MststyleheaderManagerImpl manager;

	@Mock
	private MststyleheaderDao dao;

	@Test
	public void testGetMststyleheader() {
		log.debug("testing get...");
		// given
		final MststyleheaderId id = new MststyleheaderId("SS", "LL", "Dep",
				"Comp", "Cus");
		final Mststyleheader mststyleheader = new Mststyleheader();
		given(dao.get(id)).willReturn(mststyleheader);

		// when
		Mststyleheader result = manager.get(id);

		// then
		assertSame(mststyleheader, result);
	}

	@Test
	public void testGetMststyleheaders() {
		log.debug("testing getAll...");
		// given
		final List mststyleheaders = new ArrayList();
		given(dao.getAll()).willReturn(mststyleheaders);

		// when
		List result = manager.getAll();

		// then
		assertSame(mststyleheaders, result);
	}

	@Test
	public void testSaveMststyleheader() {
		log.debug("testing save...");

		// given
		final Mststyleheader mststyleheader = new Mststyleheader();
		// enter all required fields
		mststyleheader.setFlag("YoBeWgQyEbOt");
		mststyleheader.setProductRange("BnDgUm");
		mststyleheader.setUserId("DhHqOqHwSl");

		given(dao.save(mststyleheader)).willReturn(mststyleheader);

		// when
		manager.save(mststyleheader);

		// then
		verify(dao).save(mststyleheader);
	}

	@Test
	public void testRemoveMststyleheader() {
		log.debug("testing remove...");

		// given
		final MststyleheaderId id = new MststyleheaderId("SS", "LL", "Dep",
				"Comp", "Cus");
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}