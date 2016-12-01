package com.excelsoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.dao.MststylechildColorDao;
import com.excelsoft.model.MststylechildColor;
import com.excelsoft.model.MststylechildColorId;
import com.excelsoft.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststylechildColorManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private MststylechildColorManagerImpl manager;

	@Mock
	private MststylechildColorDao dao;

	@Test
	public void testGetMststylechildColor() {
		log.debug("testing get...");
		// given
		final MststylechildColorId id = new MststylechildColorId("Red",
				"Yellow", "SS", "LL", "Comp", "Cus", "Dep");
		final MststylechildColor mststylechildColor = new MststylechildColor();
		given(dao.get(id)).willReturn(mststylechildColor);

		// when
		MststylechildColor result = manager.get(id);

		// then
		assertSame(mststylechildColor, result);
	}

	@Test
	public void testGetMststylechildColors() {
		log.debug("testing getAll...");
		// given
		final List mststylechildColors = new ArrayList();
		given(dao.getAll()).willReturn(mststylechildColors);

		// when
		List result = manager.getAll();

		// then
		assertSame(mststylechildColors, result);
	}

	@Test
	public void testSaveMststylechildColor() {
		log.debug("testing save...");

		// given
		final MststylechildColor mststylechildColor = new MststylechildColor();
		// enter all required fields

		given(dao.save(mststylechildColor)).willReturn(mststylechildColor);

		// when
		manager.save(mststylechildColor);

		// then
		verify(dao).save(mststylechildColor);
	}

	@Test
	public void testRemoveMststylechildColor() {
		log.debug("testing remove...");

		// given
		final MststylechildColorId id = new MststylechildColorId("Red",
				"Yellow", "SS", "LL", "Comp", "Cus", "Dep");
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}