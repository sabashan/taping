package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Merprecostsheetcurrency;
import com.excelsoft.model.MerprecostsheetcurrencyId;

import javax.jws.WebService;

@WebService
public interface MerprecostsheetcurrencyManager extends GenericManager<Merprecostsheetcurrency, MerprecostsheetcurrencyId> {
    public List< Merprecostsheetcurrency> getAll(Merprecostsheet merprecostsheet);
}