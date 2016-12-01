package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.excelsoft.dao.MerordersheetgroupbomDao;
import com.excelsoft.model.Merordersheetgroupbom;
import com.excelsoft.model.MerordersheetgroupbomId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MerordersheetgroupbomManagerImplTest extends
		BaseManagerMockTestCase {

	@InjectMocks
	private MerordersheetgroupbomManagerImpl manager;

	@Mock
	private MerordersheetgroupbomDao dao;

	@Test
	public void testGetMerordersheetgroupbom() {
		log.debug("testing get...");
		// given
		final MerordersheetgroupbomId id = new MerordersheetgroupbomId(0L, 0L,
				0L, 1L, "0", "HC");
		final Merordersheetgroupbom merordersheetgroupbom = new Merordersheetgroupbom();
		given(dao.get(id)).willReturn(merordersheetgroupbom);

		// when
		Merordersheetgroupbom result = manager.get(id);

		// then
		assertSame(merordersheetgroupbom, result);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testGetMerordersheetgroupboms() {
		log.debug("testing getAll...");
		// given
		final List merordersheetgroupboms = new ArrayList();
		given(dao.getAll()).willReturn(merordersheetgroupboms);

		// when
		List result = manager.getAll();

		// then
		assertSame(merordersheetgroupboms, result);
	}

	@Test
	public void testSaveMerordersheetgroupbom() {
		log.debug("testing save...");

		// given
		final Merordersheetgroupbom merordersheetgroupbom = new Merordersheetgroupbom();
		// enter all required fields

		given(dao.save(merordersheetgroupbom))
				.willReturn(merordersheetgroupbom);

		// when
		manager.save(merordersheetgroupbom);

		// then
		verify(dao).save(merordersheetgroupbom);
	}

	@Test
	public void testRemoveMerordersheetgroupbom() {
		log.debug("testing remove...");

		// given
		final MerordersheetgroupbomId id = new MerordersheetgroupbomId(0L, 0L,
				0L, 1L, "0", "HC");
		;
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}