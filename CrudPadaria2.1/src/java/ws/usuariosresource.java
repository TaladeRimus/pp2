/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Model.Usuario;
import dao.JpaUsuarioDaoImpl;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author 631310007
 */
@Path("usuarios")
public class usuariosresource {

    @EJB
    JpaUsuarioDaoImpl us;
    
    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of usuariosresource
     */
    public usuariosresource() {
    }

    /**
     * Retrieves representation of an instance of ws.usuariosresource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Usuario> getJson() {
        return us.listar();
    }

    /**
     * PUT method for updating or creating an instance of usuariosresource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
