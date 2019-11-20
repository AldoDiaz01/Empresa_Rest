package org.uv.web.rest;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.uv.dao.*;

/**
 * REST Web Service
 *
 * @author Kronoz
 */
@Path("departamentos")
public class DepartamentoResource {

    @Context
    private UriInfo context;
    private IDAOGeneral<Departamento, String> dao;

    /**
     * Creates a new instance of DepartamentoResource
     */
    public DepartamentoResource() {
        dao = FactoryDAO.create(FactoryDAO.Type.DEPARTAMENTO);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Departamento getbyId(@PathParam("id")String id)
    {
        return dao.buscarById(id);
    }

    /**
     * Retrieves representation of an instance of org.uv.web.rest.DepartamentoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Departamento> get()
    {
        return dao.buscarTodos();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento post(Departamento departamento)
    {
        dao.guardar(departamento);
        return departamento;
    } 

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento put(Departamento departamento)
    {
        dao.modificar(departamento);
        return departamento;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String delete(@PathParam("id") String id)
    {
        boolean res = dao.eliminar(id);
        if(res)
        {
            return "{\"Exito\":\"Elemento eliminado!\"}";
        }
        return "{\"Error\":\":(\"}";
    }
}