/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Guilherme
 */
@Entity
public class Usuario implements Serializable {
    
    private String nome, login, senha;
    @Id
    private int id;
    private int AUTOINCREMENT, permissao;
    
    public Usuario() {
        id = ++AUTOINCREMENT;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAUTOINCREMENT() {
        return AUTOINCREMENT;
    }

    public void setAUTOINCREMENT(int AUTOINCREMENT) {
        this.AUTOINCREMENT = AUTOINCREMENT;
    }
    
    
}
