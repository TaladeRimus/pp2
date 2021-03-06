/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Venda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Guilherme
 */
@Stateless
public class JpaVendaDaoImpl extends JpaGenericDao<Venda>{
    @PersistenceContext(unitName = "PadariaPU")
    protected EntityManager em;

    public JpaVendaDaoImpl() {
        super(Venda.class);
    }
    
    public List<Venda> buscar(int idCliente){
        Query query = query = em.createQuery("SELECT p FROM Venda p WHERE p.idCliente LIKE :idCliente");
        query.setParameter("idCliente", '%' + idCliente + '%');
        List<Venda> lista = query.getResultList();
        return lista;
    }
    
    public void removeDoEstoque(int idProduto, int qtd){
        
        Query query = query = em.createQuery("UPDATE Produtos p SET p.quantidade = (p.quantidade - :qtd) WHERE p.id = :idProduto");
        query.setParameter("idProduto",idProduto);
        query.setParameter("qtd",qtd); 
        query.executeUpdate();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
