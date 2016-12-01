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
import com.excelsoft.dao.MerordersheetgroupDao;
import com.excelsoft.model.Merordersheetgroup;
import com.excelsoft.model.MerordersheetgroupId;

public class MerordersheetgroupManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private MerordersheetgroupManagerImpl manager;

	@Mock
	private MerordersheetgroupDao dao;

	@Test
	public void testGetMerordersheetgroup() {
		log.debug("testing get...");
		// given
		final MerordersheetgroupId id = new MerordersheetgroupId(0L, 0L, 1L,
				"0", "HC");
		final Merordersheetgroup merordersheetgroup = new Merordersheetgroup();
		given(dao.get(id)).willReturn(merordersheetgroup);

		// when
		Merordersheetgroup result = manager.get(id);

		// then
		assertSame(merordersheetgroup, result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testGetMerordersheetgroups() {
		log.debug("testing getAll...");
		// given
		final List merordersheetgroups = new ArrayList();
		given(dao.getAll()).willReturn(merordersheetgroups);

		// when
		List result = manager.getAll();

		// then
		assertSame(merordersheetgroups, result);
	}

	@Test
	public void testSaveMerordersheetgroup() {
		log.debug("testing save...");

		// given
		final Merordersheetgroup merordersheetgroup = new Merordersheetgroup();
		// enter all required fields

		given(dao.save(merordersheetgroup)).willReturn(merordersheetgroup);

		// when
		manager.save(merordersheetgroup);

		// then
		verify(dao).save(merordersheetgroup);
	}

	@Test
	public void testRemoveMerordersheetgroup() {
		log.debug("testing remove...");

		// given
		final MerordersheetgroupId id = new MerordersheetgroupId(0L, 0L, 1L,
				"0", "HC");
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}