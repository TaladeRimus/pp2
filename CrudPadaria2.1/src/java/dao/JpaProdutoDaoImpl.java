/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Produtos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class JpaProdutoDaoImpl extends JpaGenericDao<Produtos> {
    @PersistenceContext(unitName = "PadariaPU")
    protected EntityManager em;

    public JpaProdutoDaoImpl() {
        super(Produtos.class);
    }
    
    public List<Produtos> buscar(String nome){
        Query query = query = em.createQuery("SELECT p FROM Produtos p WHERE p.nome LIKE :nome");
        query.setParameter("nome", '%' + nome + '%');
        List<Produtos> lista = query.getResultList();
        return lista;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
