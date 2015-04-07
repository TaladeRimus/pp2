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
public class ComandosUsuario {
    
    private List<Usuario> usuario;
    private Usuario usuarioSelecionado;
    private boolean editar = false;
    
    public ComandosUsuario(){
        usuario = new ArrayList<>();
        editar = false;
        usuarioSelecionado = new Usuario();
        
    }
    
    public List<Usuario> getUsuario() {
       return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
    
     public String adicionaUsuario() {
        if (editar) {
            for (Usuario usr : usuario) {
                if (usr.getId() == usuarioSelecionado.getId()) {
                    usr = usuarioSelecionado;
                }
            }
        } else {
            this.usuario.add(this.usuarioSelecionado);
            this.usuarioSelecionado = new Usuario();
        }
        return ("exibeUsuarios");
    }

    public void removerUsuario() {        
        usuario.remove(usuarioSelecionado);
    }
    

    public String novoUsuario() {
        this.usuarioSelecionado = new Usuario();
        editar = false;
        return ("cadastroUsuario");
    }

    public String editarUsuario() {
        editar = true;
        return ("cadastroUsuario");
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
    

}
