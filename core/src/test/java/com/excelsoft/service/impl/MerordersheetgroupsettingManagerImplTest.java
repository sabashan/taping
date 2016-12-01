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
import com.excelsoft.dao.MerordersheetgroupsettingDao;
import com.excelsoft.model.Merordersheetgroupsetting;
import com.excelsoft.model.MerordersheetgroupsettingId;

public class MerordersheetgroupsettingManagerImplTest extends
		BaseManagerMockTestCase {

	@InjectMocks
	private MerordersheetgroupsettingManagerImpl manager;

	@Mock
	private MerordersheetgroupsettingDao dao;

	@Test
	public void testGetMerordersheetgroupsetting() {
		log.debug("testing get...");
		// given
		final MerordersheetgroupsettingId id = new MerordersheetgroupsettingId(
				1L, 1L, "0", "HC");
		final Merordersheetgroupsetting merordersheetgroupsetting = new Merordersheetgroupsetting();
		given(dao.get(id)).willReturn(merordersheetgroupsetting);

		// when
		Merordersheetgroupsetting result = manager.get(id);

		// then
		assertSame(merordersheetgroupsetting, result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testGetMerordersheetgroupsettings() {
		log.debug("testing getAll...");
		// given
		final List merordersheetgroupsettings = new ArrayList();
		given(dao.getAll()).willReturn(merordersheetgroupsettings);

		// when
		List result = manager.getAll();

		// then
		assertSame(merordersheetgroupsettings, result);
	}

	@Test
	public void testSaveMerordersheetgroupsetting() {
		log.debug("testing save...");

		// given
		final Merordersheetgroupsetting merordersheetgroupsetting = new Merordersheetgroupsetting();
		// enter all required fields

		given(dao.save(merordersheetgroupsetting)).willReturn(
				merordersheetgroupsetting);

		// when
		manager.save(merordersheetgroupsetting);

		// then
		verify(dao).save(merordersheetgroupsetting);
	}

	@Test
	public void testRemoveMerordersheetgroupsetting() {
		log.debug("testing remove...");

		// given
		final MerordersheetgroupsettingId id = new MerordersheetgroupsettingId(
				1L, 1L, "0", "HC");
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}