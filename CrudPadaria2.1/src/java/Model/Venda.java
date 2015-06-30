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
public class Venda implements Serializable{
    public static int AUTOINCREMENT = 0;
    
    @Id
    int idVenda;
    
    int idProduto;
    int idCliente;
    int quantidade;

    public Venda() {
        idVenda = ++AUTOINCREMENT;
    }
    
    public static int getAUTOINCREMENT() {
        return AUTOINCREMENT;
    }

    public static void setAUTOINCREMENT(int AUTOINCREMENT) {
        Venda.AUTOINCREMENT = AUTOINCREMENT;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
