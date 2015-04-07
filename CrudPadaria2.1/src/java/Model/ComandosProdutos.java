/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@SessionScoped
public class ComandosProdutos {
    private List<Produtos> produto;
    private Produtos produtoSelecionado;
    private boolean editar = false;
    
    public ComandosProdutos(){
        produto = new ArrayList<>();
        editar = false;
        produtoSelecionado = new Produtos();
    }
    
    public List<Produtos> getProdutos() {
       return produto;
    }

    public void setProdutos(List<Produtos> produto) {
        this.produto = produto;
    }
    
     public String adicionaProduto() {
        if (editar) {
            for (Produtos prod : produto) {
                if (prod.getId() == produtoSelecionado.getId()) {
                    prod = produtoSelecionado;
                }
            }
        } else {
            this.produto.add(this.produtoSelecionado);
            this.produtoSelecionado = new Produtos();
        }
        return ("exibeProduto");
    }

    public void removerProduto() {        
        produto.remove(produtoSelecionado);
    }
    

    public String novoProduto() {
        this.produtoSelecionado = new Produtos();
        editar = false;
        return ("cadastroProduto");
    }

    public String editarProduto() {
        editar = true;
        return ("cadastroProduto");
    }

    public Produtos getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produtos usuarioSelecionado) {
        this.produtoSelecionado = usuarioSelecionado;
    }
    
}
