/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Model.Usuario;
import dao.JpaUsuarioDaoImpl;
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
public class UsuarioMB implements Serializable{

    @EJB
    private JpaUsuarioDaoImpl usuarioDao;
    private Usuario usuarioSelecionado;

    public UsuarioMB() {
        usuarioSelecionado = new Usuario();
    }

    public List<Usuario> getUsuarios() {
        return (usuarioDao.listar());
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public String prepararCadastro() {
        usuarioSelecionado = new Usuario();
        return ("cadastroUsuario");
    }

    public String cadastrar() {
        try{
            usuarioDao.inserir(usuarioSelecionado);
            Mensagem.addMensagemSucesso("Cadastro realizado com sucesso!");
        } catch (Exception e) {
            Mensagem.addMensagemErro("Erro ao cadastrar o Usuario.");
        }
        return (this.prepararCadastro());
    }

    public String prepararEdicao() {
        return ("formularioEdicao");
    }

    public String editar() {
        try{
            usuarioDao.editar(usuarioSelecionado);
            Mensagem.addMensagemSucesso("Edição realizada com sucesso!");
        } catch (Exception e) {
            Mensagem.addMensagemErro("Erro ao editar o Usuario.");
        }
        return (this.prepararEdicao());
    }
    
    public void remover() {
        try {
            usuarioDao.remover(usuarioSelecionado);
            Mensagem.addMensagemSucesso("Usuario removido com sucesso!");
        } catch (Exception e) {
            Mensagem.addMensagemErro("Erro ao remover o Usuario.");
        }
    }
    
}