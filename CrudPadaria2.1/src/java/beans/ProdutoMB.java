/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Model.Produtos;
import dao.JpaProdutoDaoImpl;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Mensagem;

/**
 *
 * @author 631310448
 */
@ManagedBean
@SessionScoped
public class ProdutoMB implements Serializable{

    @EJB
    private JpaProdutoDaoImpl produtoDao;
    private Produtos produtoSelecionado;

    public ProdutoMB() {
        produtoSelecionado = new Produtos();
    }

    public List<Produtos> getProdutos() {
        return (produtoDao.listar());
    }

    public Produtos getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produtos produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public String prepararCadastro() {
        produtoSelecionado = new Produtos();
        return ("cadastroProduto");
    }

    public String cadastrar() {
        try{
            if(produtoDao==null) System.out.println("Dao is null 000000000000000000");
            produtoDao.inserir(produtoSelecionado);
            Mensagem.addMensagemSucesso("Cadastro realizado com sucesso!");
        } catch (Exception e) {
            Mensagem.addMensagemErro("Erro ao cadastrar o Produto.");
        }
        return (this.prepararCadastro());
    }

    public String prepararEdicao() {
        return ("formularioEdicao");
    }

    public String editar() {
        try{
            produtoDao.editar(produtoSelecionado);
            Mensagem.addMensagemSucesso("Edição realizada com sucesso!");
        } catch (Exception e) {
            Mensagem.addMensagemErro("Erro ao editar o Produto.");
        }
        return (this.prepararEdicao());
    }
    
    public void remover() {
        try {
            produtoDao.remover(produtoSelecionado);
            Mensagem.addMensagemSucesso("Produto removido com sucesso!");
        } catch (Exception e) {
            Mensagem.addMensagemErro("Erro ao remover o Produto.");
        }
    }
    
}
