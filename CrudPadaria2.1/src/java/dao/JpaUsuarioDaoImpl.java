/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class JpaUsuarioDaoImpl extends JpaGenericDao<Usuario> {
    @PersistenceContext(unitName = "PadariaPU")
    protected EntityManager em;

    public JpaUsuarioDaoImpl() {
        super(Usuario.class);
    }
    
    public List<Usuario> buscar(String nome){
        Query query = query = em.createQuery("SELECT u FROM usuario WHERE u.nome LIKE :nome");
        query.setParameter("nome", '%' + nome + '%');
        List<Usuario> lista = query.getResultList();
        return lista;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
