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
import model.Usuario;

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
public class ClienteUsuario {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/CrudPadaria2.1/webresources";

    public ClienteUsuario() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("usuarios");
    }

    public void adicionarProduto(Usuario usuario) throws ClientErrorException {
        Gson gson = new Gson();
        
        String json = gson.toJson(usuario);
        Response response = webTarget.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        //webTarget.request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(produto, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public List<Usuario> listar() throws ClientErrorException {
        WebTarget resource = webTarget;
        String json = resource.request(MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Usuario>>() {}.getType();
        List<Usuario> listaUsuarios = (List<Usuario>) gson.fromJson(json,type );
        return listaUsuarios;
    }

    public void close() {
        client.close();
    }
    
}
