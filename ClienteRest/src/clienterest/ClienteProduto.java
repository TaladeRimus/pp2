/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clienterest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Produto;

/**
 * Jersey REST client generated for REST resource:ProdutoResource [produtos]<br>
 * USAGE:
 * <pre>
 *        ClienteProduto client = new ClienteProduto();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author lhries
 */
public class ClienteProduto {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/CrudPadaria2.1/webresources";

    public ClienteProduto() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("produtos");
    }

    public void adicionarProduto(Produto produto) throws ClientErrorException {
        Gson gson = new Gson();
        
        String json = gson.toJson(produto);
        Response response = webTarget.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        //webTarget.request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(produto, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public List<Produto> listar() throws ClientErrorException {
        WebTarget resource = webTarget;
        String json = resource.request(MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Produto>>() {}.getType();
        List<Produto> listaProdutos = (List<Produto>) gson.fromJson(json,type );
        return listaProdutos;
    }

    public void close() {
        client.close();
    }
    
}
