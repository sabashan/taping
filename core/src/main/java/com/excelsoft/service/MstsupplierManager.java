package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstsupplier;
import com.excelsoft.model.MstsupplierId;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("mstsupplier")
public interface MstsupplierManager extends GenericManager<Mstsupplier, MstsupplierId> {
    
	public Mstsupplier get(MstsupplierId id);
	
    @GET
    public List<Mstsupplier>getAll();
    
    @POST
    @Path("getAll/{location}")
    public List<Mstsupplier>getAll(@PathParam("location")String location);
    
    @POST
    @Path("getcode/{location}")
    public List<String>getAllid(@PathParam("location")String location);
    
    @POST
    @Path("getAllq/{location}/{q}")
    public List<Mstsupplier>getAllq(@PathParam("location")String location,@PathParam("q")String q);
    
    @POST
    @Path("get/{compCode}/{suppCode}")
    public Mstsupplier get(@PathParam("compCode")String compCode,@PathParam("suppCode")String suppCode);
}