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

import com.excelsoft.dao.MststylemainColorDao;
import com.excelsoft.model.MststylemainColor;
import com.excelsoft.model.MststylemainColorId;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MststylemainColorManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private MststylemainColorManagerImpl manager;

	@Mock
	private MststylemainColorDao dao;

	@Test
	public void testGetMststylemainColor() {
		log.debug("testing get...");
		// given
		final MststylemainColorId id = new MststylemainColorId("Main Col",
				"SS", "LL", "Comp", "Cus", "Dep");
		final MststylemainColor mststylemainColor = new MststylemainColor();
		given(dao.get(id)).willReturn(mststylemainColor);

		// when
		MststylemainColor result = manager.get(id);

		// then
		assertSame(mststylemainColor, result);
	}

	@Test
	public void testGetMststylemainColors() {
		log.debug("testing getAll...");
		// given
		final List mststylemainColors = new ArrayList();
		given(dao.getAll()).willReturn(mststylemainColors);

		// when
		List result = manager.getAll();

		// then
		assertSame(mststylemainColors, result);
	}

	@Test
	public void testSaveMststylemainColor() {
		log.debug("testing save...");

		// given
		final MststylemainColor mststylemainColor = new MststylemainColor();
		// enter all required fields

		given(dao.save(mststylemainColor)).willReturn(mststylemainColor);

		// when
		manager.save(mststylemainColor);

		// then
		verify(dao).save(mststylemainColor);
	}

	@Test
	public void testRemoveMststylemainColor() {
		log.debug("testing remove...");

		// given
		final MststylemainColorId id = new MststylemainColorId("Main Col",
				"SS", "LL", "Comp", "Cus", "Dep");
		willDoNothing().given(dao).remove(id);

		// when
		manager.remove(id);

		// then
		verify(dao).remove(id);
	}
}