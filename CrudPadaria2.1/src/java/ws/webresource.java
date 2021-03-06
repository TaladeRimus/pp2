/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Model.Produtos;
import dao.JpaProdutoDaoImpl;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Adriano
 */
@Path("produtos")
public class webresource {
    @EJB
    JpaProdutoDaoImpl cp;
    
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
       
       return(cp.listarProdutos());
        
    }

    /*@PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }*/
    @POST
    @Consumes("application/json")
    @Produces ("text/plain")
    public String postJson(Produtos p) {
        cp.inserir(p);
        return "OK";
    }
}
