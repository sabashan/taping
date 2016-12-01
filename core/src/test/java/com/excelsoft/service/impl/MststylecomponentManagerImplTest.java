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

import com.excelsoft.dao.MststylecomponentDao;
import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.MststylecomponentId;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststylecomponentManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private MststylecomponentManagerImpl manager;

	@Mock
	private MststylecomponentDao dao;

	@Test
	public void testGetMststylecomponent() {
		log.debug("testing get...");
		// given
		final MststylecomponentId id = new MststylecomponentId("COmpo", "SS",
				"LL", "Comp", "Cus", "Dep");
		final Mststylecomponent mststylecomponent = new Mststylecomponent();
		given(dao.get(id)).willReturn(mststylecomponent);

		// when
		Mststylecomponent result = manager.get(id);

		// then
		assertSame(mststylecomponent, result);
	}

	@Test
	public void testGetMststylecomponents() {
		log.debug("testing getAll...");
		// given
		final List mststylecomponents = new ArrayList();
		given(dao.getAll()).willReturn(mststylecomponents);

		// when
		List result = manager.getAll();

		// then
		assertSame(mststylecomponents, result);
	}

	@Test
	public void testSaveMststylecomponent() {
		log.debug("testing save...");

		// given
		final Mststylecomponent mststylecomponent = new Mststylecomponent();
		// enter all required fields

		given(dao.save(mststylecomponent)).willReturn(mststylecomponent);

		// when
		manager.save(mststylecomponent);

		// then
		verify(dao).save(mststylecomponent);
	}

	@Test
	public void testRemoveMststylecomponent() {
		log.debug("testing remove...");

		// given
		final MststylecomponentId id = new MststylecomponentId("COmpo", "SS",
				"LL", "Comp", "Cus", "Dep");
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}