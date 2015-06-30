/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Model.ComandosProdutos;
import Model.Produtos;
import beans.ProdutoMB;
import java.util.List;
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
 * @author Adriano
 */
@Path("webresource")
public class webresource {

    ComandosProdutos cp = new ComandosProdutos();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of webresource
     */
    public webresource() {
    }

    /**
     * Retrieves representation of an instance of ws.webresource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Produtos> getJson() {
       
       return(cp.getProdutos());
        
    }

    /**
     * PUT method for updating or creating an instance of webresource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
