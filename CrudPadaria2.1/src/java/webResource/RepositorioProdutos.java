/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webResource;

/**
 *
 * @author Guilherme
 */
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import Model.Produtos;

@Stateless
public class RepositorioProdutos {
    private List<Produtos> listaProdutos;

    public RepositorioProdutos() {
        listaProdutos = new ArrayList<Produtos> ();
        //listaProdutos.add(new Produtos("Camiseta",30.0));
        //listaProdutos.add(new Produtos("Calca",50.0));

    }

    public List<Produtos> getListaProdutos() {
        return listaProdutos;
    }

    public void add(Produtos p) {
        listaProdutos.add(p);
    }
    
    
}
