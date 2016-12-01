package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.Mststylepicture;
import com.excelsoft.model.MststylepictureId;

import javax.jws.WebService;

@WebService
public interface MststylepictureManager extends GenericManager<Mststylepicture, MststylepictureId> {
	
	public List<Mststylepicture> getAll(Mststyleheader mststyleheader);

	public List<Mststylepicture> getZero(Mststyleheader mststyleheader);
    
}