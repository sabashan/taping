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

import com.excelsoft.dao.MerordersheetdeliveryDao;
import com.excelsoft.model.Merordersheetdelivery;
import com.excelsoft.model.MerordersheetdeliveryId;

public class MerordersheetdeliveryManagerImplTest extends
		BaseManagerMockTestCase {

	@InjectMocks
	private MerordersheetdeliveryManagerImpl manager;

	@Mock
	private MerordersheetdeliveryDao dao;

	@Test
	public void testGetMerordersheetdelivery() {
		log.debug("testing get...");
		// given
		final MerordersheetdeliveryId id = new MerordersheetdeliveryId(0L, 1L,
				"0", "HC");
		final Merordersheetdelivery merordersheetdelivery = new Merordersheetdelivery();
		given(dao.get(id)).willReturn(merordersheetdelivery);

		// when
		Merordersheetdelivery result = manager.get(id);

		// then
		assertSame(merordersheetdelivery, result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testGetMerordersheetdeliveries() {
		log.debug("testing getAll...");
		// given
		final List merordersheetdeliveries = new ArrayList();
		given(dao.getAll()).willReturn(merordersheetdeliveries);

		// when
		List result = manager.getAll();

		// then
		assertSame(merordersheetdeliveries, result);
	}

	@Test
	public void testSaveMerordersheetdelivery() {
		log.debug("testing save...");

		// given
		final Merordersheetdelivery merordersheetdelivery = new Merordersheetdelivery();
		// enter all required fields

		given(dao.save(merordersheetdelivery))
				.willReturn(merordersheetdelivery);

		// when
		manager.save(merordersheetdelivery);

		// then
		verify(dao).save(merordersheetdelivery);
	}

	@Test
	public void testRemoveMerordersheetdelivery() {
		log.debug("testing remove...");

		// given
		final MerordersheetdeliveryId id = new MerordersheetdeliveryId(0L, 1L,
				"0", "HC");
		;
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}