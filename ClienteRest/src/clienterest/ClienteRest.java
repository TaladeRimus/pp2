/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clienterest;

import java.util.List;
import model.Produto;
import model.Usuario;

/**
 *
 * @author lhries
 */
public class ClienteRest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteProduto resource = new ClienteProduto();
        ClienteUsuario user = new ClienteUsuario();
        //resource.adicionarProduto(new Produto("meia", 5.0));
        List<Produto> produtos = resource.listar();
        List<Usuario> usuarios = user.listar();
        for(Produto p: produtos)
            System.out.println(p.getNome());
        
        for(Usuario u: usuarios)
            System.out.println(u.getNome());
        
    }
    
}
