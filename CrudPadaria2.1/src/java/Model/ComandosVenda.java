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
public class ComandosVenda {
        
    private List<Venda> venda;
    private Venda vendaSelecionado;
    private boolean editar = false;
    
    public ComandosVenda(){
        venda = new ArrayList<>();
        editar = false;
        vendaSelecionado = new Venda();
        
    }
    
    public List<Venda> getUsuario() {
       return venda;
    }

    public void setUsuario(List<Venda> venda) {
        this.venda = venda;
    }
    
     public String adicionaUsuario() {
        if (editar) {
            for (Venda vend : venda) {
                if (vend.getIdCliente() == vendaSelecionado.getIdCliente()) {
                    vend = vendaSelecionado;
                }
            }
        } else {
            this.venda.add(this.vendaSelecionado);
            this.vendaSelecionado = new Venda();
        }
        return ("exibeVendas");
    }

    public void removerUsuario() {        
        venda.remove(vendaSelecionado);
    }

    public String novoUsuario() {
        this.vendaSelecionado = new Venda();
        editar = false;
        return ("cadastroVenda");
    }

    public String editarUsuario() {
        editar = true;
        return ("cadastroVenda");
    }

    public Venda getUsuarioSelecionado() {
        return vendaSelecionado;
    }

    public void setUsuarioSelecionado(Venda vendaSelecionado) {
        this.vendaSelecionado = vendaSelecionado;
    }
    

}
