package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstuser;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("mstuser")
public interface MstuserManager extends GenericManager<Mstuser, String> {
    @GET
    public List<Mstuser>getAll();
    
    @POST
    @Path("getByid")
    public Mstuser get(String id);
    
    @POST
    @Path("getuserId")
    public List<String>getAlluserId();
    
    @POST
    @Path("getAllbyq/{query}")
    public List<Mstuser> getAllByq(@PathParam("query")String query);
}