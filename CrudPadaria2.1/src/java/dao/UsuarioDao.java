/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Usuario;
import java.util.List;

/**
 *
 * @author 631310448
 */
public interface UsuarioDao extends GenericDao<Usuario> {
    
    public List<Usuario> buscar(String nome);
    public List<Usuario> login(String login, String senha);
    
}
