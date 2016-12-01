package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.excelsoft.dao.MerordersheetgroupcolorDao;
import com.excelsoft.model.Merordersheetgroupcolor;
import com.excelsoft.model.MerordersheetgroupcolorId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MerordersheetgroupcolorManagerImplTest extends
		BaseManagerMockTestCase {

	@InjectMocks
	private MerordersheetgroupcolorManagerImpl manager;

	@Mock
	private MerordersheetgroupcolorDao dao;

	@Test
	public void testGetMerordersheetgroupcolor() {
		log.debug("testing get...");
		// given
		final MerordersheetgroupcolorId id = new MerordersheetgroupcolorId(
				"qqee", 0L, 1L, "0", "HC");
		final Merordersheetgroupcolor merordersheetgroupcolor = new Merordersheetgroupcolor();
		given(dao.get(id)).willReturn(merordersheetgroupcolor);

		// when
		Merordersheetgroupcolor result = manager.get(id);

		// then
		assertSame(merordersheetgroupcolor, result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testGetMerordersheetgroupcolors() {
		log.debug("testing getAll...");
		// given
		final List merordersheetgroupcolors = new ArrayList();
		given(dao.getAll()).willReturn(merordersheetgroupcolors);

		// when
		List result = manager.getAll();

		// then
		assertSame(merordersheetgroupcolors, result);
	}

	@Test
	public void testSaveMerordersheetgroupcolor() {
		log.debug("testing save...");

		// given
		final Merordersheetgroupcolor merordersheetgroupcolor = new Merordersheetgroupcolor();
		// enter all required fields

		given(dao.save(merordersheetgroupcolor)).willReturn(
				merordersheetgroupcolor);

		// when
		manager.save(merordersheetgroupcolor);

		// then
		verify(dao).save(merordersheetgroupcolor);
	}

	@Test
	public void testRemoveMerordersheetgroupcolor() {
		log.debug("testing remove...");

		// given
		final MerordersheetgroupcolorId id = new MerordersheetgroupcolorId(
				"qqee", 0L, 1L, "0", "HC");
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}