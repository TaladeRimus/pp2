/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Model.Venda;
import dao.JpaVendaDaoImpl;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Mensagem;

/**
 *
 * @author Guilherme
 */
@ManagedBean
@SessionScoped
public class VendaMB implements Serializable {
    
    @EJB
    private JpaVendaDaoImpl vendaDao;
    private Venda vendaSelecionado;

    public VendaMB() {
        vendaSelecionado = new Venda();
    }

    public List<Venda> getUsuarios() {
        return (vendaDao.listar());
    }

    public Venda getVendaSelecionado() {
        return vendaSelecionado;
    }

    public void setVendaSelecionado(Venda vendaSelecionado) {
        this.vendaSelecionado = vendaSelecionado;
    }

    public String prepararCadastro() {
        vendaSelecionado = new Venda();
        return ("cadastroVenda");
    }

    public String cadastrar() {
        try{
            vendaDao.inserir(vendaSelecionado);
            Mensagem.addMensagemSucesso("Cadastro realizado com sucesso!");
        } catch (Exception e) {
            Mensagem.addMensagemErro("Erro ao cadastrar a Venda.");
        }
        return (this.prepararCadastro());
    }

    public String prepararEdicao() {
        return ("formularioEdicao");
    }

    public String editar() {
        try{
            vendaDao.editar(vendaSelecionado);
            Mensagem.addMensagemSucesso("Edição realizada com sucesso!");
        } catch (Exception e) {
            Mensagem.addMensagemErro("Erro ao editar a Venda.");
        }
        return (this.prepararEdicao());
    }
    
    public void remover() {
        try {
            vendaDao.remover(vendaSelecionado);
            Mensagem.addMensagemSucesso("Usuario removido com sucesso!");
        } catch (Exception e) {
            Mensagem.addMensagemErro("Erro ao remover Venda.");
        }
    }
    
}
