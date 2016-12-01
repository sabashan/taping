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

import com.excelsoft.dao.MststyledemDao;
import com.excelsoft.model.Mststyledem;
import com.excelsoft.model.MststyledemId;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststyledemManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private MststyledemManagerImpl manager;

	@Mock
	private MststyledemDao dao;

	@Test
	public void testGetMststyledem() {
		log.debug("testing get...");
		// given
		final MststyledemId id = new MststyledemId("Dem", "SS", "LL", "Comp",
				"Cus", "Dep","10");
		final Mststyledem mststyledem = new Mststyledem();
		given(dao.get(id)).willReturn(mststyledem);

		// when
		Mststyledem result = manager.get(id);

		// then
		assertSame(mststyledem, result);
	}

	@Test
	public void testGetMststyledems() {
		log.debug("testing getAll...");
		// given
		final List mststyledems = new ArrayList();
		given(dao.getAll()).willReturn(mststyledems);

		// when
		List result = manager.getAll();

		// then
		assertSame(mststyledems, result);
	}

	@Test
	public void testSaveMststyledem() {
		log.debug("testing save...");

		// given
		final Mststyledem mststyledem = new Mststyledem();
		// enter all required fields

		given(dao.save(mststyledem)).willReturn(mststyledem);

		// when
		manager.save(mststyledem);

		// then
		verify(dao).save(mststyledem);
	}

	@Test
	public void testRemoveMststyledem() {
		log.debug("testing remove...");

		// given
		final MststyledemId id = new MststyledemId("Dem", "SS", "LL", "Comp",
				"Cus", "Dep","10");
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}