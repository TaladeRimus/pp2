package webResource;


import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import Model.Produtos;

@Path("produtos")
public class ProdutoResource {

    @Context
    private UriInfo context;

    //Substituir depois pelo DAO para persistência 
    @EJB
    RepositorioProdutos repositorio;
    /**
     * Creates a new instance of ProdutoResource
     */
    public ProdutoResource() {
    }

    @GET
    @Produces("application/json")
    public List<Produtos> getJson() {
        return(repositorio.getListaProdutos());
    }

    @POST
    @Consumes("application/json")
    @Produces ("text/plain")
    public String postJson(Produtos p) {
        repositorio.add(p);
        return "OK";
    }
}
