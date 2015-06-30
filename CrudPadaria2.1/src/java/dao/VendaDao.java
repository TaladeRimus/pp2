/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Model.Venda;
import java.util.List;
/**
 *
 * @author Guilherme
 */
public interface VendaDao extends GenericDao<Venda>  {
    
    public List<Venda> buscar(String venda);
    public void removeDoEstoque(int idProduto, int quantidade);
}
