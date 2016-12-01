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

import com.excelsoft.dao.MststyledemmapDao;
import com.excelsoft.model.Mststyledemmap;
import com.excelsoft.model.MststyledemmapId;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststyledemmapManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private MststyledemmapManagerImpl manager;

	@Mock
	private MststyledemmapDao dao;

	@Test
	public void testGetMststyledemmap() {
		log.debug("testing get...");
		// given
		final MststyledemmapId id = new MststyledemmapId("SS", "LL", "Comp",
				"Cus", "Dep", "Dem 01", "Dem 2", "Main Col","10","AA");
		final Mststyledemmap mststyledemmap = new Mststyledemmap();
		given(dao.get(id)).willReturn(mststyledemmap);

		// when
		Mststyledemmap result = manager.get(id);

		// then
		assertSame(mststyledemmap, result);
	}

	@Test
	public void testGetMststyledemmaps() {
		log.debug("testing getAll...");
		// given
		final List mststyledemmaps = new ArrayList();
		given(dao.getAll()).willReturn(mststyledemmaps);

		// when
		List result = manager.getAll();

		// then
		assertSame(mststyledemmaps, result);
	}

	@Test
	public void testSaveMststyledemmap() {
		log.debug("testing save...");

		// given
		final Mststyledemmap mststyledemmap = new Mststyledemmap();
		// enter all required fields

		given(dao.save(mststyledemmap)).willReturn(mststyledemmap);

		// when
		manager.save(mststyledemmap);

		// then
		verify(dao).save(mststyledemmap);
	}

	@Test
	public void testRemoveMststyledemmap() {
		log.debug("testing remove...");

		// given
		final MststyledemmapId id = new MststyledemmapId("SS", "LL", "Comp",
				"Cus", "Dep", "Dem 01", "Dem 2", "Main Col","10","AA");
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}